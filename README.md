# Spring AI – SQL Advisor Example

This is a simple **Spring Boot 3 + Spring AI** application that integrates with **OpenAI**.  
It exposes a REST API where you can send natural language questions and receive SQL-related advice or query suggestions from the AI.

---

## 🚀 Features
- Uses **Spring AI** with **OpenAI** models
- Exposes a `/api/ai/sql` endpoint
- Accepts natural language questions
- Returns AI-generated **PostgreSQL advice / SQL queries**

--- 

## ⚙️ Configuration

Set your OpenAI API key in application.properties:
```
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.options.model=gpt-4o-mini
```

---

## 📡 API Usage
Endpoint
```
POST /api/ai/sql
```
```json
"Get all employees who joined after 2021"
```