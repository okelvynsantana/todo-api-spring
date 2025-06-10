# Todo API

A robust RESTful API for managing todo items, built with Spring Boot and Kotlin.

## 🚀 Technologies

- Kotlin 1.9.25
- Spring Boot 3.5.0
- Spring Data JPA
- Spring Web
- Oracle Database (with H2 for development)
- OpenAPI/Swagger UI
- JUnit 5 for testing
- MockK for mocking in tests

## 📋 Prerequisites

- JDK 17 or higher
- Gradle
- Oracle Database (for production)
- H2 Database (for development)

## 🛠️ Getting Started

1. Clone the repository:
```bash
git clone https://github.com/okelvynsantana/todo-api-spring.git
cd todo-api-spring
```

2. Build the project:
```bash
./gradlew build
```

3. Run the application:
```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

Once the application is running, you can access the API documentation at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI Specification: `http://localhost:8080/v3/api-docs`

## 🧪 Testing

Run the test suite with:
```bash
./gradlew test
```

## 🏗️ Project Structure

```
todoapi/
├── src/
│   ├── main/
│   │   ├── kotlin/        # Kotlin source files
│   │   └── resources/     # Application properties and resources
│   └── test/
│       └── kotlin/        # Test source files
├── build.gradle.kts       # Gradle build configuration
└── settings.gradle.kts    # Gradle settings
```

## 🔧 Configuration

The application can be configured through `application.properties` or `application.yml`. Key configurations include:

- Database connection settings
- Server port
- Logging levels

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📫 Contact

Kelvyn Santana - santanakelvyn@gmail.com

Project Link: [https://github.com/okelvynsantana/todo-api-spring](https://github.com/okelvynsantana/todo-api-spring)
