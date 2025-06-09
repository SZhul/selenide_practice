package tests.selenide_files_homework;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import pageObjects.pogo_model.MenuContainer;
import tests.selenide_files_tests.FilesParsingTests;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesHomework {

    ClassLoader cl = FilesParsingTests.class.getClassLoader();

    @Test
    void jsonParseImprovedTest() throws Exception {
        Gson gson = new Gson();
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("menu.json");
        ) {
            assert resourceAsStream != null;
            try (InputStreamReader reader = new InputStreamReader(resourceAsStream);
            )  {
                MenuContainer jsonObject = gson.fromJson(reader, MenuContainer.class);
                assertThat(jsonObject.menu.id).isEqualTo("file");
                assertThat(jsonObject.menu.popup.menuitem.get(0).value).isEqualTo("New");
                assertThat(jsonObject.menu.popup.menuitem.get(1).onclick).isEqualTo("OpenDoc()");
            }
        }
    }
}
