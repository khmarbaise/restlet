State:
-----

Currently can be called like:

curl http://localhost:9080/mod-war-0.1.0-SNAPSHOT/services/first?media=txt
curl http://localhost:9080/mod-war-0.1.0-SNAPSHOT/services/first?media=xml

curl -H "Accept: text/plain" http://localhost:9080/mod-war-0.1.0-SNAPSHOT/services/first
curl -H "Accept: text/xml" http://localhost:9080/mod-war-0.1.0-SNAPSHOT/services/first

curl -d "TestValue" -X PUT http://localhost:9080/mod-war-0.1.0-SNAPSHOT/services/stage/dev-1

curl http://localhost:9080/mod-war-0.1.0-SNAPSHOT/system

Ideas
-----

 URL:9080/services/dev-01/current
 
 GET => xyz-abc.ear v:1.23.4-135

 POST =>
    Change current to previous 
    set new version.
    
    Data: xyz-abc-1.23.4-2014050612.134567-135.ear
 
 URL:9080/services/dev-01/deploy/build

 GET => 3260
 PUT => 2345 (set Jenkins Build number)


 URL:9080/services/dev-01/current/UMG-1
 URL:9080/services/dev-01/current/UMG-2
 URL:9080/services/dev-01/current/UMG-3
 


GET Requests:

 URL:9080/services/ENV/

 ENV => place holder for environment

   like dev-01
 
 URL:9080/services/dev-01/deploy/version

 1.23.4-135
 
 URL:9080/services/dev-01/deployed/build

 3567
 
 URL:9080/services/dev-01/deployed/database

 devt1a7b


 URL:9080/services/dev-01/description

 Testumgebung 1


 URL:9080/services/dev-01/status

 deploying
 deployed
 restarting


PUT Request:

 URL:9080/services/ENV/

 URL:9080/services/dev-01/deploy/version

 URL:9080/services/dev-01/deploy/build

 3567


 Set Description 
 URL:9080/services/dev-01/description

