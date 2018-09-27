package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.ContollerMenuBar;
import cz.fit.dpo.mvcshooter.controller.ControllerTest;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.sounds.Sound.Sound;
import cz.fit.dpo.mvcshooter.view.MainWindow;
import cz.fit.dpo.mvcshooter.view.View;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author stue
 */

/*  У него ут private model subject
*/
public class Shooter {
    
    public static void main(String[] args) {   
        final Model model = new Model();
        View view = new View(model);
        final ControllerTest controller = new ControllerTest(model, view);
        final ContollerMenuBar bar = new ContollerMenuBar(model);
        model.registerObserver(view);
        controller.runGame();
        
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {               
               new MainWindow(view, controller, model).setVisible(true);
               Sound.playSound("wind.aif").setVolume(21);
            }
        });
    }
}
