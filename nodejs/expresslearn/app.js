var express = require('express');
var app = express();

var User = {
id:1,name:'wang',
};

//app.param('user', function(req, res, next, id){
  app.param('user', function(req, res, next){
	console.log('i\'m here!');
	req.user = User;
	next();
});

app.param(function(name, fn){
  if (fn instanceof RegExp) {
    return function(req, res, next, val){
      var captures;
      if (captures = fn.exec(String(val))) {
	console.log('captures it')
        req.params[name] = captures;
        next();
      } else {
        next('route');
      }
    }
  }
});

app.param('id', /^\d+$/);

app.get('/user/:user', function(req, res){
  res.send('user ' +req.user.id+req.user.name);
});

app.param('range', /^(\w+)\.\.(\w+)?$/);

app.get('/range/:range', function(req, res){
  var range = req.params.range;
  res.send('from ' + range[1] + ' to ' + range[2]);
});

app.listen(3000);
