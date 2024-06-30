package arena;

import java.util.Random;

public class Arena {
    private final Player player1;
    private final Player player2;
    private final Random random;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.random = new Random();
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    private void attack(Player attacker, Player defender) {
        int attackRoll = rollDice();
        int defendRoll = rollDice();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendStrength = defender.getStrength() * defendRoll;

        int damageToDefender = Math.max(0, attackDamage - defendStrength);

        defender.reduceHealth(damageToDefender);

        System.out.println(attacker + " attacks " + defender + " with damage " + damageToDefender);
    }

    public void startFight() {
        Player currentAttacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
        Player currentDefender = player1.getHealth() <= player2.getHealth() ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            attack(currentAttacker, currentDefender);

            // Swap roles
            Player temp = currentAttacker;
            currentAttacker = currentDefender;
            currentDefender = temp;
        }

        System.out.println("Fight over!");
        System.out.println(player1);
        System.out.println(player2);
    }
}
