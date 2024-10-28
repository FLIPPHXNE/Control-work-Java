package org.Control4;

public class Task1 {
    public static void main(String args[]){
        EmpPercent empPercent = new EmpPercent("Viktor", 25000, 50.0);
        EmpStaff empStaff = new EmpStaff("Andrey", 70000);
        EmpHourly empHourly = new EmpHourly("Oleg", 600.0);

        empPercent.PayTheSalary();
        empPercent.DisplayMoney();
        empStaff.PayTheSalary();
        empStaff.DisplayMoney();
        empHourly.PayTheSalary(4, 8);
        empHourly.DisplayMoney();

        System.out.println();

        empPercent.PayTheSalary();
        empPercent.DisplayMoney();
        empStaff.PayTheSalary();
        empStaff.DisplayMoney();
        empHourly.PayTheSalary(5, 6);
        empHourly.DisplayMoney();
    }
}

abstract class Employee{
    protected String name;
    protected Double money;
    Employee(String name){
        this.name = name;
        money = 0.0;
    }

    public void DisplayMoney(){
        System.out.println(this.name + " " + this.money);
    }
}

class EmpPercent extends Employee{
    private Integer baseSalary;
    private Double percentageRate;

    public EmpPercent(String name, Integer baseSalary, Double percentageRate){
        super(name);
        this.baseSalary = baseSalary;
        this.percentageRate = percentageRate;
    }

    protected void PayTheSalary(){
        this.money += baseSalary*(1 + percentageRate/100);
    }
}

class EmpStaff extends Employee{
    private Integer monthlySalary;

    public EmpStaff(String name, Integer monthlySalary){
        super(name);
        this.monthlySalary = monthlySalary;
    }

    protected void PayTheSalary(){
        this.money += monthlySalary;
    }
}


class EmpHourly extends Employee{
    private Double salaryPerHour;

    public EmpHourly(String name, Double salaryPerHour){
        super(name);
        this.salaryPerHour = salaryPerHour;
    }

    protected void PayTheSalary(int WorkDaysPerWeek,int hoursPerWorkDay){
        this.money += WorkDaysPerWeek*4*hoursPerWorkDay*this.salaryPerHour;
    }
}