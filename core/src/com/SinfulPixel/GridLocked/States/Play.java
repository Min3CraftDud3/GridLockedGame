package com.SinfulPixel.GridLocked.States;

import com.SinfulPixel.GridLocked.Game.Game;
import com.SinfulPixel.GridLocked.Handlers.GameStateManager;
import com.SinfulPixel.GridLocked.Handlers.MyContactListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import static com.SinfulPixel.GridLocked.Handlers.B2DVars.*;

/**
 * Created by Min3 on 4/23/2014.
 */
public class Play extends GameState {
    private World world;
    private Box2DDebugRenderer b2dr;
    private OrthographicCamera b2dCam;

    public Play(GameStateManager gsm) {
        super(gsm);
        world = new World(new Vector2(0,-9.81f),true);
        world.setContactListener(new MyContactListener());
        b2dr = new Box2DDebugRenderer();
        //Create PlatForms / Maps
        BodyDef bdef = new BodyDef();
        bdef.position.set(160/PPM, 120/PPM);
        bdef.type = BodyDef.BodyType.StaticBody;
        //Static - Not Affected by forces   (Ground)
        //Dynamic - Affected by forces              (Player)
        //kinematic - Not affected by forces                (Moving Platform)

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50/PPM,5/PPM);
        Body body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fdef.filter.categoryBits = BIT_GROUND;
        fdef.filter.maskBits = BIT_BOX | BIT_BALL;
        body.createFixture(fdef).setUserData("ground");

        //Create falling box
        bdef.position.set(160/PPM,200/PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        shape.setAsBox(5/PPM,5/PPM);
        fdef.shape = shape;
        fdef.filter.categoryBits = BIT_BOX;
        fdef.filter.maskBits = BIT_GROUND;
        body.createFixture(fdef).setUserData("box");

        //Create Ball
        bdef.position.set(153/PPM,220/PPM);
        body = world.createBody(bdef);
        CircleShape cshape = new CircleShape();
        cshape.setRadius(5/PPM);
        fdef.shape = cshape;
        fdef.filter.categoryBits = BIT_BALL;
        fdef.filter.maskBits = BIT_GROUND;
        body.createFixture(fdef).setUserData("ball");

        //Setup Camera
        b2dCam = new OrthographicCamera();
        b2dCam.setToOrtho(false, Game.V_WIDTH/PPM,Game.V_HEIGHT/PPM);
    }
    public void handleInput() {

    }
    public void update(float dt) {
        handleInput();
       world.step(dt,6,2);
    }
    public void render() {
        //CLear Screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Draw World
        b2dr.render(world,b2dCam.combined);
    }
    public void dispose() {

    }
}
