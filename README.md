# OptimizerService

## Problem
This project is going to build a Rest-API for solving knacksnack problem. The job is carried out in an asynchronouse communication.
It means that a client may post its task in the sever, and get back its solution later on.  

## Technique
A stack of technique is applied in this project. It includes **Spring Boot 1.5, Hibernate-JPA, Java 8, Derby(memory database), PostgreSql database, Heroku as PaaS, Maven, Git**. 

## Architect
Code was built in following structure, from bottom to the top: 
**database(derby for dev., postgresql for cloud) -> entities and data model-> repository(DAO) -> service(business logic) -> controller(http request handler) **

User post its task via API. System feedback by htttp accepted status, meanwhile spawning a new thread to do heavy job. As the job done, the solution is inserted in to database, and waitting for user to retreive it. 

## Deployment
Cloud: https://knapsacksolver.herokuapp.com/   
or 
Local: http://localhost:8080

## Security
API is secured by the Spring Security module, with user: "test" and password: "test"

## Testing 
Unit test: Spring Intergration test using Mocked MVC. It includes an emabeded memory database, and a mocked application server.
It is presented in the code, test package. 
And/OR: 
Real life test: using Postman to invoke APIs. 

## APIs
### Create a task in the sever to calculte (http Post method)
URI: https://knapsacksolver.herokuapp.com/knapsack/tasks

Request body: {"capacity":60,"weights":[50,10,20,40,30],"prices":[300,60,90,100,240]}

Basic Auth.: user: "test"; password: "test"

![image](https://user-images.githubusercontent.com/17804600/30811114-8729fdaa-a207-11e7-9a3d-ba63dea7ea3f.png)


### Check a task status by task id (http Get method)
URI https://knapsacksolver.herokuapp.com/knapsack/tasks/2

![image](https://user-images.githubusercontent.com/17804600/30812301-b4d9ff9a-a20a-11e7-906c-cf2a413cf9ce.png)











