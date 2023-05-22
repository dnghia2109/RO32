-- DÙNG IF EXISTS để xóa db nếu nó đã tồn tại
DROP DATABASE IF EXISTS `Testing_System` 
CREATE DATABASE `Testing_System`
USE `Testing_System`

-- Table 1: Department
CREATE TABLE `Department`
(
	DepartmentID INT PRIMARY KEY AUTO_INCREMENT,
	DepartmentName VARCHAR(30)
);


-- Table 2: Position
CREATE TABLE `Position`
(
	PositionID INT PRIMARY KEY AUTO_INCREMENT,
	PositionName NVARCHAR(30)
);

-- Table 3: Account
CREATE TABLE `Account`
(
	AccountID INT PRIMARY KEY AUTO_INCREMENT,
	Email VARCHAR(30),
	Username VARCHAR(30),
	FullName VARCHAR(30),
	DepartmentID INT,
	PositionID INT,
	CreateDate DATE
);

-- TABLE 4:Table 4: Group
CREATE TABLE `Group`
(
	GroupID INT PRIMARY KEY AUTO_INCREMENT,
	GroupName VARCHAR(50),
	CreatorID INT,
	CreateDate DATE
);


-- Table 5: GroupAccount
--  GroupID: định danh của nhóm
--  AccountID: định danh của User
--  JoinDate: Ngày user tham gia vào nhóm
CREATE TABLE `GroupAccount`
(
	GroupID INT,
	AccountID INT,
	JoinDate DATE
);

-- Table 6: TypeQuestion
--  TypeID: định danh của loại câu hỏi (auto increment)
--  TypeName: tên của loại câu hỏi (Essay, Multiple-Choice)
CREATE TABLE `TypeQuestion`
(
	TypeID INT PRIMARY KEY AUTO_INCREMENT,
	TypeName NVARCHAR(30)
);

-- Table 7: CategoryQuestion
--  CategoryID: định danh của chủ đề câu hỏi (auto increment)
--  CategoryName: tên của chủ đề câu hỏi (Java, .NET, SQL, Postman, Ruby,...)
CREATE TABLE `CategoryQuestion`
(
	CategoryID INT PRIMARY KEY AUTO_INCREMENT,
	CategoryName TEXT
);


-- Table 8: Question
--  QuestionID: định danh của câu hỏi (auto increment)
--  Content: nội dung của câu hỏi
--  CategoryID: định danh của chủ đề câu hỏi
--  TypeID: định danh của loại câu hỏi
--  CreatorID: id của người tạo câu hỏi
--  CreateDate: ngày tạo câu hỏi
CREATE TABLE `Question`
(
	QuestionID INT PRIMARY KEY AUTO_INCREMENT,
	Content TEXT,
	CategoryID INT,
	TypeID INT,
	CreatorID INT,
	CreateDate DATE
);

-- Table 9: Answer
--  AnswerID: định danh của câu trả lời (auto increment)
--  Content: nội dung của câu trả lời
--  QuestionID: định danh của câu hỏi
--  isCorrect: câu trả lời này đúng hay sai
CREATE TABLE `Answer`
(
	AnswerID INT PRIMARY KEY AUTO_INCREMENT,
	Content TEXT,
	QuestionID INT,
	isCorrect BOOL
);

-- Table 10: Exam
--  ExamID: định danh của đề thi (auto increment)
--  Code: mã đề thi
--  Title: tiêu đề của đề thi
--  CategoryID: định danh của chủ đề thi
--  Duration: thời gian thi
--  CreatorID: id của người tạo đề thi
--  CreateDate: ngày tạo đề thi
CREATE TABLE `Exam`
(
	ExamID INT PRIMARY KEY AUTO_INCREMENT,
	Code INT,
	Title VARCHAR(50),
	CategoryID INT,
	Duration INT,
	CreatorID INT,
	CreateDate DATE
);

-- Table 11: ExamQuestion
--  ExamID: định danh của đề thi
--  QuestionID: định danh của câu hỏi
CREATE TABLE `ExamQuestion` 
(
	ExamID INT,
	QuestionID INT
);

