/**
 * Created by wangqi on 16/5/4.
 */
"use strict";
var person = {
    name:"张三"
};

var proxy = new Proxy(person,{
    get:function (target,property) {
        if(property in target){
            console.log(property);
            return target[property];
        }else {
            return 'do not have this property:'+property;
        }
    }
});

console.log(proxy.name);