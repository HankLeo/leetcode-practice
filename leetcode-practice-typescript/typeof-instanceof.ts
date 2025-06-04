const symbolPrimitive: any = Symbol('a');
console.log(typeof symbolPrimitive) // symbol
console.log(symbolPrimitive instanceof Symbol) // false 原始类型不是Symbol的实例

const symbol: any = Object(symbolPrimitive);
console.log(typeof symbol) // object
console.log(symbol instanceof Symbol) // true
