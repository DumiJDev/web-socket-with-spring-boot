FROM maven:3.8.5

WORKDIR /app

COPY . /app

RUN mvn install package && mkdir /jars && cp ./target/app.jar /jars/app.jar && rm -rf *

EXPOSE 8080

WORKDIR /jars

CMD ["java", "-jar", "./app.jar"]