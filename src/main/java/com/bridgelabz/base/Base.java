/**
 * Description : News_Heading.java is test file which is having test cases for News_Heading.
 * Author      : mayur mansukh
 * Date        : 12/06/2021
 */

package com.bridgelabz.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Base {
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://news.ycombinator.com/");
    }
}
