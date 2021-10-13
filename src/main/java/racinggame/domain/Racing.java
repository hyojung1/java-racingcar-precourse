package racinggame.domain;

import racinggame.common.Constant;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private boolean isFinish = false;
    private int cntFastestMove;

    // 최종 우승자 리턴
    public String getLatestWinner(List<Car> carList) {
        if (!this.isFinish) {
            throw new IllegalArgumentException(Constant.ERROR_NOT_END);
        }

        List<String> fastestList = new ArrayList<>();
        for (Car car : carList) {
            if (this.getCntFastestMove() == car.getCntMove()) {
                fastestList.add(car.getName());
            }
        }

        String fastestListCommaSeparated = String.join(",", fastestList);
        return fastestListCommaSeparated;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public int getCntFastestMove() {
        return cntFastestMove;
    }

    public void setCntFastestMove(int cntFastestMove) {
        this.cntFastestMove = cntFastestMove;
    }
}
