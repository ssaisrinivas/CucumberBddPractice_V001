package com.sai.cucumber;

import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.AddAdminUserinHRM;
import pageObject.LoginPage;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public AddAdminUserinHRM admin;
    public LoginPage lp;
    public Logger logger;
    public Properties prop;

    public static String randomAlphanumericString(int length) {
	String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

	StringBuffer randomString = new StringBuffer(length);
	Random random = new Random();

	for (int i = 0; i < length; i++) {
	    int randomIndex = random.nextInt(alphanumericCharacters.length());
	    char randomChar = alphanumericCharacters.charAt(randomIndex);
	    randomString.append(randomChar);
	}

	return randomString.toString();
    }

}
