--1. All books by an author

SELECT b.* 
FROM  author a JOIN bookauthor ba ON a.authorId = ba.authorId JOIN book b ON ba.bookId = b.bookId 
WHERE a.name = 'J.K. Rowling';

--2. Total price of an order

SELECT o.totalPrice
FROM orderTable o
WHERE o.orderId = '1';

--3. Total sales to a customer

SELECT c.name, sum(o.totalPrice) as totalSales
FROM orderTable o JOIN customer c ON c.customerId = o.customerId
WHERE c.name = 'Arnau Molins'
GROUP BY c.name;

--4. Books that are categorized as neither science fiction nor fantasy

SELECT b.*
FROM book b JOIN bookcategory bc ON b.bookId = bc.bookId JOIN category cat ON bc.categoryId = cat.categoryId
WHERE cat.name <> 'Science fiction' AND cat.name <>  'Fantasy';

--5. Average page count by genre

SELECT g.name, avg(b.pages) as avgPag
FROM book b JOIN bookgenre bg ON bg.bookId = b.bookId JOIN genre g ON g.genreId = bg.genreId
GROUP BY g.name;

--6. Categories that have no sub-categories

SELECT *
FROM Category
EXCEPT
SELECT *
FROM Category
WHERE categoryId IN (
    SELECT parentCategoryId
    FROM Category
    WHERE parentCategoryId IS NOT NULL
);

--7. ISBN numbers of books with more than one author

SELECT isbn, title
FROM Book b
WHERE bookId IN (
    SELECT authorId
    FROM BookAuthor
    GROUP BY authorId
    HAVING count(authorId) > 1
); 

--8. ISBN numbers of books that sold at least X copies (you decide the value for X)

DECLARE @X INT;
SET @X = 1;

SELECT isbn
FROM Book b
WHERE bookId IN (
    SELECT bookId
    FROM OrderItem
    GROUP BY bookId
    HAVING SUM(quantity) > @X
);


--9. outNumber of copies of each book sold – unsold books should show as 0 sold copies.

SELECT b.title, SUM(oi.quantity) as outNumber
FROM Book b
LEFT OUTER JOIN OrderItem oi
ON (oi.bookId = b.bookId)
GROUP BY b.title, oi.quantity
HAVING SUM(oi.quantity) > 0
UNION
SELECT b.title, 0 as outNumber
FROM Book b
LEFT OUTER JOIN OrderItem oi
ON (oi.bookId = b.bookId)
WHERE oi.bookId IS NULL
GROUP BY b.title, oi.quantity;


--10. Best-selling books: The top 10 selling books ordered in descending order by number of sales.

SELECT TOP(10) b.title, SUM(oi.quantity) as outNumber
FROM Book b
LEFT OUTER JOIN OrderItem oi
ON (oi.bookId = b.bookId)
GROUP BY b.title, oi.quantity
ORDER BY SUM(oi.quantity) DESC;

--11. Best-selling genres: The top 3 selling genres ordered in descending order by number of sales. 

SELECT TOP(10) g.name, SUM(oi.quantity) as outNumber
FROM Genre g
LEFT OUTER JOIN BookGenre bg
ON (
	g.genreId= bg.genreId)
	LEFT OUTER JOIN Book b 
	ON (bg.bookId = b.bookId)
		LEFT OUTER JOIN OrderItem oi
		ON (b.bookId = oi.bookId)
GROUP BY g.name, oi.quantity
ORDER BY SUM(oi.quantity) DESC;
