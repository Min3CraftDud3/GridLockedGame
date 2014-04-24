package com.SinfulPixel.GridLocked.States;

import com.SinfulPixel.GridLocked.Handlers.GameStateManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Min3 on 4/23/2014.
 */
public class Play extends GameState {
    private World world;
    public Play(GameStateManager gsm) {
        super(gsm);
        world = new World(new Vector2(0,-9.81f),true);
    }
    public void handleInput() {

    }
    public void update(float dt) {

    }
    public void render() {

    }
    public void dispose() {

    }
}
