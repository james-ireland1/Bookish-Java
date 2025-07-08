USE bookish;

INSERT INTO books (title, author, isbn, edition, publisher) VALUES
                                                                ('The Midnight Library', 'Matt Haig', '9780525559474', '1st', 'Viking'),
                                                                ('Project Hail Mary', 'Andy Weir', '9780593135204', '1st', 'Ballantine'),
                                                                ('The Silent Patient', 'Alex Michaelides', '9781250301697', '1st', 'Celadon Books'),
                                                                ('Where the Crawdads Sing', 'Delia Owens', '9780735219106', '1st', 'G.P. Putnam’s Sons'),
                                                                ('The Vanishing Half', 'Brit Bennett', '9780525536291', '1st', 'Riverhead Books'),
                                                                ('Klara and the Sun', 'Kazuo Ishiguro', '9780593318171', '1st', 'Knopf'),
                                                                ('Circe', 'Madeline Miller', '9780316556347', '1st', 'Little, Brown'),
                                                                ('The Paper Palace', 'Miranda Cowley Heller', '9780593329825', '1st', 'Riverhead Books'),
                                                                ('The Night Circus', 'Erin Morgenstern', '9780385534635', '1st', 'Doubleday'),
                                                                ('Malibu Rising', 'Taylor Jenkins Reid', '9781524798659', '1st', 'Ballantine'),

                                                                ('Daisy Jones & The Six', 'Taylor Jenkins Reid', '9781524798628', '1st', 'Ballantine'),
                                                                ('A Court of Thorns and Roses', 'Sarah J. Maas', '9781619635180', '1st', 'Bloomsbury'),
                                                                ('The Song of Achilles', 'Madeline Miller', '9780062060624', '1st', 'Ecco'),
                                                                ('Atomic Habits', 'James Clear', '9780735211292', '1st', 'Avery'),
                                                                ('Educated', 'Tara Westover', '9780399590504', '1st', 'Random House'),
                                                                ('Becoming', 'Michelle Obama', '9781524763138', '1st', 'Crown'),
                                                                ('The Four Winds', 'Kristin Hannah', '9781250178602', '1st', 'St. Martin’s Press'),
                                                                ('The Book Thief', 'Markus Zusak', '9780375842207', '1st', 'Knopf'),
                                                                ('The Giver of Stars', 'Jojo Moyes', '9780399562488', '1st', 'Pamela Dorman Books'),
                                                                ('It Ends With Us', 'Colleen Hoover', '9781501110368', '1st', 'Atria Books'),

                                                                ('Verity', 'Colleen Hoover', '9781791392796', '1st', 'Grand Central'),
                                                                ('Ugly Love', 'Colleen Hoover', '9781476753188', '1st', 'Atria Books'),
                                                                ('Reminders of Him', 'Colleen Hoover', '9781542025607', '1st', 'Montlake'),
                                                                ('The Paris Library', 'Janet Skeslien Charles', '9781982134198', '1st', 'Atria Books'),
                                                                ('The Last Thing He Told Me', 'Laura Dave', '9781501171345', '1st', 'Simon & Schuster'),
                                                                ('Before We Were Strangers', 'Renée Carlino', '9781501105777', '1st', 'Atria Books'),
                                                                ('The Seven Husbands of Evelyn Hugo', 'Taylor Jenkins Reid', '9781501139239', '1st', 'Atria Books'),
                                                                ('The Alchemist', 'Paulo Coelho', '9780061122415', '1st', 'HarperOne'),
                                                                ('The Midnight Library', 'Matt Haig', '9780525559474', '2nd', 'Canongate'),
                                                                ('The House in the Cerulean Sea', 'TJ Klune', '9781250217318', '1st', 'Tor Books');

DELIMITER $$

CREATE PROCEDURE InsertRandomBookIDs()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE j INT;
    DECLARE num_rows INT;

    WHILE i <= 30 DO
            SET num_rows = FLOOR(RAND() * 11);
            SET j = 1;
            WHILE j <= num_rows DO
                    INSERT INTO copies (bookID, status) VALUES (i, 'AVAILABLE');
                    SET j = j + 1;
                END WHILE;
            SET i = i + 1;
        END WHILE;
END $$

DELIMITER ;

-- Call the procedure
CALL InsertRandomBookIDs();

INSERT INTO members (Name, RegistrationDate) VALUES
                                               ('Olivia Mitchell', '2025-06-12'),
                                               ('Ethan Scott', '2025-04-03'),
                                               ('Sophia Johnson', '2025-03-19'),
                                               ('Liam Davis', '2024-11-08'),
                                               ('Emma Wilson', '2025-05-30'),
                                               ('Noah Anderson', '2024-12-15'),
                                               ('Ava Martinez', '2025-01-10'),
                                               ('Mason Thompson', '2025-03-23'),
                                               ('Isabella Garcia', '2025-06-05'),
                                               ('Lucas Hernandez', '2025-07-01'),
                                               ('Mia Moore', '2024-10-18'),
                                               ('James Lee', '2025-02-27'),
                                               ('Amelia White', '2025-04-19'),
                                               ('Benjamin Lewis', '2025-06-21'),
                                               ('Harper Walker', '2025-01-14'),
                                               ('Elijah Hall', '2024-08-28'),
                                               ('Evelyn Young', '2024-09-11'),
                                               ('Alexander Allen', '2024-12-02'),
                                               ('Charlotte King', '2024-11-22'),
                                               ('Daniel Wright', '2024-10-30'),
                                               ('Abigail Scott', '2025-07-03'),
                                               ('Matthew Green', '2025-06-17'),
                                               ('Ella Adams', '2025-03-05'),
                                               ('Henry Baker', '2025-05-08'),
                                               ('Scarlett Nelson', '2025-02-14'),
                                               ('Jackson Carter', '2025-01-27'),
                                               ('Grace Mitchell', '2024-08-02'),
                                               ('Sebastian Perez', '2025-06-01'),
                                               ('Chloe Roberts', '2025-04-07'),
                                               ('Aiden Turner', '2025-06-26');