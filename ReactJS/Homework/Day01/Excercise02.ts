interface Account {
    name: string;
    salary: number
}

const account1:Account = {
    name: "Acount1",
    salary: 5230.5
}
const account2:Account = {
    name: "Acount1",
    salary: 15230.5
}

const printSalary = (account:Account ) => {
    console.log(Number.parseInt(String(account.salary)));
}
printSalary(account1)
printSalary(account2)

// Question 2:


// Excercise 03



