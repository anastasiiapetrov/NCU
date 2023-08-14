import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CourseListPage {

    private SelenideElement searchBar = $(byId(":r0:"));
    private SelenideElement foundCourse = $(byText("Meta Social Media Marketing"));
    private SelenideElement foundCourseToClick = $(By.className("list-action-wrapper"));
    private ElementsCollection foundCourseByProfessor = $$x("//span[@style='font-size: 0.875rem; color: rgb(150, 113, 16);']");


    public void enterTextInSearchBar(String enteredValue){
        searchBar.shouldBe(visible).setValue(enteredValue);
    }
    public String checkCoursesName(){
       return foundCourse.shouldBe(visible).getText();
    }

    public void clickOnFoundedCourse(){
        foundCourseToClick.click();
    }

    public boolean checkCoursesByProfessor(){
        List<String> actualName = new ArrayList<String>();
        for (SelenideElement course:foundCourseByProfessor) {
            actualName.add(course.getText());
        }
        List<String> expectedName = new ArrayList<String>(actualName);
        Collections.sort(expectedName);
        return actualName.equals(expectedName);
    }
}
