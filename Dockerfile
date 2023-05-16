FROM registry.access.redhat.com/ubi8/openjdk-11-runtime:latest
USER 1001

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY build/libs/websocket-demo-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080
ENTRYPOINT [ "java", "-jar","app.jar" ]
