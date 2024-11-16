package Date;

import Employee.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDate;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        validateDate();
    }

    private void validateDate(){
        if (this.getMonth() < 1 || this.getMonth() > 12) {
            System.out.println("Error: Mês inválido");
            this.setDay(1);
            this.setMonth(1);
            this.setYear(2000);
            return;
        }

        if (this.getDay() < 1 || this.getDay() > this.daysOnMonth(this.getMonth()) || this.getYear() < 2000) {
            System.out.println("Error: Dia inválido para o mês específico.");
            this.setDay(1);
            this.setMonth(1);
            this.setYear(2000);
        }
    }

    private int daysOnMonth(int month){
        int[] allDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        if(month == 2) {
            return checkLeapYear() ? 29 : 28;
        }
        return allDays[month - 1];
    }

    private boolean checkLeapYear(){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public String toString() {
        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
