![](https://github.com/Lylio/image-repo/blob/master/logos/quarkus.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/graphql.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/postgres.png?raw=true)

# Quarkus CRUD with GraphQL

### Description
A CRUD app with Quarkus, Reactive Hibernate, Panache and GraphQL using a PostgreSQL database.


### Tech Stack
- Quarkus (JDK 11)
- GraphQL
- PostgreSQL

### Setup & Launch

#### Launch PostgreSQL Database
```
docker run -d --rm --name my_reative_db -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -e POSTGRES_DB=my_db -p 5432:5432 postgres:10.5
```

#### Launch Quarkus Application
`./mvnw compile quarkus:dev`

#### Acknowledgments
- Based on the Medium article ['Creating a CRUD app with Quarkus, Reactive Hibernate, Panache and GraphQL using a PostgreSQL database'](https://medium.com/geekculture/creating-a-crud-app-with-quarkus-reactive-hibernate-panache-and-graphql-using-a-postgresql-216ecd75ee52)

- [Article's GitHub Repo](https://github.com/dvddhln/quarkus-reactive-hibernate-graphql-crud)