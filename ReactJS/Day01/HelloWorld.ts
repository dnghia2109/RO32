var message: string = "Hello World";
console.log(message);

const person = {
    name : "Nghia",
    age : 22
}

const printNameAge = (name: string, age: number) => {
    console.log(`name: ${name}, age: ${age}`);
}

printNameAge(person.name, person.age)