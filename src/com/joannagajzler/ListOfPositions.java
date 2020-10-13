package com.joannagajzler;

import java.util.ArrayList;
import java.util.List;

public class ListOfPositions {

    private List<Position> positionList = new ArrayList<>();

    public List<Position> getPositionList() {
        return positionList;
    }

    public Position getPositionByIndex(int index) {

        if (index < 0 || index >= positionList.size()) {
            //throwing NullPointerException in case of choosing the index that doesn't exist in a list.
            throw new NullPointerException();
        } else {
            return positionList.get(index);
        }

    }
}
