
School Teacher CRUD Demo
=
This is a simple Spring Boot application  CRUD (Create, Read, Update, Delete) operation for managing teachers and their addresses.

Techonlogies Used 
-
-Java
-Spring Boot
-Spring Data Jpa 
-MySql
-Log4j2 

To Start you need to Clone the repository 
-
git clone https://github.com/aliabdkhalekk/School.git

configration for database 
you will find in application.properties in src/main/resources 

spring.datasource.url=jdbc:mysql://localhost:3306/school_project
spring.datasource.username=springstudent
spring.datasource.password=springstudent

before you run the application first run Mysql script in which workbench you use file named teachers.sql in sql-scripts

API Endpoints 
-
you will find the collection of all this endpoints in Postman file 
-GET /teachers: Retrieve all teachers.
-GET /teachers/{id}: Retrieve a specific teacher by ID.
-POST /teachers: Create a new teacher.
-PUT /teachers/{id}: Update an existing teacher by ID.
-DELETE /teachers/{id}: Delete a teacher by ID.

Logging 
- 
Used in this project Log4j2 
you can find logs file in log- app.log



