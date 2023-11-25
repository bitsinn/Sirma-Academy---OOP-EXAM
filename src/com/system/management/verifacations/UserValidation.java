package com.system.management.verifacations;


import java.util.regex.Pattern;

public class UserValidation {
    static String msg;
    private static final Pattern STRING = Pattern.compile("\\D+");
    private static final Pattern NUMBER = Pattern.compile("\\d{0,9}.\\d");

    public static String getMsg() {
        return msg;
    }

    public void setMsg() {
        UserValidation.msg = "ok";
    }

    public void validator(String name, String role, String department, double salary){
        int count = 0;
        String payment = String.valueOf(salary);
        if (NUMBER.matcher(payment).matches()){
            count++;
        }else {
            System.out.println("Enter valid salary!");
        }
        if (STRING.matcher(name).matches()){
            count++;
        }else {
            System.out.println("Enter valid name!");
        }
        if (STRING.matcher(role).matches()){
            count++;
        }else {
            System.out.println("Enter valid role!");
        }
        if (STRING.matcher(department).matches()){
            count++;
        }else {
            System.out.println("Enter valid department!");
        }
        if (count == 4){
            setMsg();
        }
    }
}
