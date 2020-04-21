
import os
import matplotlib.pyplot as plt
from skimage.transform import resize
#from sklearn.utils.validation import train_test_split
import cv2
import numpy as np
from matplotlib.pyplot import imshow 

from sklearn.preprocessing import LabelEncoder
from keras.utils import to_categorical
from sklearn.model_selection import train_test_split


from keras.models import Sequential, Model
from keras.layers import Conv2D, Input, Dropout, Activation, Dense, MaxPooling2D, Flatten, GlobalAveragePooling2D
from keras.optimizers import Adadelta
from keras.callbacks import ModelCheckpoint
from keras.callbacks import EarlyStopping
from keras.models import load_model


def exploringData():
	path = '/home/dhemasri/Desktop/'
	dataset_path = '/home/dhemasri/Desktop/dataset'
	return dataset_path



def createTrainingData():
	dataset_path = exploringData()
	count_of_images = []
	X = np.ndarray((505, 300, 300, 3), dtype=np.uint8)
	Y = []
	c = 0
	for i in os.listdir(dataset_path):
	    a = dataset_path + "/" + i
	    if not a.endswith(".ipynb_checkpoints"):
	      for k in os.listdir(a):
		  l = a + "/" + k
		  img = cv2.imread(l)
		  img1 = cv2.resize(img,(300,300))
		  X[c] = img1
		  Y.insert(c, i)
		  c += 1
	      count_of_images.append(len(os.listdir(a)))
	return X,Y                 

def plotGraph():
	classes = {'binocular' : 0, 'camera' : 1, 'ceiling_fan' : 2, 'chair' : 3, 'cup' : 4, 'headphone' : 5, 'lamp' : 6, 'scissors' : 7 , 'umbrella' : 8 , 'wrench' : 9}
	class_labels = list(classes.keys())
	x = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	plt.xlabel('class labels')
	plt.ylabel('number of images')
	plt.margins(0.1)
	plt.xticks(x, class_labels, rotation = 45)
	plt.bar(class_labels, count_of_images)


def convertToLabelEncoder(Y):
	label_encoder = LabelEncoder()
	Y_integer_encoded = label_encoder.fit_transform(Y)
	return Y_integer_encoded


def oneHot(Y_integer_encoded):
	Y_one_hot = to_categorical(Y_integer_encoded)
	return Y_one_hot


def normalise(X):
	X_normalized = X.astype(np.float64) / 255
	return X_normalized


def splittingData():
	X, Y = creatingData()
	X_normalized = normalise(X)
	Y_one_hot = oneHot(convertToLAbelEncoder(Y))
	X_train, X_validation, Y_train, Y_validation = train_test_split(X_normalized, Y_one_hot, test_size = 0.25, random_state = 42)
	return X_train, X_validation, Y_train, Y_validation


def model():
	X_train, X_validation, Y_train, Y_validation = splittingData()
	model_cnn = Sequential()
	model_cnn.add(Conv2D(8, (3,3), activation='relu', input_shape=(300,300,3)))
	model_cnn.add(Conv2D(16, (3,3), activation='relu'))
	model_cnn.add(MaxPooling2D(pool_size=2, strides=2))
	model_cnn.add(Conv2D(32, (3,3), activation='relu'))

	model_cnn.add(MaxPooling2D(pool_size=2, strides=2))
	model_cnn.add(Flatten())
	model_cnn.add(Dense(10, activation='softmax'))
	return model_cnn
	#model_cnn.summary()

def model_cnn_compile():
	model_cnn = model()
	return model_cnn.compile(loss='categorical_crossentropy',optimizer='adam', metrics=['accuracy'])
def fittingData():
	X_train, X_validation, Y_train, Y_validation = splittingData()
	model_cnn = model()
	model_cnn.fit(X_train, Y_train, batch_size=64, epochs=10, verbose=1, validation_data=(X_validation,Y_validation))

def predictClassLabel(value):
	classes = {'binocular' : 0, 'camera' : 1, 'ceiling_fan' : 2, 'chair' : 3, 'cup' : 4, 'headphone' : 5, 'lamp' : 6, 'scissors' : 7 , 'umbrella' : 8 , 'wrench' : 9}
	for key, val in classes.items():
	    if(value == val):
	      return key
def getPath(filename):
	dataset_path = exploringData()
	for i in os.listdir(dataset_path):
		a = dataset_path + "/" + i
		for k in os.listdir(a):
			if(k == filename):
				image_path = a + "/" + k
				return image_path
def predictName(filename):
	image_path = getPath(filename)
	image = cv2.imread(imagePath)
	resized_image = cv2.resize(image,(300,300))
	reshape_image = resized_image.reshape(1,300, 300, 3)
	model_cnn = model()
	prediction = model_cnn.predict(reshape_image)
	name = classLabel(np.argmax(prediction))
	return name

