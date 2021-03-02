FROM openjdk:11
LABEL version="1.0"
LABEL description="Image of Desafio Técnico"
LABEL author="Marcio Aparecido Sitoni" 
EXPOSE 8080
VOLUME /tmp
ADD ./target/registration-people-0.0.1-SNAPSHOT.jar registration-people.jar
ENTRYPOINT ["java", "-jar", "/registration-people.jar"]