/**
 * Created by wangqi on 16/4/27.
 */
var express = require('express');
var reqrouter = express.Router();

/* GET users listing. */
reqrouter.get('/:id', function(req, res, next) {
    console.dir(req.route)
    res.send('respond with a resource '+req.signedCookies.wang);
});

module.exports = reqrouter;
