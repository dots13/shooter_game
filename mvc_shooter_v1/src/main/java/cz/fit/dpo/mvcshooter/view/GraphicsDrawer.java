package cz.fit.dpo.mvcshooter.view;
import cz.fit.dpo.mvcshooter.model.objects.objects;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer {
    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;
    
    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage enemyImage3;
    private BufferedImage enemyImageBoss;    
    private BufferedImage missileImage;
    private BufferedImage collisionImage;
 

    public GraphicsDrawer() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/images/microb_1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/images/microb_1.png"));
            enemyImage3 = ImageIO.read(getClass().getResourceAsStream("/images/microb_2.png"));
            enemyImageBoss = ImageIO.read(getClass().getResourceAsStream("/images/microb_boss.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    public static enum Image {
        CANNON,
        ENEMY1,
        ENEMY2,
        ENEMY3,
        ENEMY_BOSS,
        MISSILE,
    }    
    
    private BufferedImage getImage(Image image) {
        switch (image) {
            case CANNON:
                return cannonImage;
            case ENEMY1:
                return enemyImage1;
            case ENEMY2:
                return enemyImage1;
            case ENEMY3:
                return enemyImage3;
            case ENEMY_BOSS:
                return enemyImageBoss;
            case MISSILE:
                return missileImage;
        }
        return collisionImage;
    }
    
    public void drawGameObject(Graphics g, objects object) {
        GrVisitor visitor = new GrVisitor();
        object.accept(visitor);

        // image rotation
        double rotationRequired = visitor.getAngle();
        double locationX = visitor.getSize().getX()/2;
        double locationY = visitor.getSize().getY()/2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
//*/
        g.drawImage(op.filter(getImage(visitor.getImage()), null), (int)visitor.getLocation().getX(), (int)visitor.getLocation().getY(), null);
    }

}
