# WorldRESTAPI
This is a REST API for the World MySQL database, using Spring Boot and Spring Data Rest.

To run the application go to the root of the project and do

```
mvn clean install
```
and
```
mvn spring-boot:run
```
This will start an application, most probably on port 8080 if it's not already busy. You can then 
access the api on http://localhost:8080/.

I have not limited endpoints, so all CRUD endpoints are available for all entities.

To list all countries:
```
GET http://localhost:8080/countries
```

To create a country:
```
POST http://localhost:8080/countries
{
"code": "AAA",
"name": "Arriba!",
"continent": "NORTH_AMERICA",
"region": "Caribbean",
"surfaceArea": 193,
"indepYear": 1987,
"population": 103000,
"lifeExpectancy": 78.4,
"gnp": 828,
"gnpOld": 793,
"localName": "Aruba",
"governmentForm": "Nonmetropolitan Territory of The Netherlands",
"headOfState": "Beatrix",
"capital": 129,
"code2": "AA" 
}
```

To update a country either POST with full object or PATCH:
```
PATCH http://localhost:8080/countries/AAA
{
"code":"AAA",
"name":"Abajo"
}
``` 

To delete a country:
```
DELETE http://localhost:8080/countries/AAA
```

And similar with the rest of the entities.