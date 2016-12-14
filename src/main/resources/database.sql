-- Database: company
-- CREATE DATABASE company CHARACTER SET utf8;

-- Table: gender
CREATE TABLE company.gender (
  id   INT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(7) NOT NULL
)CHARACTER SET utf8;

-- Table: position
CREATE TABLE company.position (
  id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL
)CHARACTER SET utf8;

-- Table: employees
CREATE TABLE company.employees (
  id          INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstName   VARCHAR(50)   NOT NULL,
  lastName    VARCHAR(50)   NOT NULL,
  genderId    INT           NOT NULL,
  yearOfBirth INT           NOT NULL,
  positionId  INT           NOT NULL,
  comments    VARCHAR(255),

  FOREIGN KEY (genderId)   REFERENCES company.gender (id),
  FOREIGN KEY (positionId) REFERENCES company.position (id)
)CHARACTER SET utf8;

-- Insert data
INSERT INTO company.gender VALUES (1, 'Мужчина');
INSERT INTO company.gender VALUES (2, 'Женщина');

INSERT INTO company.position VALUES (1, 'Бухгалтер');
INSERT INTO company.position VALUES (2, 'Директор');
INSERT INTO company.position VALUES (3, 'Экономист');
INSERT INTO company.position VALUES (4, 'Менеджер');
INSERT INTO company.position VALUES (5, 'Программист Java');
INSERT INTO company.position VALUES (6, 'Программист Scala');
INSERT INTO company.position VALUES (7, 'Программист Android');

INSERT INTO company.employees VALUES (1, 'Елена', 'Симонова', 2, 1990, 1, 'Комментарий 1');
INSERT INTO company.employees VALUES (2, 'Борис', 'Добрынич', 1, 1978, 2, 'Комментарий 2');
INSERT INTO company.employees VALUES (3, 'Ольга', 'Борисова', 2, 1987, 3, 'Комментарий 3');
INSERT INTO company.employees VALUES (4, 'Мария', 'Валерьянова', 2, 1991, 4, 'Комментарий 4');
INSERT INTO company.employees VALUES (5, 'Олег', 'Городецкий', 1, 1987, 5, 'Комментарий 5');
INSERT INTO company.employees VALUES (6, 'Павел', 'Шишко', 1, 1986, 6, 'Комментарий 6');
INSERT INTO company.employees VALUES (7, 'Николай', 'Красовский', 1, 1984, 5, 'Комментарий 7');
