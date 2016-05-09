function printit(n,callback){
	console.log(n);
	callback(10000);
}

printit('hello',function(n){
var count = 0,
        i, j;

    for (i = n; i > 0; --i) {
        for (j = n; j > 0; --j) {
            count += 1;
        }
    }
	console.log(count);

});

console.log('finished');
