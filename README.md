[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/kw4G8Vtl)
# PBLJ-Assignment-3
# Assignment 3 - Exception Handling

## 📖 Chapter 3: Exception Handling

### 🔹 Topics Covered:
- Introduction to Exceptions
- Difference between Error and Exception
- Try, Catch, and Throw
- Difference between Throw and Throws
- Types of Exceptions & Exception Handling

## 📝 Problem Statements

### ✅ Problem 1: Square Root Calculation (Easy Level)
**Description:**  
Write a Java program to calculate the **square root** of a number.
- **Use try-catch** to handle invalid inputs (negative numbers or non-numeric values).

**Example Input:**
```
Enter a number: -16
```
**Example Output:**
```
Error: Cannot calculate the square root of a negative number.
```

---

### ✅ Problem 2: ATM Withdrawal System (Medium Level)
**Description:**  
Simulate an **ATM withdrawal system**:
- Ask the user to **enter PIN**
- Allow withdrawal if the **PIN is correct and balance is sufficient**
- Throw exceptions for **invalid PIN or insufficient balance**
- Ensure the system **always displays the remaining balance** even after an exception.

**Example Input:**
```
Enter PIN: 1234
Withdraw Amount: 5000
```
**Example Output:**
```
Error: Insufficient balance. Current Balance: 3000
```

---
### ✅ Problem 3: University Enrollment System (Hard Level)
**Description:**  
Create a **university enrollment system** with exception handling:
- Allow students to enroll in courses.
- Throw **CourseFullException** if the course is full.
- Throw **PrerequisiteNotMetException** if prerequisites are not completed.

**Example Input:**
```
Enroll in Course: Advanced Java
Prerequisite: Core Java
Status: Prerequisite not completed
```
**Example Output:**
```
Error: PrerequisiteNotMetException - Complete Core Java before enrolling in Advanced Java.
```


## 🛠 Requirements:
- Java 8 or above
- IDE (Eclipse/IntelliJ/VS Code)

## 📂 Folder Structure:
```
Assignment-3/
│── src/
│   ├── SquareRootCalculator.java
│   ├── ATMWithdrawal.java
│── README.md
│── input_output_examples.txt
