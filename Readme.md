server:
  port: 8081
  
spring:

  datasource:
  
    url: jdbc:mysql://localhost:3306/citizenDB
    
    username: root

    password: root 
    
    driver-class-name: com.mysql.cj.jdbc.Driver
    
  jpa:
  
    hibernate:
    
      ddl-auto: update
      
    show-sql: true
    
    database-platform: org.hibernate.dialect.MySQL8Dialect
