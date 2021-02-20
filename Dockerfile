FROM openjdk:11-jdk

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .

COPY src src

RUN ./mvnw clean install

ENTRYPOINT ["./mvnw","spring-boot:run"]

# docker-compose

#app-server:
#    build: .
#    ports:
#      - 8081:8080
#    restart: always
#    depends_on:
#      - db    
#    volumes: 
#     - ./:/app
