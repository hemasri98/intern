var fs =require('fs');
var data = fs.readFileSync('./imageData.json');
console.log("Synchronous read: " + data.toString());
fs.writeFile('./imageData.json', "jvj",(err) => { 
									
  // In case of a error throw err. 
  if (err) throw err; 
}) ;
console.log("Program Ended");