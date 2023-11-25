package com.system;

import com.system.management.files.JsonRead;
import com.system.management.files.JsonWrite;
import com.system.management.files.Reader;
import com.system.management.files.Writer;
import com.system.management.staff.Manager;
import com.system.management.staff.Service;
import com.system.management.staff.StaffManager;
import com.system.management.staff.StaffService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Writer writer = new JsonWrite();
        Reader reader = new JsonRead();
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Staff Management System");
        service.displayCommands();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter a command: ");
            String command = sc.nextLine();
            manager.execute(command);
            if (command.equals("Save")){
                isRunning = false;
            }
        }
    }
}