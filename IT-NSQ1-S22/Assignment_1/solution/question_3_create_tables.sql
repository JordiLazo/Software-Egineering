DROP TABLE OrderItem;
DROP TABLE BookAuthor;
DROP TABLE BookCategory;
DROP TABLE BookCharacter;
DROP TABLE BookGenre;
DROP TABLE BookLanguage;
DROP TABLE Category;
DROP TABLE Author;
DROP TABLE Genre;
DROP TABLE Character;
DROP TABLE Language;
DROP TABLE Payment;
DROP TABLE OrderTable;
DROP TABLE Customer;
DROP TABLE Book;


IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Book]') AND type IN (N'U'))
BEGIN
CREATE TABLE Book (
    bookId INT IDENTITY (1,1) PRIMARY KEY,
    title VARCHAR (50) NOT NULL,
    isbn VARCHAR (13) NOT NULL,
    bookFormat VARCHAR (10) NOT NULL,
    price FLOAT NOT NULL,
    units INT NOT NULL,
    pages INT NOT NULL,
    condition VARCHAR (10),
    avgReview FLOAT NOT NULL,
    totalReviews INT NOT NULL
);
END
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[OrderItem]') AND type IN (N'U'))
BEGIN
CREATE TABLE OrderItem (
    orderId INT,
    bookId INT,
    quantity INT NOT NULL,
    unitPrice FLOAT NOT NULL,
    discount FLOAT NOT NULL,
    totalPrice FLOAT NOT NULL,
    PRIMARY KEY (orderId, bookId)
);
END
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[OrderTable]') AND type IN (N'U'))
BEGIN
CREATE TABLE OrderTable (
    orderId INT IDENTITY (1,1) PRIMARY KEY,
    customerId INT NOT NULL,
    date DATE NOT NULL,
    totalPrice FLOAT NOT NULL,
    shippingPrice FLOAT NOT NULL
);
END
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Customer]') AND type IN (N'U'))
BEGIN
CREATE TABLE Customer (
    customerId INT IDENTITY (1,1) PRIMARY KEY,
    name VARCHAR (30) NOT NULL,
    email VARCHAR (30) NOT NULL,
    shippingAddress VARCHAR (50) NOT NULL,
    phoneNumber VARCHAR (12)
);
END
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Payment]') AND type IN (N'U'))
BEGIN
CREATE TABLE Payment (
    orderId INT IDENTITY (1,1) PRIMARY KEY,
    refNum VARCHAR (30) NOT NULL,
    method VARCHAR (30) NOT NULL,
    description VARCHAR (50) NOT NULL
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Character]') AND type IN (N'U'))
BEGIN
CREATE TABLE Character (
    characterId INT IDENTITY (1,1) PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[BookCharacter]') AND type IN (N'U'))
BEGIN
CREATE TABLE BookCharacter (
    characterId INT,
    bookId INT,
    PRIMARY KEY(characterId, bookId)
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Genre]') AND type IN (N'U'))
BEGIN
CREATE TABLE Genre (
    genreId INT IDENTITY (1,1) PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[BookGenre]') AND type IN (N'U'))
BEGIN
CREATE TABLE BookGenre (
    genreId INT,
    bookId INT,
    PRIMARY KEY(genreId, bookId)
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Category]') AND type IN (N'U'))
BEGIN
CREATE TABLE Category (
    categoryId INT IDENTITY (1,1) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    parentCategoryId INT REFERENCES Category(categoryId) NULL
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[BookCategory]') AND type IN (N'U'))
BEGIN
CREATE TABLE BookCategory (
    categoryId INT,
    bookId INT,
    PRIMARY KEY(categoryId, bookId)
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Author]') AND type IN (N'U'))
BEGIN
CREATE TABLE Author (
    authorId INT IDENTITY (1,1) PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[BookAuthor]') AND type IN (N'U'))
BEGIN
CREATE TABLE BookAuthor (
    authorId INT,
    bookId INT,
    PRIMARY KEY(authorId, bookId)
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Language]') AND type IN (N'U'))
BEGIN
CREATE TABLE Language (
    languageId INT IDENTITY (1,1) PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
END

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[BookLanguage]') AND type IN (N'U'))
BEGIN
CREATE TABLE BookLanguage (
    languageId INT,
    bookId INT,
    PRIMARY KEY(languageId, bookId)
);
END

ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderItem_orderId
FOREIGN KEY(orderId) REFERENCES OrderTable(OrderId);

ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderItem_bookId
FOREIGN KEY(bookId) REFERENCES Book(bookId);

ALTER TABLE OrderTable ADD CONSTRAINT FK_OrderTable_customerId
FOREIGN KEY(customerId) REFERENCES Customer(customerId);

ALTER TABLE Payment ADD CONSTRAINT FK_Payment_orderId
FOREIGN KEY(orderId) REFERENCES OrderTable(orderId);

ALTER TABLE BookCharacter ADD CONSTRAINT FK_BookCharacter_characterId
FOREIGN KEY(characterId) REFERENCES Character(characterId);

ALTER TABLE BookCharacter ADD CONSTRAINT FK_BookCharacter_bookId
FOREIGN KEY(bookId) REFERENCES Book(bookId);

ALTER TABLE BookGenre ADD CONSTRAINT FK_BookGenre_genreId
FOREIGN KEY(genreId) REFERENCES Genre(genreId);

ALTER TABLE BookGenre ADD CONSTRAINT FK_BookGenre_bookId
FOREIGN KEY(bookId) REFERENCES Book(bookId);

ALTER TABLE BookCategory ADD CONSTRAINT FK_BookCategory_categoryId
FOREIGN KEY(categoryId) REFERENCES Category(categoryId);

ALTER TABLE BookCategory ADD CONSTRAINT FK_BookCategory_bookId
FOREIGN KEY(bookId) REFERENCES Book(bookId);

ALTER TABLE BookAuthor ADD CONSTRAINT FK_BookAuthor_authorId
FOREIGN KEY(authorId) REFERENCES Author(authorId);

ALTER TABLE BookAuthor ADD CONSTRAINT FK_BookAuthor_bookId
FOREIGN KEY(bookId) REFERENCES Book(bookId);

ALTER TABLE BookLanguage ADD CONSTRAINT FK_BookLanguage_languageId
FOREIGN KEY(languageId) REFERENCES Language(languageId);

ALTER TABLE BookLanguage ADD CONSTRAINT FK_BookLanguage_bookId
FOREIGN KEY(bookId) REFERENCES Book(bookId);
