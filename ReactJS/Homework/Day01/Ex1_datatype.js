"use strict";
class Department {
    constructor(name) {
        this.id = ++Department.count;
        this.name = name;
    }
    getId() {
        return this.id;
    }
    getName() {
        return this.name;
    }
}
Department.count = 0;
const newDepartment = new Department("DEV");
const newDepartment1 = new Department("DEP1");
const newDepartment2 = new Department("DEP2");
console.log(`Id: ${newDepartment.getId()} , name: ${newDepartment.getName()} `);
console.log(`Id: ${newDepartment1.getId()} , name: ${newDepartment1.getName()} `);
console.log(`Id: ${newDepartment2.getId()} , name: ${newDepartment2.getName()} `);
class Position {
    constructor(name) {
        this.id = ++Position.count;
        this.name = name;
    }
    getId() {
        return this.id;
    }
    getName() {
        return this.name;
    }
}
Position.count = 0;
const position1 = new Position("Dev01");
console.log(`Id: ${position1.getId()} , name: ${position1.getName()} `);
// class
