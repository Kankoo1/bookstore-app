# bookstore-app
Full-stack Online Book Store built with Spring Boot (backend) and Angular (frontend).  Features user authentication, book catalog, shopping cart, checkout, and admin dashboard.  Frontend deployed on Netlify; backend deployed on Render. Docker setup included for local development.


![Alt text] (https://github.com/Kankoo1/bookstore-app/blob/develop/reference%20diagram.png)

<pre>
bookstore-backend/
│
├─ src/
│  ├─ main/
│  │   ├─ java/com/example/bookstore/
│  │   │   ├─ controller/          # REST controllers
│  │   │   │   ├─ BookController.java
│  │   │   │   └─ UserController.java
│  │   │   │
│  │   │   ├─ service/             # Business logic
│  │   │   │   ├─ BookService.java
│  │   │   │   └─ UserService.java
│  │   │   │
│  │   │   ├─ repository/          # JPA Repositories
│  │   │   │   ├─ BookRepository.java
│  │   │   │   └─ UserRepository.java
│  │   │   │
│  │   │   ├─ model/               # Entities / DTOs
│  │   │   │   ├─ Book.java
│  │   │   │   └─ User.java
│  │   │   │
│  │   │   ├─ config/              # Configuration classes
│  │   │   │   ├─ DatabaseConfig.java   # HikariCP / datasource config
│  │   │   │   └─ SecurityConfig.java   # Optional: Spring Security
│  │   │   │
│  │   │   ├─ exception/           # Custom exceptions
│  │   │   │   ├─ ResourceNotFoundException.java
│  │   │   │   └─ GlobalExceptionHandler.java
│  │   │   │
│  │   │   └─ BookstoreApplication.java  # Main Spring Boot class
│  │   │
│  │   └─ resources/
│  │       ├─ application.properties     # Database URL, ports, etc.
│  │       ├─ schema.sql                 # Optional initial schema
│  │       └─ data.sql                   # Optional initial data
│  │
│  └─ test/
│      └─ java/com/example/bookstore/
│          ├─ controller/
│          │   └─ BookControllerTest.java
│          └─ service/
│              └─ BookServiceTest.java
│
├─ pom.xml                          # Maven dependencies
├─ Dockerfile                       # Optional Docker container
├─ .gitignore
└─ README.md
</pre>
