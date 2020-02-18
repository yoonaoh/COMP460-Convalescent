package com.mystudio.gamename.views;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mystudio.gamename.GameState;
import org.mini2Dx.core.geom.Polygon;

import java.util.function.Consumer;

public class AtticShelf extends ViewTwo {
    public AtticShelf(Camera camera, SpriteBatch batch, final Consumer<GameState> consumer) {
        Stage stage = new Stage(new FitViewport(1280, 720, camera), batch);
        Group actors = new Group();
        Texture background = new Texture("shelf_closeup.png");
        Polygon floorspace = new Polygon(new float[]{});
        Boolean avery = false;
        super.initialise(stage, actors, background, floorspace, avery);


    }
}
