
### Project settings

Install necessary programs
- Java 8
- Maven
- Git
- Postgresql

### Project deployment

- Open Postgresql terminal and type commands 
```
CREATE USER client WITH PASSWORD '123';
ALTER USER client CREATEDB;
//login with client and 123 
CREATE DATABASE StackWork;
```
- Open terminal and download project by typing commands
```
git clone https://github.com/Oleg700/WorkStack.git
```
- Run Application
```
cd {path}\WorkStack
mvn package
cd {path}\WorkStack\target
java -jar org.work.stack-1.0-SNAPSHOT.jar
```