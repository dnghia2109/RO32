DROP DATABASE IF EXISTS `FresherDB` 
CREATE DATABASE `FresherDB`
USE `FresherDB`


/* EXCERCISE 1: Ta có database để quản lý fresher, có table Trainee với các trường như sau:
 TraineeID: định danh của thực tập sinh (auto increment)
 Full_Name: tên đầy đủ của thực tập sinh
 Birth_Date: ngày sinh của thực tập sinh
 Gender: chỉ có 3 giá trị male, female, and unknown
 ET_IQ: Entry test point (IQ) - Điểm test đầu vào của thực tập sinh (integer có
giá trị từ 0  20)
 ET_Gmath: Entry test point (Gmath) - Điểm test đầu vào của thực tập sinh
(integer có giá trị từ 0  20)
 ET_English: Entry test point (English) - Điểm test đầu vào của thực tập sinh
(integer có giá trị từ 0  50)
 Training_Class: mã lớp của thực tập sinh đang học
 Evaluation_Notes: 1 vài note đánh giá (free text).
Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
Question 2: thêm trường VTI_Account với điều kiện not null & unique
Chú ý: chú tới tới các best practice*/

-- Question 1:
CREATE TABLE `Trainee`
(
	TraineeID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Full_Name VARCHAR(30) NOT NULL,
	Birth_Date DATE,
	Gender ENUM('MALE', 'FEMALE', 'UNKNOWN'),
	ET_IQ TINYINT UNSIGNED CHECK(ET_IQ >= 0 AND ET_IQ <= 20), -- Cách viết 2: ET_IQ INT UNSIGNED CHECK(ET_IQ BETWEEN 0 AND 20)
	ET_Gmath TINYINT UNSIGNED CHECK(ET_Gmath >= 0 AND ET_Gmath <= 20),
	ET_English TINYINT UNSIGNED CHECK(ET_English >= 0 AND ET_English <= 50),
	Training_Class INT NOT NULL,
	Evaluation_Notes TEXT
)

INSERT INTO FresherDB.Trainee (Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes, VTI_Account) 
VALUES('NGhia1', '2021-09-21', 'Male', 10, 10, 20, 10,'',12);

ALTER TABLE FresherDB.Trainee
add check(Birth_Date < '2023-04-23');


-- Question 2: thêm trường VTI_Account với điều kiện not null & unique
ALTER TABLE `Trainee`
ADD VTI_Account INT NOT NULL UNIQUE;

----------------------------------------------------------------------------------------------------------------------------------------------------
/*Exercise 2: Data Types
Bảng bên dưới sẽ có ít nhất 1 triệu bản ghi, có chứa các thông tin sau:
Bạn phải chọn 1 kiểu dữ liệu phù hợp để tối ưu không gian lưu trữ mỗi hàng của bảng*/

CREATE TABLE `Exercise02`
(
	ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(30) NOT NULL,
	Code CHAR(5) UNIQUE NOT NULL,
	ModifiedDate DATETIME DEFAULT(NOW())
)


----------------------------------------------------------------------------------------------------------------------------------------------------
/*Exercise 3: Data Types (2)
Bảng bên dưới sẽ có ít nhất 1 triệu bản ghi, có chứa các thông tin sau:
Bạn phải chọn 1 kiểu dữ liệu phù hợp để tối ưu không gian lưu trữ mỗi hàng của bảng*/

CREATE TABLE `Exercise03` 
(
	ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Name NVARCHAR(30) NOT NULL,
	Birth DATE,
	Gender BIT, -- 0: male; 1:female; null:unknown
	IsDeletedFlag BIT DEFAULT(0)
)




