# FinTrackPro
FinTrack Pro is a full-stack Personal Finance Management Application built using Java, Spring Boot, MySQL, React, and Next.js. It helps users track income, expenses, budgets, and savings goals with real-time analytics
🚀 Features

✅ User-based financial tracking
✅ Add & manage Income and Expenses
✅ Category-based transaction system
✅ Monthly Budget Management
✅ Savings Goals Tracking
✅ Dashboard with real-time analytics
✅ Interactive Charts (Bar & Pie)
✅ Clean & responsive UI

🛠 Tech Stack
Backend:

Java

Spring Boot

Spring Data JPA

REST APIs

MySQL

Frontend:

React.js

Next.js

Axios

Chart.js

Plain CSS

📁 Project Structure
fintrack-pro/
├── fintrackpro-backend/
│   ├── controller/
│   ├── model/
│   ├── repository/
│   └── resources/
│
├── fintrackpro-frontend/
│   ├── pages/
│   ├── components/
│   └── styles.css
⚙️ How to Run the Project
Backend Setup

Create MySQL database:

CREATE DATABASE fintrackpro;


Update application.properties:

spring.datasource.username=username
spring.datasource.password=PASSWORD


Run:

mvn spring-boot:run


Backend runs on:

http://localhost:8080

Frontend Setup
cd fintrackpro-frontend
npm install
npm run dev


Frontend runs on:

http://localhost:3000

📊 Dashboard Features

Total Income Summary

Total Expense Summary

Net Savings Calculation

Bar Chart: Income vs Expense

Pie Chart: Category-wise Expenses

🧪 API Example Endpoints
GET  /api/users
POST /api/transactions
GET  /api/transactions/user/{id}
GET  /api/analytics/summary/{id}

🧩 Future Enhancements

JWT Authentication

User Login & Roles

Cloud Deployment (AWS/Azure)

AI-based spending suggestions

Recurring payments tracking

Export reports as PDF/Excel

👨‍💻 Developer Info

Name: Valmiki Yogesh
GitHub: https://github.com/valmikiyogesh11

LinkedIn: https://www.linkedin.com/in/valmiki-yogesh-746113227
