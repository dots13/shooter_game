/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.Model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Анастасия
 */
public class Information extends JPanel{
    Model model;

    public Information(Model model, int width, int height) {
        Color myBlue = new Color(2, 30, 42);
        this.model = model;
        this.setBackground(myBlue);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }
    
    public void GuiToRepaint() {
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        // text
        int textx = 15;
        int texty = 10;
        gg.setColor(Color.WHITE);
        gg.setFont(new Font("default", Font.PLAIN, 14));
        for (String s: model.GetText().split("\n")) {
            gg.drawString(s, textx, texty += gg.getFontMetrics().getHeight());
        }
        gg.setFont(new Font("default", Font.BOLD, 22));
        gg.setColor(Color.WHITE);
        gg.drawString("SCOORE", 450, 36);
        gg.drawString(String.valueOf( model.getScore()), 490, 55);
        
        gg.setFont(new Font("default", Font.PLAIN, 18));
        gg.setColor(Color.WHITE);
        gg.drawString(model.getLevel(), 900, 32);
        String enemyCount = "ENEMY: " + model.countEnemy();
        Color enemyColor = (new Color(230, 255-model.countEnemy()*17, 255 - model.countEnemy()*17));
        gg.setColor(enemyColor);
        gg.drawString(enemyCount, 900, 55);
    }
}
