package com.SinfulPixel.GridLocked;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GridLocked extends ApplicationAdapter {
	SpriteBatch batch;
	Texture logo;
    //Texture title;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		logo = new Texture("Sinful640480.png");
        //title = new Texture("GridLocked_Logo.png");
       // MySQLAccess dao = new MySQLAccess();
       // try{dao.readDataBase();}catch(Exception i){}
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(logo, 0, 0);
       // try{batch.wait(5);}catch(Exception i){}
        batch.end();
       /* Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(title, 0, 0);
        batch.end();     */
	}
}
