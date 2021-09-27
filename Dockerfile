FROM tomcat:8.5.68-jdk8-adoptopenjdk-hotspot
LABEL maintainer="soumen"
EXPOSE 9000
ADD /target/ems.jar ems.jar 
ENTRYPOINT ["java", "-jar", "ems.jar"]