package racinggame.domain;

import racinggame.common.Constant;

public class Round {
    private int cntMaxRound;

    public Round(String strRound) {
        validateInput(strRound);
        this.cntMaxRound = Integer.parseInt(strRound);
    }

    private void validateInput(String strRound) {

        String regExp = "^[0-9]+$";
        if (!strRound.matches(regExp)) {
            throw new IllegalArgumentException(Constant.ERROR_ONLY_NUMBER);
        }
    }

    public void setCntMaxRound(int cntMaxRound) {
        this.cntMaxRound = cntMaxRound;
    }

    public int getCntMaxRound() {
        return cntMaxRound;
    }

}
