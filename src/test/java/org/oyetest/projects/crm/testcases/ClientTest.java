
package org.oyetest.projects.crm.testcases;

import org.oyetest.annotations.FrameworkAnnotation;
import org.oyetest.common.BaseTest;
import org.oyetest.dataprovider.DataProviderManager;
import org.oyetest.enums.AuthorType;
import org.oyetest.enums.CategoryType;

import static org.oyetest.keywords.WebUI.*;

import org.oyetest.projects.crm.pages.Clients.ClientPageCRM;
import org.oyetest.projects.crm.pages.Dashboard.DashboardPageCRM;
import org.oyetest.projects.crm.pages.SignIn.SignInPageCRM;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Client Test")
public class ClientTest extends BaseTest {

    SignInPageCRM signInPageCRM;
    DashboardPageCRM dashboardPageCRM;
    ClientPageCRM clientPageCRM;

    public ClientTest() {
        signInPageCRM = new SignInPageCRM();
    }

    @FrameworkAnnotation(author = {AuthorType.Oyetest}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "TC05_testAddClient", dataProvider = "getClientDataHashTable", dataProviderClass = DataProviderManager.class)
    public void testAddClient(Hashtable<String, String> data) {
        dashboardPageCRM = signInPageCRM.signInWithAdminRole();
        clientPageCRM = dashboardPageCRM.openClientPage();
        clientPageCRM.openClientTabPage();
        clientPageCRM.addClient(data);
    }

    @FrameworkAnnotation(author = {AuthorType.Oyetest}, category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 2, description = "TC06_testSearchClient")
    public void testSearchClient() {
        dashboardPageCRM = signInPageCRM.signInWithAdminRole();
        clientPageCRM = dashboardPageCRM.openClientPage();
        clientPageCRM.openClientTabPage();
        // Search the first
        clientPageCRM.enterDataSearchClient("Adrain Ondricka");
        checkContainsValueOnTableByColumn(2, "Adrain Ondricka");
        // Search the second
        clientPageCRM.enterDataSearchClient("Birdie Erdman");
        checkContainsValueOnTableByColumn(2, "Birdie Erdman");

    }

}