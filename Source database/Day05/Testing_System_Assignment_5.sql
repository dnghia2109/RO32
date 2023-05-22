use `Testing_System`;

-- Câu 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW `v_DanhSachNhanVienCuaPhongBanSale` AS
SELECT a.AccountID , a.FullName , d.DepartmentName 
FROM Account a 
LEFT JOIN Department d ON d.DepartmentID = a.DepartmentID 
WHERE d.DepartmentName = 'Sales';

SELECT * FROM v_DanhSachNhanVienCuaPhongBanSale vdsnvcpbs ;


-- Câu 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW `v_ThongTin_NV_tham_gia_nhieu_group_nhat` AS
WITH Count_Max_Account_Group AS (
	SELECT a.AccountID , COUNT(ga.GroupID) as 'So_Luong_Group', GROUP_CONCAT(ga.GroupID)  
	FROM Account a 
	left join GroupAccount ga ON a.AccountID = ga.AccountID 
	GROUP BY a.AccountID 
	ORDER BY `So_Luong_Group` DESC
	
)
SELECT `Count_Max_Account_Group`.*
FROM `Count_Max_Account_Group`
WHERE `So_Luong_Group` = (SELECT MAX(`So_Luong_Group`) From `Count_Max_Account_Group` );

SELECT * FROM `v_ThongTin_NV_tham_gia_nhieu_group_nhat`;

-- Câu 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi
-- select LENGTH('Hom nay toi di hoc') - LENGTH(REPLACE('Hom nay toi di hoc', ' ', '')) + 1 
-- số từ = length(chuỗi) - length(chuỗi ko có space)+1
CREATE OR REPLACE VIEW `v_DanhSach_Question_dai_qua_12_tu` AS
SELECT q.QuestionID , q.Content 
FROM Question q 
WHERE (LENGTH(q.Content) - LENGTH(REPLACE(q.Content , ' ', '')) + 1) > 12;
DELETE 
FROM Question q2 
WHERE (LENGTH(q.Content) - LENGTH(REPLACE(q.Content , ' ', '')) + 1) > 12;

SELECT * FROM v_DanhSach_Question_dai_qua_12_tu vdsqdqt ;


-- Câu 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW `v_DanhSach_Department_co_nhieu_NV` AS
WITH `Count_Max_Account_Department` AS (
	SELECT d.DepartmentID , COUNT(a.AccountID) AS 'So Luong NV' , GROUP_CONCAT(a.AccountID) AS 'Danh sach NV'
	FROM Department d
	INNER JOIN `Account` a ON d.DepartmentID = a.DepartmentID
	GROUP BY d.DepartmentID
	ORDER BY COUNT(a.DepartmentID) DESC
)
SELECT `Count_Max_Account_Department`.*
FROM `Count_Max_Account_Department`
WHERE `So Luong NV` = (SELECT MAX(`So Luong NV`)
					   FROM `Count_Max_Account_Department`);
-- SELECT * FROM v_DanhSach_Department_co_nhieu_NV vdsdcnn 


-- Câu 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW `v_list_Question_created_by_Nguyen` AS					  
SELECT q.QuestionID, q.Content, a.FullName
FROM Question q 
INNER JOIN `Account` a ON q.CreatorID = a.AccountID
WHERE SUBSTRING_INDEX(a.FullName ,' ',1) = 'Robyn';

SELECT * FROM v_DanhSach_Question_do_user_ vdsqdu ;
