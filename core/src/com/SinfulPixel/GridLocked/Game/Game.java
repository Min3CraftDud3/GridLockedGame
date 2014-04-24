package com.SinfulPixel.GridLocked.Game;

import com.SinfulPixel.GridLocked.Handlers.GameStateManager;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Min3 on 4/22/2014.
 */
public class Game implements ApplicationListener {
    public static final String TITLE = "GridLocked";
    public static final int V_HEIGHT = 240;
    public static final int V_WIDTH = 320;
    public static final int SCALE = 2;
    public static final float STEP = 1/60f;
    private float accum;
    private SpriteBatch sb;
    private OrthographicCamera cam;
    private OrthographicCamera hudCam;
    private GameStateManager gsm;

    public void create(){
        sb = new SpriteBatch();
        cam = new OrthographicCamera();
        cam.setToOrtho(false, V_WIDTH,V_HEIGHT);
        hudCam = new OrthographicCamera();
        hudCam.setToOrtho(false,V_WIDTH,V_HEIGHT);
        gsm = new GameStateManager(this);
    }
    public void render(){
        accum += Gdx.graphics.getDeltaTime();
        while(accum>=STEP){
            accum -= STEP;
            gsm.update(STEP);
            gsm.render();
        }
    }
    public void resize(int width, int height){}

    public SpriteBatch getSpriteBatch(){return sb;}
    public OrthographicCamera getCamera(){return cam;}
    public OrthographicCamera getHUDCamera(){return hudCam;}



    public void pause(){}
    public void resume(){}
    public void dispose(){}
}
