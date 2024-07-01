<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quiz Microservice API Documentation</title>
<style>
  body {
    font-family: Arial, sans-serif;
    line-height: 1.6;
    padding: 20px;
    background-color: #f0f0f0;
  }
  h1, h2, h3 {
    color: #333;
  }
  pre {
    background-color: #f9f9f9;
    padding: 10px;
    border: 1px solid #ccc;
    overflow-x: auto;
  }
  code {
    font-family: Consolas, Monaco, 'Andale Mono', 'Ubuntu Mono', monospace;
    font-size: 0.95em;
  }
  .container {
    max-width: 800px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border: 1px solid #ccc;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    border-radius: 5px;
  }
</style>
</head>
<body>

<div class="container">

  <h1>Quiz Microservice API Documentation</h1>

  <h2>Create Quiz</h2>

  <h3>HTTP Request</h3>

  <pre><code>POST http://localhost:8081/quiz/create
  Content-Type: application/json

  {
    "title": "Python Quiz"
  }
  </code></pre>

  <h2>Get Quiz by ID</h2>

  <h3>HTTP Request</h3>

  <pre><code>GET http://localhost:8081/quiz/{id}</code></pre>

  <h3>Example Response</h3>

  <pre><code>{
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
  </code></pre>

  <h2>Setup</h2>

  <pre><code>Clone the repository:

  ```bash
  git clone https://github.com/your-username/quiz-microservice.git
  cd quiz-microservice
Run the services:

Start the Quiz Service on port 8081.
Start the Question Service on port 8082.
Start the API Gateway on port 8083.
Ensure that the Eureka Server is running for service discovery.
Configure the environment as per your requirements.
</code></pre>
  <h2>Usage</h2>
  <pre><code>Create a quiz:

  ```bash
  curl -X POST http://localhost:8081/quiz/create -H "Content-Type: application/json" -d '{"title": "Python Quiz"}'
  ```

  Get all quizzes:

  ```bash
  curl http://localhost:8081/quiz/
  ```

  Get questions by quiz ID:

  ```bash
  curl http://localhost:8082/question/quizId/2
  ```

  Access through API Gateway:

  ```bash
  curl http://localhost:8083/quiz/
  ```
  </code></pre>
  <h2>Contributing</h2>
  <p>Contributions are welcome! Please fork the repository and submit a pull request with your changes.</p>
  <h2>License</h2>
  <p>This project is licensed under the MIT License. See the LICENSE file for details.</p>
</div>
</body>
</html>
```