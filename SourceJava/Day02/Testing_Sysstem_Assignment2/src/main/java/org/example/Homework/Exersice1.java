package org.example.Homework;

import org.example.Entity.Account;
import org.example.Entity.Department;
import org.example.Entity.Group;
import org.example.Entity.Position;

import java.time.LocalDate;

public class Exersice1 {
    public static void main(String[] args) {
    // Tạo Department
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Marketing";
        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Sale";
        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Dev";


    // Tạo Position
        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = Position.PositionName.Dev;
        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = Position.PositionName.PM;
        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = Position.PositionName.Scrum_Master;
        Position pos4 = new Position();
        pos4.id = 4;
        pos4.name = Position.PositionName.Test;

    // Tạo Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing System";
        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";
        Group group3 = new Group();
        group3.id = 3;
        group3.name = "Sale";
        Group group4 = new Group();
        group4.id = 4;
        group4.name = "Group4";

    // Tạo Account
        Account acc1 = new Account();
        acc1.id = 1;
        acc1.email = "daonq1@gmai.com";
        acc1.userName = "daonq1";
        acc1.fullName = "Dao Nguyen 1";
        acc1.department = department1;
        acc1.position = pos1;
        acc1.createDate = LocalDate.now();
        acc1.groups = new Group[]{ group1, group2, group4 };

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.email = "daonq2@gmai.com";
        acc2.userName = "daonq2";
        acc2.fullName = "Dao Nguyen 2";
        acc2.department = department2;
        acc2.position = pos2;
        acc2.createDate = LocalDate.of(2019, 3, 17);
        acc2.groups = new Group[] { group3, group2, group1 };

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.email = "daonq3@gmai.com";
        acc3.userName = "daonq3";
        acc3.fullName = "Dao Nguyen 3";
        acc3.department = department3;
        acc3.position = pos3;
        acc3.createDate = LocalDate.now();
        acc3.groups = new Group[] {group1, group4};

        Account acc4 = new Account();
        acc4.id = 4;
        acc4.email = "ngvanA@gmai.com";
        acc4.userName = "ngvanA";
        acc4.fullName = "Nguyen Van A";
        acc4.department = department2;
        acc4.position = pos4;
        acc4.createDate = LocalDate.of(2022,5,21);
        acc4.groups = new Group[] {group3, group4};

        Account acc5 = new Account();
        acc5.id = 5;
        acc5.email = "ngvanB@gmai.com";
        acc5.userName = "ngvanB";
        acc5.fullName = "Nguyen Van B";
        acc5.department = department1;
        acc5.position = pos2;
        acc5.createDate = LocalDate.of(2021,10,2);
        acc5.groups = new Group[] {group1, group3, group4};

        Account acc6 = new Account();
        acc6.id = 6;
        acc6.email = "ngvanC@gmai.com";
        acc6.userName = "ngvanC";
        acc6.fullName = "Nguyen Van C";
        acc6.department = department1;
        acc6.position = pos1;
        acc6.createDate = LocalDate.of(2023, 2,10);
        acc6.groups = new Group[] {null};

    // Add Group Account
        group1.accounts = new Account[] { acc1, acc2, acc3, acc5 };
        group2.accounts = new Account[] { acc1, acc2 };
        group3.accounts = new Account[] { acc2, acc4, acc5 };
        group4.accounts = new Account[] { acc1, acc3, acc4, acc5 };


//        // Question 1:
//        checkDepartmentAccount(acc2);
//
//        // Question 2:
//        checkGroupAccountJoin(acc2);
//
//        // Question 3:
//        checkDepartmentAccountWithTernary(acc2);
//
//        // Question 4:
//        checkPositionAccountWithTernary(acc1);
//
//        // Question 8:
        Account[] listAccount = {acc1, acc2, acc3, acc4, acc5, acc6};
//        getAccountDetailUsingForEach(listAccount);
//
//        // Question 9:
//        Department[] listDepartment = {department1, department2, department3};
//        getDepartmentDetailUsingForEach(listDepartment);

        getAccountDetailUsingForLoopExceptAccount02(listAccount);

    }

    // Question 1: Kiểm tra account thứ 2
    // Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
    // "Nhân viên này chưa có phòng ban"
    // Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."
    public static void checkDepartmentAccount(Account account) {
        if (account.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban.");
        } else {
            System.out.println("Phòng ban của nhân viên này là: " + account.department.name);
        }
    }

    // Question 2: Kiểm tra account thứ 2
    // Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
    // Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
    // này là Java Fresher, C# Fresher"
    // Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
    // quan trọng, tham gia nhiều group"
    // Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
    // người hóng chuyện, tham gia tất cả các group"
    public static void checkGroupAccountJoin(Account account) {
        // int countGroup = account.groups.length;
        if (account.groups == null) {
            System.out.println("Nhân viên này chưa có group");
        } else {
            int countGroup = account.groups.length;
            if (countGroup == 1 || countGroup == 2) {
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
            } else if (countGroup == 3) {
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
            } else {
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
            }
        }
    }

    // Question 3: Sử dụng toán tử ternary để làm Question 1
    public static void checkDepartmentAccountWithTernary(Account account) {
        System.out.println(account.department == null ? "Nhân viên này chưa có group" : "Phòng ban của nhân viên này là: " + account.department.name);
    }

    // Question 4: Sử dụng toán tử ternary để làm yêu cầu sau:
    // Kiểm tra Position của account thứ 1
    // Nếu Position = Dev thì in ra text "Đây là Developer"
    // Nếu không phải thì in ra text "Người này không phải là Developer"
    public static void checkPositionAccountWithTernary (Account account) {
        System.out.println(account.position.name == Position.PositionName.valueOf("Dev") ? "Đây là Developer" : "Người này không phải là Developer");
    }

    // Question 5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
    // Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
    // Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
    // Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
    // Còn lại in ra "Nhóm có nhiều thành viên"
    public static void checkQuantityAccountEachGroup(Group group) {
        if (group.accounts == null) {
            System.out.println(group.name + " chưa có thành viên tham gia");
        } else {
            int countAccount = group.accounts.length;
            switch (countAccount) {
                case 1:
                    System.out.println("Nhóm có 1 thành viên");
                    break;
                case 2:
                    System.out.println("Nhóm có 2 thành viên");
                    break;
                case 3:
                    System.out.println("Nhóm có 3 thành viên");
                    break;
                default:
                    System.out.println("Nhóm có 4 thành viên");
                    break;
            }

        }
    }

    // Question 6:
    // Sử dụng switch case để làm lại Question 2
    public static void checkcheckGroupAccountJoinSwitchCase(Account account) {
        if (account.groups == null) {
            System.out.println("Nhân viên này chưa có group");
        } else {
            int countGroup = account.groups.length;
            switch (countGroup) {
                case 1:
                    System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                    break;
                case 2:
                    System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");

                    break;
                case 3:
                    System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                    break;
                default:
                    System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                    break;
            }
        }
    }

    // Question 7:
    // Sử dụng switch case để làm lại Question 4
    public static void checkPositionAccountWithTernarySwitchCase (Account account) {
        String positionName = account.position.name.toString();
        switch (positionName) {
            case "Dev":
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
    }

    // Question 8: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban
    public static void getAccountDetailUsingForEach(Account[] accounts) {
        System.out.println("Danh sách thông tin nhân viên: ");
        for (Account account: accounts) {
            System.out.println("- Email: " + account.email + " - FullName: " + account.fullName
                    + " - Department: " + account.department.name);
        }

    }

    // Question 9: In ra thông tin các phòng ban bao gồm: id và name
    public static void getDepartmentDetailUsingForEach(Department[] departments) {
        System.out.println("Danh sách thông tin phòng ban: ");
        for (Department department: departments) {
            System.out.println("- Department ID: " + department.id + " - Department name: " + department.name);
        }
    }

    // Question 10: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban
    public static void getAccountDetailUsingForLoop(Account[] accounts) {
        System.out.println("Danh sách thông tin nhân viên: ");
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                    + " - Department: " + accounts[i].department.name);
        }
    }

    // Question 11: In ra thông tin các phòng ban bao gồm: id và name
    public static void getDepartmentDetailUsingForLoop(Department[] departments) {
        System.out.println("Danh sách thông tin phòng ban: ");
        for (int i = 0; i < departments.length; i++) {
            System.out.println(" Thông tin department thứ " + (i + 1) + ": \n\tDepartment ID: " + departments[i].id + " - Department name: " + departments[i].name);
        }
    }

    // Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
    public static void getAccountDetailUsingForLoopTop2(Account[] accounts) {
        System.out.println("Danh sách thông tin nhân viên: ");
        for (int i = 0; i < accounts.length; i++) {
            if (i <= 1) {
                System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                        + " - Department: " + accounts[i].department.name);
            }
        }
    }

    // Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2
    public static void getAccountDetailUsingForLoopExceptAccount02(Account[] accounts) {
        System.out.println("Danh sách thông tin nhân viên: ");
        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) {
                continue;
            }
            System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                    + " - Department: " + accounts[i].department.name);
        }
    }

    // Question 14: In ra thông tin tất cả các account có id < 4
    public static void getAccountDetailUsingForLoopAccountIDLessThan4(Account[] accounts) {
        System.out.println("Danh sách thông tin nhân viên: ");
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].id < 4) {
                System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                        + " - Department: " + accounts[i].department.name);
            }
        }
    }

    // Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20
    public static void question15() {
        for (int i = 0; i <= 20 ; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
        }
    }

    // Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
    // 16-10: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban
    public static void getAccountDetailUsingWhileLoop(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                    + " - Department: " + accounts[i].department.name);
            i++;
        }
    }

    // 16-11: In ra thông tin các phòng ban bao gồm: id và name
    public static void getDepartmentDetailUsingWhileLoop(Department[] departments) {
        System.out.println("Danh sách thông tin phòng ban: ");
        int i = 0;
        while (i < departments.length) {
            System.out.println(" Thông tin department thứ " + (i + 1) + ": \n\tDepartment ID: " + departments[i].id + " - Department name: " + departments[i].name);
            i++;
        }
    }

    // 16-12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
    public static void getAccountDetailUsingWhileLoopTop2(Account[] accounts) {
        int i = 1;
        while (i < accounts.length) {
            if (i <= 2) {
                System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                        + " - Department: " + accounts[i].department.name);
                i++;
            }
        }
    }

    // 16-13: In ra thông tin tất cả các account ngoại trừ account thứ 2
    public static void getAccountDetailUsingWhileLoopExceptAccount02(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            if (i == 1) {
                continue;
            }
            System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                    + " - Department: " + accounts[i].department.name);
            i++;
        }
    }

    // 16-14: In ra thông tin tất cả các account có id < 4
    public static void getAccountDetailUsingWhileLoopAccountIDLessThan4(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            if (accounts[i].id < 4) {
                System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                        + " - Department: " + accounts[i].department.name);
            }
            i++;
        }
    }

    // 16-15: In ra các số chẵn nhỏ hơn hoặc bằng 20
    public static void question15withWhileLoop() {
        int i = 0;
        while (i < 20) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
            i++;
        }
    }


    // Question 17: Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue
    // 17-10: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban
    public static void getAccountDetailUsingDoWhileLoop(Account[] accounts) {
        int i = 0;
        do {
            System.out.println("- Nhân viên thứ " + (i + 1) + ": \n\tEmail: " + accounts[i].email + " - FullName: " + accounts[i].fullName
                    + " - Department: " + accounts[i].department.name);
            i++;
        }

        while (i < accounts.length);
    }

}
