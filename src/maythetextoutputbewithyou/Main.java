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
public class Main {

    public static void main(String[] args) {

        MainWindow fenetre = new MainWindow(null, null);

        Runnable game = new GameThread(fenetre);

        fenetre.setVisible(true);
        new maythetextoutputbewithyou.Instruction().setVisible(true);

    }

    public static int randBetween(int a, int b) {
        double randy = Math.random();
        randy = (1 - randy) * a + (randy * b);
        return (int) randy;
    }

    public static double randDoubleBetween(double a, double b) {
        double randy = Math.random();
        randy = (1 - randy) * a + (randy * b);
        return randy;
    }
}
