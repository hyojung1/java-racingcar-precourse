package racinggame.controller;

import racinggame.service.ProcessService;
import racinggame.service.impl.ProcessServiceImpl;

public class PlayController {

    public void playGame() {
        try {
            ProcessService processService = new ProcessServiceImpl();
            processService.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
