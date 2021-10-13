package racinggame.view;

public class OutputView {
    
    public void returnGameStartMsg() {
        System.out.println("실행결과");
    }

    public void returnGameWinnerMsg(String winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자는 ");
        sb.append(winners);
        sb.append(" 입니다.");
        System.out.print(sb.toString());
    }

    public void returnErrorMsg(String message) {
        System.out.print(message);
    }

    public void returnCurrentScore(String currentRacingScore) {
        System.out.println(currentRacingScore);
    }
}
