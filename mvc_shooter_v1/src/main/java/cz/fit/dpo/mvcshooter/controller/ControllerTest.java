package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.view.MainWindow;
import cz.fit.dpo.mvcshooter.view.View;

import java.awt.event.KeyEvent;

/**
 *
 * @author Анастасия
 */
public class ControllerTest {
    
    private Model model;
    private View view;

    private boolean GOING_UP = false;
    private boolean GOING_DOWN = false;
    private boolean TURNING_LEFT = false;
    private boolean TURNING_RIGHT = false;
    private boolean HOLDING_SPACE = false;

    public ControllerTest(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    private void handleInput() {
        if(GOING_UP) {
            model.getCannon().carry(-1);
        }
        if(GOING_DOWN) {
            model.getCannon().carry(1);
        }
        if(TURNING_LEFT) {
            model.getCannon().turn(-1);
        }
        if(TURNING_RIGHT) {
            model.getCannon().turn(1);
        }
    }

    public void runGame() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                model.tick();
                handleInput();
            }
        });
        thread.start();
    }

    public void handleKeyboardPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                GOING_UP = true;
                break;
            case KeyEvent.VK_DOWN:
                GOING_DOWN = true;
                break;
            case KeyEvent.VK_LEFT:
                TURNING_LEFT = true;
                break;
            case KeyEvent.VK_RIGHT:
                TURNING_RIGHT = true;
                break;
            case KeyEvent.VK_SPACE:
                if(!HOLDING_SPACE) {
                    HOLDING_SPACE = true;
                    this.model.startShooting();
                }
                break;
            case KeyEvent.VK_O:
                model.addGravity(-1);
                break;
            case KeyEvent.VK_P:
                model.addGravity(1);
                break;
        }
    }

    public void handleKeyboardReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                GOING_UP = false;
                break;
            case KeyEvent.VK_DOWN:
                GOING_DOWN = false;
                break;
            case KeyEvent.VK_LEFT:
                TURNING_LEFT = false;
                break;
            case KeyEvent.VK_RIGHT:
                TURNING_RIGHT = false;
                break;
            case KeyEvent.VK_SPACE:
                model.releaseShooting();
                HOLDING_SPACE = false;
                break;
        }

    }
    ///////////////
    
}
