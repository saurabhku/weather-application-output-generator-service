# weather-application-output-generator-service

Introduction
This microservices is responsible for:
1. Calling open weather map API
2. Return JSON weather data to caller using Kafka Events.

Prerequisites
1. To run this service ensure that kafka is running on port 9092
2. Create following topics on Kafka before proceeding
   a. weatherdatainputtopic
   b. weatherdataoutputtopic
   
Invocation
This service is invoked when a specific event containing list of cities is received.
By default, it is made to listen on weatherdatainputtopic.
can be started by in IDE as spring boot application or as a jar.

Complete system diagram:
