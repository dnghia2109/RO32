$(document).ready(function () {
    const table = $("#employee-table");
  
    // Gọi API sử dụng Ajax và jQuery
    $.ajax({
      url: "http://localhost:8089/api/v1/employee/get-all",
      method: "GET",
      dataType: "json",
      success: function (data) {
        console.log(data);
        data.forEach(function (employee) {
            console.log(employee);
            const row = $(".content");
    
            $(".emp-id").text(employee.id).appendTo(row);
            $(".emp-name").text(employee.name).appendTo(row);
            $(".emp-title").text(employee.title).appendTo(row);
            $(".emp-age").text(employee.age).appendTo(row);
    
            table.append(row);
        });
      },
      error: function (xhr, status, error) {
        console.log("Đã xảy ra lỗi khi lấy danh sách nhân viên:", error);
      },
    });
  });


  