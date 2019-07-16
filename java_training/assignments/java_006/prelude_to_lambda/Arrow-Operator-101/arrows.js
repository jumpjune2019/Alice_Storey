window.addEventListener("load", init, false);
function init() {
    helloWorld("arrow");
    print("this is a test message");
    var message = [
        "hello",
        "world"
    ];
    printall(message);

}

helloWorld = name => console.log("hello " + name + " world");

print = msg => console.log(msg);

printall = list => list.forEach(print);

function CounterBad() {
  this.num = 0;  this.timer = setInterval(function add() {
    this.num++;
    console.log(this.num);
  }, 1000);
}
var a = new CounterBad();
// NaN
// NaN
// NaN
// ...

function Counter() {
  this.num = 0;  this.timer = setInterval(() => {
    this.num++;
    console.log(this.num);
  }, 1000);
}
a = new Counter();
// 1
// 2
// 3
// ...
