FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/ezdg_sample-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ezdg_sample.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ezdg_sample.jar"]
