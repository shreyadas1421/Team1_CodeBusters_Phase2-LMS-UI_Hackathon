package PageObject;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestBase;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C_ProgramPOM extends TestBase{
    String actualMsg = "";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    @FindBy(xpath = "//button[@id=\"program\"]")
    public WebElement program;

    @FindBy(xpath = "//div[contains(text(),' Manage Program')]")
    public WebElement manageProgram;

    @FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
    public WebElement paginationBelowText;

    @FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
    public WebElement paginationCountDisplay;
    @FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
    public WebElement tableLevelDeleteButton;


    @FindBy(xpath = "//button[@class='p-button-rounded p-button-success p-button p-component']")
    public WebElement addNewProgramButton;

    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']")
    public WebElement programTableBody;

    @FindBy(xpath = "//thead[@class='p-datatable-thead']/tr")
    public WebElement tableHeader;
    @FindBy(xpath = "//div[@class=\"p-dialog-header ng-tns-c132-63 ng-star-inserted\"]")
    public WebElement newProgramPopup;

    @FindBy(xpath = "//button[@Class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")
    public WebElement cancelButtonProgramPopup;

    @FindBy(xpath = "//button[@Class='p-button-rounded p-button-success p-button p-component ng-star-inserted']")
    public WebElement saveButtonProgramPopup;

    @FindBy(xpath = "//button[contains(@class,'p-dialog-header-icon p-dialog-header-close')]")
    public WebElement closeIconProgramPopup;

    @FindBy(xpath = "//small[@class='p-invalid ng-star-inserted']")
    public WebElement errorMessagesAddProgramPopup;

    @FindBy(xpath="//button[@icon='pi pi-pencil']")
    public WebElement programEditButton;

    @FindBy(xpath = "//div[@class=\"ng-trigger ng-trigger-animation ng-tns-c132-3 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted\"]")
    public WebElement editPopUp;

    @FindBy(xpath = "//input[@id=\"programName\"]")
    public WebElement editProgramName;

    @FindBy(xpath = "//input[@id=\"filterGlobal\"]")
    public WebElement searchBoxProgram;




    public void clickProgramLink() {
        program.click();
    }

    public void clickAddNewProgramButton(){
        addNewProgramButton.click();
    }

    public void clickSaveButtonOnAddProgramPopup(){
        saveButtonProgramPopup.click();
    }

    public boolean errorMessagesOnAddProgramPopup(){
        Boolean errorMessagesOnAddProgramPopup = Boolean.FALSE;
        if (errorMessagesAddProgramPopup != null){
            errorMessagesOnAddProgramPopup = Boolean.TRUE;
        }
        return errorMessagesOnAddProgramPopup;
    }

    public boolean manageProgramIsVisible() {
        return manageProgram.isDisplayed();
    }

    public boolean doesURLContaineManageProgram() {
        Boolean isURLContainsManageProgram = Boolean.FALSE;
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("Manage Program")) {
            isURLContainsManageProgram = Boolean.TRUE;
        }
        return isURLContainsManageProgram;
    }

    public boolean isPaginationBelowTextVisible() {
        Boolean paginationBelowTextVisible = Boolean.FALSE;
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("Manage Program")) {
            paginationBelowTextVisible = Boolean.TRUE;
        }
        return paginationBelowTextVisible;
    }

    public boolean paginationCountDisplay() {
        return paginationCountDisplay.isDisplayed();
    }

    public boolean isTableLevelDeleteButtonDisbaled() {
        Boolean tableLevelDeleteButtonDisbaled = Boolean.FALSE;
        if (!tableLevelDeleteButton.isEnabled()) {
            tableLevelDeleteButtonDisbaled = Boolean.TRUE;
        }
        return tableLevelDeleteButtonDisbaled;
    }

    public boolean addNewProgramButtonVisible() {
        return addNewProgramButton.isDisplayed();
    }

    public int checkCountNumberOfProgramsInTable() {
        return programTableBody.findElements(By.xpath("./child::*")).size();
    }

    public boolean isAllColumnHeaderAvailable() {
        List<String> headerNames = new ArrayList<>();
        headerNames.add("");
        headerNames.add("Program Name");
        headerNames.add("Program Description");
        headerNames.add("Program Status");
        headerNames.add("Edit / Delete");
        List<String> headerNamesFromTableHeader = new ArrayList<>();
        List<WebElement> tableHeaderElements = tableHeader.findElements(By.xpath("./child::*"));
        tableHeaderElements.stream().forEach(x -> headerNamesFromTableHeader.add(x.getText()));
        return CollectionUtils.containsAll(headerNames, headerNamesFromTableHeader);
    }

    public boolean columnHeaderWithSortIcon() {
        List<String> headerNames = new ArrayList<>();
        headerNames.add("Program Name");
        headerNames.add("Program Description");
        headerNames.add("Program Status");
        List<WebElement> headerNamesFromTableHeader = new ArrayList<>();
        List<WebElement> tableHeaderElements = tableHeader.findElements(By.xpath("./child::*"));
        tableHeaderElements.stream().forEach(x -> headerNamesFromTableHeader.add(x));
        headerNamesFromTableHeader.stream().forEach(x -> {
//            if(x.)
            System.out.println(x.getText());
            List<WebElement> childElementsEachHeader = x.findElements(By.xpath("./child::*/p-sorticon"));
//            CollectionUtils.
        });
        return Boolean.TRUE;
    }


    public Boolean isAdminOnManagePramgramPage(){
        Boolean adminOnManageProgramPage = Boolean.FALSE;
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("Manage Program")) {
            adminOnManageProgramPage = Boolean.TRUE;
        }
        return adminOnManageProgramPage;
    }

    public Boolean isSaveAndCancelVisibleInAddProgramPopup(){
        Boolean saveAndCancelVisibleInAddProgramPopup = Boolean.FALSE;
        if(cancelButtonProgramPopup != null && saveButtonProgramPopup != null)
            saveAndCancelVisibleInAddProgramPopup = Boolean.TRUE;
        return saveAndCancelVisibleInAddProgramPopup;
    }

    public void closeEditProgramPopup(){
        closeIconProgramPopup.click();
    }

    public String programCreationMsgValidation() throws InterruptedException {
        WebElement msg = driver.findElement(By.xpath("//p-toast//div[contains(@class, 'p-toast-detail')]"));
        actualMsg=msg.getText();
        return actualMsg;
    }
    public void editProgramNamefield(){
        editProgramName.sendKeys(editProgramName.getText().concat("1"));
    }

    public void updateSearchProgram(){
        searchBoxProgram.sendKeys("lmskb001");
        programEditButton.click();
    }

}
