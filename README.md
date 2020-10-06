# cloud-parent
 demo for springcloud
 creare three modules: eurekaserver, cloud-project, cloud-resource
 all the modules are registered in eureka server. 
 Project Module can get data from database
 Resource Module can use feign to call Project's method and alos get project data
 TEST URL:
 http://localhost:8761/							check eureka server
 http://hayashis-mbp.lan:8762/project   		call get all method to get data from DB
 http://hayashis-mbp.lan:8080/resource/project  call project's method
