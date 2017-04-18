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
public class Text extends Affichable {

    public Text(Space e, String txt, int X, int Y) {
        super(e);
        look = txt;
        x = X;
        y = Y;
    }

    public String charToShowAt(int X) {
//        if (X >= x) {
//            return "" + look.charAt(X - (int) x);
//        } else {
//            return "";
//        }
        return "";
    }
}
