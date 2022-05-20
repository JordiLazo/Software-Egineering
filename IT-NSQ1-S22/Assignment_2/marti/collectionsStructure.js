db.createCollection("books", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["isbn", "title", "format", "price", "units", "pages", "condition", "avgReview", "totalReviews", "category"],
        properties: {
          isbn: {
            bsonType: "string"
          },
          title: {
            bsonType: "string"
          },
          format: {
            bsonType: "string"
          },
          price: {
            bsonType: "decimal"
          },
          units: {
            bsonType: "int"
          },
          pages: {
            bsonType: "int"
          },
          condition: {
            enum: ["Good", "Bad"]
          },
          avgReview: {
            bsonType: "decimal"
          },
          totalReviews: {
            bsonType: "int"
          },
          category: {
            bsonType: "objectId"
          },
          languages: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          },
          authors: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          },
          genres: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          },
          characters: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })
  
  
  db.createCollection("customers", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["name", "email", "shippingAddress", "phone"],
        properties: {
          name: {
            bsonType: "string",
          },
          email: {
            bsonType: "string"
          },
          shippingAddress: {
            bsonType: "string"
          },
          phone: {
            bsonType: "string"
          },
          orders: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })
  
  
  db.createCollection("orders", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["customerId", "date", "totalPrice", "shippingPrice", "lines"],
        properties: {
          customerId: {
            bsonType: "objectId",
          },
          date: {
            bsonType: "string"
          },
          totalPrice: {
            bsonType: "decimal"
          },
          shippingPrice: {
            bsonType: "decimal"
          },
          lines: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })
  
  db.createCollection("orderItems", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["orderId", "lineItems"],
        properties: {
          orderId: {
            bsonType: "objectId",
          },
          lineItems: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "object",
              required: ["bookId", "name", "quantity", "unitPrice", "discount", "totalPrice"],
              properties: {
                bookId: {
                  bsonType: "objectId"
                },
                name: {
                  bsonType: "string"
                },
                quantity: {
                  bsonType: "int"
                },
                unitPrice: {
                  bsonType: "decimal"
                },
                discount: {
                  bsonType: "decimal"
                },
                totalPrice: {
                  bsonType: "decimal"
                },
              }
            }
          }
        }
      }
    }
  })
  
  db.createCollection("characters", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["categoryId", "name"],
        properties: {
          categoryId: {
            bsonType: "objectId",
          },
          name: {
            bsonType: "string"
          },
          books: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })
  
  db.createCollection("genres", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["categoryId", "name"],
        properties: {
          categoryId: {
            bsonType: "objectId",
          },
          name: {
            bsonType: "string"
          },
          books: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })
  
  db.createCollection("categories", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["name"],
        properties: {
          name: {
            bsonType: "string",
          },
          parentCategoryId: {
            bsonType: "objectId"
          },
          characters: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          },
          genres: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          },
          books: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })
  
  
  db.createCollection("authors", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["name"],
        properties: {
          name: {
            bsonType: "string",
          },
          books: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })
  
  db.createCollection("languages", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["name"],
        properties: {
          name: {
            bsonType: "string",
          },
          books: {
            bsonType: "array",
            uniqueItems: true,
            items: {
              bsonType: "objectId"
            }
          }
        }
      }
    }
  })