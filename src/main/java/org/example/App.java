package org.example;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java Time API exercises
 *
 */
public class App 
{
    public static void main( String[] args )
    {






    }
                // Exercises

    public static void exercise1(){
        LocalDate a = LocalDate.now();

        System.out.println(a);
        System.out.println(LocalDate.now());
    }

    public static void exercise2(){
        LocalDate march29 = LocalDate.now();

        String date = march29.format(DateTimeFormatter.ofPattern("EEEE d LLL"));
        System.out.println(date);
    }

    public static void exercise3(){
        LocalDate lastMon = LocalDate.of(2021,10,18);
        while(true) {
            if (lastMon.isBefore(LocalDate.of(2021, 10, 24))) {
                System.out.println(LocalDate.of(2021, 10, 18));
                System.out.println(LocalDate.of(2021, 10, 19));
                System.out.println(LocalDate.of(2021, 10, 20));
                System.out.println(LocalDate.of(2021, 10, 21));
                System.out.println(LocalDate.of(2021, 10, 22));
                System.out.println(LocalDate.of(2021, 10, 23));
            }
            break;
        }
    }

    public static void exercise4(){
        LocalDate myBirthDay = LocalDate.parse("1994-04-22");
        System.out.println(myBirthDay);
    }

    public static void exercise5() {
        LocalDate year = LocalDate.of(1945,5,8);

        DayOfWeek day = year.getDayOfWeek();
        System.out.println(day);
    }



    public static int getAgeFromBirthdate(LocalDate birthDate){
       Period period = Period.between(birthDate, LocalDate.now());
       return period.getYears();
   }
    public static List<LocalDateTime> findDateTimeBetween(LocalTime start,LocalTime end, List<LocalDateTime> dateTimeList){
        List<LocalDateTime> result = new ArrayList<>();
        for(LocalDateTime dateTime : dateTimeList){
            LocalTime time = dateTime.toLocalTime();
            if((time.isAfter(start) || time.equals(start)) && (time.isBefore(end) || time.equals(end))){
                result.add(dateTime);
            }
        }
        return result;
    }
    public static List<LocalDateTime> findDateBetween(LocalDateTime start, LocalDateTime end, List<LocalDateTime> dateTimeList) {

        List<LocalDateTime> result = new ArrayList<>();
        for (LocalDateTime datetime : dateTimeList) {
            if(
                    (datetime.isAfter(start) || datetime.isBefore(end))
                    &&
                    (datetime.isBefore(end)) || datetime.equals(end)) {
                result.add(datetime);
            }
        }
        return result;
    }
    public static void example(){
        List<LocalDateTime> dateTimeList = Arrays.asList(
                LocalDateTime.of(2021, 11, 11, 13, 0),
                LocalDateTime.of(2021, 11, 11, 14, 30),
                LocalDateTime.of(2021, 11, 12, 13, 0),
                LocalDateTime.of(2021, 11, 10, 13, 0)
        );


        LocalDateTime start = LocalDateTime.of(2021, 11, 11, 13,0);
        LocalDateTime ends = LocalDateTime.of(2021, 11, 12, 13,0);
        List<LocalDateTime> availableTimes = findDateBetween(start, ends, dateTimeList);

        System.out.println(getAgeFromBirthdate(LocalDate.parse("1994-04-22")));
    }
}
