package PageObject;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestBase;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class C_ProgramPOM {

   public WebDriver driver;

//    public C_ProgramPOM(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    public void SetDriver(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

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


    public void clickProgramLink() {
        program.click();
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

//    public boolean columnHeaderWithSortIcon() {
//        List<String> headerNames = new ArrayList<>();
//        headerNames.add("Program Name");
//        headerNames.add("Program Description");
//        headerNames.add("Program Status");
//        List<WebElement> headerNamesFromTableHeader = new ArrayList<>();
//        List<WebElement> tableHeaderElements = tableHeader.findElements(By.xpath("./child::*"));
//        tableHeaderElements.stream().forEach(x -> headerNamesFromTableHeader.add(x));
//        headerNamesFromTableHeader.stream().forEach(x -> {
////            if(x.)
//            System.out.println(x.getText());
//            List<WebElement> childElementsEachHeader = x.findElements(By.xpath("./child::*/p-sorticon"));
//            CollectionUtils.
//        });
//        return Boolean.TRUE;
//    }


    public Boolean isAdminOnManagePramgramPage(){
        Boolean adminOnManageProgramPage = Boolean.FALSE;
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("Manage Program")) {
            adminOnManageProgramPage = Boolean.TRUE;
        }
        return adminOnManageProgramPage;
    }
}
