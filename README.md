# **Expense Tracker Backend (Spring Boot + DTO + MySQL + JWT + Pagination + Sorting)** 🚀  

---

## 📌 **Tech Stack Used:**
- ✅ Java 17  
- ✅ Spring Boot 3.4.3  
- ✅ Spring Security + JWT  
- ✅ Spring Data JPA  
- ✅ MySQL  
- ✅ DTO Handling  
- ✅ Pagination & Sorting  
- ✅ Postman for API Testing  

---

## 🎯 **Project Overview:**
A **complete Expense Tracker Backend API** that allows users to **register, login, manage expenses and budgets securely**, with **JWT Authentication and Authorization**.  

---

## 🎯 **Folder Structure:**

```yaml
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
│   │   │       └── security
│   │   └── resources
│   │       ├── application.properties
│   ├── test
│   │   └── java
│   └── target
│
├── pom.xml
└── README.md


---

## ✅ **Features Implemented:**
- ✅ User Registration & Login with JWT  
- ✅ Add, Update & Delete Budget  
- ✅ Add, Update & Delete Expense  
- ✅ Filter, Sort & Pagination for Budget & Expense  
- ✅ Secure APIs with JWT Token  
- ✅ DTO Handling  
- ✅ MySQL Database Integration  

---

## 🎯 **APIs Implemented:**

---

## **1️⃣ User APIs**

| API                  | Endpoint                  | Method | JSON Body |
|----------------|--------------------|--------------------|--------------------|
| Register User ✅ | `/auth/register` | POST | `{ "email": "user@gmail.com", "password": "1234" }` |
| Login User ✅ | `/auth/login` | POST | `{ "email": "user@gmail.com", "password": "1234" }` |
| Get All Users ✅ | `/user/` | GET | 🔒 |
| Get User by ID ✅ | `/user/1` | GET | 🔒 |
| Update User ✅ | `/user/update/1` | POST | 🔒 |
| Delete User ✅ | `/user/1` | DELETE | 🔒 |

---

## **2️⃣ Budget APIs**

| API                  | Endpoint                  | Method | JSON Body |
|----------------|--------------------|--------------------|--------------------|
| Create Budget ✅ | `/budget/create` | POST | `{ "category": "Food", "month": "March", "budgetLimit": 5000, "userId": 1 }` |
| Get All Budgets ✅ | `/budget/1` | GET | 🔒 |
| Filter by Category ✅ | `/budget/filter/1/Food` | GET | 🔒 |
| Filter by Month ✅ | `/budget/filter/1/March` | GET | 🔒 |
| Sort Budget ✅ | `/budget/sort/1?order=asc` | GET | 🔒 |
| Pagination ✅ | `/budget/page/1?page=0&size=2` | GET | 🔒 |
| Update Budget ✅ | `/budget/update/2` | POST | 🔒 |
| Delete Budget ✅ | `/budget/delete/2` | DELETE | 🔒 |

---

## **3️⃣ Expense APIs**

| API                  | Endpoint                  | Method | JSON Body |
|----------------|--------------------|--------------------|--------------------|
| Create Expense ✅ | `/expense/create` | POST | `{ "category": "Shopping", "amount": 2000, "userId": 1 }` |
| Get All Expenses ✅ | `/expense/1` | GET | 🔒 |
| Filter by Category ✅ | `/expense/filter/1/Shopping` | GET | 🔒 |
| Sort Expense ✅ | `/expense/sorted/1?order=desc` | GET | 🔒 |
| Pagination ✅ | `/expense/paged/1?page=0&size=2` | GET | 🔒 |
| Update Expense ✅ | `/expense/update/3` | POST | 🔒 |
| Delete Expense ✅ | `/expense/delete/3` | DELETE | 🔒 |

---

## ✅ **Database Schema:**
### **User Table:**
| Field            | Type         |
|----------------|--------------------|
| id | Long (Primary Key) |
| email | String |
| password | String |

---

### **Budget Table:**
| Field            | Type         |
|----------------|--------------------|
| id | Long |
| category | String |
| month | String |
| budgetLimit | Double |
| user_id (FK) | Long |

---

### **Expense Table:**
| Field            | Type         |
|----------------|--------------------|
| id | Long |
| category | String |
| amount | Double |
| localDate | LocalDate |
| user_id (FK) | Long |

---

## ✅ **DTOs for Clean Code Handling:**
- `UserDTO`  
- `BudgetDTO`  
- `ExpenseDTO`  
- `AuthRequestDTO`  

---

## ✅ **Security Flow (JWT Authentication)**
1️⃣ Register User  
2️⃣ Login to get **JWT Token**  
3️⃣ Send **JWT Token** in Header as `Bearer <token>`  
4️⃣ Access Secure APIs  

---

## ✅ **Error Handling Implemented:**
| Error Type          | Status Code | Message |
|----------------|--------------------|--------------------|
| User Not Found | `404` | User does not exist |
| Budget Not Found | `404` | Budget does not exist |
| Expense Not Found | `404` | Expense does not exist |
| Invalid Budget Limit | `400` | Budget Limit cannot be negative |
| Invalid Sort Order | `400` | Invalid sort order |
