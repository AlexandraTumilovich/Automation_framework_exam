package project.by.stormnet.functional.entities.helpers.elemahelpers;

import org.openqa.selenium.WebElement;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaBlogPage;
import java.util.ArrayList;
import java.util.List;

public class ElemaBlogHelper {
    private ElemaBlogPage elemaBlogPage = new ElemaBlogPage();

    public ArrayList<String> getBlogNavigationElements(){
        List<WebElement> listElements = elemaBlogPage.getElements(elemaBlogPage.getBlogNavigation());
        ArrayList<String> listText = new ArrayList<>();
        for (WebElement q:listElements) {
            listText.add(q.getText());
        }
        return listText;
    }

    public int getBlogArticlesNumber(){
        List<WebElement> list2 = elemaBlogPage.getElements(elemaBlogPage.getBlogArticle());
        return list2.size();
    }
}
