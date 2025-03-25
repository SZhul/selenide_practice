package pageObjects.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ListboxComponent {

    public void selectElementByText(String option) {
        $$(".css-11unzgr div").findBy(text(option)).click();
    }

    public void SelectFirstElementOnList(){
        $$(".css-11unzgr div").first().click();
    }
}
