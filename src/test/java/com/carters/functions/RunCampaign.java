package com.carters.functions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/**
 * Class RunCampaign utility functions related to RunCampaign functionality.
 * Uses web driver to trigger the campaign run from the URL configured in key 'run_campaign_url' the env.properties.
 *
 * @author raghu
 */
public class RunCampaign {

    private static final Logger logger = LogManager.getLogger("RunCampaign");
    public static final String TXT_USER_ID = "txtUserID";
    public static final String TXT_PASSWORD = "txtPassword";
    public static final String SUB = "sub";
    private static String HEADLESS_OPTIONS = "--headless";
    private static String SUCCESS_MESSAGE = "Ready for Automation";

    /**
     * Initiates and schedule campaign run in CDH.
     *
     * @throws IOException thrown if the web driver not able to scrape the page.
     */
//    public void runCampaign(String env) throws IOException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments(HEADLESS_OPTIONS);
//        chromeOptions.addArguments("--remote-allow-origins=*");
        //WebDriver driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        String url = PropertyUtils.properties.getProperty(env + "." + "run_campaign_url");
//        logger.info("runCampaign->run_campaign_url :"+url);
//        driver.get(url);
//        WebElement userIDBox = driver.findElement(By.id(TXT_USER_ID));
//        WebElement txtPassword = driver.findElement(By.id(TXT_PASSWORD));
//        WebElement submitBtn = driver.findElement(By.id(SUB));
//        userIDBox.sendKeys(PropertyUtils.properties.getProperty(env + "." + "prweb_username"));
//        txtPassword.sendKeys(PropertyUtils.properties.getProperty(env + "." + "prweb_password"));
//        logger.info("runCampaign->Before Triggering submit to run campaign");
//        submitBtn.click();
//        logger.info(driver.getPageSource());
//    }
}
