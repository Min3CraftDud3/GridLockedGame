package com.SinfulPixel.GridLocked.Handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Created by Min3 on 4/25/2014.
 */
public class MyContactListener implements ContactListener {
    //Called When 2 Fixtures Start to Collide
    public void beginContact(Contact c) {
        System.out.println("Begin Contact");

    }
    //Called When 3 Fixtures are no longer colliding
    public void endContact(Contact c) {
        System.out.println("End Contact");
    }







    //Collision Detection
    //PreSolve
    //Collision Handling
    //PostSolve
    public void preSolve(Contact c, Manifold m) {}
    public void postSolve(Contact c, ContactImpulse ci) {}
}
