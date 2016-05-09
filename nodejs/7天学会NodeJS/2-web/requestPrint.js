var http = require('http');
http.createServer(function (request, response) {
    response.writeHead(200, { 'Content-Type': 'text/plain' });

    request.on('data', function (chunk) {
    });

    request.on('end', function () {
        response.write("hehehehe ahahahahahh hehheheh");
	response.end();
    });
}).listen(8080);
