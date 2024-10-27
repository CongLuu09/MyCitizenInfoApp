package com.example.mycitizeninfoapp.utils;

public class Validator {
    public static boolean isAValidPhoneNumber(String phoneNumber)
    {
        return phoneNumber != null  && phoneNumber.matches("\\d{10}");
    }

    public static boolean isValidAge(int age){
        return age  >= 0 && age <= 120;
    }
}
