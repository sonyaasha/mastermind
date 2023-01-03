package wit.comp1050.mastermindjavafx;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class CircleRows {
    private Circle circle;
    private List<Circle> circleRow = new ArrayList<Circle>();

    public CircleRows(){
        super();
    }

    public void setCircleRow(Circle theCircle){
        this.circleRow.add(theCircle);
    }

    public Circle getCircleRow(int idx){
        return this.circleRow.get(idx);
    }

    public List<Circle> getCircleRowsList(){
        return this.circleRow;
    }
}
