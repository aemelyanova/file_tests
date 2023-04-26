package com.amelyanova333;

import com.amelyanova333.modal.DataStudent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;


public class JsonJacksonTest {
    private ClassLoader cl = JsonJacksonTest.class.getClassLoader();

    @DisplayName("Проверка JSON файла")
    @Test
    void jsonParseTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        try (
                InputStream resource = cl.getResourceAsStream("student.json");
                InputStreamReader reader = new InputStreamReader(resource);
        ) {

            DataStudent dataStudents = objectMapper.readValue(reader, DataStudent.class);

            Assertions.assertTrue(dataStudents.getFormCompleted());
            Assertions.assertEquals(1001, dataStudents.getId());
            Assertions.assertEquals(90, dataStudents.getScore().getMathematics());
            Assertions.assertEquals(85, dataStudents.getScore().getScience());
            Assertions.assertEquals(89, dataStudents.getScore().getComputer());
            Assertions.assertEquals("Bella", dataStudents.getName());
            Assertions.assertEquals("Petrova", dataStudents.getSurname());
            Assertions.assertEquals("Sport", dataStudents.getHobbies().get(0));
            Assertions.assertEquals("History", dataStudents.getHobbies().get(1));

        }
    }
}