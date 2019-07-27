package coursework;

import java.util.Random;

public class Match implements Playable {
    private final Player player1;
    private final Player player2;
    private static final int MAX_POINTS = 11;
    public int player1Points = 0;
    public int player2Points = 0;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player playPoint() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return this.player1;
        }
        return this.player2;
    }

    public Player play() {
        while (true) {
            Player winner = this.playPoint();
            if (winner.id == this.player1.id) {
                this.player1Points++;
            } else {
                this.player2Points++;
            }
            if (this.player1Points == MAX_POINTS) {
                return this.player1;
            } else if (this.player2Points == MAX_POINTS) {
                return this.player2;
            }
        }
    }
}
