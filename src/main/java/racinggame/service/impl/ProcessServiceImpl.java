package racinggame.service.impl;

import nextstep.utils.Console;
import racinggame.common.Constant;
import racinggame.domain.Car;
import racinggame.domain.Racing;
import racinggame.domain.RacingCars;
import racinggame.domain.Round;
import racinggame.service.ProcessService;
import racinggame.service.RuleService;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ProcessServiceImpl implements ProcessService {

    private RuleService ruleService = new RuleServiceImpl();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    @Override
    public void startGame() throws Exception {
        //init
        RacingCars racingCars = initCars();
        Round round = initRound();

        //round loop
        outputView.returnGameStartMsg();
        Racing racing = ruleService.playNewRound(new Racing(), racingCars, round);

        //get winner
        if (racing.isFinish()) {
            String winners = racing.getLatestWinner(racingCars.getCarList());
            if (winners.isEmpty()) {
                throw new IllegalStateException(Constant.ERROR_NONE_WINNER);
            }
            outputView.returnGameWinnerMsg(winners);
        }
    }

    // 레이싱을 위한 자동차 셋팅
    private RacingCars initCars() {
        String answer = inputView.getRacingCarsName();
        StringTokenizer st = new StringTokenizer(answer, ",");

        List<Car> carList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            carList.add(new Car(st.nextToken()));
        }
        RacingCars racingCars = new RacingCars(carList);
        return racingCars;
    }

    // 레이싱을 위한 시도횟수 셋팅
    private Round initRound() {
        String strRound = inputView.getCntRacingRound();
        Round round = new Round(strRound);
        return round;
    }
}
