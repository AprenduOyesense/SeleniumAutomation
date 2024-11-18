package org.oyetest.projects.crm.pages.Projects;

import org.oyetest.keywords.WebUI;
import org.oyetest.projects.crm.pages.CommonPageCRM;
import org.openqa.selenium.By;

public class ProjectPageCRM extends CommonPageCRM {

    public ProjectPageCRM() {
    }

    private String pageText = "Projects";

    //Project Page Element
    private By projectMenu = By.xpath("//span[normalize-space()='Projects']");
    private By searchInput = By.xpath("//input[@type='search']");

    public void searchByValue(String value) {
        WebUI.clearText(searchInput);
        WebUI.setText(searchInput, value);
        WebUI.sleep(1);
    }

}
