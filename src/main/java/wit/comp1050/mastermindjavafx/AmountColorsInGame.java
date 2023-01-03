package wit.comp1050.mastermindjavafx;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class AmountColorsInGame {
    private List<Circle> coloredCircleOptionsList = new ArrayList<Circle>();

    public AmountColorsInGame(){
        super();
    }

    public void setColoredCircleClicked(Circle coloredCircleAdded){
        this.coloredCircleOptionsList.add(coloredCircleAdded);
    }

    public Circle theCircleClicked(int idx){
        return this.coloredCircleOptionsList.get(idx);
    }

    public List<Circle> returnColoredCircleOptionsList(){
        return this.coloredCircleOptionsList;
    }
}
