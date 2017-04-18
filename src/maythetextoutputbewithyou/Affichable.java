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
public abstract class Affichable implements Comparable<Affichable> {

    protected double x;
    protected double y;
    protected String look;
    protected boolean alive;
    protected Space space;
    private int index;
    private static int count = 0;

    public Affichable(Space esp) {
        x = 0;
        y = 0;
        look = "x";
        alive = true;
        space = esp;

        index = count;
        count++;
        addToTheGame();

    }

    public void addToTheGame() {
        space.addIn(this);
    }

    public void setX(int X) {
        x = X;
    }

    public void setY(int Y) {
        y = Y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public void setPos(int X, int Y) {
        x = X;
        y = Y;
    }

    @Override
    public int compareTo(Affichable a) {
        if (a == null) {
            return 1;
        }
        return (int) (y - a.getY());
    }

    @Override
    public String toString() {
        String ret = "";
        int i;
        for (i = 0; i < (double) x; i++) {
            ret = ret + " ";
        }
        ret = ret + look;
        for (; i < space.getSizeX(); i++) {
            ret = ret + " ";
        }
        return ret;
    }

    public String charToShowAt(int X) {
        if (X == (int) x) {
            return look;
        } else {
            return "";
        }
    }

    public void update() {
        if (!alive) {
            space.getArray().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Affichable) {
            Affichable a = (Affichable) o;
            return (this.index == a.getIndex() && this.getX() == a.getX() && this.getY() == a.getY());
        } else {
            return false;
        }
    }

    public void kill() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

}
