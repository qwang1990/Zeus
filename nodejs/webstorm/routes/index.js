var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' },function (err,html) {
    console.dir(html);
    //res.send(html+req.ip+" "+req.path+" "+req.host);
    res.json(null);
  });
  //next();
});

function foo() {

}

module.exports = router;
