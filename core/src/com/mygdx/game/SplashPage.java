//Adding 15-second timer to your game's splash screen (libgdx)
//Source: http://atsiitech.blogspot.ca/2013/09/adding-15-second-timer-to-your-games.html

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
import com.badlogic.gdx.utils.Timer;

public class SplashPage extends ApplicationAdapter {
    SpriteBatch batch;
    private boolean timerIsOn = false;
    Texture img;
    Texture img2;
    Texture img3;
    Texture[] tile = new Texture[3];
    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    int nColour = 1;
    Sound sound;
    Texture TempImg;
    @Override
    public void create () {
        batch = new SpriteBatch();
        stage = new Stage();
        tile[0] = new Texture(Gdx.files.internal("backgrounder.png"));
        tile[1] = new Texture(Gdx.files.internal("logoLibgdx.png"));
        tile[2] = new Texture(Gdx.files.internal("box2dlogo.png"));

        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas("button.pack"); // assign the pack file
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("UP");
        textButtonStyle.down = skin.getDrawable("DOWN");
        textButtonStyle.checked = skin.getDrawable("UP");
        button = new TextButton("", textButtonStyle);
        button.setSize(Gdx.graphics.getWidth()/10,Gdx.graphics.getWidth()/10);
        button.setPosition(1600,0);
        stage.addActor(button);
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                TempImg = tile[0];
                for(int i = 0;i<tile.length-1;i++){
                    tile[i]=tile[i+1];

                }
                tile[tile.length -1] = TempImg;
            }


                /*img3 = img;
                img = img2;
                img2 = img3;*/


        });
    }




    @Override
    public void render () {
        batch.begin();

        batch.draw(tile[0], 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.draw();
        if(!timerIsOn) {
            timerIsOn = true;

            Timer.schedule(new Timer.Task() {

                @Override
                public void run() {
                    TempImg = tile[0];
                    for(int i = 0;i<tile.length-1;i++){
                        tile[i]=tile[i+1];

                    }
                    tile[tile.length -1] = TempImg;
                }

            }, 3);

        } else if(button.isPressed()) {
            // Remove the task so we don't call changeScreen twice:
            Timer.instance().clear();

        }
    }

    }

