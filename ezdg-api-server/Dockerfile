FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/ezdg-api-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ezdg-api-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ezdg-api-server.jar"]
