//Query data
//1
db.authors.aggregate([
  {$lookup: {
      from: "books", 
      localField: "_id",
      foreignField: "authors",
      as: "AuthorsBooks"
  },
}
])
    
//2
db.orders.find({_id: ObjectId("623d937a60d37d56a344ad74")}, {totalPrice : 1})


//3
db.customers.aggregate([
  { $lookup : {from : "orders", localField : "orders" , foreignField : "_id", as : "ord_customer"} },
  { $match : { name : "John" } },
{$project: {"_id":1, "name":1,"totalValue": {$sum: "$ord_customer.totalPrice"}}}
])

//4
db.categories.aggregate([
  { $lookup : {from : "books", localField : "_id" , foreignField : "category", as : "books_cat"} },
  { $match : {$and : [{ name : { $ne : "Fiction"}},{ name : { $ne : "History"}}]}},
  { $project: {"Books":"$books_cat.title", name:1}}
])


//5
db.books.aggregate([
    {
      $unwind: "$genres"
    },
    {
      $group:
      {
        _id: "$genres",
        averagePagesByGenre: { $avg: { $sum: "$pages"}}
      }
    }
  ])
  
  //6
  db.categories.aggregate([
    {
      $lookup: {
        from: "categories",
        localField: "categoryId",
        foreignField: "_id",
        as: "parentCat"
    },
      $group: {
        _id: "$parentCat"
      }
    }
  ])
  
  //7
  db.books.aggregate([
    {
      $addFields: {
        arrayLength: {$size: '$authors'}
      },
    },
    {
      $match: {
        "arrayLength": {$gt: 1}
      }
    },
    {
      $group: {
        _id: "$isbn"      
    }
    }
  ])

  //8
  db.orderItems.aggregate([
    {
      $unwind: "$lineItems"
    },
    {$group: {
      _id: "$lineItems.bookId",
      totalSold: { $sum: "$lineItems.quantity"}
    }},
    {$match:  {totalSold: {$gt: 1}}},
     {$lookup:
        {
            from: "books",
            localField: "_id",
            foreignField: "_id",
            as: "Book"
        }
    },
    {$group:
        {
            _id: "$Book.isbn"
        }}
   ])
   
//9
db.orderItems.aggregate([
  {
    $unwind: "$lineItems"
  },
  {$group: {
    _id: "$lineItems.bookId",
    totalSold: { $sum: "$lineItems.quantity"}
  }}])

//10
db.orderItems.aggregate([
  {
    $unwind: "$lineItems"
  },
  {$group: {
    _id: "$lineItems.bookId",
    totalSold: { $sum: "$lineItems.quantity"}
  }},
  {$sort: {
    totalSold:-1
  }},
  {$limit: 10}
])

//11
db.genres.aggregate([
  {
      $lookup: {
          from: "books",
          localField: "_id",
          foreignField: "genres",
          as: "genBooks"
      }
  },
  { $project: { "_id": 1, "name": 1, "booksIds": "$genBooks._id", "genBooks": 1 } },
  {
      $lookup: {
          from: "orderItems",
          localField: "booksIds",
          foreignField: "lineItems.bookId",
          as: "myOrderItems"
      }
  },
  {
      $addFields: {
          "myBooks": {
              $filter:
              {
                  input: "$myOrderItems.lineItems",
                  as: "li",
                  cond: {
                      $in: ["$li.bookId", "$booksIds"]
                  }
              }
          }
      }
  }
])

//12
db.categories.aggregate([
  {
      $graphLookup: {
          from: "categories",
          startWith: "$parentCategoryId",
          connectFromField: "parentCategoryId",
          connectToField: "_id",
          as: "catHierarchy"
      }
    },
    {
        "$match": {
            $or:
                [
                    { "$expr": { "$in": ["Science Fiction & Fantasy", "$catHierarchy.name"] } },
                    { "$expr": { "$eq": [ "$name", "Science Fiction & Fantasy"] } }
                ]
        }
    },
    {
        $group: {_id:"$_id"}
    },
    {$lookup: {
        from: "books",
        localField: "_id",
        foreignField: "category",
        as: "catBooks"
    }}
 ])

 
 //13
 db.categories.aggregate([
  {
      $graphLookup: {
          from: "categories",
          startWith: "$parentCategoryId",
          connectFromField: "parentCategoryId",
          connectToField: "_id",
          as: "catHierarchy"
      }
  },
  {
      "$match": {
          $or:
              [
                  { "$expr": { "$in": ["Science Fiction & Fantasy", "$catHierarchy.name"] } },
                  { "$expr": { "$eq": [ "$name", "Science Fiction & Fantasy"] } }
              ]
      }
  },
  {
      $group: {_id:"$_id"}
  },
  {$lookup: {
    from: "books",
    localField: "_id",
    foreignField: "category",
    as: "catBooks"
}},
{
    $group: {_id:"$catBooks.characters"}
}
])


//14
db.categories.aggregate([
  {
      $graphLookup: {
          from: "categories",
          startWith: "$_id",
          connectFromField: "_id",
          connectToField: "parentCategoryId",
          as: "catHierarchy"
      }
  },
  { $project: { "_id": 1, "name": 1, "cats": { $concatArrays: [["$_id"], "$catHierarchy._id"] } } },
  {
      $lookup: {
          from: "books",
          localField: "cats",
          foreignField: "category",
          as: "hierBooks"
      }
  },
  {$project: {"_id":1, "name":1, "totalBooks": {$size: "$hierBooks"}}}
])
