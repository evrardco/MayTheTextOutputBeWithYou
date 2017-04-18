/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maythetextoutputbewithyou;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JTextArea;

/**
 *
 * @author Colin Evrard
 */
public class Space {

    private int sizeX;
    private int sizeY;
    private LinkedList<Affichable> whatSIn;
    private javax.swing.JTextArea textArea;
    private LinkedList<StandardEnemy> enemies;
    private int score;

    public Space(int x, int y, javax.swing.JTextArea textA) {
        sizeX = x;
        sizeY = y;
        whatSIn = new LinkedList<>();
        textArea = textA;
        enemies = new LinkedList<>();
        score = 0;
    }

    public Space() {
        this(16, 16, null);
    }

    public void setTextArea(JTextArea t) {
        textArea = t;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void addScore(int n) {
        score = score + n;
    }

    public int getScore() {
        return score;
    }

    public int getSizeY() {
        return sizeY;
    }

    public LinkedList<Affichable> getArray() {
        return whatSIn;
    }

    public LinkedList<StandardEnemy> getArrayOfEnemies() {
        return enemies;
    }

    public void addIn(Affichable a) {
        whatSIn.add(a);
    }

    public void addEnemy(StandardEnemy e) {
        enemies.add(e);
    }

    public static String superpose(String a, String b, int maxX) {
        if (a == null && b != null) {
            return b;
        }
        int n = Math.min(a.length(), b.length());
        String ret = "";
        for (int i = 0; i < n && i < maxX; i++) {
            if (b.charAt(i) != ' ') {
                ret = ret + b.charAt(i);
            } else {
                ret = ret + a.charAt(i);
            }
        }
        return ret;

    }

    public String display() {
        //System.out.println("taille affichable: " + whatSIn.size() + " taille ennemis: " + enemies.size());
        double y = 0;
        String ret = "";
        while (y < sizeY) {
            String tempString = "";
            for (int X = 0; X < sizeX; X++) {
                String tempChar = " ";

                for (int j = whatSIn.size() - 1; j > 0 && tempChar.equals(" "); j--) {
                    Affichable a = whatSIn.get(j);
                    if (a.getY() == y && !a.charToShowAt(X).isEmpty()) {
                        tempChar = a.charToShowAt(X);
                    }
                }
                for (int j = 0; j < enemies.size() && tempChar.equals(" "); j++) {
                    Affichable a = enemies.get(j);
                    if (a.getY() == y && !a.charToShowAt(X).isEmpty()) {
                        tempChar = a.charToShowAt(X);

                    }
                }

                tempString = tempString + tempChar;
            }
            ret = ret + tempString + "\n";
            y++;
        }
        return ret;
    }

    public void update() {
        for (int j = 0; j < whatSIn.size(); j++) {
            Affichable a = whatSIn.get(j);
            a.update();
        }
        for (int j = 0; j < enemies.size(); j++) {
            Affichable a = enemies.get(j);
            a.update();
        }

        textArea.setText(null);
        textArea.setText(display());

    }

    public void reset() {
        whatSIn = new LinkedList<>();
        enemies = new LinkedList<>();
    }

}
