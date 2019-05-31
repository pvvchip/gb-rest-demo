DROP TABLE IF EXISTS students;

CREATE TABLE students (
	id int(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=latin1;

INSERT INTO students (id, name)
VALUES
(1, "Bob"),
(2, "John"),
(3, "Michael");

DROP TABLE IF EXISTS books;
CREATE TABLE books (
	id int(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=latin1;

DROP TABLE IF EXISTS students_books;
CREATE TABLE students_books (
	student_id int(11) NOT NULL,
    book_id int(11) NOT NULL,

    PRIMARY KEY (student_id, book_id),

    CONSTRAINT FK_STUDENT FOREIGN KEY (student_id)
    REFERENCES students (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT FK_COURSE FOREIGN KEY (book_id)
    REFERENCES books (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB CHARSET=latin1;

INSERT INTO books (id, title)
VALUES
(1, "Harry Potter"),
(2, "Lord Of The Ring");

