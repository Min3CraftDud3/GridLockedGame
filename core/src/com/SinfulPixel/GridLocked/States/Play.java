package com.SinfulPixel.GridLocked.States;

import com.SinfulPixel.GridLocked.Game.Game;
import com.SinfulPixel.GridLocked.Handlers.GameStateManager;
import com.SinfulPixel.GridLocked.Handlers.MyContactListener;
import com.SinfulPixel.GridLocked.Handlers.MyInput;
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
    private Body playerBody;
    private MyContactListener cl;

    public Play(GameStateManager gsm) {
        super(gsm);
        world = new World(new Vector2(0,-9.81f),true);
        cl = new MyContactListener();
        world.setContactListener(cl);
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
        fdef.filter.maskBits = BIT_PLAYER;
        body.createFixture(fdef).setUserData("ground");

        //Create falling box
        bdef.position.set(160/PPM,200/PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        playerBody = world.createBody(bdef);
        shape.setAsBox(5/PPM,5/PPM);
        fdef.shape = shape;
        fdef.filter.categoryBits = BIT_PLAYER;
        fdef.filter.maskBits = BIT_GROUND;
        playerBody.createFixture(fdef).setUserData("player");

        //Create Foot Sensor
        shape.setAsBox(2/PPM,2/PPM, new Vector2(0,-5/PPM),0);
        fdef.shape = shape;
        fdef.filter.categoryBits = BIT_PLAYER;
        fdef.filter.maskBits = BIT_GROUND;
        fdef.isSensor = true;
        playerBody.createFixture(fdef).setUserData("foot");

        //Setup Camera
        b2dCam = new OrthographicCamera();
        b2dCam.setToOrtho(false, Game.V_WIDTH/PPM,Game.V_HEIGHT/PPM);
    }
    public void handleInput() {
        //Jump
        if(MyInput.isPressed(MyInput.BUTTON1)){
            if(cl.isPlayerOnGround()){
                playerBody.applyForceToCenter(0,200,true);
            }
        }
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
