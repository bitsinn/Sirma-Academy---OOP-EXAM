package com.system.management.staff;

public class StaffManager implements Manager {
    private final Service service;

    public StaffManager(Service service){
        this.service = service;
    }
    @Override
    public void execute(String command) {
        StaffService staffService = new StaffService();
        switch (command){
            case "Add employee" -> staffService.addEmployee();
            case "List employee" -> staffService.listEmployee();
            case "Fire employee" -> staffService.fireEmployee();
        }
    }
}
