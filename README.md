Expense Tracker Backend (Spring Boot + DTO Handling + MySQL + Pagination + Sorting)
📌 Tech Stack Used:
Java 17
Spring Boot 3.4.3
Spring Data JPA
MySQL
DTO Handling
Pagination & Sorting
Postman for Testing
🎯 Project Structure:
css
Copy
Edit
expense-tracker-backend/
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.expense_tracker
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── model
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── ExpenseTrackerApplication.java
│   │   └── resources
│   │       ├── application.properties
│   ├── test
│   │   └── java
│   └── target
│
├── pom.xml
└── README.md
🎯 Features Implemented:
✅ Register User
✅ Add Budget
✅ Add Expense
✅ Filter Budgets by Category & Month
✅ Sort by Budget Limit & Expense Amount
✅ Pagination for Budget & Expense
✅ DTO Conversion
✅ Error Handling
✅ Data Validation

📍 APIs Tested on Postman:
🚀 1️⃣ User APIs
API	Endpoint	Method	JSON Body
Register User ✅	/user/register	POST	{ "email": "user@gmail.com" }
Get All Users ✅	/user/	GET	❌
Get User by ID ✅	/user/1	GET	❌
Update User ✅	/user/update/1	POST	{ "email": "updateduser@gmail.com" }
Delete User ✅	/user/1	DELETE	❌
🚀 2️⃣ Budget APIs
API	Endpoint	Method	JSON Body
Create Budget ✅	/budget/create	POST	{ "category": "Food", "month": "March", "budgetLimit": 5000, "userId": 1 }
Get All Budgets ✅	/budget/1	GET	❌
Filter Budget by Category ✅	/budget/filter/1/Food	GET	❌
Filter Budget by Month ✅	/budget/filter/1/March	GET	❌
Sort Budget ✅	/budget/sort/1?order=asc	GET	❌
Pagination ✅	/budget/page/1?page=0&size=2	GET	❌
Update Budget ✅	/budget/update/2	POST	{ "category": "Travel", "month": "March", "budgetLimit": 15000, "userId": 1 }
Delete Budget ✅	/budget/delete/2	DELETE	❌
🚀 3️⃣ Expense APIs
API	Endpoint	Method	JSON Body
Create Expense ✅	/expense/create	POST	{ "category": "Shopping", "amount": 5000, "userId": 1 }
Get All Expenses ✅	/expense/1	GET	❌
Filter Expense by Category ✅	/expense/filter/1/Shopping	GET	❌
Sort Expense ✅	/expense/sorted/1?order=desc	GET	❌
Pagination ✅	/expense/paged/1?page=0&size=2	GET	❌
Update Expense ✅	/expense/update/3	POST	{ "category": "Clothing", "amount": 8000, "userId": 1 }
Delete Expense ✅	/expense/delete/3	DELETE	❌
✅ Database Schema:
User Table:
Field	Type
id	Long (Primary Key)
email	String
password	String
Budget Table:
Field	Type
id	Long
category	String
month	String
budgetLimit	Double
user_id (FK)	Long
Expense Table:
Field	Type
id	Long
category	String
amount	Double
localDate	LocalDate
user_id (FK)	Long
✅ DTOs Used for Clean Code Handling:
UserDTO
BudgetDTO
ExpenseDTO
📍 Run the Project:
bash
Copy
Edit
> mvn clean install
> Run ExpenseTrackerApplication.java
📍 Postman Collection to Test All APIs:
🔗 Download Postman Collection

🚀 Next Goals for This Project:
✅ Implement JWT Authentication
✅ Add Swagger API Documentation
✅ Deploy on AWS
