//
WITH "https://raw.githubusercontent.com/JordiLazo/VIA_University_College_Software_Engineering/main/IT-NSQ1-S22/Assignment_3/books.js" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as book
CREATE (b:Book{
    name:book.name,
    price:book.price,
    units:book.units,
    pages:book.pages,
    isbn:book.isbn})
FOREACH (category IN book.categories |
    MERGE (c:Category {
        name:category.name
    })
    MERGE (b) -[:PERTAINS_TO]->(c)
)
FOREACH (language IN book.languages |
    MERGE (l:Language {
        name:language.name
    })
    MERGE (b) -[:WRITTEN_IN]->(l)
)
FOREACH (character IN book.characters |
    MERGE (c:Character {
        name:character.name
    })
    MERGE (b) -[:INCLUDES]->(c)
)
FOREACH (genre IN book.genres |
    MERGE (g:Genre {
        name:genre.name
    })
    MERGE (b) -[:IS]->(g)
)
FOREACH (author IN book.authors |
    MERGE (a:Author {
        name:author.name
    })
    MERGE (b) <-[:WROTE]-(a)
)

//
WITH "https://raw.githubusercontent.com/JordiLazo/VIA_University_College_Software_Engineering/main/IT-NSQ1-S22/Assignment_3/category.js" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as category
MERGE (c1:Category{
    name:category.name
})

//
WITH category, c1
WHERE NOT category.parentCategory IS NULL
MERGE (c2:Category{
    name:category.parentCategory
})
MERGE (c2) -[:IS_PARENT]-> (c1)

//
WITH "https://raw.githubusercontent.com/JordiLazo/VIA_University_College_Software_Engineering/main/IT-NSQ1-S22/Assignment_3/character.js" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as character
MERGE (c:Character{
    name:character.name
})
MERGE (ca:Category{
    name:character.category
})
MERGE (c)-[:APPEARS_IN]->(ca)

//
WITH "https://raw.githubusercontent.com/JordiLazo/VIA_University_College_Software_Engineering/main/IT-NSQ1-S22/Assignment_3/genre.js" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as genre
MERGE (g:Genre{
    name:genre.name
})
MERGE (ca:Category{
    name:genre.category
})
MERGE (g)-[:IS_PART_OF]->(ca)

//
WITH "https://raw.githubusercontent.com/JordiLazo/VIA_University_College_Software_Engineering/main/IT-NSQ1-S22/Assignment_3/authors.js" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as author
MERGE (a:Author{
    name:author.name
})

//
WITH "https://raw.githubusercontent.com/JordiLazo/VIA_University_College_Software_Engineering/main/IT-NSQ1-S22/Assignment_3/language.js" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as language
MERGE (c:Language{
    name:language.name
})

//
WITH "https://raw.githubusercontent.com/JordiLazo/VIA_University_College_Software_Engineering/main/IT-NSQ1-S22/Assignment_3/customer.js" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value AS customer
CREATE (c:Customer{
	name: customer.name})
FOREACH (order IN customer.orders |
MERGE (c) -[:PURCHASES]-> (o:Order {
	orderId:order.orderId, 
    totalPrice:order.totalPrice}) 
    FOREACH (orderItem IN order.orderItems |
    MERGE(oi:OrderItem {
        name: orderItem.name, 
        quantity:orderItem.quantity, 
        unitPrice:orderItem.unitPrice,
        totalPrice:orderItem.totalPrice})
    MERGE (oi) <-[:HAS]- (o)
    MERGE (b:Book{name:orderItem.name})
    MERGE (b) <-[:REPRESENTS]- (oi)
    ))