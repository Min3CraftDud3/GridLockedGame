package com.SinfulPixel.GridLocked.Handlers;

import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Min3 on 4/25/2014.
 */
public class MyContactListener implements ContactListener {
    private boolean playerOnGround;
    //Called When 2 Fixtures Start to Collide
    public void beginContact(Contact c) {
        Fixture fa = c.getFixtureA();
        Fixture fb = c.getFixtureB();
        if(fa.getUserData() != null && fa.getUserData().equals("foot")){
            playerOnGround = true;
        }
        if(fb.getUserData() != null && fb.getUserData().equals("foot")){
            playerOnGround = true;
        }
    }
    //Called When 3 Fixtures are no longer colliding
    public void endContact(Contact c) {
        Fixture fa = c.getFixtureA();
        Fixture fb = c.getFixtureB();
        if(fa.getUserData() != null && fa.getUserData().equals("foot")){
            playerOnGround = false;
        }
        if(fb.getUserData() != null && fb.getUserData().equals("foot")){
            playerOnGround = false;
        }
    }
    public boolean isPlayerOnGround(){return playerOnGround;}






    //Collision Detection
    //PreSolve
    //Collision Handling
    //PostSolve
    public void preSolve(Contact c, Manifold m) {}
    public void postSolve(Contact c, ContactImpulse ci) {}
}
