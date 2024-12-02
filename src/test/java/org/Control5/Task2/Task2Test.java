package org.Control5.Task2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void testHandleWorker() {
        Student student = new Student("Иван", 50000, 60, 40, 2);
        assertDoesNotThrow(() -> Task2.handleWorker(student));
    }

    @Test
    void testHandleDrivingSchoolboy() {
        Student student = new Student("Иван", 50000, 60, 40, 2);
        assertDoesNotThrow(() -> Task2.handleDrivingSchoolboy(student));
    }

    @Test
    void testHandleSport() {
        Student student = new Student("Иван", 50000, 60, 40, 2);
        assertDoesNotThrow(() -> Task2.handleSport(student));
    }

    @Test
    void testHandleRussian() {
        Student student = new Student("Иван", 50000, 60, 40, 2);
        assertDoesNotThrow(() -> Task2.handleRussian(student));
    }
}
