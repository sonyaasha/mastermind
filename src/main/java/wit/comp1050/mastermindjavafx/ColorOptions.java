package wit.comp1050.mastermindjavafx;

import java.util.ArrayList;
import java.util.List;

public class ColorOptions {
    private List<String> colorsInOrderList = new ArrayList<String>();

    public ColorOptions(){
        colorsInOrderList.add("#f94892"); //0 pink
        colorsInOrderList.add("#c667c9"); //1 purple
        colorsInOrderList.add("#fbdf07"); //2 yellow
        colorsInOrderList.add("#5763ff"); //3 navy
        colorsInOrderList.add("#89cffd"); //4 blue
        colorsInOrderList.add("#53bf9d"); //5 green
        colorsInOrderList.add("#ff862f"); //6 orange
        colorsInOrderList.add("#febe8c"); //7 peach
    }

    public String theColorFromList(int idx){
        return colorsInOrderList.get(idx);
    }

    public List<String> colorsInOrder(){
        return colorsInOrderList;
    }

}
