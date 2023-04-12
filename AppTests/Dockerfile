FROM alpine:latest

# Install Git
RUN apk add --no-cache git

# Install OpenJDK 15
RUN apk add --no-cache openjdk15

# Install Maven
RUN apk add --no-cache maven

RUN apk add --no-cache curl

WORKDIR /data

CMD ["/bin/sh"]
