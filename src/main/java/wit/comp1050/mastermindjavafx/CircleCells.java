package wit.comp1050.mastermindjavafx;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class CircleCells {
    private List<CircleRows> circleCellsList= new ArrayList<CircleRows>();

    public CircleCells(){
        super();
    }

    public void setCircleCell(CircleRows circleRow){
        circleCellsList.add(circleRow);
    }

    public void setCircleCell(int idx, CircleRows circleRow){
        circleCellsList.add(idx, circleRow);
        System.out.println("setCircleCell " + idx);
    }

    public CircleRows getCircleCell(int idx){
        return this.circleCellsList.get(idx);
    }

    public List<CircleRows> getCircleCellsList(){
        return this.circleCellsList;
    }
}
