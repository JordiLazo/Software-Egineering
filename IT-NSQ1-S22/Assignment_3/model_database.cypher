//
WITH "https://gist.githubusercontent.com/santo0/e4ba9939e5146c5fe9c75d967f4fcb73/raw/98359e7b7f447b2615dcc6e0e8d9137221804f15/books.json" AS url
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
WITH "https://gist.githubusercontent.com/santo0/3ff6124dcb2cbd1d82156555022a3fbf/raw/96cb689a9ab923e7dc0cb13386ca28fdd18e788b/categories.json" AS url
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
WITH "https://gist.githubusercontent.com/santo0/b75c33cd922ee81477c37d6249074f51/raw/8f84fef4d695da00ac7ea98985481d6bac03cf6a/characters.json" AS url
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
WITH "https://gist.githubusercontent.com/santo0/afeec3df662d3317fcc28b8a53baeaaa/raw/06e96b76cf3a70e3c6b34e0ac6742dfbf9d29c0c/genres.json" AS url
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
WITH "https://gist.githubusercontent.com/santo0/9836ac6497a92f1734db1f92c049ab53/raw/8e11f93bbfef0623fc5915188bcc8cd149bb8171/authors.json" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as author
MERGE (a:Author{
    name:author.name
})

//
WITH "https://gist.githubusercontent.com/santo0/60eb770cda64a516bd588f5618556fa1/raw/80a09b8cbceded380d356fbb6ec0b1c0bd406024/languages.json" AS url
CALL apoc.load.json(url) YIELD value
UNWIND value as language
MERGE (c:Language{
    name:language.name
})

//
WITH "https://gist.githubusercontent.com/santo0/0b5917ef542bd1bd792dfc02ee0e3020/raw/d0b2163361dee94b073c28e2075d6c2db1ffb328/customers.json" AS url
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