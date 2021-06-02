# controllair

## Run:

### ControallAir Docker:
1. Start docker
2. `cd controllair`
3. `docker-compose up -d`

### Maven build
1. `cd controllair`
2. `mvn clean install`

### Run spring-boot app:
1. `cd controllair`
2. `mvn spring-boot:run`



### React Docker:
1. Start docker
2. `cd react`
3. `docker build -t react-image .`
4. `docker run -d -p 3001:3000 --name react-app react-image`
5. Open http://localhost:3001/

