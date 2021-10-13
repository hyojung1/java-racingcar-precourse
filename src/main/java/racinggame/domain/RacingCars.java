package racinggame.domain;

import racinggame.common.Constant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RacingCars {
    private List<Car> carList;

    public RacingCars(List<Car> carList) {
        validateRacingCars(carList);
        this.carList = carList;
    }

    private void validateRacingCars(List<Car> carList) {
        if (carList.size() < 2) {
            throw new IllegalArgumentException(Constant.ERROR_MIN_CAR_COUNT);
        }

        HashSet<String> hashSet = new HashSet<>(this.getNameList(carList));
        if (hashSet.size() != carList.size()) {
            throw new IllegalArgumentException(Constant.ERROR_CAR_NAME_DUPLICATE);
        }
    }

    // 자동차이름 리스트 리턴
    public List<String> getNameList(List<Car> carList) {
        List<String> nameList = new ArrayList<>();
        for (Car targetCar : carList) {
            nameList.add(targetCar.getName());
        }

        return nameList;
    }

    // 현재 스코어 출력
    public String getCurrentRacingScore() {
        StringBuffer sb = new StringBuffer();

        List<Car> currentList = this.getCarList();
        for (Car car : currentList) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(this.getMoveStep(car.getCntMove()));
            sb.append("\r\n");
        }

        return sb.toString();
    }

    // 랜덤수 4이상인 경우 move++
    private String getMoveStep(int cntMove) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cntMove; i ++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public List<Car> getCarList() {
        return carList;
    }

}
