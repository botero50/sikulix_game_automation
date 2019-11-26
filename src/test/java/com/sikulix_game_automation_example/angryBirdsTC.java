package com.sikulix_game_automation_example;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class angryBirdsTC {

	@Test
	public void test() throws FindFailed, InterruptedException{
		//page to test http://freeangrybirdsgame.org/play/angry_birds_online.html
		
		Screen s = new Screen();
        String imagePath = "src/imgs/angryBirds/";
        
        //Type Selection
    	s.doubleClick(imagePath + "play.png");
    	//Hide Message
    	s.click(s.wait(new Pattern(imagePath + "poachedEggs.png").similar((float) 0.6), 180) );

    	s.click(s.wait(new Pattern(imagePath + "poachedEggsLevel1.png").similar((float) 0.6), 180) );

    	Thread.sleep(5000);
    	s.dragDrop(imagePath + "redBird.png", s.wait(new Pattern(imagePath +"poachedEggsLevel1DropGrass.png").similar((float) 0.6), 10000));
    	
    	s.wait(imagePath + "clearRegion.png",20000).click();

    	assertNotNull("Three Stars is not present", s.wait(imagePath + "ThreeStars.png"));
    	
    	s.click(imagePath + "nextLevel.png");
    	
    	Thread.sleep(5000);
    	
    	Match dropGrass= new Screen().exists(imagePath +  "poachedEggsLevel1DropGrass.png");
    	Region reg = new Region(dropGrass.x -100, dropGrass.y-20, dropGrass.w+10, dropGrass.h+10);
    	
    	s.dragDrop(imagePath + "redBird.png", reg);
    	
    	s.wait(imagePath + "clearRegion.png",20000).click();

    	assertNotNull("Three Stars is not present", s.wait(imagePath + "ThreeStars.png"));
	}

}
