package org.Control5.Task2;

interface Worker{

    int getSalary();
    void callInSick(String reason);
}

interface drivingSchoolboy{
    int drivingSkills = 30;
    boolean hasLicense = false;
    void submitForLicense();
    void practiceDriving();
}

interface Sport{
    void Run(int t);
    void Swim(int t);
}

interface Russian extends Worker, drivingSchoolboy, Sport{
    void speekRussian(String context);
}

class Human{
    int salary = 40000;
    int health = 70;
    int driveSkill = 30;
    private String name;

    public Human(String name, int salary, int health, int driveSkill) {
        this.salary = salary;
        this.health = health;
        this.driveSkill = driveSkill;
        this.name = name;
    }
}

class Student extends Human implements Russian {

    int course = 1;

    public Student(String name, int salary, int health, int driveSkill, int course) {
        super(name, salary, health, driveSkill);
        this.course = course;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void callInSick(String reason){
        if(this.health < 40 && reason.length() > 5)
            System.out.println("Взят больничный");
        else
            System.out.println("В больничном отказано");
    }

    @Override
    public void speekRussian(String context) {
        String phrase;
        switch (context) {
            case "greeting":
                phrase = "Привет! Как дела?";
                break;
            case "farewell":
                phrase = "До свидания.";
                break;
            case "question":
                phrase = "Как тебя зовут?";
                break;
            default:
                phrase = "Я говорю по-русски.";
        }
        System.out.println(phrase);
    }

    @Override
    public void submitForLicense(){
        if(!drivingSchoolboy.hasLicense && drivingSchoolboy.drivingSkills > 50)
            System.out.println("Сдан экзамен.");
        else
            System.out.println("Экзамен не сдан.");
    }

    @Override
    public void practiceDriving() {
        if(driveSkill < 100)
            driveSkill += 10;
    }

    @Override
    public void Run(int t) {
        System.out.printf("Start run ");
        for(int i = 0; i < t; i++)
            System.out.printf("%d ", i);
        System.out.println("End");
    }

    @Override
    public void Swim(int t) {
        System.out.printf("Start swim ");
        for(int i = 0; i < t; i++)
            System.out.printf("%d ", i);
        System.out.println("End");
    }
}

public class Task2 {

    public static void handleWorker(Worker worker) {
        worker.callInSick("Болен гриппом");
        System.out.println("Зарплата: " + worker.getSalary());
    }

    public static void handleDrivingSchoolboy(drivingSchoolboy dsb) {
        dsb.submitForLicense();
        dsb.practiceDriving();
    }

    public static void handleSport(Sport sport) {
        sport.Run(5);
        sport.Swim(3);
    }

    public static void handleRussian(Russian russian) {
        russian.speekRussian("greeting");
        russian.submitForLicense();
    }

    public static void main(String[] args) {
        Student student = new Student("Иван", 50000, 60, 40, 2);

        handleWorker(student);
        handleDrivingSchoolboy(student);
        handleSport(student);
        handleRussian(student);
    }
}