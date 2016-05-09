var express = require('express');
var app = express();
app.get('/', function(req, res){
    res.send('hello world '+req.query.wang);
});
app.listen(3000);
