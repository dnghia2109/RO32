/*Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
trước 1 năm trước*/
DROP TRIGGER IF EXISTS trigger_insert_group;
DELIMITER $$
CREATE TRIGGER trigger_insert_group
BEFORE INSERT
ON `Group` FOR EACH ROW
BEGIN
    IF TIMESTAMPDIFF(YEAR, NEW.CreateDate, NOW()) > 1 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Group có ngày tạo phai gần hơn 1 năm trở lại';
    end if;
END $$
DELIMITER ;


/*Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
"Sale" cannot add more user"*/
DROP TRIGGER IF EXISTS trigger_donot_insert_account_to_SaleDepartment;
DELIMITER $$
CREATE TRIGGER trigger_doNot_insert_account_to_SaleDepartment
BEFORE INSERT
ON `Account` FOR EACH ROW
BEGIN
    DECLARE v_departmentID INT;
    SELECT d.DepartmentID INTO v_departmentID
    FROM `Department` d
    WHERE d.DepartmentName = 'Sales';

    IF NEW.DepartmentID = v_departmentID THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department Sales cannot add more user';
    end if ;
END $$
DELIMITER ;

DROP TRIGGER IF EXISTS trigger_donot_update_account_to_SaleDepartment;
DELIMITER $$
CREATE TRIGGER trigger_doNot_update_account_to_SaleDepartment
BEFORE UPDATE
ON `Account` FOR EACH ROW
BEGIN
    DECLARE v_departmentID INT;
    SELECT d.DepartmentID INTO v_departmentID
    FROM `Department` d
    WHERE d.DepartmentName = 'Sales';

    IF NEW.DepartmentID = v_departmentID THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department Sales cannot add more user';
    end if ;
END $$
DELIMITER ;


-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS trigger_MaxAccount_EachGroup_Is5;
DELIMITER $$
CREATE TRIGGER trigger_MaxAccount_EachGroup_Is5
BEFORE INSERT ON GroupAccount FOR EACH ROW
BEGIN
    DECLARE var_CountGroupID TINYINT;

    SELECT COUNT(GA.AccountID) -- INTO var_CountGroupID
    FROM GroupAccount GA
    WHERE GA.GroupID  =  NEW.GroupID;
    IF (var_CountGroupID >= 5) THEN
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Cant add more User to This Group';
    END IF;
END $$
DELIMITER ;


-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS trigger_MaxQuestion_EachExam_10;
DELIMITER $$
CREATE TRIGGER trigger_MaxQuestion_EachExam_10
BEFORE INSERT ON ExamQuestion FOR EACH ROW
BEGIN
    DECLARE var_CountQuestion TINYINT;
    SELECT COUNT(EQ.QuestionID) INTO var_CountQuestion
    FROM ExamQuestion EQ
    WHERE EQ.ExamID = NEW.ExamID;
    IF (var_CountQuestion >= 10) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Can not add more Question to This Exam';
    END IF;
END $$
DELIMITER ;


/*Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
tin liên quan tới user đó
*/
DROP TRIGGER IF EXISTS trigger_doNot_DeleteAdminAccount;
DELIMITER $$
CREATE TRIGGER trigger_doNot_DeleteAdminAccount
BEFORE DELETE ON Account FOR EACH ROW
BEGIN
    DECLARE var_email VARCHAR(50);
    SELECT Email INTO var_email
    FROM Account
    WHERE AccountID = OLD.AccountID;
    IF (var_email = 'admin@gmail.com') THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Can not delete admin account';
    END IF $$;
END $$
DELIMITER ;


/*Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
vào departmentID thì sẽ được phân vào phòng ban "waiting Department"*/
DROP TRIGGER IF EXISTS trigger_setDefault_Apartment;
DELIMITER $$
CREATE TRIGGER trigger_setDefault_Apartment
BEFORE INSERT ON Account FOR EACH ROW
BEGIN
    DECLARE v_WaitingRoom_ID INT;
    SELECT d.DepartmentID INTO v_WaitingRoom_ID
    FROM Department d
    WHERE d.DepartmentName = 'Waiting room';
    IF (NEW.DepartmentID IS NULL) THEN
        SET NEW.DepartmentID = v_WaitingRoom_ID;
    END IF;
END $$
DELIMITER ;


/*Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
question, trong đó có tối đa 2 đáp án đúng.*/
DROP TRIGGER IF EXISTS trigger_limit_answer_question;
DELIMITER $$
CREATE TRIGGER trigger_setDefault_Apartment
BEFORE INSERT ON Answer FOR EACH ROW
BEGIN
    DECLARE v_CountAnswersEachQuestion INT;
    DECLARE v_CountCorrectAnswerEachQuestion INT;

    SELECT COUNT(a.AnswerID) INTO v_CountAnswersEachQuestion
    FROM Answer a
    WHERE a.QuestionID = NEW.QuestionID;

    SELECT COUNT(a.AnswerID) INTO v_CountCorrectAnswerEachQuestion
    FROM Answer a
    WHERE a.QuestionID = NEW.QuestionID AND a.isCorrect = 0;

    IF (v_CountAnswersEachQuestion >= 4) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Can not insert more answers for this question';
    END IF ;

    IF (v_CountCorrectAnswerEachQuestion >= 2) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Can not insert more correct answers for this question';
    END IF ;
END $$
DELIMITER ;


/*Question 8: Viết trigger sửa lại dữ liệu cho đúng:
Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database*/

-- Bảng Account chưa có trường gender nên để tạm
DROP TRIGGER IF EXISTS trigger_format_gender;
DELIMITER $$
CREATE TRIGGER trigger_format_gender
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
    IF (NEW.gender = 'MALE') THEN
        SET NEW.gender = 'M';
    ELSEIF (NEW.gender = 'FEMALE') THEN
        SET NEW.gender = 'F';
    ELSEIF (NEW.gender = 'UNKNOWN') THEN
        SET NEW.gender = 'U';
    END IF;
END $$
DELIMITER ;


-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS trigger_delete_exam;
DELIMITER $$
CREATE TRIGGER trigger_delete_exam
BEFORE DELETE ON Exam
FOR EACH ROW
BEGIN
    DECLARE v_date_create_exam DATE;
    SELECT e.CreateDate INTO v_date_create_exam
    FROM Exam e
    WHERE e.ExamID = OLD.ExamID;

    IF (DATEDIFF(v_date_create_exam, CURRENT_DATE) <= 2 ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Can not delete exam was created 2 days ago';
    ELSE
        DELETE
        FROM ExamQuestion eq
        WHERE eq.ExamID = OLD.ExamID;
        DELETE
        FROM Exam e
        WHERE e.ExamID = OLD.ExamID;
    END IF;
END $$
DELIMITER ;


/*Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
question khi question đó chưa nằm trong exam nào*/

DROP TRIGGER IF EXISTS trigger_update_question;
DELIMITER $$
CREATE TRIGGER trigger_update_question
BEFORE UPDATE ON Question
FOR EACH ROW
BEGIN
    DECLARE v_count_question_in_exam INT;
    SELECT COUNT(eq.QuestionID) INTO v_count_question_in_exam
    FROM ExamQuestion eq
    WHERE eq.QuestionID = NEW.QuestionID;

    IF (v_count_question_in_exam > 0) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Can not update question exsist in exam';
    END IF;
END $$
DELIMITER ;

DROP TRIGGER IF EXISTS trigger_update_question;
DELIMITER $$
CREATE TRIGGER trigger_update_question
BEFORE DELETE ON Question
FOR EACH ROW
BEGIN
    DECLARE v_count_question_in_exam INT;
    SELECT COUNT(eq.QuestionID) INTO v_count_question_in_exam
    FROM ExamQuestion eq
    WHERE eq.QuestionID = OLD.QuestionID;

    IF (v_count_question_in_exam > 0) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Can not delete question exsist in exam';
    END IF;
END $$
DELIMITER ;
/*Question 12: Lấy ra thông tin exam trong đó:
Duration <= 30 thì sẽ đổi thành giá trị "Short time"
30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
Duration > 60 thì sẽ đổi thành giá trị "Long time"*/

SELECT e.ExamID, e.Code, e.Title , e.ExamID, e.Code, e.Title ,
CASE
    WHEN Duration <= 30 THEN 'Short time'
    WHEN Duration <= 60 THEN 'Medium time'
ELSE 'Longtime'
END AS Duration, e.CreateDate, e.Duration
FROM Exam e;


/*Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
là the_number_user_amount và mang giá trị được quy định như sau:
Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher*/
SELECT ga.GroupID, COUNT(ga.GroupID) ,
CASE
    WHEN COUNT(ga.GroupID) <= 5 THEN 'few'
    WHEN COUNT(ga.GroupID) <= 20 THEN 'normal'
ELSE 'higher'
END AS the_number_user_amount
FROM GroupAccount ga
GROUP BY ga.GroupID;


/*Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
không có user thì sẽ thay đổi giá trị 0 thành "Không có User"*/
SELECT d.DepartmentName ,
CASE
    WHEN COUNT(a.DepartmentID) = 0 THEN 'Không có User'
    ELSE COUNT(a.DepartmentID)
END AS SL FROM Department d
LEFT JOIN Account a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID;