# airlines-ticketing
Airlines Flight Booking Ticketing Backend System


# Flight Booking API Application

Spring boot ile REST api Spring MVC, Spring Data JPA kullanılmıştır.

Swagger dökümanı incelenerek apilerin tanımlarına ve kullanılma payloadlarına ulaşılır http://server_url:8080/swagger-ui.html

Postman collection src/main/resource altındadır.

## Features




## Technologies used

1. Java (Programming Language)
2. Spring Boot (Application Platform)
3. Spring Data JPA (Data persistence)
4. MySQL (Database)



### Prerequisites
1. Java 8
2. Maven 3
3. Git
4. Docker
5. Docker Compose


#### Clone this repo
	

git clone https://github.com/esasmer-dou/airlines-ticketing.git



#### Start the app

 - application.properties mysql db connection info	
	
```
mvn spring-boot:run
```


#### Start the app with docker compose

 - build işleminden sonra target dizinine Dockerfile ve docker-compose.yml dosyaları kopyalanacaktır.
	
```
docker-compose up
```


#### Access the Home screen

Postman collection api lerin kullanımı için hazırlanmıştır. Collection içinde tanımlanmış olan base_url değişkeni ile server host adresi değiştirilir.

The application will be available at the URL: http://server_url:8080.

The application swager dökümantasyonu URL : http://server_url:8080/swagger-ui.html.  adresindedir.













