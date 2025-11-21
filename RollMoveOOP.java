import java.util.*;

class Player {
    String name;
    int pos = 0, score = 0;

    Player(String n) { name = n; }

    void move(int d) { pos = (pos + d) % 20; }
}

class Board {
    int reward(int t) {
        if (t % 5 == 0) return 10;
        if (t % 6 == 0) return -5;
        return 2;
    }
}

class Game {
    Player p1 = new Player("Player 1");
    Player p2 = new Player("Player 2");
    Board board = new Board();
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    void play(Player p) {
        System.out.print(p.name + " press Enter...");
        sc.nextLine();
        int d = r.nextInt(6) + 1;
        p.move(d);
        p.score += board.reward(p.pos);
        System.out.println(p.name + ": roll=" + d + ", pos=" + p.pos + ", score=" + p.score);
    }

    void start() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nRound " + i);
            play(p1);
            play(p2);
        }
        System.out.println("\nWinner: " +
                (p1.score > p2.score ? "Player 1" :
                p2.score > p1.score ? "Player 2" : "Draw"));
    }
}

public class RollMoveOOP {
    public static void main(String[] args) {
        new Game().start();
    }
}
