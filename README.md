# HelpDesk System

A REST API developed with Java and Spring Boot for managing users and support tickets in a help desk environment.

## Technologies

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Swagger/OpenAPI
* Jakarta Validation

---

## Features

### Users

* Create users
* List all users
* Display one user

### Tickets

* Create tickets for users
* Change ticket status to `IN_PROGRESS`
* Close tickets
* Track creation and update timestamps

---

## API Endpoints

### Users

| Method | Endpoint      | Description      |
| ------ | ------------- | ---------------- |
| GET    | `/users`      | List all users   |
| GET    | `/users/{id}` | Display one user |
| POST   | `/users`      | Create a user    |

---

### Tickets

| Method | Endpoint                                            | Description                    |
| ------ | --------------------------------------------------- | ------------------------------ |
| POST   | `/users/{id}/tickets`                               | Create a ticket for a user     |
| PATCH  | `/users/{userId}/tickets/{ticketId}/call-attendant` | Change status to `IN_PROGRESS` |
| PATCH  | `/users/{userId}/tickets/{ticketId}/close`          | Close a ticket                 |

---

## Example Requests

### Create User

```http
POST /users
```

```json
{
  "name": "Rafaela",
  "email": "rafaela@email.com",
  "phoneNumber": "21999999999"
}
```

---

### Create Ticket

```http
POST /users/1/tickets
```

```json
{
  "title": "Login issue",
  "description": "Unable to access account"
}
```

---

## Running the Project

### Clone the repository

```bash
git clone https://github.com/rafaelabou1999/helpDesk-system.git
```

### Configure the database

Update the `application.properties` file with your PostgreSQL credentials.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/helpdesk
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

### Run the application

```bash
mvn spring-boot:run
```

---

## Swagger Documentation

After running the application, access:

```text
http://localhost:8080/swagger-ui.html
```

or

```text
http://localhost:8080/swagger-ui/index.html
```



