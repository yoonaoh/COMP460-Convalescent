package com.mystudio.gamename.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mystudio.gamename.utils.MainAdapter;
import org.mini2Dx.core.geom.Polygon;

public class View {

    Stage stage;
    Group actors;
    Texture background;
    Polygon floorspace;
    Boolean includesAvery;
    MainAdapter mainAdapter;

    public View(MainAdapter mainAdapter) {
        this.mainAdapter = mainAdapter;
        stage = new Stage(mainAdapter.getViewPort(), mainAdapter.getBatch());
        actors = new Group();
        stage.addActor(actors);
    }

    public void initialise() {}

    public Polygon getFloorspace() {
        return floorspace;
    }

    public Boolean includesAvery() {
        return includesAvery;
    }

    public Group getActors() {
        return actors;
    }

    public Stage getStage() {
        return stage;
    }

    public void drawBackground() {
        stage.getBatch().begin();
        stage.getBatch().draw(this.background, 0, 0, stage.getWidth(), stage.getHeight());
        stage.getBatch().end();
    }

    public void drawStage() {
        stage.draw();
    }
}
