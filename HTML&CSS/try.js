//var LocalStorage = require('node-localstorage').LocalStorage;

// localStorage = new LocalStorage('./scratch'); 
//Storing data:
myObj = [{url:"ww.image.com",
imageName:"image",
information:"practice",
date:"27-9-19",}];
//myJSON = JSON.stringify(myObj);
if (typeof localStorage === "undefined" || localStorage === null) {
    var LocalStorage = require('node-localstorage').LocalStorage;
    localStorage = new LocalStorage('./scratch');
  }
 
   
//var localStorage = require('node-localstorage').LocalStorage;
//localStorage = new LocalStorage('./scratch');
//console.log(localStorage);

//localStorage.setItem("testJSON", myJSON);

// //Retrieving data:
text = localStorage.getItem("testJSON");

obj = JSON.parse(text);
obj.push({"a":"x"});
text = JSON.stringify(obj); 
console.log(text);