CREATE TABLE user
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(16) NOT NULL,
password VARCHAR(16) NOT NULL,
email VARCHAR(32) NOT NULL,
UNIQUE(email)
);

INSERT INTO user(name,password,email)
VALUE('123','123','123');

CREATE TABLE book
(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(32) NOT NULL,
author VARCHAR(32) NOT NULL,
category VARCHAR(32) NOT NULL,
price INT NOT NULL
);

INSERT INTO book(title,author,category,price)
VALUES('1','123','123',123),
('2','123','123',123),
('3','123','123',123);

／*CREATE TABLE myorder
(
id INT PRIMARY KEY AUTO_INCREMENT,
amount INT NOT NULL,
year VARCHAR(32) NOT NULL,
month VARCHAR(32) NOT NULL,
day VARCHAR(32) NOT NULL,
bookid INT,
userid INT,
FOREIGN KEY (bookid) REFERENCES book(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (userid) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
);*／

CREATE TABLE myorder
(
id INT PRIMARY KEY AUTO_INCREMENT,
amount INT NOT NULL,
year INT NOT NULL,
month INT NOT NULL,
day INT NOT NULL,
bookid INT,
userid INT,
FOREIGN KEY (bookid) REFERENCES book(id),
FOREIGN KEY (userid) REFERENCES user(id)
);


insert into myorder(userid,bookid,year,month,day,amount) values(5,2,2,2,2,2),(5,1,1,1,1,1);