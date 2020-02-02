FROM openjdk:8

COPY backend /backend
WORKDIR /backend
RUN ./mvnw package

EXPOSE 8080

CMD java -jar ./application/target/application-0.0.1-SNAPSHOT.jar
