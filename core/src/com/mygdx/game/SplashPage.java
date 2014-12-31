package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class SplashPage extends ApplicationAdapter {
	SpriteBatch batch;
    TextButton button;
	Texture img;
    Texture img2;
    Texture img3;
    Sprite sprite;
    Stage stage;
    TextButton.TextButtonStyle textButtonStyle;//make a textbutton style : fonts, etc
    BitmapFont font;
    Skin skin;
    Texture texture;
    TextureAtlas buttonAtlas;
	
	@Override
	public void create () {
        skin = new Skin();
        stage = new Stage();
        batch = new SpriteBatch();
        font = new BitmapFont();
        Gdx.input.setInputProcessor(stage);
        img = new Texture("backgrounder.png");
        img2 = new Texture(Gdx.files.internal("logoLibgdx.png"));
        img3 = new Texture(Gdx.files.internal("box2dlogo.png"));
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.pack"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;

        textButtonStyle.up = skin.getDrawable("nextbutton");
        textButtonStyle.down = skin.getDrawable("nextbuttonpressed");
        textButtonStyle.checked = skin.getDrawable("nextbuttonpressed");
        button = new TextButton("", textButtonStyle);
        stage.addActor(button);
        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println("Button Pressed");
            }
        });
    }

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        batch.draw(sprite,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
	}
}
