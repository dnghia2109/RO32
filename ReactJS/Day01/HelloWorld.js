"use strict";
var message = "Hello World";
console.log(message);
const person = {
    name: "Nghia",
    age: 22
};
const printNameAge = (name, age) => {
    console.log(`name: ${name}, age: ${age}`);
};
printNameAge(person.name, person.age);
