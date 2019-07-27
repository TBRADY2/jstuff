package coursework;

import java.util.ArrayList;
import java.util.List;

public class Tournament implements Playable {
    private List<Player> players = new ArrayList<>();

    public Tournament(int players) {
        for (int i = 0; i < players; i++) {
            this.players.add(new Player(i));
        }
    }

    public Player play() {
        return Tournament.playRound(this.players);
    }

    public static Player playRound(List<Player> players) {
        List<Player> winners = new ArrayList<>();
        for (int i = 0; i + 1 < players.size(); i+= 2) {
            Player player1 = players.get(i);
            Player player2 = players.get(i + 1);
            Match match = new Match(player1, player2);
            Player winner = match.play();
            System.out.println(String.format("Between %d and %d. %d won! %d-%d",
                    player1.id,
                    player2.id,
                    winner.id,
                    match.player1Points,
                    match.player2Points
            ));
            winners.add(winner);
        }
        if (winners.size() == 1) {
            return winners.get(0);
        }
        return Tournament.playRound(winners);



    }
}
