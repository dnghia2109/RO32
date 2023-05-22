DROP DATABASE IF EXISTS `FinalExam03`;
CREATE DATABASE `FinalExam03`;
USE `FinalExam03`;

CREATE TABLE `Country`
(
    country_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR(20) NOT NULL
);

CREATE TABLE `Location`
(
    location_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    street_address VARCHAR(200) NOT NULL,
    postal_code CHAR(12),
    country_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (country_id) REFERENCES `Country`(country_id)
);

CREATE TABLE `Employee`
(
    employee_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(40) NOT NULL,
    email VARCHAR(50) NOT NULL,
    location_id INT UNSIGNED,
    FOREIGN KEY (location_id) REFERENCES `Location`(location_id)
);


INSERT INTO `Country` (country_id, country_name) VALUES
(1, 'United States'),
(2, 'Viet Nam'),
(3, 'Thailand'),
(4, 'France'),
(5, 'China'),
(6, 'Serbia'),
(7, 'Poland'),
(8, 'China'),
(9, 'China'),
(10, 'Indonesia');

INSERT INTO `Location` (street_address, postal_code, country_id) VALUES
('71 Havey Park', null, 5),
('163 Leroy Park', 'K2R', 2),
('76 Fulton Hill', '97240', 3),
('77458 Haas Street', null, 6),
('2 Sutherland Park', '793 16', 10),
('4577 Rowland Parkway', null, 7),
('28 Pankratz Street', '83-220', 4),
('40 Almo Street', '2102', 5),
('29940 Rutledge Trail', null, 1),
('4446 Glacier Hill Point', null, 7),
('6834 Heath Crossing', '68540', 7),
('16 Carioca Hill', null, 2),
('0 Westend Parkway', null, 4),
('13 Emmet Drive', '2424', 5),
('293 Haas Junction', null, 7),
('52206 Golf View Alley', null, 7),
('342 Springs Circle', null, 3),
('343 Holy Cross Circle', '15561', 2),
('9 Montana Court', '735 43', 7),
('90 Prentice Point', '85800', 10),
('5209 Mallory Drive', '64901', 1),
('28 Chive Road', null, 4),
('2 Armistice Crossing', '6022', 1),
('47 Menomonie Pass', null, 6),
('3549 Monument Place', '904-2223', 6),
('7 Hintze Way', '29000', 8),
('0519 Bayside Way', null, 6),
('81 Farwell Hill', '733517', 4),
('74089 Raven Street', null, 5),
('67 Sycamore Court', 'J4N', 3),
('34450 Artisan Trail', null, 10),
('344 Hoepker Street', '84280', 5),
('0 Walton Circle', '53140', 8),
('2 Independence Trail', '20311', 1),
('1947 Kennedy Drive', null, 5),
('641 Oneill Junction', null, 2),
('43118 Monument Street', null, 6),
('4 Acker Junction', '11245', 9),
('5 Stoughton Parkway', '7904', 6),
('6 Waywood Parkway', '75638', 3),
('304 Grover Trail', null, 8),
('86 Cottonwood Lane', '3832', 5),
('9845 Oxford Hill', '13300', 9),
('7 Sauthoff Drive', null, 4),
('11 Monterey Point', '62220', 9),
('55 Barnett Park', null, 1),
('1 American Street', null, 3),
('9 Northview Point', null, 5),
('2 Holy Cross Road', '84002', 4),
('6802 Rigney Crossing', '5507', 8),
('7 High Crossing Point', '27900', 6);

INSERT INTO `Employee` (full_name, email, location_id) VALUES
('Sharai Rolance', 'srolance0@liveinternet.ru', 15),
('Jeffy Hartness', 'jhartness1@theglobeandmail.com', 16),
('Gracia Gedge', 'ggedge2@globo.com', 4),
('Tripp Shearstone', 'tshearstone3@ezinearticles.com', 1),
('Jacinthe Bastow', 'jbastow4@gmpg.org', 21),
('Donny Swainson', 'dswainson5@comcast.net', 12),
('Barbabra Perrins', 'bperrins6@a8.net', 16),
('Ali Dytham', 'adytham7@craigslist.org', 12),
('Garland Poulton', 'gpoulton8@i2i.jp', 24),
('Jacintha Swepson', 'jswepson9@loc.gov', 20),
('Timothea Mathes', 'tmathesa@pagesperso-orange.fr', 12),
('Kliment Carous', 'kcarousb@tinyurl.com', 23),
('Ninnetta Jory', 'njoryc@cbslocal.com', 18),
('Mallory Chitham', 'mchithamd@yahoo.co.jp', 19),
('Emilie Vatini', 'evatinie@wikipedia.org', 12),
('Hollyanne Hassen', 'hhassenf@howstuffworks.com', 18),
('Merlina Gasquoine', 'mgasquoineg@soundcloud.com', 25),
('Keary Raxworthy', 'kraxworthyh@samsung.com', 24),
('Brana Kleynen', 'bkleyneni@accuweather.com', 15),
('Aridatha Blackleech', 'ablackleechj@bigcartel.com', 25),
('Janel Brophy', 'jbrophyk@wikispaces.com', 21),
('Leanor Batchelar', 'lbatchelarl@washingtonpost.com', 22),
('Frankie Guiver', 'fguiverm@drupal.org', 21),
('Gunar Pichan', 'gpichann@cloudflare.com', 14),
('Constantin Breslin', 'cbreslino@paginegialle.it', 1),
('Lorita Stapleton', 'lstapletonp@webs.com', 6),
('Albina Blown', 'ablownq@washington.edu', 8),
('Peri Datte', 'pdatter@prlog.org', 3),
('Tarrah Artingstall', 'tartingstalls@phoca.cz', 16),
('Inessa Husselbee', 'ihusselbeet@fastcompany.com', 17),
('Josh Thain', 'jthainu@artisteer.com', 23),
('Zuzana Moneti', 'zmonetiv@ebay.com', 20),
('Durante Rohmer', 'drohmerw@google.co.uk', 6),
('Brigg Crosston', 'bcrosstonx@angelfire.com', 19),
('Yasmin O''Caherny', 'yocahernyy@cnn.com', 14),
('Thane Yong', 'tyongz@google.nl', 2),
('Bonita Barhems', 'bbarhems10@friendfeed.com', 2),
('Alisa Chasemore', 'achasemore11@sourceforge.net', 5),
('Dmitri Collip', 'dcollip12@dailymotion.com', 8),
('Lorraine Gordon', 'lgordon13@reddit.com', 13),
('Clarey Hackworthy', 'chackworthy14@businessinsider.com', 1),
('Carlota Dripps', 'cdripps15@examiner.com', 10),
('Jeana Rough', 'jrough16@devhub.com', 18),
('Klemens Village', 'kvillage17@auda.org.au', 13),
('Micki Meadley', 'mmeadley18@purevolume.com', 9),
('Gonzales Gooder', 'ggooder19@t.co', 6),
('Darb Greenroa', 'dgreenroa1a@nationalgeographic.com', 11),
('Tyne Wheelhouse', 'twheelhouse1b@yahoo.co.jp', 19),
('Abraham Dreger', 'adreger1c@wp.com', 11),
('Ofelia Cuthbert', 'ocuthbert1d@noaa.gov', 21),
('Matti Oswick', 'moswick1e@cafepress.com', 2),
('Shaun Saywell', 'ssaywell1f@nydailynews.com', 17),
('Sidonia Grebert', 'sgrebert1g@about.me', 14),
('Judye Blakebrough', 'jblakebrough1h@example.com', 17),
('Ardyce Rosoman', 'arosoman1i@posterous.com', 4),
('Ivonne Muselli', 'imuselli1j@prnewswire.com', 13),
('Heida Verdey', 'hverdey1k@istockphoto.com', 19),
('Penni Mustarde', 'pmustarde1l@go.com', 1),
('Alano Pearson', 'apearson1m@joomla.org', 19);


-- 2. Viết lệnh để
-- a) Lấy tất cả các nhân viên thuộc Việt nam
SELECT *
FROM Employee E
JOIN Location L on E.location_id = L.location_id
JOIN Country C on C.country_id = L.country_id
WHERE C.country_name = 'Viet Nam';


-- b) Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
SELECT C.country_name
FROM Country C
JOIN Location L on C.country_id = L.country_id
JOIN Employee E on L.location_id = E.location_id
WHERE E.email = 'nn03@gmail.com';


-- c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.
SELECT C.country_id, C.country_name, L.location_id, COUNT(E.employee_id) AS Num_Employees
FROM Country C
LEFT JOIN Location L on C.country_id = L.country_id
LEFT JOIN Employee E on L.location_id = E.location_id
GROUP BY C.country_id, L.location_id;


-- Question 3. Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS `trigger_EachCountry_Max10Employees`;
DELIMITER $$
CREATE TRIGGER `trigger_EachCountry_Max10Employees`
BEFORE INSERT
ON Employee FOR EACH ROW
BEGIN
    DECLARE v_nums_employee_country INT;

    SELECT COUNT(E.employee_id) INTO v_nums_employee_country
    FROM Employee E
    LEFT JOIN Location L on L.location_id = E.location_id
    INNER JOIN Country C on C.country_id = L.country_id
    WHERE C.country_id = (
                            SELECT L.country_id
                            FROM Location L
                            WHERE L.location_id = NEW.location_id
                         );
    IF v_nums_employee_country >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Country cannot add more user';
    END IF;
END $$
DELIMITER ;

INSERT INTO Employee (full_name, email, location_id) VALUE ('demo1', 'demo1@gmail.com', 8);
INSERT INTO Employee (full_name, email, location_id) VALUE ('demo2', 'demo2@gmail.com', 8);

/*SELECT C.country_id,  COUNT(E.employee_id) AS Num_Employees
FROM Country C
LEFT JOIN Location L on C.country_id = L.country_id
LEFT JOIN Employee E on L.location_id = E.location_id
GROUP BY C.country_id;
*/


/*Question 4. Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở
location đó sẽ có location_id = null*/
DROP TRIGGER IF EXISTS trigger_location_delete;
DELIMITER $$
CREATE TRIGGER trigger_location_delete
BEFORE DELETE ON Location FOR EACH ROW
BEGIN
    UPDATE Employee E
    SET location_id = NULL
    WHERE E.location_id = OLD.location_id;
END $$
DELIMITER ;

SELECT E.employee_id, L.location_id
FROM Employee E
LEFT JOIN Location L on E.location_id = L.location_id
LEFT JOIN Country C on C.country_id = L.country_id
ORDER BY L.location_id;

DELETE
FROM Location L
WHERE L.location_id = 4;

