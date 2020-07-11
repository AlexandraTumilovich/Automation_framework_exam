package project.by.stormnet.functional.entities.helpers.elemahelpers;

import org.openqa.selenium.WebElement;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaNewsPage;
import java.util.ArrayList;
import java.util.List;

public class ElemaNewsHelper extends AbstractHelper {
    ElemaNewsPage elemaNewsPage = new ElemaNewsPage();

    public boolean checkNewsHeader(){
        return elemaNewsPage.getElement(elemaNewsPage.getHeaderNews()).isDisplayed();
    }

    public String getNewsHeaderText(){
        return elemaNewsPage.getElement(elemaNewsPage.getHeaderNews()).getText();
    }

    public int getSideSectionElementsNumber(){
        List<WebElement> listElements = elemaNewsPage.getElements(elemaNewsPage.getSideSection());
        return listElements.size();
    }

    public ArrayList<String> getSideSectionElementsList(){
        List<WebElement> listElements = elemaNewsPage.getElements(elemaNewsPage.getSideSection());
        ArrayList<String> elementText = new ArrayList<>();
        for (WebElement a:listElements) {
            elementText.add(a.getText());
        }
        return elementText;
    }
}
