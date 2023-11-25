package com.system.management.staff;

import com.system.management.files.JsonRead;
import com.system.management.files.JsonWrite;
import com.system.management.files.Reader;
import com.system.management.files.Writer;
import com.system.management.verifacations.UserValidation;

import java.io.Serializable;
import java.util.*;

public class StaffService implements Service{
    private Reader reader = new JsonRead();
    private Writer writer = new JsonWrite();
    private final String fileName = "employee.json";
    private final String fired = "firedEmployee.json";

    public StaffService(Reader reader, Writer writer){
        this.reader = reader;
        this.writer = writer;
    }

    public StaffService(){}

    public void displayCommands(){
        System.out.println("Add employee");
        System.out.println("Edit employee");
        System.out.println("Fire employee");
        System.out.println("List employee");
    }

    protected void addEmployee(){
        List<Serializable> employeeList = new ArrayList<>();
        UserValidation validation = new UserValidation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee's id: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter employee's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter employee's department: ");
        String department = scanner.nextLine();
        System.out.println("Enter employee's role: ");
        String role = scanner.nextLine();
        System.out.println("Enter employee's salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        validation.validator(name,role,department,salary);
        if (UserValidation.getMsg().equals("ok")) {
            employeeList.add(new Employee(id, name, department, role, salary));
        }
        writer.write(employeeList, fileName);
    }

    protected void listEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Commands list:");
        System.out.println("Id || Department || Role || Name || All");
        System.out.print("Enter a command: ");
        String command = scanner.nextLine();
        List<Employee> res = (List<Employee>) reader.read(fileName);
        switch (command){
            case "Id" -> {
                System.out.print("Enter id: ");
                long id = Long.parseLong(scanner.nextLine());
                for (Employee el : res) {
                    if (el.getId() == id){
                        System.out.println(el);
                    }
                }
            }
            case "Department", "Role", "Name" ->{
                String criterion = scanner.nextLine();
                for (Employee el : res) {
                    if (el.getName().equals(criterion) || el.getDepartment().equals(criterion) || el.getRole().equals(criterion)){
                        System.out.println(el);
                    }
                }
            }
            case "All" -> {
                for (Serializable employee  : res) {
                    System.out.println(employee);
                }
            }
        }
    }

    protected void fireEmployee(){
        Scanner scanner = new Scanner(System.in);
        long id = Long.parseLong(scanner.nextLine());
        List<Employee> res = (List<Employee>) reader.read(fileName);
        List<Serializable> firedEmployee = new ArrayList<>();
        for (Employee employees : res) {
            if (employees.getId() == id) {
                res.remove(employees);
                firedEmployee.add(employees);
                writer.write(firedEmployee, fired);
                System.out.println(employees);
            }
        }
    }
}
