/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import maythetextoutputbewithyou.GameThread;
import maythetextoutputbewithyou.Player;
import maythetextoutputbewithyou.Space;

/**
 *
 * @author Colin Evrard
 */
public class MainWindow extends javax.swing.JFrame {

    private maythetextoutputbewithyou.Space espace;
    private long timer;
    private boolean started;
    private KeyListener keyImp;
    private Thread thread;

    public class KeyDetector implements KeyListener {

        private boolean upReady = true;
        private boolean downReady = true;
        private boolean spaceReady = true;
        private Player playerMoveable;

        public KeyDetector(Player p) {
            playerMoveable = p;

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (playerMoveable == null) {
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upReady = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downReady = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spaceReady = true;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (playerMoveable != null) {
                if (e.getKeyCode() == KeyEvent.VK_UP && playerMoveable.getY() > 0 && upReady) {
                    playerMoveable.setPos((int) playerMoveable.getX(), (int) playerMoveable.getY() - 1);
                    upReady = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN && playerMoveable.getY() < espace.getSizeY() - 1 && downReady) {
                    playerMoveable.setPos((int) playerMoveable.getX(), (int) playerMoveable.getY() + 1);
                    downReady = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE && spaceReady && System.currentTimeMillis() - timer > 1000) {
                    timer = System.currentTimeMillis();
                    new maythetextoutputbewithyou.LaserBeam(playerMoveable, espace);
                    spaceReady = false;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.out.println("Escape appuye");
                if (thread == null || !thread.isAlive()) {
                    thread = new Thread(new GameThread(getOuterClass()));
                    thread.start();
                }
            }

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    /**
     * Creates new form MainWindow
     */
    public MainWindow(maythetextoutputbewithyou.Player p, maythetextoutputbewithyou.Space esp) {
        initComponents();
        espace = esp;
        timer = System.currentTimeMillis();
        started = false;
        thread = null;
        keyImp = new KeyDetector(null);
        jTextArea1.addKeyListener(keyImp);

    }

    public void setSpace(Space e) {
        espace = e;
    }

    public boolean getGameState() {
        return started;
    }

    public void removeKeyListener() {
        jTextArea1.removeKeyListener(keyImp);
    }

    public void addKeyListener(Player p) {
        jTextArea1.removeKeyListener(keyImp);
        keyImp = new KeyDetector(p);
        jTextArea1.addKeyListener(keyImp);
    }

    private MainWindow getOuterClass() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        label1.setText("label1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MayTheTextOutputBeWithYou");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public javax.swing.JTextArea getTextArea() {
        return jTextArea1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
