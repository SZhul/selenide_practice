package tests.selenide_files_tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import pageObjects.pogo_model.Glossary;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTests {

    ClassLoader cl = FilesParsingTests.class.getClassLoader();

    @Test
    void pdfParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadedPdf = $x("//a[@href='junit-user-guide-5.12.2.pdf']").download();
        try (InputStream is = new FileInputStream(downloadedPdf)) {
            PDF content = new PDF(downloadedPdf);
            assertThat(content.creator.contains("Sam Brannen")).isTrue();
        }
    }

    @Test
    void xlsParseTest() throws Exception {
        try (InputStream resourceAsStream = cl.getResourceAsStream("АЛ ЖУЛЬ.xlsx")) {
            XLS content = new XLS(resourceAsStream);
            System.out.println();
        }
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadedPdf = $x("//a[@href='junit-user-guide-5.12.2.pdf']").download();
        try (InputStream is = new FileInputStream(downloadedPdf)) {
            PDF content = new PDF(downloadedPdf);
            assertThat(content.creator.contains("Sam Brannen")).isTrue();
        }
    }

    @Test
    void csvParseTest() throws Exception {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("lesson.csv");
                CSVReader csvReader = new CSVReader(new InputStreamReader(resourceAsStream));
        ) {
            List<String[]> content = csvReader.readAll();
            assertThat(content.get(0)[1]).contains("lesson");
        }
    }

    @Test
    void zipParseTest() throws Exception {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("lesson.zip");
                ZipInputStream zis = new ZipInputStream(resourceAsStream);
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).contains("lesson");
            }
        }
    }

    @Test
    void jsonParseTest() throws Exception {
        Gson gson = new Gson();
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("glossary.json");
                InputStreamReader reader = new InputStreamReader(resourceAsStream);
        )  {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            assertThat(jsonObject.get("title").getAsString()).isEqualTo("example glossary");
            assertThat(jsonObject.get("GlossDiv").getAsJsonObject()
                    .get("title").getAsString()).isEqualTo("S");
            assertThat(jsonObject.get("GlossDiv").getAsJsonObject()
                    .get("flag").getAsBoolean()).isTrue();
            assertThat(jsonObject.get("GlossDiv").getAsJsonObject().get("GlossList").getAsJsonObject()
                    .get("GlossEntry").getAsJsonObject().get("ID").getAsString())
                    .isEqualTo("SGML");
        }
    }

    @Test
    void jsonParseImprovedTest() throws Exception {
        Gson gson = new Gson();
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("glossary.json");
                InputStreamReader reader = new InputStreamReader(resourceAsStream);
        )  {
            Glossary jsonObject = gson.fromJson(reader, Glossary.class);
            assertThat(jsonObject.title).isEqualTo("example glossary");
            assertThat(jsonObject.glossDiv.title).isEqualTo("S");
            assertThat(jsonObject.glossDiv.flag).isTrue();
        }
    }
}
