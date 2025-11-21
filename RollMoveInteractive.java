import java.util.*;

public class RollMoveInteractive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int p1Pos = 0, p2Pos = 0;
        int p1Score = 0, p2Score = 0;

        for (int round = 1; round <= 5; round++) {
            System.out.println("\n--- Round " + round + " ---");

            // Player 1
            System.out.print("Player 1: Press Enter to roll...");
            sc.nextLine();
            int d1 = r.nextInt(6) + 1;
            p1Pos = (p1Pos + d1) % 20;
            p1Score += reward(p1Pos);
            System.out.println("P1 rolled " + d1 + ", pos " + p1Pos + ", score " + p1Score);

            // Player 2
            System.out.print("Player 2: Press Enter to roll...");
            sc.nextLine();
            int d2 = r.nextInt(6) + 1;
            p2Pos = (p2Pos + d2) % 20;
            p2Score += reward(p2Pos);
            System.out.println("P2 rolled " + d2 + ", pos " + p2Pos + ", score " + p2Score);
        }

        System.out.println("\n=== Final Scores ===");
        System.out.println("Player 1 = " + p1Score);
        System.out.println("Player 2 = " + p2Score);

        System.out.println(
            (p1Score > p2Score) ? "Player 1 Wins!" :
            (p2Score > p1Score) ? "Player 2 Wins!" :
            "It's a Draw!"
        );
    }

    static int reward(int t) {
        if (t % 5 == 0) return 10;
        if (t % 6 == 0) return -5;
        return 2;
    }
}

