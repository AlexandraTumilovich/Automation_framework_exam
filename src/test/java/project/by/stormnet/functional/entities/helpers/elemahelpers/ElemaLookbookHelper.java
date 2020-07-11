package project.by.stormnet.functional.entities.helpers.elemahelpers;

import org.openqa.selenium.WebElement;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaLookbookPage;
import java.util.ArrayList;
import java.util.List;

public class ElemaLookbookHelper extends AbstractHelper {
    ElemaLookbookPage elemaLookbookPage = new ElemaLookbookPage();

    public boolean checkLookbookHeader(){
        return elemaLookbookPage.getElement(elemaLookbookPage.getLookbookHeader()).isDisplayed();
    }

    public ArrayList<String> getLookbookText(){
        ArrayList<String> list1 = new ArrayList<>();
        List<WebElement> listElements = elemaLookbookPage.getElements(elemaLookbookPage.getLookbookText());
        for (WebElement a:listElements) {
            list1.add(a.getText());
        }
        return list1;
    }
}
