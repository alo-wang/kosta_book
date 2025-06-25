#1단계 : Maven을 사용하여스프링부트프로젝트빌드
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
#2단계 : 빌드된 JAR 파일을 실행할 OPENJDK 이미지를 이용하여 Docker 이미지생성
FROM openjdk:17-jdk
VOLUME /uploadtest
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT [ "java" ]
CMD ["-jar", "app.jar"]