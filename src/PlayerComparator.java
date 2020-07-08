import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;


class Player {
    String name;

    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else {
            return p2.score - p1.score;
        }
    }

    @Test
    public void testComparator() {
        Player[] players = new Player[3];

        players[0] = new Player("ydgd",100);
        players[1] = new Player("yewbf",890);
        players[2] = new Player("mgfg",78);

        PlayerComparator comparator = new PlayerComparator();

        Arrays.sort(players, comparator);

        for(Player p : players) {
            System.out.println(p.name + " " +  p.score);
        }

    }
}
