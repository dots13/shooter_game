package cz.fit.dpo.mvcshooter.model.objects.cannon;
import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.factory.AbstractObjFactory;
import cz.fit.dpo.mvcshooter.model.objects.cannon.state.CannonState;
import cz.fit.dpo.mvcshooter.model.objects.cannon.state.DoubleState;
import cz.fit.dpo.mvcshooter.model.objects.cannon.state.SingleState;
import cz.fit.dpo.mvcshooter.model.objects.cannon.state.SuperState;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import cz.fit.dpo.mvcshooter.model.objects.objects;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;
import java.util.List;

/**
 *
 * @author Анастасия
 */
public class Cannon extends objects {
    private AbstractObjFactory objFactory;
    private CannonState state;
    private ActiveState activeState;
    
    private static enum ActiveState {
        SINGLE,
        DOUBLE,
        SUPER
    }
   
    public Cannon(Coordinates field) {
        super();
        size.setX(25);
        size.setY(69);
        location.setX(25);
        location.setY(field.getY() / 2);
        setDoubleState();
    }
    
    public Cannon() {}

    public Cannon clone() {
        Cannon cannon = new Cannon();
        cannon.setAs(this);
        if (activeState == ActiveState.SINGLE) {
            cannon.setSingleState();
        } else {
            cannon.setDoubleState();
        }
        return cannon;        
    }
    
    public void setSingleState() {
        this.activeState = ActiveState.SINGLE;
        this.state = new SingleState();
    }

    public void setDoubleState() {
        this.activeState = ActiveState.DOUBLE;
        this.state = new DoubleState();
    }
    
    public void setSuperState() {
        this.activeState = ActiveState.SUPER;
        this.state = new SuperState();
    }

    public void swapStates() {
        
        if (activeState == ActiveState.DOUBLE) {
            setSingleState();
        } else  {
            setDoubleState();
        }
    }
    
    public String getState(){
        return activeState.toString();
    }
    public void setState(String state) {
        this.activeState = ActiveState.valueOf(state);
        if ("DOUBLE".equals(state))
            this.state = new DoubleState();
        else
            this.state = new SingleState();
    }

    public void setFactory(AbstractObjFactory objFactory) {
        this.objFactory = objFactory;
    }

    public AbstractObjFactory getObjFactory() {
        return objFactory;
    }

    public List<Missile> fire(int power) {
        return state.fire(this, power);
    }

    @Override
    public synchronized boolean move(Coordinates battlefield, double gravity) {
        mooving.diminish(1.2);
     //   angle =0;
        return super.move(battlefield, gravity);
    }

    public synchronized void carry(int value) {
        mooving.addY(3 * value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCannon(this);
    }

    public String getUserMsg() {
        String msg = "";
        msg += "Sling state: ";
        if (activeState == ActiveState.SINGLE) {
            msg += "single";
        } else if (activeState == ActiveState.DOUBLE) {
            msg += "double";
        }
        return msg;
    }

}
