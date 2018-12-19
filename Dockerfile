FROM maven:3
ADD . /web/
WORKDIR /web
RUN mvn clean package

FROM openjdk:8-jdk-alpine
COPY --from=0 /web/target/*.jar /web/
EXPOSE 80
WORKDIR /web
CMD java -jar *.jar  
