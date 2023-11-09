![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black) 


# Web Scrapper

Web scraping app based on *Spring boot*

## Directory Structure
```bash
├── src
  ├── config
  ├── controller
  ├── domain
  ├── repository
  ├── service
├── resources
```

#### src :satellite:
This directory the source code for the app.

#### config :satellite:
This directory contains config files for the web app, eg: security, audit fields, etc.

### controller :satellite:
Contains controller classes.

### domain :satellite:
Contains the domain classes and dtos.

### repository :satellite:
Contains the repository layer for db access.

### service :satellite:
Contains the service layer to perform different operations.

### resources :satellite:
Contains various config file.

### Requirements :white_check_mark:

* jdk 17
* mysql db

To run the application you must have a mysql instance up and running, database credentials can be changed under the /resources/application.properties file 

### Running  the application :star:


Run the following command to start the app.

```
./mvnw spring-boot:run
```




### Accessing web app :star:

*   http://localhost:8080/