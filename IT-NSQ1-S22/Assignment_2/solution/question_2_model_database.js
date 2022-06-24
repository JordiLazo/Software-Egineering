//Remove everything
db.authors.remove({})
db.books.remove({})
db.categories.remove({})
db.characters.remove({})
db.genres.remove({})
db.authors.remove({})
db.languages.remove({})
db.orderItems.remove({})
db.orders.remove({})
db.customers.remove({})



//Customers
db.customers.insertMany([
  {
    name: "John",
    email: "email@gmail.com",
    shippingAddress: "Carrer Normal",
    phone: "123321"
  },
  {
    name: "Pep",
    email: "mouse@outlook.com",
    shippingAddress: "Somewhere",
    phone: "456789"
  },
  {
    name: "Miquel",
    email: "adeu@terra.es",
    shippingAddress: "Chicago",
    phone: "143245"
  },
  {
    name: "Andrew",
    email: "klk@xtec.cat",
    shippingAddress: "Avinguda Verda",
    phone: "096048"
  }
])

customers_ids = {
  "John": db.customers.findOne({ name: "John" })._id,
  "Pep": db.customers.findOne({ name: "Pep" })._id,
  "Miquel": db.customers.findOne({ name: "Miquel" })._id,
  "Andrew": db.customers.findOne({ name: "Andrew" })._id,
}


//Categories
db.categories.insertMany([
  { name: "Children's Book" },
  { name: "Crime, Thrillers & Mystery" },
  { name: "Fiction" },
  { name: "History" },
  { name: "Biography" },
  { name: "Food & Drink" },
  { name: "Arts & Photography" },
  { name: "Romance" },
  { name: "Science Fiction & Fantasy" },
  { name: "Comics & Graphic Novels" }
])

categories_ids = {
  "Child": db.categories.findOne({ name: "Children's Book" })._id,
  "Crime": db.categories.findOne({ name: "Crime, Thrillers & Mystery" })._id,
  "Fiction": db.categories.findOne({ name: "Fiction" })._id,
  "History": db.categories.findOne({ name: "History" })._id,
  "Biography": db.categories.findOne({ name: "Biography" })._id,
  "Food": db.categories.findOne({ name: "Food & Drink" })._id,
  "Arts": db.categories.findOne({ name: "Arts & Photography" })._id,
  "Romance": db.categories.findOne({ name: "Romance" })._id,
  "SciFi": db.categories.findOne({ name: "Science Fiction & Fantasy" })._id,
  "Comics": db.categories.findOne({ name: "Comics & Graphic Novels" })._id
}

//Books
db.books.insertMany([
  {
    isbn: "B017V51FEG2D9",
    title: "Harry Potter",
    format: "Audiobook",
    price: NumberDecimal("17.99"),
    units: NumberInt(-1),
    pages: NumberInt(345),
    condition: "Bad",
    avgReview: NumberDecimal(4.8),
    totalReviews: NumberInt(49223),
    category: categories_ids.Fiction
  },
  {
    isbn: "MSUE83L1093LS",
    title: "Maus",
    format: "Hardcover",
    price: NumberDecimal("19.99"),
    units: NumberInt(453),
    pages: NumberInt(303),
    condition: "Good",
    avgReview: NumberDecimal(4.9),
    totalReviews: NumberInt(2341),
    category: categories_ids.History
  },
  {
    isbn: "OD93M0CKE0EMW",
    title: "1984",
    format: "Softcover",
    price: NumberDecimal("4.99"),
    units: NumberInt(666),
    pages: NumberInt(421),
    condition: "Good",
    avgReview: NumberDecimal(4.5),
    totalReviews: NumberInt(73212),
    category: categories_ids.Biography
  },
  {
    isbn: "SIEL283PEM21",
    title: "It",
    format: "Hardcover",
    price: NumberDecimal("9.99"),
    units: NumberInt(230),
    pages: NumberInt(1053),
    condition: "Bad",
    avgReview: NumberDecimal(4.7),
    totalReviews: NumberInt(7234),
    category: categories_ids.Crime
  }
])

books_ids = {
  "HP": db.books.findOne({ title: "Harry Potter" })._id,
  "Maus": db.books.findOne({ title: "Maus" })._id,
  "Orwell": db.books.findOne({ title: "1984" })._id,
  "It": db.books.findOne({ title: "It" })._id,
}

//Characters
db.characters.insertMany([
  { name: "Monster", categoryId: categories_ids.SciFi },
  { name: "Human", categoryId: categories_ids.Romance },
  { name: "Ghost", categoryId: categories_ids.Comics }
])

characters_ids = {
  "Monster": db.characters.findOne({ name: "Monster" })._id,
  "Human": db.characters.findOne({ name: "Human" })._id,
  "Ghost": db.characters.findOne({ name: "Ghost" })._id
}

db.categories.update(
  { _id: categories_ids.SciFi },
  { $push: { characters: characters_ids.Monster } }
)
db.categories.update(
  { _id: categories_ids.Romance },
  { $push: { characters: characters_ids.Human } }
)
db.categories.update(
  { _id: categories_ids.Comics },
  { $push: { characters: characters_ids.Ghost } }
)


db.books.update(
  { _id: books_ids.It },
  { $push: { characters: characters_ids.Monster } }
)

db.books.update(
  { _id: books_ids.It },
  { $push: { characters: characters_ids.Ghost } }
)

db.books.update(
  { _id: books_ids.Orwell },
  { $push: { characters: characters_ids.Human } }
)

db.books.update(
  { _id: books_ids.HP },
  { $push: { characters: characters_ids.Monster } }
)

db.books.update(
  { _id: books_ids.Maus },
  { $push: { characters: characters_ids.Human } }
)

//Genres
db.genres.insertMany([
  { name: "Magic world", categoryId: categories_ids.SciFi },
  { name: "Dystopian", categoryId: categories_ids.Fiction },
  { name: "Horror", categoryId: categories_ids.Crime }
])

genres_ids = {
  "MW": db.genres.findOne({ name: "Magic world" })._id,
  "Dystopian": db.genres.findOne({ name: "Dystopian" })._id,
  "Horror": db.genres.findOne({ name: "Horror" })._id
}

db.categories.update(
  { _id: categories_ids.SciFi },
  { $push: { genres: genres_ids.MW } }
)
db.categories.update(
  { _id: categories_ids.Fiction },
  { $push: { genres: genres_ids.Dystopian } }
)
db.categories.update(
  { _id: categories_ids.Crime },
  { $push: { genres: genres_ids.Horror } }
)

db.books.update(
  { _id: books_ids.It },
  { $push: { genres: genres_ids.Horror } }
)
db.books.update(
  { _id: books_ids.It },
  { $push: { genres: genres_ids.MW } }
)
db.books.update(
  { _id: books_ids.HP },
  { $push: { genres: genres_ids.MW } }
)
db.books.update(
  { _id: books_ids.Orwell },
  { $push: { genres: genres_ids.Dystopian } }
)

//Languages

db.languages.insertMany([
  { name: "Catalan" },
  { name: "English" },
  { name: "Danish" }
])

languages_ids = {
  "Catalan": db.languages.findOne({ name: "Catalan" })._id,
  "English": db.languages.findOne({ name: "English" })._id,
  "Danish": db.languages.findOne({ name: "Danish" })._id
}

db.book.update(
  { _id: books_ids.It },
  { $push: { languages: languages_ids.Catalan } }
)

db.book.update(
  { _id: books_ids.It },
  { $push: { languages: languages_ids.Danish } }
)


db.book.update(
  { _id: books_ids.It },
  { $push: { languages: languages_ids.English } }
)

db.book.update(
  { _id: books_ids.Orwell },
  { $push: { languages: languages_ids.Catalan } }
)

db.book.update(
  { _id: books_ids.HP },
  { $push: { languages: languages_ids.English } }
)
db.book.update(
  { _id: books_ids.Maus },
  { $push: { languages: languages_ids.Danish } }
)


//Authors
db.authors.insertMany([
  { name: "JK Rowling" },
  { name: "Stephen King" },
  { name: "Isaac Asimov" },
])

authors_ids = {
  "JK": db.authors.findOne({ name: "JK Rowling" })._id,
  "King": db.authors.findOne({ name: "Stephen King" })._id,
  "Asimov": db.authors.findOne({ name: "Isaac Asimov" })._id
}

db.books.update(
  { _id: books_ids.HP },
  { $push: { authors: authors_ids.JK } }
)

db.books.update(
  { _id: books_ids.HP },
  { $push: { authors: authors_ids.Asimov } }
)

db.books.update(
  { _id: books_ids.It },
  { $push: { authors: authors_ids.Asimov } }
)

db.books.update(
  { _id: books_ids.It },
  { $push: { authors: authors_ids.King } }
)

db.books.update(
  { _id: books_ids.Maus },
  { $push: { authors: authors_ids.JK } }
)
db.books.update(
  { _id: books_ids.Orwell },
  { $push: { authors: authors_ids.King } }
)


//Orders
db.orders.insertMany([
  {
    customerId: customers_ids.John, date: "10/10/2010",
    totalPrice: NumberDecimal(101.20), shippingPrice: NumberDecimal(10.2),
    lines: []
  },
  {
    customerId: customers_ids.Pep, date: "15/01/2010",
    totalPrice: NumberDecimal(11.20), shippingPrice: NumberDecimal(10.2),
    lines: []
  },
  {
    customerId: customers_ids.John, date: "08/12/2010",
    totalPrice: NumberDecimal(41.20), shippingPrice: NumberDecimal(10.2),
    lines: []
  }
])

orders_ids = {
  "John1": db.orders.findOne({ customerId: customers_ids.John, date: "10/10/2010" })._id,
  "Pep1": db.orders.findOne({ customerId: customers_ids.Pep, date: "15/01/2010" })._id,
  "John2": db.orders.findOne({ customerId: customers_ids.John, date: "08/12/2010" })._id
}

db.customers.update(
  { _id: customers_ids.John },
  { $push: { orders: orders_ids.John1 } }
)
db.customers.update(
  { _id: customers_ids.Pep },
  { $push: { orders: orders_ids.Pep1 } }
)
db.customers.update(
  { _id: customers_ids.John },
  { $push: { orders: orders_ids.John2 } }
)


//OrderItems

db.orderItems.insertMany([
  {
    orderId: orders_ids.John1,
    lineItems:
      [
        {
          bookId: books_ids.It,
          name: "It",
          quantity: NumberInt(1),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0.0),
          totalPrice: NumberDecimal(9.99)
        },
        {
          bookId: books_ids.Maus,
          name: "Maus",
          quantity: NumberInt(1),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0.0),
          totalPrice: NumberDecimal(9.99)
        },
      ]
  },
  {
    orderId: orders_ids.Pep1,
    lineItems:
      [
        {
          bookId: books_ids.HP,
          name: "Harry Potter",
          quantity: NumberInt(2),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0.0),
          totalPrice: NumberDecimal(19.98)
        }
      ]
  },
  {
    orderId: orders_ids.John2,
    lineItems:
      [
        {
          bookId: books_ids.Orwell,
          name: "1984",
          quantity: NumberInt(1),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0.0),
          totalPrice: NumberDecimal(9.99)
        },
        {
          bookId: books_ids.Maus,
          name: "Maus",
          quantity: NumberInt(1),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0.0),
          totalPrice: NumberDecimal(9.99)
        },
      ]
  },
])

orderItems_ids = {
  "John1": db.orderItems.findOne({ orderId: orders_ids.John1 })._id,
  "Pep1": db.orderItems.findOne({ orderId: orders_ids.Pep1 })._id,
  "John2": db.orderItems.findOne({ orderId: orders_ids.John2 })._id
}

db.orders.update(
  { _id: orders_ids.John1 },
  { $push: { lines: orderItems_ids.John1 } }
)
db.orders.update(
  { _id: orders_ids.Pep1 },
  { $push: { lines: orderItems_ids.Pep1 } }
)
db.orders.update(
  { _id: orders_ids.John2 },
  { $push: { lines: orderItems_ids.John2 } }
)


db.categories.insertOne({
  name: "Soap Opera",
  parentCategoryId: categories_ids.SciFi,
  characters: [characters_ids.Human],
  genres: [genres_ids.MW],
  books: [books_ids.It]
})


categories_ids["SoOp"] = db.categories.findOne({name:"Soap Opera"})._id

db.characters.update(
  { _id: characters_ids.Human },
  { $push: { categories: categories_ids.SoOp} }
)

db.genres.update(
  { _id: genres_ids.MW },
  { $push: { categories: categories_ids.SoOp} }
)

db.books.update(
  { _id: books_ids.It },
  { $set: { category: categories_ids.SoOp} }
)
  



//9
