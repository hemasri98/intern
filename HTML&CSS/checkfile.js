var obj = {
   table: []
};
//Add some data to it like

obj.table.push({id: 1, square:2});
//Convert it from an object to string with stringify

var json = JSON.stringify(obj);
//use fs to write the file to disk

var fs = require('fs');
fs.writeFile('myjsonfile.json', json, 'utf8', callback);
//if you want to append it read the json file and convert it back to an object

fs.readFile('myjsonfile.json', 'utf8', function readFileCallback(err, data){
    if (err){
        console.log(err);
    } else {
    obj = JSON.parse(data); //now it an object
    obj.table.push({id: 2, square:3}); //add some data
    json = JSON.stringify(obj); //convert it back to json
    fs.writeFile('myjsonfile.json', json, 'utf8', callback); // write it back 
}});