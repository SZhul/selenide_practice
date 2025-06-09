package tests.selenide_files_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelenideFilesTests {

    @Test
    void selenideDownloadTests() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("[data-testid=\"raw-button\"]").download();
        try (InputStream is = new FileInputStream(downloadedFile)) {
            byte[] bytes = is.readAllBytes();
            String textContext = new String(bytes);
            assertThat(textContext).contains("This repository is the home of JUnit Platform, Jupiter, and Vintage.");
        }
    }

    @Test
    void selenideUploadTests() throws Exception {
        open("https://arielsalminen.com/filetest/");
        $("input[type='file']").shouldBe(visible).uploadFromClasspath("kitty.png");
    }
}
