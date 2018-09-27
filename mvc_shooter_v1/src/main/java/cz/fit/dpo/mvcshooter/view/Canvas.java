package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.objects.objects;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.sounds.Sound.Sound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel { 
    GraphicsDrawer drawer = new GraphicsDrawer();
    Model model;
    private BufferedImage FonIIm;
    
 public Canvas(Model model, int x, int y, int width, int height) {
        Color myBlue = new Color(230, 241, 246);
        this.model = model;
        this.setBackground(myBlue);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }
    
    public void thisIsHowYouForceGuiToRepaint() {        
        repaint();
    }
// Можно через итераор. Модель является контейнером. В моделе сделать 
//getIteraator() и длаьше обращаться к методам next, get
// ДЛя начала нальдь чрез объекты и приклей визитор нормально. Посмотри для чего receiver
// Для комманд эффективее иметь 2 коллекции на обработаные и нет. Там с Мементо, и тоже читаем. 
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);    
//        drawer.drawCannon(g,new Cannon());
//        drawer.drawEnemy(g, new DefEnemy());
//    }
    @Override
    protected void paintComponent(Graphics g) {
        try {
            FonIIm = ImageIO.read(getClass().getResourceAsStream("/images/Fon.png"));
        } catch (IOException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.paintComponent(g);
        // objects
        if (!model.endOfGame()){
            g.drawImage(FonIIm,0,0, 1000, 700,this);
            for (objects o: model.getObjects()) {
            drawer.drawGameObject(g, o);
            }
        }
        else {
            Sound endGame = new Sound("christmas.aif");
            Color myRed = new Color(208, 0, 0);
            g.setFont(new Font("default", Font.BOLD, 46));
            g.setColor(myRed);
         //   g.drawImage(img, WIDTH, WIDTH, this) merry christmas
            g.drawString("THE END", 410, 260);
            g.setFont(new Font("default", Font.BOLD, 66));
            g.setColor(myRed);
            g.drawString("Merry Christmas", 260, 380);
            if (!endGame.isPlaying())
                endGame.stop();
            
        }
        
    }
}