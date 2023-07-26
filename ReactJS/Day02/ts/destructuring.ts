

//console.log(2);
const array1: (string|number)[] = [1, "2", 3, "4"];
const [item1, item2, ,item3] = array1;

console.log(item1);

const person = {
    fullname: "Nghia",
    age: 22,
    job: "DEV"
};

const {job :j, fullname, age} = person;
console.log(j);
console.log(fullname);

// QUESTION 1:
var date: number[] = [2023,7,24];
const [year, month, day] = date;
console.log(day + `-` + month + `-` + year);
