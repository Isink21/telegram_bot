FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=isink2_bot
ENV BOT_TOKEN=5240774034:AAFTRi3WqpeF9vSKRqch0fhBV4W5IcY2RMk
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]