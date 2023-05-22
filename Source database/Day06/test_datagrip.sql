-- Câu 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS sp_getAccount_OfDepartment;
DELIMITER //
CREATE PROCEDURE sp_getAccount_OfDepartment(IN departmentName Varchar(50))
BEGIN
	SELECT a.AccountID , a.FullName , a.DepartmentID , d.DepartmentName
	FROM Account a
	JOIN Department d ON a.DepartmentID = d.DepartmentID
	WHERE d.DepartmentName = departmentName;
END //
DELIMITER ;
SET @p0='Dev'; CALL `sp_getAccount_OfDepartment`(@p0);


-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_getQuantityOfAccount_EachGroup;
DELIMITER $$
CREATE PROCEDURE sp_getQuantityOfAccount_EachGroup(IN groupId INT)
BEGIN
	SELECT COUNT(ga.AccountID)
	FROM GroupAccount ga
	WHERE ga.GroupID = groupId;
END$$
DELIMITER ;


-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
DROP PROCEDURE IF EXISTS sp_getListQuestion_ByType_InCurrentMonth;
DELIMITER $$
CREATE PROCEDURE sp_getListQuestion_ByType_InCurrentMonth()
BEGIN
	SELECT tq.TypeID, COUNT(q.QuestionID)
	FROM  TypeQuestion tq
	INNER JOIN Question q ON q.TypeID =  tq.TypeID
    WHERE MONTH(q.CreateDate) = MONTH(NOW()) AND YEAR(q.CreateDate) = YEAR(NOW())
	GROUP BY tq.TypeID;
END $$
DELIMITER ;

CALL sp_getListQuestion_ByType_InCurrentMonth();


-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_getTypeIDQuestion_HasMostQuestion;
DELIMITER $$
CREATE PROCEDURE sp_getTypeIDQuestion_HasMostQuestion(OUT out_TypeID INT)
BEGIN
	WITH `Count_Max_Question_By_Type` AS (
		SELECT q.TypeID, COUNT(q.QuestionID) AS `So_CauHoi`
		FROM Question q
		GROUP BY q.TypeID
	)
	SELECT `Count_Max_Question_By_Type`.TypeID INTO out_TypeID
	FROM `Count_Max_Question_By_Type`
    WHERE `Count_Max_Question_By_Type`.`So_CauHoi` = (SELECT MAX(`So_CauHoi`) FROM Count_Max_Question_By_Type) ;
END $$
DELIMITER ;

SET @v_typeID = 0;
CALL sp_getTypeIDQuestion_HasMostQuestion(@v_typeID);
SELECT @v_typeID;


-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS sp_getTypeQuestion_HasMostQuestion;
DELIMITER $$
CREATE PROCEDURE sp_getTypeQuestion_HasMostQuestion(OUT out_TypeName VARCHAR(20))
BEGIN
	WITH `Count_Max_Question_By_Type` AS (
		SELECT q.TypeID, COUNT(q.QuestionID) AS `So_CauHoi`, TQ.TypeName
		FROM Question q
		INNER JOIN TypeQuestion TQ on q.TypeID = TQ.TypeID
		GROUP BY q.TypeID
	)
	SELECT `Count_Max_Question_By_Type`.TypeName INTO out_TypeName
	FROM `Count_Max_Question_By_Type`
    WHERE `Count_Max_Question_By_Type`.`So_CauHoi` = (SELECT MAX(`So_CauHoi`) FROM Count_Max_Question_By_Type) ;
END $$
DELIMITER ;

SET @v_typeName = '';
CALL sp_getTypeQuestion_HasMostQuestion(@v_typeName);
SELECT @v_typeName;


-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS sp_getNameGroupOrUsername;
DELIMITER $$
CREATE PROCEDURE sp_getNameGroupOrUsername(IN in_String VARCHAR(50))
BEGIN
	SELECT g.GroupName, g.GroupID
	FROM `Group` g
	WHERE g.GroupName LIKE CONCAT('%', in_String, '%')
	UNION
	SELECT a.Username, a.accountid
	FROM `Account` a
	WHERE a.Username LIKE CONCAT('%', in_String, '%');
END $$
DELIMITER ;
CALL sp_getNameGroupOrUsername('g');


/*Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
trong store sẽ tự động gán:
	username sẽ giống email nhưng bỏ phần @..mail đi
	positionID: sẽ có default là developer
	departmentID: sẽ được cho vào 1 phòng chờ
Sau đó in ra kết quả tạo thành công*/
DROP PROCEDURE IF EXISTS sp_formInputForUser;
DELIMITER $$
CREATE PROCEDURE sp_formInputForUser(IN in_Fullname VARCHAR(50), IN in_Email VARCHAR(60))
BEGIN
	DECLARE var_PositionID VARCHAR(20);
	SELECT p.PositionID INTO var_PositionID
	FROM `Position` p
	WHERE p.PositionName = 'Developer';

    INSERT INTO `Account` ( Email, Username, FullName, DepartmentID, PositionID, CreateDate)
    VALUES (in_Email, SUBSTRING_INDEX(trim(in_Email),'@',1), in_Fullname, 11, var_PositionID, DATE(NOW()));
END $$
DELIMITER ;

CALL sp_formInputForUser('Lai Duy Nghia', 'ldnghia@gmail.com');


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS sp_getQuestionHasLongestContent_ByType;
DELIMITER $$
CREATE PROCEDURE sp_getQuestionHasLongestContent_ByType(IN in_TypeName VARCHAR(30))
BEGIN
	WITH TMP AS (
	    SELECT q.QuestionID, q.Content, CHAR_LENGTH(q.Content) AS 'Length of content'
		FROM Question q
		INNER JOIN TypeQuestion tq on q.TypeID = tq.TypeID
		WHERE tq.TypeName = in_TypeName
	)
    SELECT *
    FROM TMP
    WHERE TMP.`Length of content` = (SELECT MAX(`Length of content`) FROM TMP) ;
END $$
DELIMITER ;

CALL sp_getQuestionHasLongestContent_ByType('Essay');
CALL sp_getQuestionHasLongestContent_ByType('Multiple-Choice');


-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_deleteExamByID;
DELIMITER $$
CREATE PROCEDURE sp_deleteExamByID(IN in_ExamID INT)
BEGIN
    DELETE
    FROM ExamQuestion eq
    WHERE eq.ExamID = in_ExamID; -- Khi có delete cascade thì ko cần đoạn nay

    DELETE
	FROM Exam e
	WHERE e.ExamID = in_ExamID;
END $$
DELIMITER ;


/*Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
dụng store ở câu 9 để xóa)
Sau đó in số lượng record đã remove từ các table liên quan trong khi
removing*/



/*Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
chuyển về phòng ban default là phòng ban chờ việc*/
DROP PROCEDURE IF EXISTS sp;
DELIMITER $$
CREATE PROCEDURE sp_deleteDepartmentByName(IN in_DepartmentName VARCHAR(50))
BEGIN
	DECLARE departmentID_variable INT;
	SELECT d.DepartmentID INTO departmentID_variable
	FROM Department d
    WHERE d.DepartmentName = in_DepartmentName;

	UPDATE `Account` a
    SET a.DepartmentID = 11
    WHERE a.DepartmentID = departmentID_variable;

	DELETE
	FROM `Department` d
    WHERE d.DepartmentID = departmentID_variable;
END $$
DELIMITER ;
CALL sp_deleteDepartmentByName('HR');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS sp_getQuantityOfQuestion_EachMonthInThisYear;
DELIMITER $$
CREATE PROCEDURE sp_getQuantityOfQuestion_EachMonthInThisYear()
BEGIN
	SELECT Months.`Month`, COALESCE(COUNT(Question.QuestionID), 0) AS NumQuestions -- Sử dụng COALESCE() dể convert NULL => 0
	FROM (
		SELECT 1 AS `Month` UNION SELECT 2 UNION SELECT 3 UNION SELECT 4
		UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8
		UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12) Months
	LEFT JOIN Question ON Months.`Month` = MONTH(Question.CreateDate) AND YEAR(Question.CreateDate) = YEAR(NOW())
	GROUP BY Months.`Month`;
END $$
DELIMITER ;

/*DECLARE i INT UNSIGNED DEFAULT 1;
DECLARE num_questions INT UNSIGNED;
WHILE i <= 12 DO
	SELECT COUNT(*) INTO num_questions
	FROM Question
	WHERE YEAR(CreateDate) = YEAR(NOW()) AND MONTH(CreateDate) = i;
	SELECT MONTHNAME()
	SET i = i + 1;
END WHILE;*/

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
-- tháng")
-- Tạo stored procedure để in ra số lượng câu hỏi được tạo trong mỗi tháng của 6 tháng gần đây nhất
DROP PROCEDURE IF EXISTS `sp_getQuestions_Last_6_Months`;
DELIMITER $$
CREATE PROCEDURE `sp_getQuestions_Last_6_Months`()
BEGIN
WITH TMP AS
(
    SELECT 1 AS `MONTH`
    UNION SELECT 2 AS `MONTH`
    UNION SELECT 3 AS `MONTH`
    UNION SELECT 4 AS `MONTH`
    UNION SELECT 5 AS `MONTH`
    UNION SELECT 6 AS `MONTH`
    UNION SELECT 7 AS `MONTH`
    UNION SELECT 8 AS `MONTH`
    UNION SELECT 9 AS `MONTH`
    UNION SELECT 10 AS `MONTH`
    UNION SELECT 11 AS `MONTH`
    UNION SELECT 12 AS `MONTH`
)
SELECT CONCAT(TMP.Month,'/',YEAR(q.CreateDate)) AS `Month` -- , COUNT(q.QuestionID) AS `Number of Questions`
FROM TMP
LEFT JOIN `Question` q ON TMP.`MONTH` = MONTH(q.CreateDate)
WHERE q.createdate >= subdate(now(), interval 5 month)
GROUP BY TMP.`MONTH`, YEAR(q.CreateDate)
ORDER BY YEAR(q.CreateDate), TMP.`MONTH`;
END $$
DELIMITER ;

CALL `sp_getQuestions_Last_6_Months`();
