import java.util.Map;

public class Main {

    public static void main(String[] args) {

        MontyHall game = new MontyHall();
        int numGames = 1000;
        game.playMultipleGames(numGames);
        Map<String, Integer> stats = game.getStats();

        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Процент побед: " + game.winPercent() + "%");
        System.out.println("Процент поражений: " + game.lossPercent() + "%");

    }

}
