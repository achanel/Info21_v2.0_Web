FROM tomcat:8.0-jre8
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./war/InfoWeb-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]