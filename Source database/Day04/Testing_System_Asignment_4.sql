use `Testing_System`

-- Câu 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT a.AccountID , a.FullName , d.DepartmentID , d.DepartmentName 
FROM Account a 
LEFT JOIN Department d ON d.DepartmentID  = a.DepartmentID ;


-- Câu 2:Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT a.AccountID , a.CreateDate 
FROM Account a 
WHERE a.CreateDate < '2019-12-20';


-- Câu 3: Viết lệnh để lấy ra tất cả các Programmer Analyst I
SELECT *
FROM Account a 
JOIN `Position` p ON p.PositionID = a.PositionID 
WHERE p.PositionName = 'Programmer Analyst I';

-- Câu 4:Viết lệnh để lấy ra danh sách các phòng ban có > 9 nhân viên
SELECT d.DepartmentID , d.DepartmentName , count(a.AccountID) AS 'Quantity of employees'
FROM Department d 
LEFT JOIN Account a ON a.DepartmentID = d.DepartmentID 
GROUP BY d.DepartmentID , d.DepartmentName 
HAVING COUNT(a.DepartmentID) > 9

/*SELECT a.DepartmentID , COUNT(a.DepartmentID)
FROM Account a 
group by a.DepartmentID 
having COUNT(a.DepartmentID) > 3*/


-- Câu 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
/*SELECT eq.QuestionID , COUNT(DISTINCT eq.ExamID), GROUP_CONCAT(DISTINCT eq.ExamID) AS 'DanhSach'
FROM ExamQuestion eq
GROUP BY eq.QuestionID 
ORDER BY COUNT(DISTINCT eq.ExamID) DESC;*/

SELECT sub_table.QuestionID , sub_table.`So Luong` , sub_table.`Danh Sach Exam`
FROM ( SELECT eq.QuestionID, GROUP_CONCAT(DISTINCT eq.ExamID) AS 'Danh Sach Exam' , COUNT(DISTINCT ExamID) AS 'So Luong' 
	   FROM `ExamQuestion` eq
	   LEFT JOIN `Question` q ON q.QuestionID = eq.QuestionID
	   GROUP BY eq.QuestionID ) sub_table
WHERE sub_table.`So Luong` = ( SELECT MAX(sub_table1.`So Luong`) 
							  FROM (SELECT eq.QuestionID , COUNT(DISTINCT ExamID) AS 'So Luong' 
									FROM `ExamQuestion` eq										
									GROUP BY eq.QuestionID) sub_table1)
ORDER BY sub_table.QuestionID ASC;


-- Câu 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT cq.CategoryID , cq.CategoryName , COUNT(q.QuestionID) AS `Quantity questions`
FROM CategoryQuestion cq 
LEFT JOIN Question q ON q.CategoryID = cq.CategoryID 
GROUP BY cq.CategoryID, cq.CategoryName 
ORDER BY `Quantity questions` DESC;

/*SELECT CategoryID , COUNT(q.QuestionID) 
FROM Question q 
group by q.CategoryID*/ 


-- Câu 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT eq.QuestionID , COUNT(DISTINCT eq.ExamID), GROUP_CONCAT(DISTINCT eq.ExamID)  
FROM ExamQuestion eq
GROUP BY eq.QuestionID 
ORDER BY COUNT(DISTINCT eq.ExamID) DESC;


-- Câu 8: Lấy ra Question có nhiều câu trả lời nhất
/*SELECT a.QuestionID, q.Content , COUNT(a.AnswerID)
FROM  Answer a 
right join Question q ON q.QuestionID = a.QuestionID 
Group by a.QuestionID 
ORDER BY COUNT(a.AnswerID) DESC;*/

SELECT sub_table.QuestionID , sub_table.`So Luong` , sub_table.`List of answers`
FROM (  SELECT a.QuestionID , GROUP_CONCAT(a.AnswerID) AS 'List of answers', COUNT(a.AnswerID) AS 'So Luong'
		FROM  Answer a 
		RIGHT JOIN Question q ON q.QuestionID = a.QuestionID 
		GROUP BY a.QuestionID ) sub_table
WHERE sub_table.`So Luong` = ( SELECT MAX(sub_table1.`So Luong`) 
							  FROM ( SELECT a2.QuestionID , COUNT(a2.AnswerID) AS 'So Luong' 
									 FROM Answer a2 	
									 WHERE a2.QuestionID IS NOT NULL 
									 GROUP BY a2.QuestionID) sub_table1 )
ORDER BY sub_table.QuestionID ASC; 


-- Câu 9: Thống kê số lượng account trong mỗi group
SELECT g.GroupID , g.GroupName , COUNT(ga.AccountID) 
FROM `Group` g 
join GroupAccount ga on g.GroupID  = ga.GroupID  
GROUP BY ga.GroupID , g.GroupName
ORDER BY COUNT(ga.AccountID) DESC;


-- Câu 10: Tìm chức vụ có ít người nhất
/*SELECT a.PositionID , COUNT(a.AccountID), GROUP_CONCAT(a.AccountID)  
FROM `Position` p 
LEFT JOIN Account a ON a.PositionID = p.PositionID 
GROUP BY a.PositionID , p.PositionName  */

SELECT sub_table.PositionID, p.PositionName , sub_table.`So Luong` , sub_table.`List of employees`
FROM ( SELECT a.PositionID , COUNT(a.AccountID) AS 'So Luong' , GROUP_CONCAT(a.AccountID) AS 'List of employees'
	   FROM `Position` p 
	   LEFT JOIN Account a ON a.PositionID = p.PositionID 
	   GROUP BY a.PositionID , p.PositionName ) sub_table
LEFT JOIN `Position` p ON p.PositionID = sub_table.PositionID
WHERE sub_table.`So Luong` = ( SELECT MAX(sub_table1.`So Luong`) 
							   FROM ( SELECT a.PositionID , COUNT(a.AccountID) AS 'So Luong'
								      FROM Account a 								    
								      GROUP BY a.PositionID ) sub_table1 )
ORDER BY sub_table.PositionID ASC; 								      
								      
								      
								      
-- Câu 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM (lấy ra các position trong mỗi phòng ban)
SELECT d.DepartmentID , d.DepartmentName , p.PositionID, p.PositionName , COUNT(p.PositionID) AS 'Quantity of employees'
FROM `Department` d
LEFT JOIN `Account` a ON d.DepartmentID = a.DepartmentID
LEFT JOIN `Position` p ON p.PositionID = a.PositionID
GROUP BY d.DepartmentID, d.DepartmentName, p.PositionID, p.PositionName
ORDER BY d.DepartmentID ASC;


-- Câu 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT q.QuestionID , q.Content , cq.CategoryName , a.Username AS 'Creator' , a2.Content AS 'Answer' , a2.isCorrect 
FROM Question q 
LEFT JOIN CategoryQuestion cq ON cq.CategoryID = q.CategoryID 
LEFT JOIN Account a ON a.AccountID = q.CreatorID 
LEFT JOIN Answer a2 ON a2.QuestionID = q.QuestionID;


-- Câu 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT q.TypeID , tq.TypeName , COUNT(q.QuestionID) AS ''
FROM Question q 
LEFT JOIN TypeQuestion tq ON q.TypeID = tq.TypeID 
GROUP BY q.TypeID , tq.TypeName;


-- Câu 14 + 15: Lấy ra group không có account nào
SELECT g.GroupID , COUNT(ga.AccountID) 
FROM `Group` g 
LEFT JOIN GroupAccount ga ON ga.GroupID = g.GroupID 
GROUP BY g.GroupID 
HAVING COUNT(ga.AccountID) < 1;


-- Câu 16: Lấy ra question không có answer nào
SELECT q.QuestionID , COUNT(a.AnswerID)
FROM Question q 
LEFT JOIN Answer a ON a.QuestionID = q.QuestionID 
GROUP BY q.QuestionID 
HAVING COUNT(a.AnswerID) < 1; 















