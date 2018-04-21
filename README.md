# springJPA
simple Registration and login web services using JPA and mysql

**Run Application:**
1. Befor run the application make sour you have create database using with name "demo".
2. go to application.properties file and change mysql username and password to your mysql database.
3. open terminal 
4. go to application directory 
5. fire command: ./gradlew bootrun
6. default port is 4445 (you can change from application.properties file)

**Examples:**
1. For Registration:
curl -H "Content-Type: application/json" -X POST -d '{"fullName":"First Name","address":"India","userName":"myname","password":"Password"}' http://localhost:4445/api/user/saveUser

2. For Login:
curl -H "Content-Type: application/json" -X POST -d '{"userName":"myname","Password":"abc"}' http://localhost:4445/api/user/login
