package com.mystudio.gamename.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mystudio.gamename.utils.GameState;
import com.mystudio.gamename.utils.MainAdapter;
import org.mini2Dx.core.geom.Polygon;

public class View {

    String sceneName;
    Stage stage;
    Group actors;
    Group bg_actors;
    Texture background;
    Polygon floorspace;
    Boolean includesAvery;
    Boolean includesInventory;
    MainAdapter mainAdapter;
    String bgmFile;
    GameState changeToState = null;

    public View(MainAdapter mainAdapter) {
        this.mainAdapter = mainAdapter;
        stage = new Stage(mainAdapter.getViewPort(), mainAdapter.getBatch());
        bg_actors = new Group();
        stage.addActor(bg_actors);
        actors = new Group();
        stage.addActor(actors);
        bgmFile = null;
    }

    public void onOpen() {
    }

    public Polygon getFloorspace() {
        return floorspace;
    }

    public Boolean includesAvery() {
        return includesAvery;
    }

    public Boolean includesInventory() {
        return includesInventory;
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
        try {
            stage.draw();
        } catch (NullPointerException e) {
            System.out.println("Stage null pointer exception");
            stage.getBatch().end();
        }
    }

    public Group getBackground() {
        return bg_actors;
    }

    public String getBGM() {
        return bgmFile;
    }

    public void setChangeToState(GameState prevState) {
        this.changeToState = prevState;
    }

    public void addActor(Actor a) {
        actors.addActor(a);
    }
}
