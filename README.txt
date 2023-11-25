This is staff management program. You can add, fire and list your staff. 
There are three main packages: files, staff and verifications.

In the file package have JsonRead and JsonWrite classes which implements the Reader and Writer interfaces.
In the staff package have class Employee and two Manager and Service interfaces which are implemented by StaffManager and StaffService classes. The Manager class has only one method: execute();. This method is Override by StaffManager class where the method manage the commands that we have typed.
Service interface has one method displayCommands. This method shows us the main commands when we start the program. In StaffService class have another methods like: addEmployee (which add an employee), fireEmployee(which remove the employee) and listEmployee in which you can list the employee by criteria.
In the verifications package the is only one class which validate the date when you want to add new employee.  