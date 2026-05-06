Comment for JWT token



Add the Security dependency in pom.xml
As soon as you add Spring security will give the Basic default username and password 
to customize it we need to config the SecurityFilter chain. Create bean in config class annote with @EnableWebSecurity and 
make signup and login initial page no authentication . And for the other resources authentication is required 
By default SpringSecurity Authentication is username and Password 
But Here we are trying to authenticate using jwt token
for that include jwt imp and jwt-api dependency in the classpath
ANd then we are configuring to generate token in the login process using spring security .
in the configuration we are adding .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).
That is adding jwtFilter before usernameAndPasword Authentication
then using USerdetails loadUserByUsername() verifying username and password .if the username and password matches then generating token for that username using
claims and Keys 
Then returning the token in the login request 
then reusing the token as Beare token (Authorization) for the next request 
then validating the token if the token is valid getting acces to the resource.

In the config class create job,masterstep(workerstepstep,partiotion,taskexecutor,),workerstep(jobrepository,transactionmananger,reader,processor,writer).

need to create bean or class with spring annotation 
create bean for partiition and taskExecutor 

when you make feild final it will ask for constructor injection because final field should get value during object creation , feild injection is
not valid in that case 

Used JPQL query and used entityManager to create query . CreateQuery ()
If its native query teh CreateNAtiveQuery()

in the jpql query we use java class entity in our query for table and feild nme for column .

