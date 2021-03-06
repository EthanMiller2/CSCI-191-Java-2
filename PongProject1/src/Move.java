    
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ethanmiller
 */
public class Move extends javax.swing.JFrame {

    //Random Ball launch Code
    public void launchBall() {
        ballx = fieldWidth / 2;
        bally = fieldHeight / 2;
        ballxv = randoms.nextInt(16) + 5;
        int other = randoms.nextInt(2);
        if (other % 2 == 0) {
            ballxv = ballxv;

        } else {
            ballxv = -ballxv;
        }
        ballyv = randoms.nextInt(31) - 15;
    }

    /**
     * Creates new form Move
     */
    public Move() {
        initComponents();

        clock.start();
    }
    public int leftScore = 0;
    public int rightScore = 0;
    public int leftPaddley;    // These are the y coordinates of the center of the left paddle
    public int rightPaddley;  // These should be between 0 and 300
    public int ballx = 300;         // 0 <= x < 600
    public int bally = 150;          // 0 <= y < 300
    public int ballxv = 0;         // This is the velocity of the ball
    public int ballyv = 0;
    public int mousex;          // These are updated to reflect current mouse
    public int mousey;          // location in the panel
    public static final int ballRadius = 5;
    public static final int paddleWidth = 5;
    public static final int paddleHeight = 50;
    public static final int fieldWidth = 600;
    public static final int fieldHeight = 300;
    public static final int leftPaddlex = 15;
    public static final int rightPaddlex = fieldWidth - 15;

    public Random randoms = new Random();   // Use this to randomize the ball
    // after a score
    public Timer clock = new Timer(50, new ActionListener() {  // 50ms delay between ticks
        public void actionPerformed(ActionEvent e) {
            tick();               // Write a method named tick to advance your game
            ViewPanel.repaint();
        }

        public void paddlebounce() {
            //PaddleBounce code
            if (ballx <= leftPaddlex + paddleWidth / 2 + ballRadius
                    && bally - ballRadius <= leftPaddley + 25
                    && bally - ballRadius >= leftPaddley - 25) {
                ballxv = -ballxv;

            }

            if (ballx >= rightPaddlex - paddleWidth / 2 - ballRadius
                    && bally - ballRadius <= rightPaddley + 25
                    && bally - ballRadius >= rightPaddley - 25) {
                ballxv = -ballxv;

            }

        }

        public void tick() {
            paddlebounce();
            //Score Counter
            if (ballx > fieldWidth) {
                leftScore++;

                LeftScore.setText("Left Score " + leftScore);
                launchBall();
            }
            if (ballx < 0) {
                rightScore++;

                RightScore.setText("Right Score " + rightScore);
                launchBall();
            }
            //Ball movement Code
            ballx = ballx + ballxv;
            bally = bally + ballyv;

            //Paddle Movement Code
            leftPaddley = mousey;
            rightPaddley = mousex / 2;

            //Bounce ball of the top and bottom 
            if (bally < ballRadius) {
                ballyv = -ballyv;
                bally = 2 * ballRadius - bally;
            }
            if (bally > fieldHeight - ballRadius) {
                ballyv = -ballyv;
                bally = 2 * (fieldHeight - ballRadius) - bally;
            }

        }
    });  // panel is the name of the JPanel that displays the game

    public class MyPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.GREEN);
            g.fillOval(ballx - ballRadius, bally - ballRadius, ballRadius * 2, ballRadius * 2);
            g.fillRect(leftPaddlex - paddleWidth / 2, leftPaddley - paddleHeight / 2, paddleWidth, paddleHeight);
            g.fillRect(rightPaddlex - paddleWidth / 2, rightPaddley - paddleHeight / 2, paddleWidth, paddleHeight);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewPanel = new MyPanel();
        RightScore = new javax.swing.JLabel();
        LeftScore = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ViewPanel.setBackground(new java.awt.Color(0, 51, 255));
        ViewPanel.setPreferredSize(new java.awt.Dimension(600, 300));
        ViewPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ViewPanelMouseMoved(evt);
            }
        });

        RightScore.setText("Right Score:");

        LeftScore.setText("Left Score:");

        javax.swing.GroupLayout ViewPanelLayout = new javax.swing.GroupLayout(ViewPanel);
        ViewPanel.setLayout(ViewPanelLayout);
        ViewPanelLayout.setHorizontalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LeftScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(RightScore)
                .addGap(85, 85, 85))
        );
        ViewPanelLayout.setVerticalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RightScore)
                    .addComponent(LeftScore))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Pong by Ethan");

        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 0));
        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPanelMouseMoved
        mousex = evt.getX();
        mousey = evt.getY();

    }//GEN-LAST:event_ViewPanelMouseMoved

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        leftScore = 0;
        rightScore = 0;
        LeftScore.setText("Left Score:0");
        RightScore.setText("Right Score:0");
        launchBall();


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Move.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Move.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Move.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Move.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Move().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LeftScore;
    private javax.swing.JLabel RightScore;
    private javax.swing.JPanel ViewPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
