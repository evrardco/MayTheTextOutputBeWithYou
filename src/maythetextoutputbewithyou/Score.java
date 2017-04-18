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
public class Score extends Text {

    public Score(Space esp) {
        super(esp, "Score: ", esp.getSizeY() - 1, esp.getSizeX() - 14);
    }

    public void update() {
        look = "Score: " + space.getScore();
    }
}
