package com.m0n3.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.m0n3.game.FlappyDemo;

/**
 * Created by Андрей on 10.04.2016.
 */
public class GameOver extends State {

    private Texture background;
    private Texture gameOver;
    private BitmapFont font;

    public GameOver(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("bg.png");
        gameOver = new Texture("gameover.png");
        font = new BitmapFont();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        font.draw(sb, "You Score: " +  Integer.toString((int)PlayState.points/10),80,20);
        sb.draw(gameOver, camera.position.x - gameOver.getWidth()/2, camera.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();
        font.dispose();
    }
}
