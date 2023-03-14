FROM ubuntu

RUN apt-get update && apt-get install -y \
openjdk-8-jdk \
curl \
unzip

RUN curl -G https://dlcdn.apache.org/axis/axis2/java/core/1.8.0/axis2-1.8.0-bin.zip -o /opt/axis2.zip

RUN unzip /opt/axis2.zip -d /opt

ENV AXIS2_HOME=/opt/axis2-1.8.0
ENV PATH=$PATH:$AXIS2_HOME/bin
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64

WORKDIR /ws

COPY calculadora.java .
COPY calculadora.class .
COPY services.xml META-INF/

RUN java2wsdl.sh -cn calculadora
RUN jar cvf calculadora.aar calculadora.* META-INF
COPY calculadora.aar /opt/axis-version/repository/services

EXPOSE 8080

CMD axis2server.sh





