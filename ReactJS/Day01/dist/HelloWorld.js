var message = "Hello World";
console.log(message);
var person = {
    name: "Nghia",
    age: 22
};
var printNameAge = function (name, age) {
    console.log("name: ".concat(name, ", age: ").concat(age));
};
printNameAge(person.name, person.age);
