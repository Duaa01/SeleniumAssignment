
## Installation Instructions

### Prequisites

- JDK 21 or latest version.
- Maven.
- Browser Drivers

### Maven Dependencies

- Add below mentioned dependencies in `pom.xml` file.

- TestNg
```
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.8.0</version>
    </dependency>
```

- Selenium
```
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.14.1</version>
    </dependency>
```
- JSON 
```
    <dependency>
      <groupId>org.json</groupId>
      <artifactId>json</artifactId>
      <version>20231013</version>
    </dependency>
```
- Extent Report
```
    <dependency>
      <groupId>com.aventstack</groupId>
      <artifactId>extentreports</artifactId>
      <version>5.1.0</version>
    </dependency>
```

- Log4j2
```
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.21.1</version>
    </dependency>
```
### Run Tests

To run all tests, use below command 
```
mvn test
```









