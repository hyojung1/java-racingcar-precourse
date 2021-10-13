package racinggame.view;

import nextstep.utils.Console;
import racinggame.common.Constant;

import java.util.NoSuchElementException;

public class InputView {
    public String getRacingCarsName() {
        System.out.println(Constant.INPUT_GET_CARS);
        String answer = Console.readLine();

        if (answer.isEmpty()) {
            throw new NoSuchElementException(Constant.ERROR_CAR_NAME);
        }

        return answer;
    }

    public String getCntRacingRound() {
        System.out.println(Constant.INPUT_GET_ROUND);
        String answer = Console.readLine();

        if (answer.isEmpty()) {
            throw new NoSuchElementException(Constant.ERROR_COUNT_ROUND);
        }

        return answer;
    }
}
