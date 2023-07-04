FROM maven:3-amazoncorretto-17 as maven_build
WORKDIR /app
COPY pom.xml .
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target/
COPY src ./src
RUN mvn clean package -Dmaven.test.skip
ENTRYPOINT ["java", "-jar", "target/hashed_it.jar"]
