DELETE FROM OrderItem;
DELETE FROM BookAuthor;
DELETE FROM BookCategory;
DELETE FROM BookCharacter;
DELETE FROM BookGenre;
DELETE FROM BookLanguage;
DELETE FROM Category;
DELETE FROM Author;
DELETE FROM Genre;
DELETE FROM Character;
DELETE FROM Language;
DELETE FROM Payment;
DELETE FROM OrderTable;
DELETE FROM Customer;
DELETE FROM Book;

-- BOOK --
INSERT INTO Book(title, isbn, bookFormat, price, units, pages, condition, avgReview, totalReviews)
VALUES ('Maus', 'MSUE83L1093LS','Hardcover', 19.99, 453, 303, 'New', 4.9, 2341);

INSERT INTO Book(title, isbn, bookFormat, price, units, pages, condition, avgReview, totalReviews)
VALUES ('1984', 'OD93M0CKE0EMW','Softcover', 4.99, 666, 421,'New', 4.5, 73212);

INSERT INTO Book(title, isbn, bookFormat, price, units, pages, condition, avgReview, totalReviews)
VALUES ('It', 'SIEL283PEM21','Hardcover', 9.99, 230, 1053,'New', 4.7, 7234);

INSERT INTO Book (title, isbn, bookFormat, price, units, pages, condition, avgReview, totalReviews)
VALUES ('Harry Potter and the Philosopher''s Stone, Book 1', 'B017V51FEG2D9', 'Audiobook', 17.99, -1, 345, 'New', 4.8, 49223);

DECLARE @Maus INT;
SET @Maus = (SELECT bookId FROM Book WHERE title='Maus');
DECLARE @1984 INT;
SET @1984 = (SELECT bookId FROM Book WHERE title='1984');
DECLARE @It INT;
SET @It = (SELECT bookId FROM Book WHERE title='It');
DECLARE @HP INT;
SET @HP = (SELECT bookId FROM Book WHERE title='Harry Potter and the Philosopher''s Stone, Book 1');


-- CUSTOMER --
INSERT INTO Customer(name, email, shippingAddress, phoneNumber)
VALUES ('John Doe', 'iamdoe@gmail.com', 'Nowhere', '873647382012');

INSERT INTO Customer(name, email, shippingAddress, phoneNumber)
VALUES ('Xavier Nadal', 'xavinadal14@gmail.com', 'Almacelles', '034973741622');

INSERT INTO Customer(name, email, shippingAddress, phoneNumber)
VALUES ('Arnau Molins', 'arnabomolinos@gmail.com', 'Balaguer', '873647382012');

INSERT INTO Customer(name, email, shippingAddress, phoneNumber)
VALUES ('Martí La Rosa', 'martithecrackxd@gmail.com', 'Horsens', '873647382013');

DECLARE @John INT;
SET @John = (SELECT customerId FROM Customer WHERE name='John Doe');
DECLARE @Xavier INT;
SET @Xavier = (SELECT customerId FROM Customer WHERE name='Xavier Nadal');
DECLARE @Arnau INT;
SET @Arnau = (SELECT customerId FROM Customer WHERE name='Arnau Molins');
DECLARE @Marti INT;
SET @Marti = (SELECT customerId FROM Customer WHERE name='Martí La Rosa');

-- ORDER TABLE --
INSERT INTO OrderTable(customerId, date, totalPrice, shippingPrice)
VALUES (@Xavier, '2022-02-15', 34.18, 3.99);

INSERT INTO OrderTable(customerId, date, totalPrice, shippingPrice)
VALUES (@John, '2022-02-14', 24.98, 1.99);

INSERT INTO OrderTable(customerId, date, totalPrice, shippingPrice)
VALUES (@Arnau, '2022-02-15', 19.98, 10.99);

INSERT INTO OrderTable(customerId, date, totalPrice, shippingPrice)
VALUES (@Arnau, '2022-02-16', 4.99, 0.99);

DECLARE @O1 INT;
SET @O1 = (SELECT orderId FROM OrderTable WHERE customerId=@Xavier);
DECLARE @O2 INT;
SET @O2 = (SELECT orderId FROM OrderTable WHERE customerId=@John);
DECLARE @O3 INT;
SET @O3 = (SELECT orderId FROM OrderTable WHERE customerId=@Arnau AND date='2022-02-15');
DECLARE @O4 INT;
SET @O4 = (SELECT orderId FROM OrderTable WHERE customerId=@Arnau AND date='2022-02-16');



-- ORDER ITEM --
INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@O1, @HP, 2, 17.99, 0.05, 34.18);

INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@O1, @Maus, 1, 19.99, 0, 19.99);

INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@O2, @1984, 1, 4.99, 0, 4.99);

INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@O3, @It, 2, 9.99, 0, 19.98);

INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@O4, @1984, 1, 4.99, 0, 4.99);

-- PAYMENT --
SET IDENTITY_INSERT Payment ON
INSERT INTO Payment (orderId, refNum, method, description)
VALUES (@O1, '8582484997135218', 'Credit card', 'Mastercard Debit');

INSERT INTO Payment (orderId, refNum, method, description)
VALUES (@O2, '8582484997135219', 'Paypal', 'arnabomolinos@gmail.com');

INSERT INTO Payment (orderId, refNum, method, description)
VALUES (@O3, '8582484997135217', 'Credit card', 'Visa Electron');

INSERT INTO Payment (orderId, refNum, method, description)
VALUES (@O4, '8582484997135216', 'Credit card', 'Mastercard Debit');
SET IDENTITY_INSERT Payment OFF 

-- LANGUAGE --
INSERT INTO Language (name)
VALUES ('English');

INSERT INTO Language (name)
VALUES ('Catalan');

-- BOOK LANGUAGE --
INSERT INTO BookLanguage(bookId, languageId)
SELECT bookId, languageId
FROM Book, Language
WHERE title='Maus' AND name='Catalan';

INSERT INTO BookLanguage(bookId, languageId)
SELECT bookId, languageId
FROM Book, Language
WHERE title='1984' AND name='Catalan';

INSERT INTO BookLanguage(bookId, languageId)
SELECT bookId, languageId
FROM Book, Language
WHERE title='It' AND name='English';

INSERT INTO BookLanguage(bookId, languageId)
SELECT bookId, languageId
FROM Book, Language
WHERE title='Harry Potter and the Philosopher''s Stone, Book 1' AND name='English';


-- AUTHOR --
INSERT INTO Author (name)
VALUES ('J.K. Rowling')

INSERT INTO Author (name)
VALUES ('George Orwell')

INSERT INTO Author (name)
VALUES ('Art Spiegelman')

INSERT INTO Author (name)
VALUES ('Stephen King')

-- BOOK AUTHOR --
INSERT INTO BookAuthor(bookId, authorId)
SELECT bookId, authorId
FROM Book, Author
WHERE title='Maus' AND name='Art Spiegelman';

INSERT INTO BookAuthor(bookId, authorId)
SELECT bookId, authorId
FROM Book, Author
WHERE title='1984' AND name='George Orwell';

INSERT INTO BookAuthor(bookId, authorId)
SELECT bookId, authorId
FROM Book, Author
WHERE title='It' AND name='Stephen King';

INSERT INTO BookAuthor(bookId, authorId)
SELECT bookId, authorId
FROM Book, Author
WHERE title='Harry Potter and the Philosopher''s Stone, Book 1' AND name='J.K. Rowling';

-- CATEGORY --
INSERT INTO Category(name)
VALUES ('Fantasy');

INSERT INTO Category(name)
VALUES ('Horror');

DECLARE @Horror INT;
SET @Horror = (SELECT categoryId FROM Category WHERE name='Horror');

INSERT INTO Category(name, parentCategoryId)
VALUES ('Contemporary Horror', @Horror);

INSERT INTO Category(name)
VALUES ('Children''s Books');

DECLARE @Children INT;
SET @Children = (SELECT categoryId FROM Category WHERE name='Children''s Books');

INSERT INTO Category(name, parentCategoryId)
VALUES ('Literature and Fiction', @Children)

DECLARE @LitFic INT;
SET @LitFic = (SELECT categoryId FROM Category WHERE name='Literature and Fiction');

INSERT INTO Category(name, parentCategoryId)
VALUES ('Growing Up and Facts of Life', @LitFic)

INSERT INTO Category(name)
VALUES ('History')



INSERT INTO Category(name)
VALUES ('Science Fiction')

DECLARE @SciFi INT;
SET @SciFi = (SELECT categoryId FROM Category WHERE name='Science Fiction');

INSERT INTO Category(name, parentCategoryId)
VALUES ('Space Opera', @SciFi)


-- BOOK CATEGORY --

INSERT INTO BookCategory(bookId, categoryId)
SELECT bookId, categoryId
FROM Book, Category
WHERE title='It' AND name='Space Opera';

INSERT INTO BookCategory(bookId, categoryId)
SELECT bookId, categoryId
FROM Book, Category
WHERE title='It' AND name='Contemporary Horror';

INSERT INTO BookCategory(bookId, categoryId)
SELECT bookId, categoryId
FROM Book, Category
WHERE title='Maus' AND name='History';

INSERT INTO BookCategory(bookId, categoryId)
SELECT bookId, categoryId
FROM Book, Category
WHERE title='1984' AND name='Science Fiction';

INSERT INTO BookCategory(bookId, categoryId)
SELECT bookId, categoryId
FROM Book, Category
WHERE title='Harry Potter and the Philosopher''s Stone, Book 1' AND name='Fantasy';

-- GENRE --
INSERT INTO Genre(name)
VALUES ('Magic world');

INSERT INTO Genre(name)
VALUES ('Dystopian');

-- BOOK GENRE --
INSERT INTO BookGenre(bookId, genreId)
SELECT bookId, genreId
FROM Book, Genre
WHERE title='Harry Potter and the Philosopher''s Stone, Book 1' AND name='Magic world';

INSERT INTO BookGenre(bookId, genreId)
SELECT bookId, genreId
FROM Book, Genre
WHERE title='1984' AND name='Dystopian';

-- CHARACTER --
INSERT INTO Character(name)
VALUES ('Monster');

INSERT INTO Character(name)
VALUES ('Human');

-- BOOK CHARACTER --
INSERT INTO BookCharacter(bookId, characterId)
SELECT bookId, characterId
FROM Book, Character
WHERE title='It' AND name='Monster';

INSERT INTO BookCharacter(bookId, characterId)
SELECT bookId, characterId
FROM Book, Character
WHERE title='1984' AND name='Human';

INSERT INTO BookCharacter(bookId, characterId)
SELECT bookId, characterId
FROM Book, Character
WHERE title='Harry Potter and the Philosopher''s Stone, Book 1' AND name='Human';