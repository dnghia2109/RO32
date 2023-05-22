-- Department (Department_Number, Department_Name)
-- Employee_Table (Employee_Number, Employee_Name, Department_Number)
-- Employee_Skill_Table (Employee_Number, Skill_Code, Date Registered)

DROP DATABASE IF EXISTS `EXTRA04`;
CREATE DATABASE `EXTRA04`;
USE `EXTRA04`;

CREATE TABLE `Department` 
(
	Department_Number INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Department_Name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE `Employee`
(
	Employee_Number INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Employee_Name VARCHAR(40) NOT NULL,
	Department_Number INT UNSIGNED,
	FOREIGN KEY (`Department_Number`) REFERENCES `Department`(Department_Number)
);

CREATE TABLE `Employee_Skill_Table` 
(
	Employee_Number INT UNSIGNED,
	Skill_Code VARCHAR(20),
	Registered DATE DEFAULT(NOW()),
	FOREIGN KEY (`Employee_Number`) REFERENCES `Employee`(Employee_Number)
);


INSERT INTO Department (Department_Name) VALUES
( 'Human Resources'),
( 'Accounting'),
( 'Product Management'),
( 'Research and Development'),
( 'Support'),
( 'Business Development1'),
( 'Research and Development1'),
( 'Legal'),
( 'Business Development'),
( 'Marketing');

INSERT INTO Employee (Employee_Name, Department_Number) VALUES
('Harley Duxbury', 4),
('Dominga Fosdike', 3),
('Ignazio Halcro', 2),
('Clarita McVitty', 1),
('Gnni Bugg', 3),
('Cassi Wallentin', 10),
('Elvyn Toffts', 6),
('Carter Strathman', 3),
('Betty Fiennes', 6),
('Kirsteni Conan', 6),
('Corella Janowski', 10),
('Carlina Kinnon', 8),
('Carleton Thaim', 1),
('Bone Andrysek', 4),
('Ethan Gozzett', 6),
('Cookie Vause', 6),
('Winthrop Smowton', 7),
('Ardelis Whittlesey', 8),
('Lucretia Hughesdon', 2),
('Gill Torbeck', 10),
('Zuzana Egan', 3),
('Lewiss Prium', 9),
('Gaston O''Breen', 2),
('Ekaterina Gueinn', 3),
('Dee Williment', 8),
('Marcus Parfitt', 3),
('Jdavie Herche', 3),
('Averil Decaze', 2),
('Krystalle Addy', 9),
('Lorens Shelvey', 8),
('Maure Tale', 4),
('Ruttger Cawthry', 4),
('Nicol McFetrich', 10),
('Appolonia Fulham', 10),
('Sheppard Diglin', 3),
('Davin Whitham', 5),
('Harmony Belison', 1),
('Nanine Linkin', 9),
('Starlene Ingyon', 4),
('Janessa Arger', 4),
('Christel Scrace', 5),
('Marget Windridge', 4),
('Ervin Chene', 5),
('Ulrick Adriaens', 4),
('Evangelin Bondley', 2),
('Salome Aguilar', 5),
('Cyb Leat', 4),
('Deirdre Marle', 4),
('Zitella Mouat', 7),
('Blanche Gildersleaves', 4),
('Marilin McKeurton', 8),
('Stephanus Clemonts', 2),
('Camala Raynes', 5),
('Susanna Atherton', 10),
('Leoine Wabersich', 2),
('Dalila Adamini', 7),
('Myer De Blasiis', 6),
('Wilbert MacCallister', 1),
('Godiva Baus', 5),
('Stafford Renwick', 7),
('Dru Jurges', 1),
('Shaine Caveau', 6),
('Corella Fawltey', 6),
('Krispin Skottle', 10),
('Virgil Aldham', 8),
('Barnie Sprowson', 4),
('Colver Courcey', 7),
('Mose Treverton', 3),
('Willie Hirtz', 6),
('Hoebart Scholig', 4),
('Sydney Bowell', 9),
('Sukey Fayers', 4),
('Lexy Yeowell', 9),
('Salvidor O''Duane', 3),
('Patin Scranney', 5),
('Ramon Foran', 1),
('Lenore Preist', 4),
('Natale Scatcher', 10),
('Lilly Droghan', 9),
('Matthieu Cosford', 9),
('Karlotta Wohlers', 5),
('Etan Purdey', 3),
('Cirillo Guerrieri', 9),
('Augustina Van Arsdale', 6),
('Curt Bougourd', 5),
('Jacqueline Scamadine', 7),
('Si Cowan', 8),
('Noe Radborne', 6),
('Molly Ovesen', 5),
('Lacey Rushmare', 6),
('Dewitt Detoc', 1),
('Kahlil Wagstaff', 6),
('Aldin Lindenbluth', 4),
('Felicio MacGillivray', 8),
('Durante Treasure', 1),
('Claus Soppit', 9),
('Judi Albinson', 5),
('Stefan Eppson', 3),
('Pincus Bertolin', 7),
('Hastie Kightly', 7);


INSERT INTO Employee_Skill_Table (Employee_Number, Skill_Code, Registered) VALUES
(44, null, '2021-09-24'),
(51, 'Java', '2022-12-01'),
(72, 'Java', '2020-12-21'),
(89, 'C++', '2021-05-11'),
(90, 'C++', '2022-05-01'),
(51, 'JS', '2022-12-09'),
(70, 'Go', '2022-01-03'),
(40, 'Go', '2022-03-30'),
(21, 'C#', '2022-04-15'),
(94, 'Go', '2023-04-15'),
(32, 'C++', '2020-08-20'),
(61, 'JS', '2021-02-12'),
(65, 'JS', '2020-11-21'),
(55, 'C++', '2022-10-04'),
(76, 'C++', '2023-03-06'),
(75, 'Java', '2022-10-09'),
(89, 'C++', '2021-02-02'),
(26, 'PHP', '2020-05-07'),
(25, 'PHP', '2023-03-31'),
(12, 'C#', '2021-11-06'),
(54, 'JS', '2021-03-09'),
(100, 'C#', '2022-10-10'),
(52, 'JS', '2020-07-28'),
(100, 'Java', '2021-03-06'),
(14, null, '2021-11-06'),
(65, 'C++', '2021-11-25'),
(51, 'C++', '2020-10-30'),
(68, 'C++', '2022-09-13'),
(78, 'Java', '2020-08-20'),
(58, 'Java', '2020-07-24'),
(29, 'C#', '2022-03-27'),
(12, 'C++', '2023-03-23'),
(66, 'PHP', '2022-04-21'),
(38, 'JS', '2023-01-12'),
(88, 'Go', '2022-04-24'),
(54, 'Go', '2023-01-04'),
(92, 'PHP', '2021-03-17'),
(71, null, '2021-08-12'),
(60, 'C++', '2020-09-27'),
(96, 'PHP', '2020-05-20'),
(37, 'JS', '2021-06-18'),
(46, 'C#', '2021-12-10'),
(63, 'C#', '2022-12-09'),
(98, 'Go', '2021-04-11'),
(100, 'PHP', '2020-07-16'),
(93, 'C#', '2020-08-14'),
(83, 'C++', '2021-09-25'),
(82, 'JS', '2020-09-11'),
(82, 'C#', '2020-06-15'),
(31, 'C++', '2023-01-07'),
(89, null, '2020-10-18'),
(20, 'C#', '2020-05-02'),
(44, null, '2022-04-26'),
(23, 'C++', '2022-04-19'),
(67, 'Java', '2020-06-19'),
(63, 'Go', '2022-11-23'),
(48, 'JS', '2020-10-05'),
(83, 'Go', '2022-10-09'),
(52, 'PHP', '2021-07-10'),
(47, 'Go', '2021-02-07'),
(32, null, '2020-08-12'),
(36, 'JS', '2020-12-27'),
(77, 'C++', '2020-04-27'),
(40, 'Go', '2021-09-15'),
(1, 'PHP', '2022-01-28'),
(39, 'PHP', '2022-09-03'),
(96, 'C#', '2021-12-05'),
(21, 'Java', '2021-05-08'),
(11, 'Java', '2023-04-06'),
(35, null, '2023-03-28'),
(52, 'Go', '2021-11-16'),
(4, 'Go', '2020-09-25'),
(30, 'Java', '2020-05-24'),
(31, 'JS', '2022-03-25'),
(70, 'Java', '2021-06-01'),
(32, 'PHP', '2022-05-03'),
(34, 'C#', '2023-03-07'),
(93, 'Java', '2021-11-30'),
(94, 'C#', '2020-05-23'),
(29, 'JS', '2022-06-30'),
(17, 'Go', '2020-04-17'),
(62, 'Go', '2021-02-12'),
(45, 'C#', '2023-01-29'),
(20, 'Go', '2022-10-07'),
(40, 'PHP', '2021-09-06'),
(8, 'C++', '2020-05-13'),
(90, 'PHP', '2021-01-22'),
(51, 'Go', '2021-07-02'),
(58, 'JS', '2020-04-30'),
(51, null, '2021-02-06'),
(8, 'Java', '2022-04-29'),
(16, null, '2022-02-11'),
(28, 'PHP', '2021-06-10'),
(14, 'PHP', '2022-08-12'),
(89, 'JS', '2021-02-11'),
(85, 'JS', '2022-12-05'),
(89, 'JS', '2021-10-15'),
(41, 'C#', '2023-01-08'),
(56, 'C++', '2021-03-05'),
(60, 'C#', '2020-11-15');

-- Câu 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
CREATE OR REPLACE VIEW `v_DanhSachNhanVienCoSkillJava` as
SELECT e.Employee_Number as 'ID' , e.Employee_Name , est.Skill_Code 
FROM Employee e 
JOIN Employee_Skill_Table est ON e.Employee_Number = est.Employee_Number 
WHERE est.Skill_Code = 'Java';


-- Câu 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
CREATE OR REPLACE VIEW `v_DanhSachPhongBanCoNhieuHon3NV` as
SELECT d.Department_Number,Department_Name , COUNT(e.Employee_Number), GROUP_CONCAT(e.Employee_Number) 
FROM Department d 
LEFT JOIN Employee e ON e.Department_Number = d.Department_Number 
GROUP BY d.Department_Number,Department_Name  
HAVING COUNT(e.Employee_Number) > 9 ;


-- Câu 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
CREATE OR REPLACE VIEW `v_DanhSachNhanVienCuaPhongBan` as
SELECT d.Department_Number,Department_Name , COUNT(e.Employee_Number), GROUP_CONCAT(e.Employee_Number)  
FROM Department d
LEFT JOIN  Employee e ON e.Department_Number = d.Department_Number 
GROUP BY d.Department_Number,Department_Name ;


-- Câu 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
CREATE OR REPLACE VIEW `v_DanhSachNhanVienCo>1_Skill` as
SELECT e.Employee_Number,Employee_Name , GROUP_CONCAT(DISTINCT est.Skill_Code) ,COUNT(DISTINCT est.Skill_Code)
FROM Employee e 
LEFT JOIN Employee_Skill_Table est ON e.Employee_Number = est.Employee_Number 
GROUP BY e.Employee_Number 
HAVING COUNT(DISTINCT est.Skill_Code) > 1;






