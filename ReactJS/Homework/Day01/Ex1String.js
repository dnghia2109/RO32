"use strict";
const string1 = " lai Duy nghia";
const stringArr = string1.trim().split(/\s+/);
console.log(stringArr.length);
// const countWord
// for (let i = 0; i < string1.length; i++) {
//     if (string1[i] == " ") {
//         continue;
//     }
//     const element = string1[i];
// }
// question2:
// console.log(stringArr[0]);
// const upperCaseFirstLetter = (input: string) => {
//     const firstLetter = input[0].trim().toUpperCase();
//     const output = `${firstLetter}${input.slice(1)}`
//     return output;
// }
// stringArr.forEach(element => {
//     const rs = `` + upperCaseFirstLetter(element);
// });
// upperCaseFirstLetter("nghia")
const getGreeting = (firstname, lastName) => {
    const greeting1 = () => console.log(`Hello ${firstname} ${lastName}`);
    greeting1();
};
getGreeting("lai", "nghia");
