import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class StudentDirectoryPage {

    private SelenideElement searchBar = $(byId(":r0:"));
  //  private SelenideElement foundStudent = $(byTagName("h3"));
    private SelenideElement foundStudent = $(byText("Martin Slepanek"));

    public void enterTextInSearchBar(String enteredValue){
        searchBar.shouldBe(visible).setValue(enteredValue);
    }
    public String checkStudentName(){
        return foundStudent.shouldBe(visible).getText();
    }

}
