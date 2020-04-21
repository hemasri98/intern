from django import forms
class QuestionForm(forms.Form):
    filename = forms.CharField(label = 'filename', max_length=50)