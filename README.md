# Expense Management API

A Spring Boot REST API for managing expenses — built as part of training assignments.

---

## 📌 Project Overview

This project implements an **Expense Management REST API** that supports:

- **Adding expenses**
- **Listing expenses within a date range**
- **Deleting expenses**
- **Validations**
- **DTO-based design**
- **Clean layered architecture (Controller → Service → Repository)**

This implementation follows Spring Boot 3.x and Java 17 standards.

---

## 🧱 Features

### 🛠️ Core Requirements
- **Entity:** `Expense(id, category, amount, expenseDate, description)`
- **REST APIs:**
  - Add an expense
  - List expenses by date range (`startDate`, `endDate`)
  - Delete expense by `id`
- **Validation:**
  - `amount > 0`
  - `expenseDate` not in the future
- **DTOs:**
  - `ExpenseCreateDTO` for input
  - `ExpenseViewDTO` for output
- **REST conventions:**
  - Plural resource naming (`/api/expenses`)
  - Query parameters for filtering

---

## 🧠 Architecture

