# DemoShop Selenium Automation Framework

This is a professional Java-based Selenium automation framework for testing the **Demo Web Shop** e-commerce site.

## 🚀 Tech Stack
* **Language:** Java 21
* **Automation Tool:** Selenium WebDriver (v4.18.1+)
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Reporting:** Extent Reports & TestNG Reports
* **Design Pattern:** Page Object Model (POM)

## 📁 Project Structure
* `src/main/java`: Contains Page Objects and Utility classes (Decoding, Screenshots, etc.).
* `src/test/java`: Contains the actual TestNG test scripts.
* `target/`: (Ignored by Git) Contains generated reports and failure screenshots.

## 🛠️ Setup Instructions
1. Clone the repository:
   ```bash
   git clone [https://github.com/YOUR_USERNAME/Sample_Test.git](https://github.com/YOUR_USERNAME/Sample_Test.git)

   Open the project in VS Code or IntelliJ.

Ensure Maven is installed and dependencies are downloaded.

🏃 Running Tests
To run all tests via terminal:
mvn clean test


To run a specific test class:
mvn test -Dtest=DemoShopTest

📊 Reporting
After running tests, you can find the visual report at:
target/ExtentReport.html



