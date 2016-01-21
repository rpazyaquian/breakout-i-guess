package com.retrocombine.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by rpaz on 1/20/16.
 */
public class MainScreen implements Screen {

    public int width = 640;
    public int height = 480;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private GameInput gameInput;
    public World gameWorld;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();

        camera.setToOrtho(false);
        batch.setProjectionMatrix(camera.combined);

        this.gameInput = new GameInput();
        this.gameWorld = new World(width, height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameWorld.tick(delta);
        renderWorld();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private void renderWorld() {
        Bricks bricks = gameWorld.bricks;
        Ball ball = gameWorld.ball;
        Paddle paddle = gameWorld.paddle;

        batch.begin();

        for (Brick brick:
             bricks.bricks) {
            batch.draw(brick.texture, brick.position.x, brick.position.y, brick.size.w, brick.size.h);
        }

        batch.draw(ball.texture, ball.position.x, ball.position.y, ball.size.w, ball.size.h);
        batch.draw(paddle.texture, paddle.position.x, paddle.position.y, paddle.size.w, paddle.size.h);

        batch.end();
    }
}
