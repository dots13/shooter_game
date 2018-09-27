/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.Model;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Анастасия
 */
public class ContollerMenuBar {
    private static Model model;
     
    public ContollerMenuBar(Model model) {
        this.model = model;
    }
    public static JMenuBar createGUI() {         
  
        Font font = new Font("Verdana", Font.PLAIN, 12);         
        JMenuBar menuBar = new JMenuBar();
         
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);
        
        fileMenu.addSeparator();
        
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        newGame.setFont(font);
        fileMenu.add(newGame);
        
        JMenuItem newLevel = new JMenuItem("New Level");
        newLevel.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        newLevel.setFont(font);
        fileMenu.add(newLevel);
         
        JMenuItem saveGame = new JMenuItem("Save Game");
        saveGame.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveGame.setFont(font);
        fileMenu.add(saveGame);
        
        JMenuItem loadGame = new JMenuItem("Load Game");
        loadGame.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        loadGame.setFont(font);
        fileMenu.add(loadGame);         
         
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        exitItem.setFont(font);
        fileMenu.add(exitItem);
        
        JMenu settingMenu = new JMenu("Settings");
        settingMenu.setFont(font);
        
        settingMenu.addSeparator();
        
        JMenuItem addEnemy = new JMenuItem("Add Enemy");
        addEnemy.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        addEnemy.setFont(font);
        settingMenu.add(addEnemy);
        
        JMenu swapMode = new JMenu("Mode");
        swapMode.setFont(font);
        settingMenu.add(swapMode);
        
        JMenuItem simpleMode = new JMenuItem("Simple");
        simpleMode.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        simpleMode.setFont(font);
        swapMode.add(simpleMode);
        
        JMenuItem realisticMode = new JMenuItem("Realistic");
        realisticMode.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        realisticMode.setFont(font);
        swapMode.add(realisticMode);
        
        JMenu swapCannon = new JMenu("Swap Cannon");
        swapCannon.setFont(font);
        settingMenu.add(swapCannon);
        
        JMenuItem singleCannon = new JMenuItem("Single");
        singleCannon.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        singleCannon.setFont(font);
        swapCannon.add(singleCannon);
        
        JMenuItem dubleCannon = new JMenuItem("Double");
        dubleCannon.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        dubleCannon.setFont(font);
        swapCannon.add(dubleCannon);
         
        exitItem.addActionListener((ActionEvent e) -> {
            System.exit(0);           
        });
        
        newGame.addActionListener((ActionEvent e) -> {
            model.resetObjects(true);           
        });
        newLevel.addActionListener((ActionEvent e) -> {
            model.resetObjects(false);           
        });        
        saveGame.addActionListener((ActionEvent e) -> {
            model.saveGame();
        });
        loadGame.addActionListener((ActionEvent e) -> {
            model.loadGame();
        });
        loadGame.addActionListener((ActionEvent e) -> {
            model.spawnEnemy();
        });
        singleCannon.addActionListener((ActionEvent e) -> {
            model.singleCannon();
        });
        dubleCannon.addActionListener((ActionEvent e) -> {
            model.doubleState();
        });
        simpleMode.addActionListener((ActionEvent e) -> {
            model.setSimpleMode();
        });
        realisticMode.addActionListener((ActionEvent e) -> {
            model.setRealisticMode();
        });
        addEnemy.addActionListener((ActionEvent e) -> {
            model.spawnEnemy();
        });
        menuBar.add(fileMenu);
        menuBar.add(settingMenu);
        return menuBar;
                 
    }
 //   public static JMenuBar getBar(){
 //       return createGUI(); addEnemy
 //   }
    public void actionPerformed(ActionEvent e) {
        //...Get information from the action event...
        //...Display it in the text area...
    }
    
}
