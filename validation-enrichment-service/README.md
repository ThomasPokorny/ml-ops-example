# spring-boot-template
SpringBoot template 

## Description
Very opinionated spring-boot template repository.

## Starting the server

Create postgres container:
```shell
docker compose up
```

In order to start from scratch:
```shell
docker compose up --force-recreate
```

## Swagger UI & Open API Documentation

The application uses [Springdoc](https://springdoc.org/) and its
bundled [Swagger UI](https://swagger.io/tools/swagger-ui/)
to document the API. Once you have started the backend, you can access the Swagger UI at
http://localhost:8080/swagger-ui/index.html.