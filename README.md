#spring-jpa-jersey

sample application
SpringBoot updated to 2.0.0.RELEASE
removed .yml configuration files
added application.properties

## Running the project

On root folder:

```
mvn clean compile
mvn package
mvn spring-boot:run
```

## Loading Data Service at

###Countries:
```
localhost:8090/
```
Body JSON Sample:
```
{  
   "countryList":[  
      {  
         "name":"CHINA"
      },
      {  
         "name":"South Korea"
      },
      {  
         "name":"Thailand"
      }
   ]
}
```

###Cities:
```
localhost:8090/rest/cities/load
```
Body JSON Sample:
```
{  
   "cityList":[  
      {  
         "name":"Macau",
         "country":{  
            "id":4,
            "name":"CHINA"
         }
      },
      {  
         "name":"Beijing",
         "country":{  
            "id":4,
            "name":"CHINA"
         }
      },
      {  
         "name":"Shanghai",
         "country":{  
            "id":4,
            "name":"CHINA"
         }
      }
   ]
}
```
## Database Privileges
in order to insert values and Auto Generate ID it's required to execute query:
```
GRANT ALL PRIVILEGES ON sample.* TO 'dbuser'@'localhost';


```
after executing src/main/resources/sql/db_init.mysql.sql

##Test Coverage

printscreen from sonar sonarqube added to root folder:
```
coverage.png
```
wich contains the test coverage percentage obtained with jacoco plugin.

###the test coverage can be obtained with the following maven command lines:
```
mvn clean test
mvn sonar:sonar
```