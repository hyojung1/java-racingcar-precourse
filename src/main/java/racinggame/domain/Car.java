package racinggame.domain;

import racinggame.common.Constant;

public class Car {
    private String name;
    private int cntMove;
    private int numCurrentRandom;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.cntMove = 0;
    }

    private void validateNameLength(String name) {
        if (name.length() > Constant.MAX_LENGTH_CAR_NAME) {
            throw new IllegalArgumentException(Constant.ERROR_CAR_NAME_OVER_LENGTH);
        }
    }

    public Car moveCarByRandomNum(Car car, int randomNum) {
        if (randomNum < Constant.MOVE_CONDITION) {
            return car;
        }

        car.addMove();
        return car;
    }

    public void addMove() {
        this.cntMove ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCntMove() {
        return cntMove;
    }

    public void setCntMove(int cntMove) {
        this.cntMove = cntMove;
    }

    public int getNumCurrentRandom() {
        return numCurrentRandom;
    }

    public void setNumCurrentRandom(int numCurrentRandom) {
        this.numCurrentRandom = numCurrentRandom;
    }
}
