package com.projectstorm.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.projectstorm.Game;
import org.ini4j.Ini.*;

import java.io.File;

public class DesktopLauncher {
	static int FPSCap = 60;
	static boolean isFPSCapped = true;
	static boolean isFullscreen = true; //Make sure to change this, so that it does not override user configuration value.
	static boolean isVSyncEnabled = false;
	static boolean isDebugModeOn = false;
	private static boolean displayFPSCount = true;
	static boolean pauseGameWhenNotInFocus = true;
	private static int windowedModeWidth = 1280;
	private static int windowedModeHeight = 720;

	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		initFieldValuesFromINIFile();
		config.title = "Project Storm (W.I.P. LibGDX Build)";
		if(isFullscreen){
			config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
			config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
			config.fullscreen = true;
		}
		else{
			config.width = windowedModeWidth;
			config.height = windowedModeHeight;
			config.fullscreen = false;
		}
		config.vSyncEnabled = isVSyncEnabled;
		if(!isVSyncEnabled){
			if(isFPSCapped){
				config.foregroundFPS = FPSCap;
				if(pauseGameWhenNotInFocus) config.backgroundFPS = -1;
				else config.backgroundFPS = FPSCap;
			}
			else{
				config.foregroundFPS = 0;
				if(pauseGameWhenNotInFocus) config.backgroundFPS = -1;
				else config.backgroundFPS = 0;
			}
		}
		//setFullscreen(true);
		for(String arg : args){
			if(arg.equals("--debug") || arg.equals("-d")) isDebugModeOn = true;
			//else if(arg.equals("--disable_FPS")) displayFPSCount = false; - This does not really work.
		}

		new LwjglApplication(new Game(), config);
	}

	public static void initFieldValuesFromINIFile(){
	    try{
	        Wini configINI = new Wini(new File("Config.ini")); //Use "%AppData%/ProjectStorm/Config.ini"
	        pauseGameWhenNotInFocus = configINI.get("General","pauseGameWhenNotInFocus",boolean.class);
	        isFPSCapped = configINI.get("Video","isFPSCapped",boolean.class);
	        FPSCap = configINI.get("Video","FPSCap",int.class);
	        isFullscreen = configINI.get("Video","isFullscreen",boolean.class);
	        isVSyncEnabled = configINI.get("Video","isVSyncEnabled",boolean.class);
	        windowedModeWidth = configINI.get("Video","windowedModeWidth",int.class);
	        windowedModeHeight = configINI.get("Video","windowedModeHeight",int.class);
        }
	    catch(Exception e){
	    	System.out.println("There was an error in finding the INI file. (Should the file extension be added?)");
	    	//Replace this message with the one from the Game class after initial testing is complete.
		}
    }

	public static int getWindowedModeWidth(){
		return windowedModeWidth;
	}

	public static int getWindowedModeHeight(){
		return windowedModeHeight;
	}

	public static boolean getFPSCountState(){
		return displayFPSCount;
	}
}
