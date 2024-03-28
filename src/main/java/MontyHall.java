import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
public class MontyHall {

    private int totalGames;
    private int wins;
    private int losses;
    private Random random;

    public MontyHall() {
        this.totalGames = 0;
        this.wins = 0;
        this.losses = 0;
        this.random = new Random();
    }

    public void playGame() {
        int prizeDoor = random.nextInt(3);
        int chosenDoor = random.nextInt(3);
        int openedDoor;
        int changedDoor;

        do {
            openedDoor = random.nextInt(3);
        } while (openedDoor == prizeDoor || openedDoor == chosenDoor);

        do {
            changedDoor = random.nextInt(3);
        } while (changedDoor == chosenDoor || changedDoor == openedDoor);

        totalGames++;

        if (changedDoor == prizeDoor) {
            wins++;
        } else {
            losses++;
        }
    }

    public void playMultipleGames(int numGames) {
        for (int i = 0; i < numGames; i++) {
            playGame();
        }
    }

    public double winPercent() {
        return (double) wins / totalGames * 100;
    }

    public double lossPercent() {
        return (double) losses / totalGames * 100;
    }

    public Map<String, Integer> getStats() {
        Map<String, Integer> results = new HashMap<>();
        results.put("Побед", wins);
        results.put("Поражений", losses);
        return results;
    }

}
