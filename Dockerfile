FROM gradle:6.8.0-jdk11
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build
EXPOSE 8083
ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/jibberjabber-followers-0.0.1-SNAPSHOT.jar"]