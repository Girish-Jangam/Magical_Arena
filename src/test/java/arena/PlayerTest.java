package arena;

public class PlayerTest {
    public static void main(String[] args) {
        PlayerTest test = new PlayerTest();
        test.testPlayerInitialization();
        test.testReduceHealth();
        test.testIsAlive();
        System.out.println("All Player tests passed.");
    }

    public void testPlayerInitialization() {
        Player player = new Player(100, 10, 15);
        assert player.getHealth() == 100 : "Expected health to be 100";
        assert player.getStrength() == 10 : "Expected strength to be 10";
        assert player.getAttack() == 15 : "Expected attack to be 15";
    }

    public void testReduceHealth() {
        Player player = new Player(100, 10, 15);
        player.reduceHealth(30);
        assert player.getHealth() == 70 : "Expected health to be 70";
    }

    public void testIsAlive() {
        Player player = new Player(100, 10, 15);
        assert player.isAlive() : "Expected player to be alive";
        player.reduceHealth(100);
        assert !player.isAlive() : "Expected player to be dead";
    }
}
