// // console.log(a);
// // var b;
// // let c;
// // function sum(a, b) {
// //     var total = a + b
// //     return total
// // }
// // console.log(total);


// var tbStudent = document.getElementById("tblStudent");
// var addStudentForm = document.getElementById("addStudentForm");
// var fullName = document.getElementById("name");
// var date = document.getElementById("date");
// var des = document.getElementById("des");
// var id = 4;
// function onDelete1(event) {
//     // alert("deleted")
//     console.log(event);
//     var currentBtn = event.target;
//     var td = currentBtn.parentNode;
//     var tr = td.parentNode;
//     var table = tr.parentNode;
//     console.log(tr)
//     table.removeChild(tr);
//     // tbStudent.deleteRow(1);
// }

// function onDelete(event) {
//     // alert("deleted")
//     console.log(event);
//     var currentBtn = event.target;
//     var td = currentBtn.parentNode;
//     var tr = td.parentNode;
    
//     console.log(tr.innerHTML);
//     tbStudent.innerHTML = tbStudent.innerHTML.replace(tr.innerHTML, "");
//     console.log(tbStudent.innerHTML);
// }

// addStudentForm.addEventListener("submit", function(event) {
//     event.preventDefault();
//     alert("add");
//     id = id + 1;
//     var row = tbStudent.insertRow(id);
//     var cellId = row.insertCell(0);
//     cellId.innerHTML = id;
//     var cellId = row.insertCell(1);
//     cellId.innerHTML = fullName.value;
//     var cellId = row.insertCell(2);
//     cellId.innerHTML = date.value;
//     var cellId = row.insertCell(3);
//     cellId.innerHTML = des.value;
//     var cellId = row.insertCell(4);
//     cellId.innerHTML = `<button onclick="onDelete(event)">Del</button>`;


//     var row = `
//         <tr>
//             <td>${id}</td>
//             <td>${fullName.value}</td>
//             <td>${date.value}</td>
//             <td>${des.value}</td>
//             <td><button onclick="onDelete(event)">Del</button></td>
//         </tr>
//     `
    
// })