package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import steps.pages.ProductPage;
import steps.pages.checkout.CheckOutCompletePage;
import steps.pages.checkout.CheckOutOverviewPage;
import steps.pages.checkout.CheckOutYourInformationPage;

public class CheckOutSteps extends BaseStep {

    private CheckOutYourInformationPage checkOutYourInformationPage;
    private CheckOutOverviewPage checkOutOverviewPage;
    private CheckOutCompletePage checkOutCompletePage;


    public CheckOutSteps(WebDriver driver) {
        super(driver);
        checkOutYourInformationPage = new CheckOutYourInformationPage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);
    }

    public void fillRequiredFields (String firstName, String lastName, String postCode) {
        checkOutYourInformationPage.getFirstNameFieldLocator().sendKeys(firstName);
       checkOutYourInformationPage.getLastNameFieldLocator().sendKeys(lastName);
       checkOutYourInformationPage.getPostalCodeFieldLocator().sendKeys(postCode);
    }

    public CheckOutOverviewPage pressContinueButton() {
        checkOutYourInformationPage.getContinueButtonLocator().click();
        return new CheckOutOverviewPage(driver);
    }

    public CheckOutCompletePage pressFinishButton() {
        checkOutOverviewPage.getFinishButtonLocator().click();
        return new CheckOutCompletePage(driver);
    }

    public ProductPage pressBackToHomeButton() {
        checkOutCompletePage.getBackHomeButtonLocator().click();
        return new ProductPage(driver);
    }

}
