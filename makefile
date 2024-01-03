.PHONY: list db package run packagerun

COMMANDS=db | package | run | packagerun

list:
	echo "${COMMANDS}"

db:
	docker run --name workout_regimen-server-psql -p 5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=password -e POSTGRES_DB=workout_regimen-database -d postgres

package:
	mvn package -DskipTests

run:
	java -jar -DSERVER_DB_URL=jdbc:postgresql://localhost:5432/workout_regimen-database -DSERVER_DB_USERNAME=root -DSERVER_DB_PASSWORD=password target/workout_regimen_api-0.0.1-SNAPSHOT.jar

packagerun: package run