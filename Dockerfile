FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=isink2_bot
ENV BOT_TOKEN=5240774034:AAFTRi3WqpeF9vSKRqch0fhBV4W5IcY2RMk
ENV BOT_DB_USERNAME=isink_db_user
ENV BOT_DB_PASSWORD=isink_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]