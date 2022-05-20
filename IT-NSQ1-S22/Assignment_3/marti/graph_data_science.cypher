//Community

CALL gds.graph.create.cypher('customer-book-purchase',  
"MATCH (n) 
 WHERE n:Customer or n:Book 
 RETURN id(n) AS id, labels(n) AS labels",
"
  MATCH (c:Customer)-[p:PURCHASES]->(o:Order)-[h:HAS]->(oi:OrderItem)-[r:REPRESENTS]->(b:Book)
  RETURN id(c) AS source, id(b) AS target, 'HAS_PURCHASED_BOOK' as type
")
YIELD graphName AS graph, nodeQuery, nodeCount AS nodes, relationshipQuery, relationshipCount AS rels

CALL gds.louvain.stream('customer-book-purchase')
YIELD nodeId, communityId, intermediateCommunityIds
RETURN gds.util.asNode(nodeId).name AS name, communityId, intermediateCommunityIds
ORDER BY name ASC


//Centrality

CALL gds.graph.create.cypher('order-purchased-by-customer',  
"MATCH (n) 
 WHERE n:Customer or n:Order 
 RETURN id(n) AS id, labels(n) AS labels",

"
  MATCH (c:Customer)-[p:PURCHASES]->(o:Order)
  RETURN id(o) AS source, id(c) AS target, 'PURCHASED_BY' as type
") 
YIELD graphName AS graph, nodeQuery, nodeCount AS nodes, relationshipQuery, relationshipCount AS rels

CALL gds.articleRank.stream('order-purchased-by-customer')
YIELD nodeId, score
RETURN gds.util.asNode(nodeId).name AS name, score
ORDER BY score DESC, name ASC


//Topological link prediction

MATCH (c:Customer {name: 'Miquel'})
MATCH (b:Book)
RETURN gds.alpha.linkprediction.adamicAdar(c, b, 
{relationshipQuery: 
  "
  MATCH (c:Customer)-[p:PURCHASES]->(o:Order)-[h:HAS]->(oi:OrderItem)-[r:REPRESENTS]->(b:Book)
  RETURN id(c) AS source, id(b) AS target, 'HAS_PURCHASED_BOOK' as type
"
}) AS score, b.name as book

