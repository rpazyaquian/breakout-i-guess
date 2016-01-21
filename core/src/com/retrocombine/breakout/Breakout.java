package com.retrocombine.breakout;

import com.badlogic.gdx.Game;

public class Breakout extends Game {

	@Override
	public void create() {
        MainScreen mainScreen = new MainScreen();
        setScreen(mainScreen);
	}
}
