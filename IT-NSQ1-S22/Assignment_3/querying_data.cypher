//1. All books by an author 
MATCH(:Author {name:"Stephen King"})-[:WROTE]->(book:Book)
RETURN book

//2. Total price of an order 
MATCH(o:Order {orderId:1}) 
RETURN o.totalPrice

//3. Total sales (in £) to a customer
MATCH(c:Customer{name:"John"})-[:PURCHASES]->(o:Order)
RETURN sum(o.totalPrice) 

//4. Books that are categorized as neither fiction nor non-fiction
MATCH(b:Book)-[PERTAINS_TO]->(c:Category)
WHERE NOT c.name="Fiction" AND NOT c.name="Biography"
RETURN b

//5.Average page count by genre
MATCH (b:Book)-[:IS]->(g:Genre)
RETURN avg(b.pages),g

//6.Categories that have no sub-categories
MATCH (c:Category)
WHERE NOT (c)-[:IS_PARENT]->(:Category)
RETURN c

//7.ISBN numbers of books with more than one author
MATCH (a:Author) -[:WROTE]-> (b:Book)
WITH count(a) AS numAuthors,b
WHERE numAuthors >= 2
RETURN  b.isbn

//8. ISBN numbers of books that sold at least X copies (you decide the value for X)
MATCH (oi: OrderItem) -[:REPRESENTS]-> (b:Book)
WITH sum(oi.quantity) as qty, b
WHERE qty >= 2
RETURN b.isbn

//9. Number of copies of each book sold – unsold books should show as 0 sold copies.
MATCH (b:Book)
OPTIONAL MATCH (oi: OrderItem) -[:REPRESENTS]-> (b)
WITH sum(oi.quantity) as quantity, b.name as bookName
RETURN bookName, quantity

//10. Best-selling books: The top 10 selling books ordered in descending order by number of sales.
MATCH (b:Book)
OPTIONAL MATCH (oi: OrderItem) -[:REPRESENTS]-> (b)
WITH sum(oi.quantity) as quantity, b.name as bookName
RETURN bookName, quantity
ORDER BY quantity DESC
LIMIT 10

//11. Best-selling genres: The top 3 selling genres ordered in descending order by number of sales.
MATCH (b:Book) -[:IS]-> (g:Genre)
OPTIONAL MATCH (oi: OrderItem) -[:REPRESENTS]-> (b)
WITH sum(oi.quantity) as quantity, g.name as genreName
RETURN genreName, quantity
ORDER BY quantity DESC
LIMIT 10

//12. All science fiction books. Note: Books in science fiction subcategories like cyberpunk also count as science fiction. Don’t use your knowledge of 
//the concrete category structure.
MATCH (catParent:Category{name:"Science Fiction & Fantasy"}) -[:IS_PARENT * 1..4]-> (c:Category)
OPTIONAL MATCH (b1:Book) -[:PERTAINS_TO]-> (c:Category)
OPTIONAL MATCH (b2:Book) -[:PERTAINS_TO]-> (catParent:Category)
WITH coalesce(b1.name, []) + coalesce(b2.name, []) as bookNames
RETURN bookNames
 

//13. Characters used in science fiction books. Note from (12) applies here as well.
MATCH (catParent:Category{name:"Science Fiction & Fantasy"}) -[:IS_PARENT * 1..4]-> (c:Category)
OPTIONAL MATCH (b1:Book) -[:PERTAINS_TO]-> (c:Category)
OPTIONAL MATCH (b2:Book) -[:PERTAINS_TO]-> (catParent:Category)
WITH apoc.coll.toSet(collect(coalesce(b1.name, [])) + collect(coalesce(b2.name, []))) as bookNames
UNWIND bookNames as bookName
MATCH (:Book{name:bookName})-[:INCLUDES]-> (c:Character)
RETURN c.name

//14. Number of books in each category including books in subcategories.
MATCH (catParent:Category) -[:IS_PARENT * 1..4]-> (c:Category)
WITH apoc.coll.toSet(collect(coalesce(catParent.name, [])) + collect(coalesce(c.name, [])))  as catNames
UNWIND catNames AS catName
MATCH (cat:Category)
OPTIONAL MATCH (b:Book) -[:PERTAINS_TO]->(cat)
WITH count(b) as numBook, cat
RETURN cat.name, numBook