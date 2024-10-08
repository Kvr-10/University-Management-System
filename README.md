# University Management System

## Overview

The University Management System is a comprehensive Java-based application designed to manage and streamline various administrative tasks within a university. This system provides functionalities for managing student and faculty information, leave applications, examination results, and fee details. The application features a user-friendly graphical interface built with Swing and integrates with a MySQL database for data storage and retrieval.

## Features

- **Login System:** Secure login interface for users to access the system.
- **Main Dashboard:** Central hub for navigating through different functionalities.
- **Student Management:** Add new student information, view details, and update records.
- **Faculty Management:** Add new faculty information, view details, and update records.
- **Leave Management:** Apply for and view leave details for both students and faculty.
- **Examination Management:** Enter marks and view examination results.
- **Fee Management:** View fee structure, fill out fee forms, and display paid fees.
- **Extras:** Access to calculator, notepad, and external links such as Instagram and GitHub.

## Technologies Used

- **Java:** Core programming language for application development.
- **Swing:** GUI toolkit for building the user interface.
- **MySQL:** Database for storing and managing data.
- **JCalendar:** For handling date inputs in the application.
- **RS2XML:** For exporting data to XML format.

## APIs Used
- **Java MySQL Connector:** Provides the JDBC API to connect Java applications to MySQL databases. It allows execution of SQL queries and updates through a standard JDBC interface.  
 **Documentation:** [MySQL Connector/J Documentation](https://dev.mysql.com/doc/connector-j/en/)
  
- **JCalendar:** Provides a graphical calendar component for handling date input in Java Swing applications. It allows users to select dates through a user-friendly interface.  
  **Documentation:** [JCalendar API](https://toedter.com/jcalendar/)
  
- **RS2XML:** Allows exporting and importing data in XML format using Java. It integrates with the JDBC API to convert SQL result sets into XML.  
  **Documentation:** [RS2XML API](https://sourceforge.net/projects/finalangelsanddemons/files/rs2xml.jar/download)

## Setup and Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Kvr-10/University-Management-System.git
   ```
2. **Navigate to Project Directory**

   ```sh
   University-Management-System/out/artifacts/UniversityMs_jar/UniversityMs.jar
   ```

3. **Install Dependencies:**
   
- Ensure you have Java Development Kit (JDK) installed.
- Add the following libraries to your project's classpath:
     - `MySQL Connector-java.jar` Download [MySQL Connector](https://dev.mysql.com/downloads/connector/j/)
     - `JCalendar.jar` Download [JCalender](https://toedter.com/jcalendar/)
     - `RS2XML.jar` Download [RS2XML](https://sourceforge.net/projects/finalangelsanddemons/files/rs2xml.jar/download)

## Database Setup

You need to create the database before importing the SQL file into it.
  
  ```sql
  CREATE DATABASE UniversityManagement;
  ```

 **Import the SQL File:**   
 
   Download the [`UniversityManagement.sql`](https://github.com/Kvr-10/University-Management-System/tree/master/database) file from the repository and import it into your MySQL database.  
   You can use tools like MySQL Workbench, phpMyAdmin, or command-line tools to execute the SQL script.

   ```shell
   mysql -u username -p UniversityManagement < path/to/UniversityManagement.sql
   ```
  **Note:** Make sure to update the username and password in the `DriverManager.getConnection` method within your `Connectionmysql` class to match your MySQL database credentials.

**Run the Application:**
   - Compile and run the `Splash` class to start the application.
   - Initial Username: `kvr10` Password: `admin.`

## Alternative
   - Ensure that you have created the Database `UniversityManagement`, and imported the [`UniversityManagement.sql`](https://github.com/Kvr-10/University-Management-System/tree/master/database) file from the repository into your MySQL database.  
   - You can directly download the JAR file from the [Releases page](https://github.com/Kvr-10/University-Management-System/releases/latest) and run it.    
   - Download [University-Management-System](https://github.com/Kvr-10/University-Management-System/releases/latest/download/UniversityMS.jar) Application.   
   - Initial Username: `kvr10` Password: `admin.`

## Usage

- **Splash:** Starts the application with a animation.
- **Login:** Enter your credentials to access the system.
- **Main Dashboard:** Use the menu options to navigate through student and faculty management, leave applications, examination results, and fee details.
- **Student and Faculty Management:** Use the respective menus to add, view, and update records.
- **Leave and Examination Management:** Apply for leave and enter examination results through the provided options.
- **Fee Management:** Access fee-related information and forms as needed.
- **Access Extras:** Access external tools and resources via the "Extras" menu.

## Contributing

Feel free to fork the repository and submit pull requests for improvements or bug fixes. Please ensure that any contributions adhere to the existing code style and include appropriate documentation.


## Contact

For any questions or issues, please contact [chamansinha9480@gmail.com](mailto:chamansinha9480@gmail.com).

---
