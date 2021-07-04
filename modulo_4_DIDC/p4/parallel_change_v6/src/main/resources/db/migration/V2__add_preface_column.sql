ALTER TABLE book ADD preface varchar(5000);

UPDATE book SET book.preface = book.description;