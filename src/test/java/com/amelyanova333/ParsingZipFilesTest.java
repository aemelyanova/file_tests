package com.amelyanova333;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParsingZipFilesTest {
    private ClassLoader cl = ParsingZipFilesTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка PDF файла")
    void zipParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {

                if (entry.getName().equals("test_file.pdf")) {

                    PDF pdf = new PDF(zis);
                    assertEquals("Пример cопроводительного файла", pdf.text);

                }
            }
        }
    }


    @Test
    @DisplayName("Проверка XLS файла")
    void zipXlsTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("test_demo.xlsx")) {
                    XLS xls = new XLS(zis);
                    assertTrue(xls.excel.getSheetAt(1).getRow(0).getCell(2)
                            .getStringCellValue().contains("<AT> АВСТРИЯ"));

                }
            }
        }
    }

    @Test
    @DisplayName("Проверка CSV файла")
    void zipCsvTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("test_names.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = csvReader.readAll();
                    assertArrayEquals(new String[]{"Имя", "Возраст", "Город"}, content.get(0));

                }
            }
        }
    }
}
