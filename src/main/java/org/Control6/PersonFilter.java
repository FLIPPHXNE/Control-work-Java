package org.Control6;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONObject;
import org.json.JSONArray;

class Person {
    private LocalDate birthdate;
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    Person(String name, LocalDate birthdate, String email){
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{name=" + name  + ", birthdate='" + birthdate.toString() + "', email=" + email + '}';
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new org.json.JSONObject();
        jsonObject.put("name", name);
        //jsonObject.put("birthdate", birthdate);
        jsonObject.put("email", email);

        return jsonObject;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}

public class PersonFilter{
    private static final Logger logger = Logger.getLogger(PersonFilter.class.getName());

    public static void main(String[] args) throws IOException {
        configureLogger();
        String filePath = "src/main/java/org/Control6/persons.json";
        try {
            List<Person> persons = readPersonsFromJson(filePath);
            logger.info("Данные из файла " + filePath + " успешно прочитаны.");

            Predicate<Person> adultPred = person -> person.getAge() > 18;
            Predicate<Person> leapYearPred = person -> {
                int year = person.getBirthdate().getYear();
                return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            };
            applyFunctions(persons);
            List<Person> adultPersons = filterPersons(persons, adultPred);

            writeFilteredPersonsToJson(adultPersons, "src/main/java/org/Control6/filtered_persons.json");
            logger.info("Отфильтрованные данные записаны в файл filtered_persons.json");

            double averageAge = calculateAverageAge(persons);
            logger.info("Средний возраст людей: " + averageAge);

            List<Person> leapYearBorn = findLeapYearBorn(persons);
            leapYearBorn.forEach(person -> logger.info("Родился в високосный год: " + person.getName()));

            Map<String, List<Person>> ageGroups = groupByAgeCategory(persons);
            ageGroups.forEach((category, list) -> {
                logger.info("Возрастная группа: " + category);
                list.forEach(person -> logger.info(person.getName()));
            });
            int SIZE = 10000;
            int[] arr = new int[SIZE];
            for(int i = 0; i < SIZE; i++){
                arr[i] = (SIZE%1000+i*i)%3000;
            }
            measureSortPerformance(arr, Arrays::sort);
        }
        catch (IOException | org.json.JSONException e) {
            logger.log(Level.SEVERE, "Произошла ошибка: " + e);
        }
    }

    public static void writeFilteredPersonsToJson(List<Person> persons, String filePath) throws IOException {
        JSONArray jsonArray = new JSONArray();
        persons.forEach(person -> jsonArray.put(person.toJSONObject()));

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toString(2));
            file.flush();
        }
    }


    public static double calculateAverageAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    public static Predicate<Person> isAdult() {
        return person -> person.getAge() > 18;
    }

    public static Function<Person, String> personToNameEmail() {
        return person -> person.getName() + " - " + person.getEmail();
    }

    public static Consumer<Person> printPerson() {
        return person -> System.out.println(person.getName() + " - " + person.getEmail());
    }

    public static List<Person> findLeapYearBorn(List<Person> persons) {
        return persons.stream()
                .filter(person -> {
                    int year = person.getBirthdate().getYear();
                    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                })
                .collect(Collectors.toList());
    }

    public static List<Person> filterPersons(List<Person> persons, Predicate<Person> predicate) {
        List<Person> filtredPersons = persons.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        filtredPersons.forEach(person -> logger.info("Прошел фильтр: " + person.getName()));
        return filtredPersons;
    }

    private static void configureLogger() {
        try {
            FileHandler fh = new FileHandler("person_filter.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при настройке логгера", e);
        }
    }

    public static void applyFunctions(List<Person> persons) {
        persons.stream()
                .filter(isAdult())
                .map(personToNameEmail())
                .forEach(System.out::println);
    }


    public static Map<String, List<Person>> groupByAgeCategory(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(person -> {
                    int age = person.getAge();
                    if (age < 18) {
                        return "Дети";
                    } else if (age < 30) {
                        return "Молодежь";
                    } else if (age < 65) {
                        return "Средняя";
                    } else {
                        return "Пенсионеры";
                    }
                }));
    }

    public static List<Person> readPersonsFromJson(String filePath) throws IOException, org.json.JSONException {
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonArray = new JSONArray(jsonContent);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate birthDate = LocalDate.parse(jsonObject.getString("birthdate"), formatter);
                    return new Person(
                            jsonObject.getString("name"),
                            birthDate,
                            jsonObject.getString("email")
                    );
                })
                .collect(Collectors.toList());
    }

    public static void measureSortPerformance(int[] array, Consumer<int[]> cs) {
        long startTime = System.currentTimeMillis();

        cs.accept(array);
        //Arrays.sort(array);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        logger.info("Время выполнения сортировки: " + duration + " мс.");
    }
}