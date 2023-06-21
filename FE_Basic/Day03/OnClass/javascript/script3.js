var addStudentForm = $("#addStudentForm");
var sumRow = $("#tblStudent tr:lastChild")
var id = 4;

function addStudentFormSubmitHandler(event) {
    id++;
    alert("submit")
    event.preventDefault();
    var row = 
    `
    <tr>
        <td>${id}</td>
        <td>Thang4</td>
        <td>01-09-1994</td>
        <td>Des1</td>
        <td><button onclick="onDelete(event)">Delete</button></td>
    </tr>
    `
    
    addStudentForm.last

}

addStudentForm.on("submit", addStudentFormSubmitHandler);

