if (typeof localStorage === "undefined" || localStorage === null) {
    var LocalStorage = require('node-localstorage').LocalStorage;
    localStorage = new LocalStorage('./scratch');
}
var text = localStorage.getItem("testJSON");
var obj = JSON.parse(text);
var newImage = {
    url:"www.img.com",
    imageName:"image2",
    information:"image",
    date:"28-3-2019",				
};
obj.push(newImage);
text = JSON.stringify(obj); 
console.log(text);