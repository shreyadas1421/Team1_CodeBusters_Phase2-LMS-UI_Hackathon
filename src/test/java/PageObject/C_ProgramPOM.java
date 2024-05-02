package PageObject;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.util.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestBase;
import utility.excelDataReader;

import java.time.Duration;
import java.util.*;

public class C_ProgramPOM extends TestBase {

    public excelDataReader datamap;
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
    @FindBy(xpath = "//button[@icon='pi pi-pencil']")
    public WebElement programEditButton;
    @FindBy(xpath = "//div[@class=\"ng-trigger ng-trigger-animation ng-tns-c132-3 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted\"]")
    public WebElement editPopUp;
    @FindBy(xpath = "//input[@id=\"programName\"]")
    public WebElement editProgramName;
    @FindBy(xpath = "//input[@id='programDescription']")
    public WebElement editProgramDescription;
    @FindBy(xpath = "//input[@id=\"filterGlobal\"]")
    public WebElement searchBoxProgram;
    @FindBy(xpath = "//div[@class=\"p-radiobutton p-component p-radiobutton-checked\"]")
    public WebElement statusActiveIconProgram;
    @FindBy(xpath = "//div[@class=\"p-radiobutton-box\"]")
    public WebElement unselectedStatusCheckboxProgram;
    @FindBy(xpath = "//button[@label=\"Cancel\"]")
    public WebElement cancelButtonProgram;
    @FindBy(xpath = "//button[@label=\"Save\"]")
    public WebElement saveButtonProgram;
    @FindBy(xpath = "//input[@id='programName']")
    public WebElement programDetailNameTextBox;
    @FindBy(xpath = "//input[@id='programDescription']")
    public WebElement programDetailDescriptionTextBox;
    @FindBy(xpath = "//div[@class='ng-star-inserted']")
    public WebElement programDetailRadioButtons;
    Map<String, String> excelmap;
    Set hashset = new HashSet();
    String actualMsg = "";
    public String programName = "";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    public void clickProgramLink() {
        program.click();
    }

    public void clickAddNewProgramButton() {
        addNewProgramButton.click();
    }

    public void clickSaveButtonOnAddProgramPopup() {
        saveButtonProgramPopup.click();
    }

    public boolean errorMessagesOnAddProgramPopup() {
        Boolean errorMessagesOnAddProgramPopup = Boolean.FALSE;
        if (errorMessagesAddProgramPopup != null) {
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


    public Boolean isAdminOnManagePramgramPage() {
        Boolean adminOnManageProgramPage = Boolean.FALSE;
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("Manage Program")) {
            adminOnManageProgramPage = Boolean.TRUE;
        }
        return adminOnManageProgramPage;
    }

    public Boolean isSaveAndCancelVisibleInAddProgramPopup() {
        Boolean saveAndCancelVisibleInAddProgramPopup = Boolean.FALSE;
        if (cancelButtonProgramPopup != null && saveButtonProgramPopup != null)
            saveAndCancelVisibleInAddProgramPopup = Boolean.TRUE;
        return saveAndCancelVisibleInAddProgramPopup;
    }

    public void closeEditProgramPopup() {
        closeIconProgramPopup.click();
    }

    public String programCreationMsgValidation() throws InterruptedException {
        WebElement msg = driver.findElement(By.xpath("//p-toast//div[contains(@class, 'p-toast-detail')]"));
        actualMsg = msg.getText();

        return actualMsg;
    }

    public void editProgramNamefield() {
        editProgramName.sendKeys(editProgramName.getText().concat("1"));

    }

    public void addProgramNameField(String startString) {
        String randomString = randomEndForValue();
        editProgramName.sendKeys(startString + randomString);
    }

    public void addProgramDescriptionField(String startString) {
        String randomString = randomEndForValue();
        editProgramDescription.sendKeys(startString + randomString);
    }

    public void updateSearchProgram() {
        searchBoxProgram.clear();
        searchBoxProgram.sendKeys("KB100");
        try {

            wait.wait(3000l);
        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
        programEditButton.click();
    }

    public void editProgramName_Description_SpecialCharacters() {
        editProgramName.sendKeys("&^%&^%&^*^%$^%");
        editProgramDescription.sendKeys("*&^&*^*&@@#%$");
    }

    public void addProgramAllfieldsValidValues() {
        String randomString = randomEndForValue();
        editProgramName.sendKeys("lmskb001" + randomString);
        editProgramDescription.sendKeys("lmskb001" + randomString);
        editStatusIconProgram();
    }

    public String randomEndForValue() {
        String randomString = String.valueOf(Math.random()).replace(".", "").substring(0, 5);
        return randomString;
    }

    public void editProgramDescriptionField() {
        editProgramDescription.sendKeys(editProgramDescription.getText().concat("1"));
    }

    public void editStatusIconProgram() {
        unselectedStatusCheckboxProgram.click();
    }

    public void disappearEditPopupBox() {
        cancelButtonProgramPopup.click();
    }

    // TODO: 5/1/2024 Add logic to verify the propram details being modified
    public boolean isEditPopupVisibleAndContentsChanged() {
        Boolean editPopUpDisappearedAndContentNotChanges = Boolean.TRUE;
        WebElement popup = null;
        try {
//            popup = driver.findElement(By.xpath("//div[@class=\"ng-trigger ng-trigger-animation ng-tns-c132-3 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted\"]"));
            popup = driver.findElement(By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-3 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']"));
        } catch (Exception exception) {
            editPopUpDisappearedAndContentNotChanges = Boolean.FALSE;
        }
        return editPopUpDisappearedAndContentNotChanges;
    }

    public void clickSavebuttonProgram() {
        saveButtonProgram.click();
    }

    public void getSuccessMessageAfterClickEditSavebutton() {
        searchBoxProgram.sendKeys("KB100");
        editProgramNamefield();
        editProgramDescriptionField();
        saveButtonProgram.click();

    }

    public boolean programNameAndDescriptionTextBoxVisible() {
        boolean isProgramNameAndDescriptionTextBoxVisible = Boolean.FALSE;
        if (programDetailDescriptionTextBox != null && programDetailNameTextBox != null) {
            isProgramNameAndDescriptionTextBoxVisible = Boolean.TRUE;
        }
        return isProgramNameAndDescriptionTextBoxVisible;
    }


    public int numberOfRadioButtonsOnAddProgramPopup() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
        return list.size();
    }

    public void readProgramInfoFromExcel(String sheetname, int rowNumber) {
        datamap = new excelDataReader();
        excelmap = datamap.getTestData(sheetname, rowNumber);
        String randomString = randomEndForValue();

        programName = excelmap.get("ProgramName").concat(randomString);

        programDetailNameTextBox.sendKeys(programName);
        programDetailDescriptionTextBox.sendKeys(excelmap.get("ProgramDescription").concat(randomString));
        clickOnRadioButtonOnManageProgramPopup(excelmap.get("Status"));

    }

    public void clickOnRadioButtonOnManageProgramPopup(String statusTobeSelected) {
        List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
        System.out.println("checkbox names are ");
        for (WebElement we : checkboxList) {
            if (statusTobeSelected.equalsIgnoreCase(we.getText())) {
                System.out.println("Inside if condition");
                we.click();
                we.findElement(By.xpath("./child::*")).click();
            }
        }
    }

    public boolean checkForErrorMessage(String errorMessage) {
        List<WebElement> webElementList = driver.findElements(By.xpath("//small[@class='p-invalid ng-star-inserted']"));
        for (WebElement we : webElementList) {
            if (we.getText().equalsIgnoreCase(errorMessage)) return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

}
