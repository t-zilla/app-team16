# psi-twwo

## Local

Run docker-compose to test frontend and backend together

```
docker-compose up --force-recreate -d
```

Then open in browser `http://psi.localhost`

Endpoint `/api` will respond with 502 Bad Gateway until `mvnw package` finishes.
Check progress with: `docker-compose logs -f backend`

Status & logs:
```
docker-compose ps
docker-compose logs
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose exec nginx tail /var/log/nginx/psi.access.log
docker-compose exec nginx tail /var/log/nginx/psi.error.log
```

Backend local configuration prerequisites: 
- Java 8
- Mysql Database
  - schema: psi
  - username: root
  - password: pass
  
LDAP Active Directory users: 
- Jan Abacki
  - username: jan
  - password: secret
  - role: researcher
- Lech Wojcik
  - username: lech
  - password: secret
  - role: syllabus_author  
- Jozef Malinowski
  - username: jozef
  - password: secret
  - role: program_committee    
- Marek Nowak
  - username: marek
  - password: secret
  - role: administrator
