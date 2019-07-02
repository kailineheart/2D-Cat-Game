package com.mygdx.calliespaceadventure.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.calliespaceadventure.main.CallieGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//makes the config file
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//setting game screen size and title
		config.title = CallieGame.TITLE;
		config.width = CallieGame.V_WIDTH;
		config.height = CallieGame.V_HEIGHT;
		
		new LwjglApplication(new CallieGame(), config);
	}
}
