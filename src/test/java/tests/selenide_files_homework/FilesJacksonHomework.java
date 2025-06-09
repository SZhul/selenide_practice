package tests.selenide_files_homework;

import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import pageObjects.pogo_model.MenuContainer;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesJacksonHomework {

    @Test
    void jsonParseImprovedJacksonTest() throws Exception {
        File file = new File("src/test/resources/menu.json");
        ObjectMapper objectMapper = new ObjectMapper();
        MenuContainer menu = objectMapper.readValue(file, MenuContainer.class);
        assertThat(menu.menu.id).isEqualTo("file");
        assertThat(menu.menu.popup.menuitem.get(0).value).isEqualTo("New");
    }
}
