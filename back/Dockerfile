FROM java:openjdk-8u111-jdk
MAINTAINER Mahdi CHEKINI <me.chekini@gmail.com>
WORKDIR /opt
ADD build/libs/back-*.jar back.jar
ENV JAVA_OPTS "-Djava.security.egd=file:/dev/./urandom"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9080", "/opt/back.jar"]