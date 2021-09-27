Employee Management System Backend Code.

A simple spring boot application.

Dockerfile is attached the same can be dockerized and launched.

Command for Docker:
1. docker build -t emsapp_v1.0 .
2. docker run -d -p 9000:9000 [docker image id generated after creating the build from point 1].

Note:
Port Number should be 9000 as the same port is being used by front end view application.

For Documentation:

http://localhost:9000/swagger-ui/index.html

The api's can be tested from there itself.


Note:
1. The in memory database is being used HashMap for the same.
2. Test cases are not wrtitten as the same is not mentioned in the requirement as hence expeted not required for evalution.




Requirement Document (copy pasted):
Requirement: Create an Employee Database Application.

1.	Create a REST API (CRUD) to manage Employees in a Database.  
2.	Create APIs mentioned in the table.
3.	Design your own model objects, database schema (Can use In memory DB or just use program memory, if you willing to use  actual  DB package them as docker images -  good but not mandatory)
4.	Create a simple UI to make async API calls to get List of Employees and display on screen. Can also add filter capability 

REST API Endpoint - /employees	Employee should have a hierarchy. An Employee reports to another Employee
GET /employees/{empId}	Get Employee details by Employee ID
POST /employees	Create employee
PUT/PATCH /employees/{empId}	Update Employee Details
GET /employees	Get list of Employee details by any criteria (choose your own criteria)
GET /employees/{empId}/reportees	Given an Employee - Fetch all Employees under this Employee hierarchy (direct and indirect reports)
GET /employees/{empId}/managers	Given an Employee – Fetch all Employees above the hierarchy.
Create your own endpoint	Given two Employees, Find the common superior manager.(Need not be immediate manager) 


Artifacts to be completed
1.	Design documentation
2.	ReadMe doc for executing the code
3.	DB schema – if using DB
4.	Code – Code should independently execute without errors and dependency issues.



