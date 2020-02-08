package com.mystudio.gamename.robotgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class MouseMonitor {

    boolean dragging = false;
    Vector2 dragStartPos = null;
    DraggableCircle caught = null;

    public MouseMonitor() {}

    public void update() {
        if (leftKeyDown()) {
            dragging = true;
            dragStartPos = pos();
        } else if (dragging) {
            dragging = false;
            dragStartPos = null;
        }
    }

    public void updateInteractables(ArrayList<DraggableCircle> interactables) {
        if (dragging) {
            if (caught != null) {
                caught.handleDrag(this);
            } else {
                for (DraggableCircle interactable: interactables) {
                    if (interactable.collideWith(dragStartPos) && !interactable.fixed) {
                        caught = interactable;
                        break;
                    }
                }
            }
        } else if (caught != null) {
            caught.stopDrag(interactables);
            caught = null;
        }

    }

    public boolean leftKeyDown() {
        return Gdx.input.isButtonPressed(Input.Buttons.LEFT);
    }

    public int x() {
        return Gdx.input.getX();
    }

    public int y() {
        return 720 - Gdx.input.getY();
    }

    public Vector2 pos() {
        return new Vector2(x(), y());
    }
}
