SpringBootRestWebService Application Details:
---------------------------------------------
Technologies used:
``````````````````
Spring boot 2.0.4
REST
JDK 1.8
Maven
Mongo DB (embedded)
	-- running on localhost:27017
	-- DB: test
	-- Collection: Employee
Tomcat (embedded)
	-- running on localhost:8080

REST End Points:
````````````````
/rest/emp/create		[POST]
/rest/emp/delete/{id} 	[PUT]
/rest/emp/getAll 		[GET]
/rest/emp/{id} 			[GET]
/rest/randomEndPoint 	[GET]

Swagger URL:
````````````
http://localhost:8080/swagger-ui.html

