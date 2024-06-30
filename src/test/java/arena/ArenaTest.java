package arena;

package test; // Assuming your test files are in a "test" package

import arena.Player;
import arena.Arena;


public class ArenaTest {
    private Player playerA;
    private Player playerB;

    public static void main(String[] args) {
        ArenaTest test = new ArenaTest();
        test.setUp();
        test.testFight();
        System.out.println("All Arena tests passed.");
    }

    public void setUp() {
        playerA = new Player(50, 5, 10);
        playerB = new Player(100, 10, 5);
    }

    public void testFight() {
        Arena arena = new Arena(playerA, playerB);
        arena.startFight();

        assert !playerA.isAlive() || !playerB.isAlive() : "Expected one player to be dead";
    }
}
