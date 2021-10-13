package racinggame.service.impl;

import nextstep.utils.Randoms;
import racinggame.domain.Car;
import racinggame.domain.Racing;
import racinggame.domain.RacingCars;
import racinggame.domain.Round;
import racinggame.service.RuleService;
import racinggame.view.OutputView;

public class RuleServiceImpl implements RuleService {

    private static int CURRENT_ROUND = 0;
    private OutputView outputView = new OutputView();

    @Override
    public Racing playNewRound(Racing racing, RacingCars racingCars, Round round) throws Exception {

        try {
            CURRENT_ROUND ++;

            // 게임 종료 확인
            if (round.getCntMaxRound() < CURRENT_ROUND) {
                racing.setFinish(true);
                return racing;
            }

            // 랜덤수 배정 및 전진
            this.moveCars(racingCars);

            // 현재 가장 빠른 전진횟수 셋팅
            this.getCntFastestMove(racing, racingCars);

            // 끝날때까지 재귀
            if (!racing.isFinish()) {
                // 현재 스코어 출력
                String currentRacingScore = racingCars.getCurrentRacingScore();
                outputView.returnCurrentScore(currentRacingScore);

                this.playNewRound(racing, racingCars, round);
            }

        } catch (Exception e) {
            throw new Exception();
        }

        return racing;
    }

    private void getCntFastestMove(Racing racing, RacingCars racingCars) {
        int cntMove = 0;
        for (Car car : racingCars.getCarList()) {
            cntMove = Math.max(cntMove, car.getCntMove());
        }

        racing.setCntFastestMove(cntMove);
    }

    private void moveCars(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            car.moveCarByRandomNum(car, randomNum);
        }
    }
}
