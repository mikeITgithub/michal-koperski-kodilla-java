package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTest {
    @Test
    public void testUpdate() {
        //Given
        HomeworksStack student1homework = new Student1Homeworks();
        HomeworksStack student2homework = new Student2Homeworks();
        Mentor adam = new Mentor("Adam");
        Mentor iwona = new Mentor("Iwona");
        Mentor ala = new Mentor("Ala");
        student1homework.registerObserver(adam);
        student2homework.registerObserver(iwona);
        student1homework.registerObserver(ala);
        student2homework.registerObserver(ala);
        //When
        student1homework.addHomework("Homework 1");
        student1homework.addHomework("Homework 2");
        student2homework.addHomework("Homework 3");
        student1homework.addHomework("Homework 4");
        student2homework.addHomework("Homework 5");
        //Then
        assertEquals(3, adam.getUpdateCount());
        assertEquals(2,iwona.getUpdateCount());
        assertEquals(5,ala.getUpdateCount());
    }
}
