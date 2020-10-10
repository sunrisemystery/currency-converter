package com.joannagajzler;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    private List<Position> positionList = new ArrayList<>();

    public void addToList(Position position) {
        positionList.add(position);
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public Position getPositionByIndex(int index) {
        if (index >= 0 && index < positionList.size()) {
            return positionList.get(index);
        }
        return null;
    }

}
