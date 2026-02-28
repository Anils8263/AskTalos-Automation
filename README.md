# AskTalos Selenium Automation Framework

## Overview
This project is a **production-grade Selenium + TestNG automation framework** for the AskTalos CRM application.  
It automates core modules of the application, including:

1. Homepage Validation** – `asktalos.com`  
2. User Signup Flow – `ai.asktalos.com/signup`  
3. Login Flow – `ai.asktalos.com`  
4. CRM Lead Creation – `CRM → Leads → Actions → Create Lead`  

The framework follows **Page Object Model (POM)** design pattern, includes reusable utilities, robust assertions, and screenshot capture on test failure.

---

## Technology Stack
| Component | Technology |
|-----------|-----------|
| Programming Language | Java |
| Browser Automation | Selenium WebDriver |
| Test Framework | TestNG |
| Design Pattern | Page Object Model (POM) |
| Wait Strategy | Fluent/Explicit waits via custom `WaitUtils` |

---

## Prerequisites
- Java JDK 17+ installed and configured  
- Maven 3.8+ installed  
- Supported browsers: **Chrome, Firefox, Edge**  
- Git installed for version control  
- IDE: IntelliJ IDEA recommended  

---

## Project Setup

1. Clone the repository
```bash
git clone https://github.com/Anils8263/AskTalos-Automation.git
