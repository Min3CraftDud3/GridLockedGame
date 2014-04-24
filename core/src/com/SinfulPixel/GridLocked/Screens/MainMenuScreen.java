package com.SinfulPixel.GridLocked.Screens;

import com.SinfulPixel.GridLocked.Game.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Created by Min3 on 4/22/2014.
 */
public class MainMenuScreen implements Screen {
    Game game;
    public MainMenuScreen(Game game){
        this.game = game;
    }
    @Override
    public void render(float delta) {
    //Update and Draw
        if(Gdx.input.justTouched()){
           // game.setScreen(game.SplashScreenTitle);
        }
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
