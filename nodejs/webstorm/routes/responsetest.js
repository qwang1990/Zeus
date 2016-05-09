/**
 * Created by wangqi on 16/4/27.
 */
var express = require('express');
var responsetest = express.Router();

/* GET users listing. */
responsetest.get('/', function(req, res, next) {
   // console.dir(express().locals);
    res.status(404).send('respond with a resource');
});

module.exports = responsetest;