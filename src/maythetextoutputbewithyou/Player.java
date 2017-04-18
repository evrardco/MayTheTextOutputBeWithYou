/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maythetextoutputbewithyou;

import affichage.MainWindow;

/**
 *
 * @author Colin Evrard
 */
public class Player extends Affichable {

    private MainWindow fenetre;

    public Player(Space esp, MainWindow f) {
        super(esp);
        look = "E";
        fenetre = f;
        alive = true;
    }

    public void start() {
        alive = true;
    }

    public void update() {
        if (!alive) {
            space.getArray().remove(this);
        }
    }

}
