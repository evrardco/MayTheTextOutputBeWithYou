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
public class GameThread implements Runnable {

    private MainWindow fenetre;
    private Player player;

    public GameThread(MainWindow fen) {
        fenetre = fen;
    }

    @Override
    public void run() {
        long timeSpent = System.currentTimeMillis();
        System.out.println("Demarrage du jeu");
        Space espace = new Space(64, 27, null);
        System.out.println("1");
        espace.setTextArea(fenetre.getTextArea());
        System.out.println("2");
        long tick = System.currentTimeMillis();
        System.out.println("3");
        player = new Player(espace, fenetre);
        espace.addIn(player);
        fenetre.addKeyListener(player);
        System.out.println("4");
        System.out.println("5");
        fenetre.setSpace(espace);
        System.out.println("6");
        while (player.isAlive()) {
            if (System.currentTimeMillis() - tick > 16) {
                tick = System.currentTimeMillis();
                float rand = (float) Math.random();
                float difficulty = (float) Math.min((tick - timeSpent) / 300000.0, 0.3);

                if (rand < 0.05 + difficulty) {
                    new StandardEnemy(espace, player);
                }
                espace.update();
            }
        }
        fenetre.getTextArea().setText(null);
        fenetre.getTextArea().setText("Score : " + espace.getScore()
                + "\nAppuyez sur Escape pour recommencer...");

    }

}
