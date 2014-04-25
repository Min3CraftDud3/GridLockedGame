package com.SinfulPixel.GridLocked.Handlers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import static com.SinfulPixel.GridLocked.Handlers.MyInput.setKey;

/**
 * Created by Min3 on 4/25/2014.
 */
public class MyInputProcessor extends InputAdapter {
    public boolean keyDown(int k){
        if(k == Keys.Z){
            setKey(MyInput.BUTTON1,true);
        }
        if(k == Keys.X){
            setKey(MyInput.BUTTON2,true);
        }
        return true;
    }
    public boolean keyUp(int k){
        if(k == Keys.Z){
            setKey(MyInput.BUTTON1,false);
        }
        if(k == Keys.X){
            setKey(MyInput.BUTTON2,false);
        }
        return true;
    }
}
