USE `Testing_System`;


-- Câu 1: Thêm ít nhất 10 record vào mỗi table


-- Câu 2: lấy ra tất cả các phòng ban
SELECT *
FROM `Department` d ;


-- Câu 3: lấy ra id của phòng ban "Sale"
SELECT d.DepartmentID 
FROM `Department` d 
WHERE d.DepartmentName = 'Sales';


-- Câu 4: lấy ra thông tin account có full name dài nhất
/*SELECT a.AccountID , a.FullName , LENGTH(a.FullName) 
FROM Account a 
ORDER BY LENGTH(a.FullName) DESC*/
SELECT * 
FROM `Account` a 
WHERE LENGTH(a.FullName) = (
							SELECT MAX(LENGTH(a2.FullName)) 
							FROM Account a2 
);

						  
-- Câu 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
-- Cách 1:
SELECT * , LENGTH(FullName)
FROM `Account` a 
WHERE a.DepartmentID = 3 
AND LENGTH(a.FullName) = (
							SELECT MAX(LENGTH(a2.FullName)) 
							FROM Account a2 
							WHERE a2.DepartmentID = 3
);
-- Cách 2:
/*SELECT * , LENGTH(FullName)
FROM `Account`
HAVING DepartmentID = 3
ORDER BY LENGTH(FullName) DESC
LIMIT 1;*/


-- Câu 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT g.GroupName -- , g.CreateDate 
FROM `Group` g 
WHERE g.CreateDate < '2019-12-20'
ORDER BY g.CreateDate DESC;


-- Câu 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT a.QuestionID , GROUP_CONCAT(a.AnswerID) AS 'List of answers' 
FROM `Answer` a 
GROUP BY a.QuestionID 
HAVING COUNT(a.QuestionID) >=4;
/*SELECT *
FROM `Answer` a 
WHERE a.QuestionID = 3;*/


-- Câu 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
 SELECT *
 FROM Exam e 
 WHERE (e.Duration >=60) AND (e.CreateDate < '2019-12-20')


-- Câu 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
FROM `Group` g 
ORDER BY g.CreateDate DESC
LIMIT 5;


-- Câu 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(a.AccountID)
FROM `Account` a 
WHERE a.DepartmentID = 2;
/*SELECT a.DepartmentID , COUNT(a.AccountID) AS Quantity ,GROUP_CONCAT(a.AccountID) AS Account
FROM `Account` a 
WHERE a.DepartmentID = 2
group by a.DepartmentID; */

-- Câu 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT *
FROM `Account` a 
WHERE a.FullName LIKE 'D%o';


-- Câu 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE 
FROM `Exam` e
WHERE e.CreateDate < '2019-20-12';


-- Câu 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "Làm cách"
DELETE 
FROM `Question` q
WHERE q.Content LIKE 'Làm cách%';


-- Câu 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và
-- email thành loc.nguyenba@vti.com.vn
UPDATE `Account` a 
SET a.Username = 'Nguyễn Bá Lộc', a.Email = 'loc.nguyenba@vti.com.vn'
WHERE a.AccountID = 5
/*SELECT AccountID, Email, Username, FullName, DepartmentID, PositionID, CreateDate 
FROM Account
WHERE AccountID = 5;*/


-- Câu 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `GroupAccount` ga 
SET ga.GroupID = 4
WHERE ga.AccountID = 5;
/*SELECT GroupID, AccountID, JoinDate 
FROM GroupAccount
WHERE AccountID = 5;*/

				  