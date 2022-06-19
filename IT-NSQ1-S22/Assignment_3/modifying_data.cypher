//1. Sell a book to a customer.
CREATE (oi:OrderItem{unitPrice:9.99, quantity:1, totalPrice:9.99, name:"1984"})
CREATE (o:Order{totalPrice:19.98, orderId:5})
WITH oi, o
MATCH (c:Customer{name:"John"})
CREATE (o)-[:HAS]->(oi)
CREATE (c) -[:PURCHASES]->(o)
WITH *
MATCH (b:Book{name:"1984"})
SET b.units = b.units-1

//2. Change the address of a customer.
MATCH(c:Customer{name:{"Miquel"})
SET c.address = "Almacelles, Lleida"

//3. Add an existing author to a book.
MATCH (a:Author{name:"Isaac Asimov"})
MATCH (b:Book{name:"It"})
MERGE (a)-[:WROTE]->(b)

//4. Retire the "Space Opera" category and assign all books from that category to the parent category. 
//Don't assume you know the id of the parent category.
MATCH (catParent:Category)-[:IS_PARENT]->(cat:Category{name:"Space Opera"})
OPTIONAL MATCH (cat)-[:IS_PARENT]->(catChild:Category)
WITH catParent, cat, catChild
CREATE (catParent)-[:IS_PARENT]->(catChild)
DETACH DELETE cat

//5. Sell 3 copies of one book and 2 of another in a single order
CREATE (oi1:OrderItem{unitPrice:9.99, quantity:2, totalPrice:19.98, name:"It"})
CREATE (oi2: OrderItem{unitPrice:9.99, quantity:3, totalPrice:29.97, name:"Maus"})
CREATE (o:Order{totalPrice:49.95, orderId:6})
WITH oi1, oi2, o
MATCH (c:Customer{name:"Pep"})
CREATE (o)-[:HAS]->(oi1)
CREATE (o)-[:HAS]->(oi2)
CREATE (c) -[:PURCHASES]->(o)
WITH *
MATCH (b1:Book{name:"It"})
SET b1.units = b1.units-2
WITH *
MATCH (b2:Book{name:"Maus"})
SET b2.units = b2.units-3