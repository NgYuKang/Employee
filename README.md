##   miniproject-employee-system
This repo is a mini project coded for an interview. Java version used is Java 22
## How to run
Ensure Java 22 is installed first<br>
Pull the repo, then run with the following command in a terminal:<br>
./gradlew bootRun<br>
The API should be started on localhost on port 8080
## Auth
All endpoints are secured using spring boot security, using basic auth.<br>
Currently the username is set to user and password is set to password, changeable in application.properties
## Endpoints
When launched, swagger docs can be viewed at http://localhost:8080/swagger-ui/index.html
### Employees
- /employees GET
- /employees/{id} GET
- /employees POST
- /employees/{id} PATCH
- /employees/{id} delete
- ### Projects
- /projects GET
- /projects/{id} GET
- /projects POST
- /projects/{id} PATCH
- /projects/{id} delete
- ### departments
- /departments GET
- /departments/{id} GET
- /departments POST
- /departments/{id} PATCH
- /departments/{id} delete
