Config server add the cloud config server dependency and ureka client to register this server in eurkea server
Whatever the general configuration which is same for all the clients can be kept in github application.yml or in dev or prod or any environment
application file and then which can be accessed by the config server 
just in appliaction file refer the github url where general configuration is kept 
and just to fetch this configuration for the every other services use the config client dependency and 
in the application file iport the details from the config server url 
