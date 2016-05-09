/**
 * Created by wangqi on 16/4/27.
 */
var express = require('express');
var attachments = express.Router();

/* GET users listing. */
attachments.get('/', function(req, res, next) {
    //console.dir(express().locals);
    //res.send('respond with a resource');
    //res.attachment('public/images/2.png');
    //res.sendfile('public/images/2.png');
    //res.download('public/images/2.png');

    res.links({
        next: 'http://localhost:3000/stylesheets/style.css'
    });
    res.redirect('/attachments/redirectto');
    //res.render('wang');
});

attachments.get('/redirectto',function (req,res,next) {
    res.render('wang');
})

module.exports = attachments;