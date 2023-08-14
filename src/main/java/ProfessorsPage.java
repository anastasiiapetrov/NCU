import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfessorsPage {

    private SelenideElement searchBar = $(byId(":r0:"));

    private SelenideElement foundCourse = $(byText("Computer Science"));

    public void enterTextInSearchBar(String enteredValue){
        searchBar.shouldBe(visible).setValue(enteredValue);
    }
    public String checkCourseName(){
        foundCourse.scrollIntoView(false);
        return foundCourse.shouldBe(visible).getText();
    }


}
