
School Teacher CRUD Demo
=
This is a simple Spring Boot application  CRUD (Create, Read, Update, Delete) operation for managing teachers and their addresses.
<br />
Techonlogies Used 
-
-Java <br />
-Spring Boot <br />
-Spring Data Jpa <br />
-MySql <br />
-Log4j2 

To Start you need to Clone the repository 
-
git clone https://github.com/aliabdkhalekk/School.git
<br />
configration for database 
you will find in application.properties in src/main/resources 

spring.datasource.url=jdbc:mysql://localhost:3306/school_project
spring.datasource.username=springstudent
spring.datasource.password=springstudent

before you run the application first run Mysql script in which workbench you use file named teachers.sql in sql-scripts

API Endpoints 
-
you will find the collection of all this endpoints in Postman file <br />

-GET /teachers: Retrieve all teachers.<br />
-GET /teachers/{id}: Retrieve a specific teacher by ID.<br />
-POST /teachers: Create a new teacher.<br />
-PUT /teachers/{id}: Update an existing teacher by ID.<br />
-DELETE /teachers/{id}: Delete a teacher by ID.<br />

Logging 
- 
Used in this project Log4j2 <br />
you can find logs file in log- app.log <br />



