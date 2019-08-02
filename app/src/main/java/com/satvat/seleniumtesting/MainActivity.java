package com.satvat.seleniumtesting;

import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity {
    private WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws Exception{

        String baseUrl = "";

        String exePath = "D:\\Softwares\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
//        options.addargument('--start-maximized');
//        options.addargument('--start-fullscreen');
        driver.get(baseUrl);

        driver.findElement(By.name("firstname")).sendKeys("Suthishan");
        driver.findElement(By.name("lastname")).sendKeys("Murali");
        driver.findElement(By.name("surname")).sendKeys("Murali");

        Select dropDown = new Select((driver.findElement(By.name("gender"))));
        dropDown.selectByVisibleText("Male");

        WebElement BirthDate = driver.findElement(By.name("dob"));
        BirthDate.clear();
        BirthDate.sendKeys("11/15/1994");

        driver.findElement(By.name("pob")).sendKeys("Gingee");
        driver.findElement(By.name("nationality")).sendKeys("Indian");
        Select maritStatus = new Select(driver.findElement(By.name("marital")));
        maritStatus.selectByVisibleText("Single");

        driver.findElement(By.name("phone")).sendKeys("9751527881");
        driver.findElement(By.name("phone_cug")).sendKeys("8754450435");
        driver.findElement(By.name("email")).sendKeys("sutheshan.shan5@gmail.com");
        driver.findElement(By.name("passport")).sendKeys("878789822");
        driver.findElement(By.name("p_address")).sendKeys("4/121, Pillaiyar Kovil St, " +
                "SN Palayam");
        driver.findElement(By.name("p_address2")).sendKeys("Agaramcherri(PO), Ambur(TK)");
        driver.findElement(By.name("p_address3")).sendKeys("Vellore Dist");
        driver.findElement(By.name("primarydistrict")).sendKeys("Vellore");
        driver.findElement(By.name("primarystate")).sendKeys("Tamil Nadu");
        driver.findElement(By.name("primarypincode")).sendKeys("635804");

        driver.findElement(By.xpath("//label[@for='same']")).click();
        Date d = new Date();
        System.out.println(d.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");         // Your each screenshot will be taken as this format "Year-Month-Date-Hours-Minutes-Seconds"
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,  new File("D:\\docu\\"+sdf.format(d)+".png"));

        WebElement nextButton = driver.findElement(By.xpath("//*[@id='create-account']"));
        nextButton.click();
        driver.findElement(By.id("create-account")).click();
        driver.findElement(By.name("fathername")).sendKeys("Murali");
        driver.findElement(By.name("f_age")).sendKeys("69");
        driver.findElement(By.name("f_edu")).sendKeys("Degree");
        driver.findElement(By.name("f_edu")).sendKeys("Degree");
        driver.findElement(By.name("f_ocup")).sendKeys("Ex-Army");
        Select dependent = new Select(driver.findElement(By.name("f_depnt")));
        dependent.selectByVisibleText("NO");

        driver.findElement(By.name("mothername")).sendKeys("Thamilarasi");
        driver.findElement(By.name("m_age")).sendKeys("65");
        driver.findElement(By.name("m_edu")).sendKeys("M.Phil");
        driver.findElement(By.name("m_ocup")).sendKeys("Government Teacher");

        Select mdepentdent = new Select(driver.findElement(By.name("m_depnt")));
        mdepentdent.selectByVisibleText("NO");
        WebElement fanextButton = driver.findElement(By.xpath("//*[@id='create-account']"));
        fanextButton.click();
        driver.findElement(By.id("create-account")).click();


        WebElement photo = driver.findElement(By.xpath("//*[@id='profileImg']"));
//        element.click();

//        WebElement photo = driver.findElement(By.className("avatarsize"));
//        WebElement photo = driver.findElement(By.id("photo-preview"));
        photo.sendKeys("E:\\SUTHISHAN\\Suthishan\\MY Documents\\suthish-20kb.jpg");
        driver.switchTo().activeElement();
        if (driver.switchTo().activeElement().isEnabled()) {
            System.out.println("Test");
            driver.findElement(By.xpath("//div[@class='p-1 text-center']/span[@class='btn btn-success upload-result']")).click();
//            driver.findElement(By.xpath("//*[@class='btn btn-success upload-result']/span")).click();
//            driver.findElement(By.className("btn btn-success upload-result")).click();
        } else {
            System.out.println("Test not");
        }

        WebElement sign = driver.findElement(By.xpath("//*[@id='signImg']"));
        sign.sendKeys("E:\\SUTHISHAN\\Suthishan\\MY Documents\\suthish-20kb-sign.jpg");
        driver.switchTo().activeElement();
        if (driver.switchTo().activeElement().isEnabled()) {
            System.out.println("Test");
            driver.findElement(By.xpath("//div[@class='p-1 text-center']/span[@class='btn btn-success upload-result-sign']")).click();
//            driver.findElement(By.xpath("//*[@class='btn btn-success upload-result']/span")).click();
//            driver.findElement(By.className("btn btn-success upload-result")).click();
        } else {
            System.out.println("Test not");
        }
        WebElement photonextButton = driver.findElement(By.xpath("//*[@id='create-account']"));
        photonextButton.click();
        driver.findElement(By.id("create-account")).click();

        driver.findElement(By.name("education1")).sendKeys("SSLC");
        driver.findElement(By.name("yearpass1")).sendKeys("2010");
        driver.findElement(By.name("institude1")).sendKeys("Shiksha Kendra Matric Hr Sec School");
        driver.findElement(By.name("subject1")).sendKeys("Computer");
        driver.findElement(By.name("grade1")).sendKeys("73.45");

        Select schoolspe = new Select(driver.findElement(By.name("course1")));
        schoolspe.selectByVisibleText("Regular");

        driver.findElement(By.name("education2")).sendKeys("HSC");
        driver.findElement(By.name("yearpass2")).sendKeys("2012");
        driver.findElement(By.name("institude2")).sendKeys("Bethel Matric HR Sec School");
        driver.findElement(By.name("subject2")).sendKeys("Computer Science");
        driver.findElement(By.name("grade2")).sendKeys("74.5");
        Select hscspe = new Select(driver.findElement(By.name("course2")));
        hscspe.selectByVisibleText("Regular");

        driver.findElement(By.name("education3")).sendKeys("BE");
        driver.findElement(By.name("yearpass3")).sendKeys("2016");
        driver.findElement(By.name("institude3")).sendKeys("Gnanamani College of Engineering");
        driver.findElement(By.name("subject3")).sendKeys("Computer Science Engineering");
        driver.findElement(By.name("grade3")).sendKeys("70.5");
        Select collegespe = new Select(driver.findElement(By.name("course3")));
        collegespe.selectByVisibleText("Regular");

//        public boolean checkIfElementIsExpanded(int number) {
//            WebElement textElement = driver.findElement(By.xpath("//div[@class='accordionItem']"));
//
////        WebElement textElement = driver.findElement(By.xpath(("//*[@id='accordion']/div[" + number + "]/div[2]")));
//            return textElement.isDisplayed();
//        }

//        WebElement expanded = driver.findElement(By.xpath("//div[@class='accordionItemHeading']"));
//        expanded.click();

//        if(driver.findElement(By.xpath("//div[@class='accordionItem']")).isDisplayed()){
//            System.out.println("test");
//        }else{
//            System.out.println("test sdfjk");
//
//        }//*[@id="rms-wizard"]/div/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div/div/div[2]/h4
//        driver.findElement(By.xpath("//*[@class='col-md-12']/div/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div/div/div[2]/h4")).click();
//        driver.findElement(By.xpath("*//h4[@class='accordionItemHeading']")).click();
//        driver.findElement(By.xpath("*//div[2][@class='accordionItemHeading']")).click();

        driver.findElement(By.name("lastcompany")).sendKeys("Dezineguru");
        driver.findElement(By.name("start_salary")).sendKeys("10,000");
        driver.findElement(By.name("leav_salary")).sendKeys("12,000");
        driver.findElement(By.name("start_desgn")).sendKeys("Designer");
        driver.findElement(By.name("leav_desgn")).sendKeys("Web Designer");
        driver.findElement(By.name("work_from")).sendKeys("2016");
        driver.findElement(By.name("work_to")).sendKeys("2017");
        driver.findElement(By.name("work_fun")).sendKeys("Html, Css");
        driver.findElement(By.name("reason_leav")).sendKeys("Learn New technologies");



//        List checkbox = driver.findElements(By.xpath("//label[@for='radio-42']"));

        driver.findElement(By.xpath("//label[@for='radio-42']")).click();
        driver.findElement(By.xpath("//label[@for='radio-43']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-44']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-45']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-46']")).click();
        driver.findElement(By.xpath("//label[@for='radio-47']")).click();
        driver.findElement(By.xpath("//label[@for='radio-48']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-49']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-50']")).click();
        driver.findElement(By.xpath("//label[@for='radio-51']")).click();
        driver.findElement(By.xpath("//label[@for='radio-52']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-53']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-54']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-55']")).click();
//        driver.findElement(By.xpath("//label[@for='radio-56']")).click();


//        List checkbox  = driver.findElement(By.xpath("//label[@for='radio-42']"));
//        int count = checkbox.size();
//
//
//        for(int i=0; i<count;i++){
//            String value = checkbox.get(i).toString();
//            System.out.println("str"+value);
//            WebElement checkTam = (WebElement) checkbox.get(i);
//            checkTam.getAttribute("value");
//            System.out.println(checkTam.getAttribute("value"));
////            if(checkTam.getAttribute("value").equalsIgnoreCase("1")){
////                checkTam.click();
////            }
//
////            if (value.equalsIgnoreCase(""))
//
//        }

        WebElement edunextButton = driver.findElement(By.xpath("//*[@id='create-account']"));
        edunextButton.click();

        driver.findElement(By.name("refer_name")).sendKeys("Test Person");
        driver.findElement(By.name("refer_desgn")).sendKeys("Test");
        driver.findElement(By.name("refer_company")).sendKeys("Test Company");
        driver.findElement(By.name("refer_landline")).sendKeys("");
        driver.findElement(By.name("refer_mobile")).sendKeys("9545454655");
        driver.findElement(By.name("refer_mail")).sendKeys("Test65@gmail.com");
        driver.findElement(By.name("refer_address")).sendKeys("Test Address");


        driver.findElement(By.xpath("//label[@for='radio-57']")).click();
        driver.findElement(By.xpath("//label[@for='radio-58']")).click();
        driver.findElement(By.xpath("//label[@for='radio-59']")).click();

        WebElement othernextButton = driver.findElement(By.xpath("//*[@id='create-account']"));
        othernextButton.click();

        JavascriptExecutor jexec = (JavascriptExecutor) driver;
        boolean isScrollBarPresent = (boolean) jexec.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
        long scrollHeight = (long) jexec.executeScript("return document.documentElement.scrollHeight");
        long clientHeight = (long) jexec.executeScript("return document.documentElement.clientHeight");
        int fileIndex = 1;
        if (driver instanceof ChromeDriver) {
            if (isScrollBarPresent) {
                while (scrollHeight > 0) {
                    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    org.apache.commons.io.FileUtils.copyFile(srcFile, new File("D:\\docu\\" + File.separator + fileIndex + ".jpg"));
                    jexec.executeScript("window.scrollTo(0," + clientHeight * fileIndex++ + ")");
                    scrollHeight = scrollHeight - clientHeight;
                }
            } else {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                org.apache.commons.io.FileUtils.copyFile(srcFile, new File("D:\\docu\\" + File.separator + fileIndex + ".jpg"));
            }
        } else {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(srcFile, new File("D:\\docu\\" + File.separator + fileIndex + ".jpg"));
        }

//        driver.findElement(By.linkText("#")).click();
        driver.findElement(By.className("print")).click();

//        for(int i=0;i<checkbox.size();i++){
//            value = checkbox.get(i).getAttribute("value");
////            if(Value.equalsIgnoreCase("Option 1"))
////                Checkbox.get(i).click();
//        }

//        List<WebElement> chkBx_Profession = driver.findElements(By.name("tam_radio[]"));
//        int iSize = chkBx_Profession.size();
//        for(int i=0; i < iSize ; i++ ){
//            // Store the Check Box name to the string variable, using 'Value' attribute
//            String sValue = chkBx_Profession.get(i).getAttribute("value");
//
//            System.out.println(sValue);
//
//            if(sValue.equalsIgnoreCase("1")){
//                chkBx_Profession.get(i).click();
//                if(chkBx_Profession.get(i).isSelected()){
//                    System.out.println("check success");
//                }else{
//                    System.out.println("check fail");
//                }
//                System.out.println(chkBx_Profession.get(i).isSelected());
//                System.out.println("Success");
//            }else{
//                System.out.println("Fail");
//            }

        // Select the Check Box it the value of the Check Box is same what you are looking for
//            if (sValue.equalsIgnoreCase("1")){
//                chkBx_Profession.get(i).click();
//                // This will take the execution out of for loop
//                break;
//            }
    }

//        driver.findElement(By.id("tam_radio[]")).click();
//        driver.findElement(By.xpath("//*[@id='tam_radio[]']")).click();
//        if(driver.findElement(By.id("//*[@id='tam_radio[]']")).isSelected()){
//            System.out.println("checked");
//        }else{
//            System.out.println("unchecked");
//        }


    //div[@class=game-date-time]/span[@data-behavior='date_time']

//        driver.findElement(By.className("div[@class=modal upload-wrap/div[@class=modal-dialog/div[@class=modal-content/div[@class=row/div[@class=col-md-12/div[@class=p-1 text-center/span[@class=btn btn-success upload-result")).click();
//        driver.findElement(By.xpath("//span[contain(text(), 'Done']")).click();


//        boolean tcCheckIsDisplayed = tcCheckbox.isDisplayed();
//        System.out.println("Is Terms and condition checkbox displayed: "+tcCheckIsDisplayed);
//        boolean tcCheckboxIsEnabled = tcCheckbox.isEnabled();
//        System.out.println("Is Terms and condition checkbox enabled: "+tcCheckboxIsEnabled);
//        boolean tcCheckboxIsSelected = tcCheckbox.isSelected();
//        System.out.println("Default Terms and Condition checkbox status: "+tcCheckboxIsSelected);
//        tcCheckbox.click();
//        boolean tcCheckboxNewStatus = tcCheckbox.isSelected();
//        System.out.println("Terms and Condition checkbox status after perform click() event: "+tcCheckboxNewStatus);


//        driver.findElement(By.linkText("btnsubmit")).click();


//        Date
//        Thread.sleep(3000);
//        driver.quit();
}

