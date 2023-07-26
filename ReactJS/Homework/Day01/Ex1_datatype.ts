

class Department {
    private static count = 0;
    private id:number;
    private name:string

    public constructor(name: string) {
        this.id = ++Department.count;
        this.name = name;
    }

    public getId(): number {
        return this.id;
    }

    public getName(): string {
        return this.name;
    }
}

const newDepartment = new Department("DEV");
const newDepartment1 = new Department("DEP1");
const newDepartment2 = new Department("DEP2");
console.log(`Id: ${newDepartment.getId()} , name: ${newDepartment.getName()} `);
console.log(`Id: ${newDepartment1.getId()} , name: ${newDepartment1.getName()} `);
console.log(`Id: ${newDepartment2.getId()} , name: ${newDepartment2.getName()} `);

class Position {
    private static count = 0;
    private id:number;
    private name:string

    public constructor(name: string) {
        this.id = ++Position.count;
        this.name = name;
    }

    public getId(): number {
        return this.id;
    }

    public getName(): string {
        return this.name;
    }
}
const position1 = new Position("Dev01");
console.log(`Id: ${position1.getId()} , name: ${position1.getName()} `);

// class