--1. Sell a book to a customer.

--Insert value to  Order and OrderItems

DECLARE @John INT;
SET @John = (SELECT customerId FROM Customer WHERE name='John Doe');

INSERT INTO OrderTable(customerId, date, totalPrice, shippingPrice)
VALUES (@John, '2024-01-11', 34.18, 3);

DECLARE @O1 INT;
SET @O1 = (SELECT orderId FROM OrderTable WHERE customerId=@John AND date='2024-01-11');

DECLARE @Maus INT;
SET @Maus = (SELECT bookId FROM Book WHERE title='Maus');

INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@O1, @Maus, 2, 17.99, 0.05, 34.18);


SET IDENTITY_INSERT Payment ON
INSERT INTO Payment(orderId, refNum, method, description)
VALUES (@O1, 'FDGSUAIH', 'PayPal', 'lorem ipsum');
SET IDENTITY_INSERT Payment OFF


--2. Change the address of a customer.

--Update shippingAddress in Customer

DECLARE @Xavier INT;
SET @Xavier = (SELECT customerId FROM Customer WHERE name='Xavier Nadal');

UPDATE Customer
SET shippingAddress = 'Somewhere'
WHERE customerId = @John;

--3. Add an existing author to a book.

--Insert row into BookAuthor

DECLARE @1984 INT;
SET @1984 = (SELECT bookId FROM Book WHERE title='1984');
DECLARE @Steph INT;
SET @Steph = (SELECT authorId FROM Author WHERE name='Stephen King');

INSERT INTO BookAuthor(authorId, bookId)
VALUES (@Steph, @Maus);

--4. Retire the "Space Opera" category and assign all books from that category to the parent category. 
    --Do not assume you know an id of the parent category.

--Update BookCategory of all books with category 'Space Opera' to parent category.
--Remove 'Space Opera' category

UPDATE BookCategory
SET categoryId = c.parentCategoryId
FROM BookCategory bc
INNER JOIN Category c
ON bc.categoryId=c.categoryId
WHERE c.name='Space Opera';

DELETE FROM Category
WHERE name='Space Opera';

--5. Sell 3 copies of one book and 2 of another in a single order

--Create Order in OrderTable
--Insert item lines in OrderItem
--Add payment method in Payment table

DECLARE @Customer5 INT;
SET @Customer5 = (SELECT customerId FROM Customer WHERE name='Arnau Molins');

DECLARE @Book5a INT;
SET @Book5a = (SELECT bookId FROM Book WHERE title='1984');

DECLARE @Book5b INT;
SET @Book5b = (SELECT bookId FROM Book WHERE title='It');

INSERT INTO OrderTable(customerId, date, totalPrice, shippingPrice)
VALUES (@Customer5, '2027-01-11', 34.18, 3);

DECLARE @Order5 INT;
SET @Order5 = (SELECT orderId FROM OrderTable WHERE customerId=@Customer5 AND date='2027-01-11');

INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@Order5, @Book5a, 3, 10, 0.0, 30.0);

INSERT INTO OrderItem (orderId, bookId, quantity, unitPrice, discount, totalPrice)
VALUES (@Order5, @Book5b, 2, 17.99, 0.05, 34.18);

SET IDENTITY_INSERT Payment ON
INSERT INTO Payment(orderId, refNum, method, description)
VALUES (@Order5, 'ABCGDEJF', 'Bank transfer', 'lorem ipsum');
SET IDENTITY_INSERT Payment OFF