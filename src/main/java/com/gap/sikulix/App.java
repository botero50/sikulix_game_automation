package com.gap.sikulix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class App 
{
	static WebDriver driver;
	/*test case for Piano Tiles : http://www.pianotiles.org/*/
    public static void main( String[] args ) throws FindFailed, InterruptedException
    {
		System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();  
        driver.get("http://www.pianotiles.org/");
        
        //Type Selection
    	new Screen().doubleClick("src/imgs/classic.png", 0);
    	//Hide Message
    	new Screen().click("src/imgs/dontTouchMessage.png", 0);
    	
    	Thread.sleep(500);
    	Match MPrincipal= new Screen().exists("src/imgs/principal.png",0);
    	Region reg = new Region(MPrincipal.x , MPrincipal.y-150, MPrincipal.w+10, MPrincipal.h+10);

        try{
        	reg.doubleClick("src/imgs/startTile.png", 0);
        	while(reg.exists("src/imgs/end.png",0) == null)
        	{
        		Thread.sleep(500);
	        	if( reg.exists("src/imgs/f.png",0) != null)
	        		reg.click("src/imgs/f.png", 0);
	        	else if( reg.exists("src/imgs/d.png",0) != null)
	        		reg.click("src/imgs/d.png", 0);
	        	else if( reg.exists("src/imgs/s.png",0) != null)
	        		reg.click("src/imgs/s.png", 0);
	        	else if( reg.exists("src/imgs/a.png",0) != null)
	        		reg.click("src/imgs/a.png", 0);
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
