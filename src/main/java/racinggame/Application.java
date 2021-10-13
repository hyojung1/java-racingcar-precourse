package racinggame;

import racinggame.controller.PlayController;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {

        PlayController playController = new PlayController();
        playController.playGame();
    }
}
