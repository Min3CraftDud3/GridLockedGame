package com.SinfulPixel.GridLocked.States;

import com.SinfulPixel.GridLocked.Handlers.GameStateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Min3 on 4/23/2014.
 */
public class Play extends GameState {
    private World world;
    private Box2DDebugRenderer b2dr;
    public Play(GameStateManager gsm) {
        super(gsm);
        world = new World(new Vector2(0,-9.81f),true);
        b2dr = new Box2DDebugRenderer();
        //Create PlatForms / Maps
        BodyDef bdef = new BodyDef();
        bdef.position.set(160, 120);
        bdef.type = BodyDef.BodyType.StaticBody;
        //Static - Not Affected by forces   (Ground)
        //Dynamic - Affected by forces              (Player)
        //kinematic - Not affected by forces                (Moving Platform)
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50,5);
        Body body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);
        //Create falling box
        bdef.position.set(160,200);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);
        shape.setAsBox(5,5);
        fdef.shape = shape;
        fdef.restitution = 1f;
        body.createFixture(fdef);
    }
    public void handleInput() {

    }
    public void update(float dt) {
       world.step(dt,6,2);
    }
    public void render() {
        //CLear Screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Draw World
        b2dr.render(world,cam.combined);
    }
    public void dispose() {

    }
}
