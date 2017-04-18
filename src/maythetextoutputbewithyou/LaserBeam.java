/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maythetextoutputbewithyou;

import java.util.LinkedList;

/**
 *
 * @author Colin Evrard
 */
public class LaserBeam extends Affichable {

    private int xMax;

    public LaserBeam(Player p, Space e) {
        super(e);
        look = "-";
        x = p.getX() + 1;
        y = p.getY();
        xMax = e.getSizeX();
    }

    public void update() {

        super.update();
        LinkedList<StandardEnemy> enemies = space.getArrayOfEnemies();
        if (alive) {
            if (x < xMax - 1) {
                for (int i = 0; i < enemies.size(); i++) {
                    StandardEnemy e = enemies.get(i);
                    if ((int) y == (int) e.getY()) {
                        int Xe = (int) e.getX();
                        int X = (int) x;
                        if (Xe - x < 2) {
                            e.kill();
                            alive = false;
                        }
                    }
                }
                x = x + 6.0;
            } else {
                alive = false;
            }
        }

    }

}
