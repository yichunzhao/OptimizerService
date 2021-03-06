# OptimizerService

## Problem
The project is to build a Rest-API for solving knacksnack problem. The job is carried out in an asynchronous communication.
It means that a client may post its task in the sever, and get back its solution later on.  

## Knapsack Algorithm
I slightly changed [Java Program to Implement Knapsack Algorithm](http://www.sanfoundry.com/java-program-knapsack-algorithm/), so that it fits into the project. 


## Concept
User post its task via API. System feedback a http accepted status, meanwhile spawning a new thread to do the heavy job. As the job done, the solution is inserted in to database, waiting for user to retrieve it. 

## Deployment
Cloud: https://knapsacksolver.herokuapp.com/   
Project jar file is deployed on the Cloud via Heroku CLI using git command. 

The cloud server is totally free, so it will very often fall in idle. You need to wait a while until it wakes up. 

or 
Local: http://localhost:8080
running on Tomcat sever

## Security
API is secured by the Spring Security, with user: "test" and password: "test"

## Testing 
Unit test: Spring Integration test with Mocked MVC. It includes an embedded memory database, and a mocked application server.
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
URI https://knapsacksolver.herokuapp.com/knapsack/tasks/id

id : Long ; task id.

![image](https://user-images.githubusercontent.com/17804600/30812301-b4d9ff9a-a20a-11e7-906c-cf2a413cf9ce.png)


### Get back a solution ref. to task String (http Get method)
URI https://knapsacksolver.herokuapp.com/knapsack/solutions/task

task: JAVA util UUID String ; achieved when posting a task

for instance: https://knapsacksolver.herokuapp.com/knapsack/solutions/0964614d-b8fb-450e-9abd-fcace74dabe9

![image](https://user-images.githubusercontent.com/17804600/30818261-612d2906-a21b-11e7-982f-f40fc7c59814.png)

### Get tasks classified by status (http Get method)
URI https://knapsacksolver.herokuapp.com/knapsack/admin/tasks

return all tasks classified by their status. 

for instance

![image](https://user-images.githubusercontent.com/17804600/30820429-296efeca-a222-11e7-88d4-dd499490faea.png)










