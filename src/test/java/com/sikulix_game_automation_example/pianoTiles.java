package com.sikulix_game_automation_example;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class pianoTiles {

	@Test
	public void test() throws FindFailed, InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();  
        driver.get("http://www.pianotiles.org/");
        
        String imagePath = "src/imgs/pianoTiles/";
        
        //Type Selection
    	new Screen().doubleClick(imagePath + "/classic.png", 0);
    	//Hide Message
    	new Screen().click(imagePath + "/dontTouchMessage.png", 0);
    	
    	Thread.sleep(500);
    	Match MPrincipal= new Screen().exists(imagePath + "/principal.png",0);
    	Region reg = new Region(MPrincipal.x , MPrincipal.y-150, MPrincipal.w+10, MPrincipal.h+10);

        try{
        	reg.click(imagePath + "/startTile.png", 0);
        	while(reg.exists(imagePath + "/end.png",0) == null)
        	{
        		Thread.sleep(500);
	        	if( reg.exists(imagePath + "/f.png",0) != null)
	        		reg.click(imagePath + "/f.png", 0);
	        	else if( reg.exists(imagePath + "/d.png",0) != null)
	        		reg.click(imagePath + "/d.png", 0);
	        	else if( reg.exists(imagePath + "/s.png",0) != null)
	        		reg.click(imagePath + "/s.png", 0);
	        	else if( reg.exists(imagePath + "/a.png",0) != null)
	        		reg.click(imagePath + "/a.png", 0);
        	}
        }
        catch(FindFailed e)
        {
        	e.printStackTrace();
        	driver.quit();
        }
        driver.quit();
	}

}
