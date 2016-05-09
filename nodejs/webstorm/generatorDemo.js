/**
 * Created by wangqi on 16/5/4.
 */

function * helloworldGenerator() {
    yield 'hello';
    yield 'world';
    return 'end';
}

var hw = helloworldGenerator();

console.dir(hw.next());
console.dir(hw.next());
console.dir(hw.next());

function* f() {
    for(var i=0;true;i++) {
        var result = yield i;
        if(result){i=-1;}
    }
}

var g = f();

console.dir(g.next(true));
console.dir(g.next(true));
console.dir(g.next(true));