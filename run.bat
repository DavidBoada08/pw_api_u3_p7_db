CALL ./mvnw clean package "-Dquarkus.package.type=uber-jar" 
CALL java -jar target/pw_api_u3_p7_db-1.0.0-SNAPSHOT-runner.jar