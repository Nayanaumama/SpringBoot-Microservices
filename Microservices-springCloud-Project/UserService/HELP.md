1.Here I used the circuit  Breaker 
Circuit Breaker pattern is from resilleince 4j .Which is used to indicate if any services requesting for is down for some reason
.
There are 3 status in this 
closed ,open and half-open

if the services are up and running status is closed 
if any service is down ,it tries maximum no of time which is configured and changes the status to open if the service is down for all the time . ANd then set the waiting threshold time in the 
open status .after the threshold time if the request comes and if the request is agin failed more than 50 % or any threashold percent we configure ,if the failure rate is more ,then it will be again open ,or if the success rate is more then the circuit is closed again .means its successful

here we can give the name to the circuit breaker @circuitBreaker(name=""userratehotel ") and also define the call back method 
in the same controller wher you call the API 

use the actuator to check the health status and to know how many request is passed or failed all the needed information

2. here Also added the Retry that means before calling the fallback method retrried for 3 timeas to reach the service and if its not
getting response in 3 times and then return the fall back method that service is down 

3. Here also used Rate Limiter .
rate Limiter is pattern which will help to increase the services security and performance.
we are limiting the no of hit to the server by using resilience 4j rate Limiter.
That way we are stopping our services from DOS attack (like thousands of request at a time ) and also preventing the system from crashing with access request than its capacity 
@RateLimiter(name="",fallBackMethod="")
then do the required configuration in application.properties