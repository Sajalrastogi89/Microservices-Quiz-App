# Quiz Microservice Application

This project is a Quiz Microservice Application designed to manage quizzes and their respective questions. The application uses a microservice architecture with several advanced features to ensure scalability, flexibility, and ease of management.

## Table of Contents

- [Architecture](#architecture)
- [Features](#features)
- [Services](#services)
  - [Quiz Service](#quiz-service)
  - [Question Service](#question-service)
  - [API Gateway](#api-gateway)
- [Endpoints](#endpoints)
  - [Quiz Service Endpoints](#quiz-service-endpoints)
  - [Question Service Endpoints](#question-service-endpoints)
  - [API Gateway Endpoints](#api-gateway-endpoints)
- [Setup](#setup)
- [Usage](#usage)
- [Architecture Diagram](#architecture-diagram)
- [Contributing](#contributing)
- [License](#license)

## Architecture

<div style="display: flex; justify-content: space-around;">
  <img src="/img/Screenshot_2024-07-01-18-43-11-843_com.google.android.youtube.jpg" alt="Architecture 1" style="width: 45%;">
  <img src="/img/Screenshot_2024-07-01-18-43-54-581_com.google.android.youtube.jpg" alt="Architecture 2" style="width: 45%;">
</div>


The application is composed of three main services:

1. **Quiz Service**: Manages quizzes.
2. **Question Service**: Handles questions associated with quizzes.
3. **API Gateway**: Provides a unified interface for clients and handles request routing.

### Features

- **Load Balancer**: Ensures even distribution of incoming requests across multiple service instances to improve performance and reliability.
- **Service Registry (Eureka Server)**: Manages the registration and discovery of services, allowing for dynamic scaling and better service management.
- **API Gateway**: Acts as a single entry point for all services, managing requests and providing a security layer.
- **Spring Cloud**: Utilizes Spring Cloud features for seamless integration of microservices, enabling easy configuration, monitoring, and management.
- **Inter-Service Communication (Feign Client)**: Simplifies the inter-service communication, making it easier to call other services using HTTP.
- **Eureka Client**: Registers services with the Eureka Server for discovery by other services.
- **Eureka Server**: Hosts the service registry, enabling services to find each other.

## Services

### Quiz Service

The Quiz Service is responsible for creating, retrieving, and managing quizzes. It runs on port 8081.

### Endpoints

#### Quiz Service Endpoints

- **Create Quiz**

```http
POST http://localhost:8081/quiz/create
Content-Type: application/json

{
  "title": "Python Quiz"
}
```

- **Get Quiz by ID**

```http
GET http://localhost:8081/quiz/{id}
```

Response Example:

```json
{
  "id": 2,
  "title": "Python Quiz",
  "questionList": [
    {
      "questionId": 1,
      "question": "Python is dynamically typed or statically typed",
      "quizId": 2
    },
    {
      "questionId": 2,
      "question": "Python is dynamically typed or statically typed",
      "quizId": 2
    },
    {
      "questionId": 3,
      "question": "Python is dynamically typed or statically typed",
      "quizId": 2
    },
    {
      "questionId": 4,
      "question": "Python is dynamically typed or statically typed",
      "quizId": 2
    }
  ]
}
```

- **Get All Quizzes**

```http
GET http://localhost:8081/quiz/
```

Response Example:

```json
[
  {
    "id": 1,
    "title": "Java Quiz",
    "questionList": [
      {
        "questionId": 1,
        "question": "What is Java",
        "quizId": 1
      },
      {
        "questionId": 2,
        "question": "What is Java Networking",
        "quizId": 1
      }
    ]
  },
  {
    "id": 2,
    "title": "Python Quiz",
    "questionList": [
      {
        "questionId": 3,
        "question": "What is Python",
        "quizId": 2
      },
      {
        "questionId": 4,
        "question": "Python is dynamically typed or statically typed",
        "quizId": 2
      },
      {
        "questionId": 5,
        "question": "Python is dynamically typed or statically typed",
        "quizId": 2
      }
    ]
  }
]
```

### Question Service

The Question Service manages questions associated with quizzes. It runs on port 8082.

### Endpoints

#### Question Service Endpoints

- **Create Question**

```http
POST http://localhost:8082/question
Content-Type: application/json

{
  "questionId": 6,
  "question": "Python is dynamically typed or statically typed",
  "quizId": 1
}
```

- **Get All Questions**

```http
GET http://localhost:8082/question
```

Response Example:

```json
[
  {
    "questionId": 1,
    "question": "Python is dynamically typed or statically typed",
    "quizId": 2
  },
  {
    "questionId": 2,
    "question": "Python is dynamically typed or statically typed",
    "quizId": 2
  },
  {
    "questionId": 3,
    "question": "Python is dynamically typed or statically typed",
    "quizId": 2
  },
  {
    "questionId": 4,
    "question": "Python is dynamically typed or statically typed",
    "quizId": 2
  }
]
```

- **Get Questions by Quiz ID**

```http
GET http://localhost:8082/question/quizId/2
```

Response Example:

```json
[
  {
    "questionId": 3,
    "question": "What is Python",
    "quizId": 2
  },
  {
    "questionId": 4,
    "question": "Python is dynamically typed or statically typed",
    "quizId": 2
  },
  {
    "questionId": 5,
    "question": "Python is dynamically typed or statically typed",
    "quizId": 2
  }
]
```

### API Gateway

The API Gateway serves as a single entry point to the microservices.

### Endpoints

#### API Gateway Endpoints

- **Test Controller**

```http
GET http://localhost:8083/quiz-test
```

Response Example:

```json
[
  {
    "id": 1,
    "title": "Java Quiz",
    "questionList": [
      {
        "questionId": 1,
        "question": "What is Java",
        "quizId": 1
      },
      {
        "questionId": 2,
        "question": "What is Java Networking",
        "quizId": 1
      }
    ]
  },
  {
    "id": 2,
    "title": "Python Quiz",
    "questionList": [
      {
        "questionId": 3,
        "question": "What is Python",
        "quizId": 2
      },
      {
        "questionId": 4,
        "question": "Python is dynamically typed or statically typed",
        "quizId": 2
      },
      {
        "questionId": 5,
        "question": "Python is dynamically typed or statically typed",
        "quizId": 2
      }
    ]
  }
]
```

## Setup

### Clone the repository:

```bash
git clone https://github.com/your-username/quiz-microservice.git
cd quiz-microservice
```

### Run the services:

1. Start the Quiz Service on port 8081.
2. Start the Question Service on port 8082.
3. Start the API Gateway on port 8083.
4. Ensure that the Eureka Server is running for service discovery.
5. Configure the environment as per your requirements.

## Usage

### Create a quiz:

```bash
curl -X POST http://localhost:8081/quiz/create -H "Content-Type: application/json" -d '{"title": "Python Quiz"}'
```

### Get all quizzes:

```bash
curl http://localhost:8081/quiz/
```

### Get questions by quiz ID:

```bash
curl http://localhost:8082/question/quizId/2
```

### Access through API Gateway:

```bash
curl http://localhost:8083/quiz/
```