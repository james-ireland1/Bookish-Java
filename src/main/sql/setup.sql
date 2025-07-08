DROP DATABASE IF EXISTS Bookish;

CREATE DATABASE IF NOT EXISTS Bookish;

USE Bookish;

CREATE TABLE IF NOT EXISTS Books (
                                     BookID int NOT NULL AUTO_INCREMENT,
                                     Title varchar(255) NOT NULL,
                                     Author varchar(255),
                                     ISBN varchar(255),
                                     Edition varchar(255),
                                     Publisher varchar(255),
                                     PRIMARY KEY (BookID)
);

CREATE TABLE IF NOT EXISTS Members (
                                       MemberID int NOT NULL AUTO_INCREMENT,
                                       Name varchar(255) NOT NULL,
                                       RegistrationDate date NOT NULL,
                                       Status enum('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
                                       PRIMARY KEY (MemberID)
);

CREATE TABLE IF NOT EXISTS Librarians (
                                          LibrarianID int NOT NULL AUTO_INCREMENT,
                                          Name varchar(255) NOT NULL,
                                          PRIMARY KEY (LibrarianID)
);

CREATE TABLE IF NOT EXISTS Copies (
                                      CopyID int NOT NULL AUTO_INCREMENT,
                                      BookID int NOT NULL,
                                      Status enum('AVAILABLE','UNAVAILABLE','ISSUED','LOST','SOLD','DESTROYED') DEFAULT 'UNAVAILABLE',
                                      MemberID int DEFAULT NULL,
                                      DueBack date DEFAULT NULL,
                                      PRIMARY KEY (CopyID),
                                      FOREIGN KEY (BookID) REFERENCES Books(BookID),
                                      FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

CREATE TABLE IF NOT EXISTS TransactionLog (
                                              TransactionID int NOT NULL AUTO_INCREMENT,
                                              Timestamp timestamp NOT NULL,
                                              MemberID int NOT NULL,
                                              LibrarianID int NOT NULL,
                                              PRIMARY KEY (TransactionID),
                                              FOREIGN KEY (MemberID) REFERENCES Members(MemberID),
                                              FOREIGN KEY (LibrarianID) REFERENCES Librarians(LibrarianID)
);

CREATE TABLE IF NOT EXISTS IssueLog (
                                        IssueID int NOT NULL AUTO_INCREMENT,
                                        TransactionID int NOT NULL,
                                        Type enum('ISSUED','RENEWED','RETURNED') NOT NULL,
                                        CopyID int NOT NULL,
                                        DueBack date,
                                        PRIMARY KEY (IssueID),
                                        FOREIGN KEY (TransactionID) REFERENCES TransactionLog(TransactionID),
                                        FOREIGN KEY (CopyID) REFERENCES Copies(CopyID)
);


CREATE TABLE `technologies` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `name` varchar(50) NOT NULL,
                                `logoUrl` varchar(200) DEFAULT NULL,
                                PRIMARY KEY (`id`)
);

INSERT INTO `technologies`
(id, name, logoUrl)
VALUES
    (1,'Java','https://pngimage.net/wp-content/uploads/2018/06/java-logo-png-transparent-background-7.png'),
    (2,'Spring','https://www.logolynx.com/images/logolynx/98/980c5fe716efb66c936eebe1937d5489.png'),
    (3,'Thymeleaf','https://raw.githubusercontent.com/thymeleaf/thymeleaf-dist/master/src/artwork/thymeleaf%202016/thymeleaf_logo_transparent.png'),
    (4,'MySQL','https://upload.wikimedia.org/wikipedia/en/thumb/6/62/MySQL.svg/1920px-MySQL.svg.png'),
    (5,'HTML','https://www.w3.org/html/logo/downloads/HTML5_Logo_256.png'),
    (6,'CSS','https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/CSS3_logo_and_wordmark.svg/2000px-CSS3_logo_and_wordmark.svg.png');