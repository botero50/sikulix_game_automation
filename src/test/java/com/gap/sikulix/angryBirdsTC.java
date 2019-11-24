package com.gap.sikulix;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class angryBirdsTC {

	@Test
	public void test() throws FindFailed, InterruptedException{
		//page to test http://freeangrybirdsgame.org/play/angry_birds_online.html
		
		Screen s = new Screen();
        String imagePath = "src/imgs/angryBirds/";
        //Type Selection
    	s.click(imagePath + "play.png", 0);
    	//Hide Message
    	s.click(imagePath + "poachedEggs.png", 0);

    	s.click(imagePath + "poachedEggsLevel1.png", 0);

    	Thread.sleep(5000);
    	s.dragDrop(imagePath + "redBird.png", imagePath +  "poachedEggsLevel1DropGrass.png");
    	
    	s.wait(imagePath + "clearRegion.png",20000).click();
    	
    	assertNotNull("Score is not returning the expected value", s.wait(imagePath + "poachedEggsLevel1Score.png"));
    	
    	assertNotNull("Three Stars is not present", s.wait(imagePath + "ThreeStars.png"));
    	
    	s.click(imagePath + "nextLevel.png", 0);
    	
    	Thread.sleep(5000);
    	s.dragDrop(imagePath + "redBird.png", imagePath +  "poachedEggsLevel2DropGrass.png");
    	
    	s.wait(imagePath + "clearRegion.png",20000).click();
    	
    	assertNotNull("Score is not returning the expected value", s.wait(imagePath + "poachedEggsLevel2Score.png"));
    	
    	assertNotNull("Three Stars is not present", s.wait(imagePath + "ThreeStars.png",5000));
	}

}
