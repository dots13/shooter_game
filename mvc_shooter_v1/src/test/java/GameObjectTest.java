
import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.cannon.Cannon;
import cz.fit.dpo.mvcshooter.model.objects.objects;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Анастасия
 */
public class GameObjectTest {
     @Test
    public void visitingTest() throws Exception {
        MockLocationVisitor visitor = new MockLocationVisitor();
        Cannon cannon = new Cannon();
        cannon.accept(visitor);
        double initialY = visitor.getLocation().getY();
        cannon.carry(1);
        cannon.move(new Coordinates(500,500), 0);
        cannon.accept(visitor);
        double movedY = visitor.getLocation().getY();
        assert initialY != movedY;
    }

    @Test
    public void testCollision() throws Exception {
        objects ractangle1 = new objects();
        objects ractangle2 = new objects();
        ractangle1.location = new Coordinates(0.5,0.5);
        ractangle1.size = new Coordinates(1,1);
        ractangle2.location = new Coordinates(1.5,1.5);
        ractangle2.size = new Coordinates(1,1);
        assert ractangle1.collides(ractangle2) == false;
        ractangle2.location = new Coordinates(1,1);
        assert ractangle1.collides(ractangle2) == true;
    }
}
