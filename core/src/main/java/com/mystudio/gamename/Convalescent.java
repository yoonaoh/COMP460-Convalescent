package com.mystudio.gamename;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

import java.util.ArrayList;


public class Convalescent extends BasicGame {

    public static final String GAME_IDENTIFIER = "org.mini2Dx.convalescent";

    // Stores the state of the game
    private GameState state = GameState.ATTIC;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private ArrayList<Asset> assets = new ArrayList<Asset>();
    private Asset asset;
    RobotGame robogame = new RobotGame();

//    Music music_level1;
//    Music music_level2;

    private Room texture;

    Avery sprite;
    Inventory inventory;

    @Override
    public void initialise() {
        // Set screen size
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1400, 772);
        camera.position.set(700, 386, 0);
        batch = new SpriteBatch();

        //Load the sprite from an image
        texture = new Room();

//        titleScreen = new Texture("Title.jpeg");

        sprite = new Avery();
        inventory = new Inventory();
        asset = new Asset("trash.png", 675, 222, 100, 100, new float[]{
                583, 772-475,
                893, 772-475,
                949, 772-575,
                539, 772-575});
        assets.add(asset);

//        music_level1 = Gdx.audio.newMusic(Gdx.files.internal("secure.mp3"));
//        music_level1.setLooping(true);
//        music_level1.play();
//        music_level2 = Gdx.audio.newMusic(Gdx.files.internal("Disturbed.mp3"));
//        music_level2.setLooping(true);

    }

    @Override
    public void update(float delta) {
        camera.update();

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//            System.out.println("Cursor at: " + Gdx.input.getX() + ", " + Gdx.input.getY());
            if (Gdx.input.getX() >= 1320 && Gdx.input.getY() >= 650) {
                System.out.println("Inventory is open");
                inventory.display();
            } else if (Gdx.input.getX() >= 600 && Gdx.input.getX() <= 800 && Gdx.input.getY() >= 457 && Gdx.input.getY() <= 557) {
                System.out.println("Game has started");
                robogame.start();
            } else {
                sprite.update(Gdx.input.getX(), Gdx.input.getY(), assets);
            }
        }
        sprite.move(assets);

    }

    @Override
    public void interpolate(float alpha) {

    }

    @Override
    public void render(Graphics g) {

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        // Background
        texture.render(batch);

        //Assets
        asset.render(batch, false);

        // Player Character
        sprite.render(batch);

        // Inventory
        inventory.render(batch);

        // Games
        if (robogame.hasStarted()) {
            robogame.render(batch, g);
        }

        batch.end();




    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
