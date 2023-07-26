"use strict";
const account1 = {
    name: "Acount1",
    salary: 5230.5
};
const account2 = {
    name: "Acount1",
    salary: 15230.5
};
const printSalary = (account) => {
    console.log(Number.parseInt(String(account.salary)));
};
printSalary(account1);
printSalary(account2);
