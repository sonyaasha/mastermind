package wit.comp1050.mastermindjavafx;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RectangleClass {

    private List<Circle> fourCircleList;

    public RectangleClass(List<Circle> circleList){
        super();
        this.fourCircleList = circleList;
    }

    public void setListCircle(int idx, Circle circle){
        this.fourCircleList.add(idx, circle);
    }

    public List<Circle> getListCircle(){
        return this.fourCircleList;
    }

    public List<Circle> getListCircleV1(){
        int idx = this.fourCircleList.size();
        List<Circle> sortedCircleList = this.fourCircleList;
        for(Circle circle : this.fourCircleList){
            sortedCircleList.set(idx-1, circle);
            idx--;
        }
        return sortedCircleList;
    }
}
