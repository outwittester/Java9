Difference Between Put and Post:
Put:
* idempotent
* called when modifying a single resource which is already a part of the resource collection
* syntax is PUT /questions/{question-id}
* PUT method answer can be cached
* If you send the same request multiple times, the result will remain the same
* works as specific
* we use UPDATE query in PUT
* client decides which URI resource should have

POST:
* not idempotent
* called when you have to add a child resource under resources collection
* syntax is POST/questions
* you can't cache PUT method responses
* if you send same POST request more than one time, you will receive different results
* POST work as abstract
* we use create query in POST
* server decides which URI resource should have 

