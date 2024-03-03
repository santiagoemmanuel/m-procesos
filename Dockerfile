#FROM azul/zulu-openjdk:17.0.0-17.28.13-jre
#COPY target/med.jar /usr/local/med/
#WORKDIR /usr/local/med/
#run echo ${DATABASE_URL}
#EXPOSE 8091
#CMD ["java","-Doracle.jdbc.timezoneAsRegion=false","-jar","med.jar"]


FROM maven:3.8.5-openjdk-17

run export GIT_SSL_NO_VERIFY=true
run apk add --no-cache git curl bash coreutils
run git config --global user.email "gssantiago.dev@gmail.com"
run git config --global user.name  "gsantiago"
run git remote remove origin


COPY . /usr/local/med/

WORKDIR /usr/local/med/
run mvn verify
WORKDIR /usr/local/med/target/
EXPOSE 8091

CMD ["java","-Doracle.jdbc.timezoneAsRegion=false","-jar","med.jar"]



#RUN apt update