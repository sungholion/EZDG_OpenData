FROM openjdk:17-jdk
LABEL maintainer="gkrhf@naver.com"
ARG JAR_FILE=build/libs/ezdg-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ezdg-auto.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ezdg-auto.jar"]