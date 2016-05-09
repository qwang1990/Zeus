var fs = require('fs');
var rs = fs.createReadStream('./wang.txt');

rs.on('data', function (chunk) {
    console.log(chunk);
});

rs.on('end', function () {
console.log('i\'m finished!');
});

