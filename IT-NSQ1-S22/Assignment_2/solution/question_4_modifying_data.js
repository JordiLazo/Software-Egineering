//Modifying data
//1
db.orders.insertOne (
    {
        customerId: customers_ids.John,
        date: "24/03/2022",
        totalPrice: NumberDecimal(9.99),
        shippingPrice: NumberDecimal(1.99),
        lines: []
    }
  )
  orders_ids["John3"] = db.orders.findOne({ customerId: customers_ids.John, date: "24/03/2022" })._id
  db.orderItems.insertOne(
    {
      orderId: orders_ids.John3,
      lineItems: lineItems[
        {
          bookId: books_ids.Orwell,
          name: "1984",
          quantity: NumberInt(1),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0),
          totalPrice: NumberDeciaml(9.99)
        }
      ]
    }
  )
  orderItems_ids["John3"] = db.orders.findOne({ orderId: orders_ids.John3 })._id
  db.orders.update(
    {__id: orders_ids.John3 },
    { $push: {lines: orderItems_ids.John3}}
  )
  db.customers.update(
    {_id: customers_ids.John },
    { $push: {orders: orders.John3}}
  )
  db.books.update(
    {_id: books_ids.Orwell },
    { $inc: {units: -1}}
  )
  
  

//2
db.customers.update(
    {name: "Pep"}, 
    {$set: {shippingAddress: "Kamtjatka 7, K13"}}
)   
//3
db.books.update(
    {title: "Maus"}, 
    {$push: {authors: authors_ids.King}}
)

//4
db.books.aggregate([
  {
    $lookup: {
      from: "categories",
      localField: "category",
      foreignField: "_id",
      as: "oldCat"
    }
  },
  { $match: { "oldCat.name": "Soap Opera" } },
  {
    $set: {
      "category": {
        $first: "$oldCat.parentCategoryId"
      }
    }
  },
  { $unset: ["oldCat"] },
  {
    $merge: {
      into: "books",
      whenMatched: "replace",
      whenNotMatched: "discard"
    }
  }
 ])
  
 db.characters.aggregate([
  {
    $lookup: {
      from: "categories",
      localField: "categoryId",
      foreignField: "_id",
      as: "oldCat"
    }
  },
  { $match: { "oldCat.name": "Soap Opera" } },
  {
    $set: {
      "categoryId": {
        $first: "$oldCat.parentCategoryId"
      }
    }
  },
  { $unset: ["oldCat"] },
  {
    $merge: {
      into: "characters",
      whenMatched: "replace",
      whenNotMatched: "discard"
    }
  }
 ])
  
 db.genres.aggregate([
  {
    $lookup: {
      from: "categories",
      localField: "categoryId",
      foreignField: "_id",
      as: "oldCat"
    }
  },
  { $match: { "oldCat.name": "Soap Opera" } },
  {
    $set: {
      "categoryId": {
        $first: "$oldCat.parentCategoryId"
      }
    }
  },
  { $unset: ["oldCat"] },
  {
    $merge: {
      into: "genres",
      whenMatched: "replace",
      whenNotMatched: "discard"
    }
  }
 ])
  
 db.categories.aggregate([
  {
    $lookup: {
      from: "categories",
      localField: "parentCategoryId",
      foreignField: "_id",
      as: "parentCat"
    }
  },
  { $match: { "parentCat.name": "Soap Opera" } }
  ,
  {
    $set: {
      "parentCategoryId": {
        $first: "$parentCat.parentCategoryId"
      }
    }
  }
  ,
  { $unset: ["parentCat"] },
  {
    $merge: {
      into: "categories",
      whenMatched: "replace",
      whenNotMatched: "discard"
    }
  }
 ])
  
 db.categories.remove({ name: "Soap Opera" })
 

//5
db.orders.insertOne (
    {
      customerId: customers_ids.Pep,
      date: "25/03/2022",
      totalPrice: NumberDecimal(49.95),
      shippingPrice: NumberDecimal(1.50),
      lines: []
    }
   )
   orders_ids["Pep2"] = db.orders.findOne({ customerId: customers_ids.Pep, date: "25/03/2022" })._id
   db.orderItems.insertMany(
    {
      orderId: orders_ids.Pep2,
      lineItems: lineItems[
        {
          bookId: books_ids.Maus,
          name: "Maus",
          quantity: NumberInt(3),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0),
          totalPrice: NumberDecimal(29.97)
        },
        {
          bookId: books_ids.It,
          name: "It",
          quantity: NumberInt(2),
          unitPrice: NumberDecimal(9.99),
          discount: NumberDecimal(0),
          totalPrice: NumberDecimal(19.98)
        }
      ]
    }
   )
   orderItems_ids["Pep2"] = db.orders.findOne({ orderId: orders_ids.Pep2 })._id
   db.orders.update(
    {__id: orders_ids.Pep2 },
    { $push: {lines: orderItems_ids.Pep2}}
   )
   db.customers.update(
    {_id: customers_ids.Pep2 },
    { $push: {orders: orders.Pep}}
   )
   db.books.update(
    {_id: books_ids.Maus },
    { $inc: {units: -3}}
   )
   db.books.update(
    {_id: books_ids.It },
    { $inc: {units: -2}}
   )
  