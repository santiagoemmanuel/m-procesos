#FROM azul/zulu-openjdk:17.0.0-17.28.13-jre
#COPY target/med.jar /usr/local/med/
#WORKDIR /usr/local/med/
#run echo ${DATABASE_URL}
#EXPOSE 8091
#CMD ["java","-Doracle.jdbc.timezoneAsRegion=false","-jar","med.jar"]


FROM maven:3.8.5-openjdk-17
COPY . /usr/local/med/

WORKDIR /usr/local/med/
run mvn verify
WORKDIR /usr/local/med/target/
EXPOSE 8091

CMD ["java","-Doracle.jdbc.timezoneAsRegion=false","-jar","med.jar"]



#RUN apt update