DROP DATABASE IF EXISTS DB_FinalExam;
CREATE DATABASE DB_FinalExam;
USE DB_FinalExam;


CREATE TABLE `Country`
(
    country_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,

);

CREATE TABLE ``
(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,

);

CREATE TABLE ``
(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,

);


/*DROP PROCEDURE IF EXISTS sp_;
DELIMITER $$
CREATE PROCEDURE ()
BEGIN
	SELECT tq.TypeID, COUNT(q.QuestionID)
	FROM  TypeQuestion tq
	INNER JOIN Question q ON q.TypeID =  tq.TypeID
    WHERE MONTH(q.CreateDate) = MONTH(NOW()) AND YEAR(q.CreateDate) = YEAR(NOW())
	GROUP BY tq.TypeID;
END $$
DELIMITER ;

CALL ;*/


/*DROP TRIGGER IF EXISTS trigger_donot_update_account_to_SaleDepartment;
DELIMITER $$
CREATE TRIGGER trigger_doNot_update_account_to_SaleDepartment
BEFORE UPDATE
ON  FOR EACH ROW
BEGIN

END $$
DELIMITER ;*/