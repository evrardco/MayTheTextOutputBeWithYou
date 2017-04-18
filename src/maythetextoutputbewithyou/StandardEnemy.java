/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maythetextoutputbewithyou;

/**
 *
 * @author Colin Evrard
 */
public class StandardEnemy extends Affichable {

    protected int reward;
    protected Player player;
    private double speed;

    public StandardEnemy(Space esp, Player player) {
        super(esp);
        y = player.getY() + Main.randBetween(Math.max(-(int) player.getY(), -8), Math.min(8, space.getSizeY() - (int) player.getY()));
        x = space.getSizeX() - 1;
        look = "I";

        this.player = player;
        double rand = Math.random();
        if (rand < 0.5) {
            speed = Main.randDoubleBetween(1, 1.25);
        } else if (rand > 0.7) {
            speed = Main.randDoubleBetween(1, 2);
        } else if (rand > 0.9) {
            speed = Main.randDoubleBetween(2, 4);
        } else if (rand > 0.95) {
            speed = 6;
        } else {
            speed = 0.75;
        }
        speed = speed * 1;
        reward = 1 + (int) speed;
    }

    @Override
    public void addToTheGame() {
        space.addEnemy(this);
    }

    @Override
    public void update() {
        if (!alive) {
            look = "";
            space.getArrayOfEnemies().remove(this);
        }
        if (alive && x > 0) {
            x = x - speed;

        } else if (alive && player.getY() == y) {
            player.kill();
        } else {
            kill();
        }

    }

    public void kill() {
        if (alive) {
            alive = false;
            space.addScore(reward);
        }
    }

}
