import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfessorsPage {

    private SelenideElement searchBar = $(byId(":r0:"));
    private SelenideElement foundProfessor = $x("(//*[contains(@style,'rgb(150, 113, 16);')])");



    public void enterTextInSearchBar(String enteredValue){
        searchBar.shouldBe(visible).setValue(enteredValue);
    }
    public String checkCourseName(){
        foundProfessor.scrollIntoView(false);
        return foundProfessor.shouldBe(visible).getText();
    }


}
