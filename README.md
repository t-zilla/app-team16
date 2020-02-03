# psi-twwo

## Non-functional requirements

### B1. Tworzenie/edycja dokumentów (program kształcenia, karty przedmiotów) tylko przez uprawnione osoby

* [Security config (authentication and authorization enabled)](https://github.com/pwr-twwo/app-team16/blob/master/backend/application/src/main/java/com/psi/config/SecurityConfig.java#L48)
* [Resource config (RBAC required to create CUD resource)](https://github.com/pwr-twwo/app-team16/blob/master/backend/application/src/main/java/com/psi/resource/SyllabusResource.java#L38)

### B2. Kontrola zmian (rejestracja daty, rodzaju zmiany i osoby, która ją wykonała) w planach/programach/kartach przedmiotów/planach powierzeń

* [Javers repository annotation](https://github.com/pwr-twwo/app-team16/blob/master/backend/universitydomain/src/main/java/com/psi/subjectcard/repository/SubjectCardRepository.java#L8)
* [Endpoint to fetch changes captured via Javers](https://github.com/pwr-twwo/app-team16/blob/master/backend/universitydomain/src/main/java/com/psi/subjectcard/service/SubjectCardService.java#L45)

### B3. Logowanie on-site

* [LDIF mock-up](https://github.com/pwr-twwo/app-team16/blob/master/backend/application/src/main/resources/localldapactivedirectory.ldif)

* [LDAP connection config](https://github.com/pwr-twwo/app-team16/blob/master/backend/application/src/main/resources/application.yml#L5)

* [Security config (LDAP enabled)](https://github.com/pwr-twwo/app-team16/blob/master/backend/application/src/main/java/com/psi/config/SecurityConfig.java#L62)

### WS1. Wygenerowane fragmenty kodu źródłowego z modeli (ewentualnie skrypty tworzące bazę w przypadku relacyjnego modelu danych)

* [Generated DDL](https://github.com/pwr-twwo/app-team16/blob/master/docs/psi.ddl)

## Database schema

* [Schema diagram](https://github.com/pwr-twwo/app-team16/blob/master/docs/db-schema.pdf)

## Backend

### Requirements

* Java 8
* MySQL database

### Quick start

```bash
cd backend
./mvnw package
java -jar ./application/target/application-0.0.1-SNAPSHOT.jar
```

### Default database

* schema: `psi`
* username: `root`
* password: `pass`

### Default LDAP Active Directory users

* Jan Abacki
  * username: `jan`
  * password: `secret`
  * role: `researcher`

* Lech Wojcik
  * username: `lech`
  * password: `secret`
  * role: `syllabus_author`

* Jozef Malinowski
  * username: `jozef`
  * password: `secret`
  * role: `program_committee`

* Marek Nowak
  * username: `marek`
  * password: `secret`
  * role: `administrator`

## Frontend

### Requirements

* NodeJS
* npm

### Quick start

```bash
npm install
npm run build  # or: npm run start
```

## Devops

### Requirements

* docker
* docker-compose
* minikube

### Quick start (local environment)

```bash
docker-compose up -d
```

Then open in browser <http://psi.localhost>

Endpoint `/api` will respond with 502 Bad Gateway until `mvnw package` finishes.
Check progress with: `docker-compose logs -f backend`

Status & logs:

```bash
docker-compose ps
docker-compose logs
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose exec nginx tail /var/log/nginx/psi.access.log
docker-compose exec nginx tail /var/log/nginx/psi.error.log
```

Shutdown:

```bash
docker-compose down
```

### Kubernetes

Start cluster:

```bash
minikube start --extra-config=apiserver.service-node-port-range=80-30000
```

Set up local registry:

```bash
kubectl create -f devops/prod/kubernetes/kube-registry.yaml
kubectl port-forward --namespace kube-system $(kubectl get po -n kube-system | grep kube-registry-v0 | \awk '{print $1;}') 5000:5000  # leave running in separate terminal
```

Build images and push to registry:

```bash
docker build -f devops/prod/docker/backend/Dockerfile -t team16-backend .
docker tag team16-backend localhost:5000/team16-backend
docker push localhost:5000/team16-backend

docker build -f devops/prod/docker/nginx/Dockerfile -t team16-nginx .
docker tag team16-nginx localhost:5000/team16-nginx
docker push localhost:5000/team16-nginx
```

Deploy the app:

```bash
kubectl delete daemonsets,replicasets,services,deployments,pods,rc,persistentvolumeclaims --all
kubectl apply -f devops/prod/kubernetes
minikube service nginx --url
```
