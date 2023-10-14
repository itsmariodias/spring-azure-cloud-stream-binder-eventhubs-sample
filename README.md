# spring-azure-cloud-stream-binder-eventhubs-sample
Simple SpringBoot application demonstrating Spring Cloud Azure EventHubs integration.

This application is used to demonstrate Azure Event Hubs integration with Spring Cloud Stream as part of my Medium article series (linked below).  
* [Publish and Consume Events with Spring Cloud Stream and Azure Event Hubs](https://itsmariodias.medium.com/publish-and-consume-events-with-spring-cloud-stream-and-azure-event-hubs-f190a230ff20)  
* [Configure Multiple Binders with Spring Cloud Stream and Azure Event Hubs](https://itsmariodias.medium.com/configure-multiple-binders-with-spring-cloud-stream-and-azure-event-hubs-fd41e19dfe47)  
* [Authentication in Spring Cloud Azure](https://itsmariodias.medium.com/authentication-in-spring-cloud-azure-81f82bc240a8)  

### Spring Profiles
The repo contains the code for all 4 implementations demonstrated in the articles linked above. To switch between the implementations, simply change the environment variable SPRING_PROFILES_ACTIVE before executing the application to one of the following:
* single-binder
* multi-binder
* multi-binder-mi-auth
* multi-binder-sp-auth
