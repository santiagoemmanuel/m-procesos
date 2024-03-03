FROM maven:3.8.5-openjdk-17

run export GIT_SSL_NO_VERIFY=true
#run apk add --no-cache git curl bash coreutils
run git config --global user.email "gsantiago.dev@gmail.com"
run git config --global user.name  "gsantiago"

WORKDIR /usr/local/
run git clone https://github.com/santiagoemmanuel/m-procesos.git

WORKDIR /usr/local/m-procesos/
run mvn verify
WORKDIR /usr/local/m-procesos/target/
EXPOSE 8091
CMD ["java","-Doracle.jdbc.timezoneAsRegion=false","-jar","med.jar"]
