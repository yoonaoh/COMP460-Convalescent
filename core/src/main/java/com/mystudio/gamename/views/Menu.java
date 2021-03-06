package com.mystudio.gamename.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.mystudio.gamename.utils.GameState;
import com.mystudio.gamename.utils.MainAdapter;
import org.mini2Dx.core.geom.Polygon;


public class Menu extends View {
    public Menu(final MainAdapter mainAdapter) {
        super(mainAdapter);
        background = new Texture("views/Title.jpeg");
        floorspace = new Polygon(new float[]{});
        includesAvery = false;
        includesInventory = false;

        Skin skin = mainAdapter.getManager().getSkin();

        // Start button
        final TextButton startButton = new TextButton("START", skin);
        startButton.setBounds(500, 150, 100, 50);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if (changeToState != null && changeToState != GameState.MENU) {
                    mainAdapter.updateState(changeToState);
                    startButton.setChecked(false);
                } else {
                    final Timer timer = new Timer();
                    Timer.Task switchBtn = new Timer.Task() {

                        @Override
                        public void run() {
                            startButton.setText("RESUME");
                            timer.clear();
                        }
                    };
                    timer.scheduleTask(switchBtn, 5);
                    mainAdapter.updateState(GameState.INTRO);
                }
            }

        });

        // Quit button
        TextButton quitButton = new TextButton("QUIT", skin);
        quitButton.setBounds(680, 150, 100, 50);
        quitButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainAdapter.getManager().dispose();
                System.exit(0);
            }

        });

        actors.addActor(startButton);
        actors.addActor(quitButton);

        // Add music
        bgmFile = "sounds/menu.mp3";
    }
}
