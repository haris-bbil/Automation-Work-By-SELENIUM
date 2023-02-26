package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        int emailSuffix = (int) (Math.random() * (1000 - 1) + 1);
        int nameSuffix = (int) (Math.random() * (100 - 1) + 1);
        int phonenumber = (int) (Math.random() * (999999999 - 777777777) + 99000000);
        int id = 9;
        System.out.println(emailSuffix);
        System.out.println(nameSuffix);
        System.out.println(phonenumber +""+ id);
     //   System.out.println(java.time.LocalDate.now());
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

// In string format
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate todayDate = LocalDate.now();
        LocalDate tomorrowDate = todayDate.plusDays(1);
        String TomorrowDateFld = FORMATTER.format(tomorrowDate);
        System.out.println(TomorrowDateFld);

    }
}