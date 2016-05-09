/**
 * Created by wangqi on 16/4/27.
 */
var express = require('express');
var cookiestest = express.Router();

/* GET users listing. */
cookiestest.get('/', function(req, res, next) {
    res.cookie("wang","ahahhhahaah",{signed:true});
    res.send("hello world!!");
});

module.exports = cookiestest;