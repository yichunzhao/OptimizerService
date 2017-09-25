# OptimizerService

## Problem
This project is going to build a Rest-API for solving knacksnack problem. The Rest-API support asynchronouse communication, thus a long job can be solve later on. The Rest api is deployed in the cloud sever, i.e. heroku. 

## Technique
A stack of technique is applied in this project. It includes **Spring Boot 1.5, Hibernate-JPA, Java 8, Derby(memory database), PostgreSql database, Heroku as PaaS, Maven, Git**. 

## Architect
Code bascially has a following architect, from bottom to the top: 
**database(derby for dev., postgresql for cloud) -> entities and data model-> repository(DAO) -> service(business logic) -> controller(http request handler) **

## Deployment
Cloud: https://knapsacksolver.herokuapp.com/   
or 
Local: http://localhost:8080

## Security
API is secured by the Spring Security module, with user: "test" and password: "test"

## Testing 
Unit test: Spring Intergration test using Mocked MVC. Testing include an emabeded memory database, and a mocked application server.
And/OR: 
Real life test: using Postman to invoke APIs. 

## APIs

Get a task by id
https://knapsacksolver.herokuapp.com/knapsack/tasks/1








