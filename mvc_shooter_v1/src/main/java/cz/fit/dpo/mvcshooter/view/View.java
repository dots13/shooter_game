
package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.observer.Observer;

/**
 *
 * @author Анастасия
 */
public class View extends Observer{
    private Canvas canvas;
    private Information info;
    
    public View(Model model) {
        this.canvas = new Canvas(model, 0, 0, (int)model.getField().getX(), (int)model.getField().getY());
        this.info = new Information(model, (int)model.getField().getX(), 70);
    }
    public Information getInfoCanvas() {
        return info;
    }
    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public void observerNotify() {
        this.canvas.thisIsHowYouForceGuiToRepaint();
        this.info.GuiToRepaint();
    }
    
}
