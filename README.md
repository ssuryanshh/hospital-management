# Hospital Management System

A Hospital Management System built using Java Swing and MySQL, developed in Apache NetBeans IDE.

## Project Structure

```bash
hospitalmanagementsystem/
├── source packages/
│   ├── default packages/
│   │   ├── addNewPatient.java
│   │   ├── fullHistoryofPatient.java
│   │   ├── addNewDiagnosis.java
│   │   ├── home.java
│   │   ├── updatePatientRecord.java
│   │   └── login.java
│   ├── com.mycompany.hospitalmanagementsystem/
│   │   └── hospitalmanagementsystem.java
│   └── project/
│       └── ConnectionProvider.java
├── Test packages
└── Dependencies

```


## Features

- **Login**: Entry point of the application. Handles user authentication.
- **Add New Patient**: Allows adding new patient records.
- **Full History of Patient**: Retrieves and displays the complete medical history of a patient.
- **Add New Diagnosis**: Enables adding new diagnoses to a patient's record.
- **Home**: Main dashboard/home screen after login.
- **Update Patient Record**: Allows updating existing patient records.

## Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/hospitalmanagementsystem.git
   cd hospitalmanagementsystem
   ```
2. **Open in NetBeans:**

   - Launch Apache NetBeans IDE.
   - Open the cloned project directory in NetBeans.
 3. **Set Up MySQL Database:**

    - Ensure MySQL is installed and running on your machine.
    - Create a database named project.
    - Update the database credentials in ConnectionProvider.java.

 4. **Set Main Class in NetBeans:**

    - Right-click the project in the Projects window and select Properties.
    - Select the Run category.
    - In the Main Class field, type login (or use the Browse button to locate and select login).
    - Click OK to save the changes.
      
  5. **Run the Project:**
  
     - Click on the Run Project button in NetBeans.

## Usage
  1. **Login:**

      - Use the login screen to authenticate.
      - username: admin
      - passwaord: 123
  2. **Home Dashboard:**

      -  Navigate through the home dashboard to access various features like adding new patients, viewing patient history, adding new diagnoses, and updating patient records.
    

## Summary

This `README.md` file provides an overview of the project structure, features, installation steps, usage instructions, and contact information. You can further customize it according to your specific requirements and project details.
