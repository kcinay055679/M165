## Installation 
- Install docker (if missing)
- Run command `docker compose up --build`
- Start Spring application
- use [this](https://interstellar-sunset-680755.postman.co/workspace/SBB-Fuek294~df5e5420-db11-4c46-b763-6c431af08a8f/collection/16830288-5fbc47fe-d676-42f7-8603-9dd13009207c?action=share&creator=16830288) Link to get a full postman example 


## Commands
Open Container
```
docker exec -it mongodb bash
```

Open mongo cli:
```
mongosh -u admin -p password
```
Use correct database
```
use admin
```
Create document
```
db.person.insertOne({
    _id: 'a7e7b1bd-e49f-4d0b-8d28-87e25239c181',
    firstName: 'My',
    lastName: 'owner',
    employmentLvl: 69,
    isMale: true,
    _class: 'ch.gibb.m165.backend.models.Person'
  })
```

Find all documents
```
db.person.find()
```

Find document with id;
```
db.person.find({"_id":a7e7b1bd-e49f-4d0b-8d28-87e25239c181})
```