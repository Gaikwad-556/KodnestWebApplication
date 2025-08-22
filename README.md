KodeNest Application – Test Automation Suite
📌 Project Overview
The CodeNest Application Test Suite is an automated testing project built using Java and TestNG. It validates the key functionalities of the CodeNest application, including:

- User Registration
- User Login
- Password Recovery

This project follows the Page Object Model (POM) for test automation and uses a Data-Driven Testing approach by fetching test data directly from a database.

📂 Project Structure
KodeNest-Application/
│
├── src/
│   ├── registration/        # Contains Registration test scripts & page objects
│   ├── login/               # Contains Login test scripts & page objects
│   ├── passwordrecovery/    # Contains Password Recovery test scripts & page objects
│
└── README.md                # Project documentation (this file)

🧪 Features
- Page Object Model (POM): Separates page elements and actions from test logic for better reusability.
- Data-Driven Testing: Test data is fetched from a database (instead of hardcoded values or resource files).
- TestNG Integration: Allows parallel execution, grouping of tests, and reporting.
- Functional Coverage:
  - Registration flow validation
  - Login functionality validation
  - Password recovery validation

⚙️ Prerequisites
Before running the tests, ensure you have the following installed:
- Java JDK 8 or above
- TestNG (installed in your IDE or via jar)
- Selenium WebDriver JARs included in the project
- Database Connection (configured inside test classes for fetching test data)

🚀 Future Enhancements
- Add CI/CD pipeline integration (Jenkins/GitHub Actions).
- Extend database-driven tests with more scenarios.
- Introduce cross-browser testing support.

📊 Test Coverage
- Registration Module
  - Valid data submission
  - Invalid inputs (email, phone, WhatsApp number, year selection, etc.)
  - Duplicate user registration handling
  - Online & Offline mode selection validation
  - Career choice validation (Development / Testing)

- Login Module
  - Valid login with correct credentials
  - Invalid login (wrong username/password)
  - Empty fields validation

- Password Recovery Module
  - Valid user password recovery
  - Invalid/non-registered user recovery attempt

👨‍💻 Author:-
Shubhankar S. Gaikwad
