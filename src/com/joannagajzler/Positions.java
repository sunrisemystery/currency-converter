package com.joannagajzler;

import java.util.List;

public class Positions {

    private List<Position> positionList;

    public Positions(List<Position> positionList) {
        this.positionList = positionList;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public Position getPositionByIndex(int index) {
        if (index >= 0 && index < positionList.size()) {
            return positionList.get(index);
        }
        //returning null to catch NullPointerException in case of choosing the list's index that don't exist.
        return null;
    }

}
