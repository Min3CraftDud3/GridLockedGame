package com.SinfulPixel.GridLocked.States;

import com.SinfulPixel.GridLocked.Game.Game;
import com.SinfulPixel.GridLocked.Handlers.GameStateManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Min3 on 4/23/2014.
 */
public abstract class GameState {
    protected GameStateManager gsm;
    protected Game game;
    protected SpriteBatch sb;
    protected OrthographicCamera cam;
    protected OrthographicCamera hudCam;
    protected GameState(GameStateManager gsm){
        this.gsm = gsm;
        game = gsm.game();
        sb = game.getSpriteBatch();
        cam = game.getCamera();
        hudCam = game.getHUDCamera();
    }
    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();
}
