"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const array1 = [1, "2", 3, "4"];
const [item1, item2, ...rest] = array1;
console.log("rest", rest); // rest sẽ có gtri là các phần tử còn lại trong array
const person = {
    fullname: "Nghia",
    age: 22,
    job: "DEV"
};
const { job: j, fullname, age } = person;
console.log(j);
console.log(fullname);
//clone array1 to array2
const array2 = [...array1];
console.log("array2: ", array2);
console.log("array2 === array1:", array2 === array1);
console.log("array2 == array1:", array2 == array1);
const array3 = [...array1, 5, '6'];
console.log(array3);
// Question 3:
const cold = ['autumn', 'winter'];
const warm = ['spring', 'summer'];
const season = [...cold, ...warm];
console.log(season);
