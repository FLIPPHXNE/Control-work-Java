package org.Control5.Task2;

interface Worker{
    int salary = 40000;
    int health = 50;
    int getSalary();
    void callInSick();
}

interface drivingSchoolboy{
    boolean hasLicense = false;
    void submitForLicense();
    void methodBB();
}

interface IC{
    void methodBA();
    void methodBB();
}

interface Russian extends Worker, IB, IC{
    void speekRussian();
}

class Human{
    private String name;
}

class Student implements Russian {

    @Override
    public int getSalary() {
        return Worker.salary;
    }

    @Override
    public void callInSick(){
        if(Worker.health < 40)
            System.out.println("Взят больничный");
    }

    @Override
    public void speekRussian(){
        System.out.println("Привет");
    }

    @Override
    public void submitForLicense(){
        if(!drivingSchoolboy.hasLicense)
            System.out.println("Сдан экзамен");;
    }
}

public class Task2 {
    public static void main(String[] args) {

    }
}
