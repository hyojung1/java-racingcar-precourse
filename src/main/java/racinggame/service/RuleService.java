package racinggame.service;

import racinggame.domain.Racing;
import racinggame.domain.RacingCars;
import racinggame.domain.Round;

public interface RuleService {

    Racing playNewRound(Racing racing, RacingCars racingCars, Round round) throws Exception;

}
