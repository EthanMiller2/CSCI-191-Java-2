package hw2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HW2 extends javax.swing.JFrame {
    // Size of the array being animated

    public static int asize = 50;
    // The array being displayed
    public int arr[][] = new int[asize][asize];
    // An array this holds the previous values
    public boolean running = true;
    // The colors being displayed.  These colors are pretty terrible - please use better ones!
    public static Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
        Color.MAGENTA, Color.WHITE, Color.ORANGE, Color.BLACK};
    // Number of different colors
    public static int ncolors = colors.length;
    public Random randoms = new Random();
    // Animate at 4 frames / second
    public Timer clock = new Timer(250, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            tick();
            arrayView.repaint();
        }
    });

    public HW2() {
        initComponents();
        // The following code is needed to make all three
        // comboboxes have the same options on pull down.
        ComboBoxModel m = patternModify1.getModel();
        DefaultComboBoxModel m1 = new DefaultComboBoxModel();
        DefaultComboBoxModel m2 = new DefaultComboBoxModel();
        for (int i = 0; i < m.getSize(); i++) {
            m1.addElement(m.getElementAt(i));
            m2.addElement(m.getElementAt(i));
        }
        patternModify2.setModel(m1);
        patternModify3.setModel(m2);

        clock.start();


    }

    public class MyPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // Draw 5x5 squares of color in the graphics panel
            for (int i = 0; i < asize; i++) {
                for (int j = 0; j < asize; j++) {
                    g.setColor(colors[arr[i][j]]);
                    g.fillRect(j * 5, i * 5, 5, 5);
                }
            }
        }
    }

    public void tick() {
        if (running) {
            // At each tick. modify the array three times:
            modifyArray(patternModify1.getSelectedIndex());
            modifyArray(patternModify2.getSelectedIndex());
            modifyArray(patternModify3.getSelectedIndex());
            arrayView.repaint();
        }
    }

    // These functions "wrap" the colors / positions.  That is, when you go past
    // the last color or position you get to the first one.  Using these prevents
    // out of bounds errors
    public int cr(int i) {
        return (i + 2000 * ncolors) % ncolors;
    }

    public int ir(int i) {
        return (i + 2000 * asize) % asize;
    }
    // Fill in the code to modifyArray.  The "whatToDo" is an integer
    // corresponding to the options on the pulldowns.  You need to make sure
    // that these correspond correctly with the order of items in the
    // drop down

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public void modifyArray(int whatToDo) {
        int oldarr[][] = new int[asize][asize];
        // Controlled by stop/startarr = oldarr;
        for (int i = 0; i < asize; i++) {
            for (int j = 0; j < asize; j++) {
                oldarr[i][j] = arr[i][j];
            }
        }
        // Your code puts values into arr, with the previous array values in oldarr.
        switch (whatToDo) {
            case 0:  //No Change
                // No need to change the array!
                break;
            case 1: //Transpose
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = oldarr[j][i];
                    }
                }
                break;
            case 2: //Rotate
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = oldarr[ asize - 1 - j][i];
                    }
                }
                
                break;
            case 3:  //Increment
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = cr(oldarr[i][j]+1);
                    }
                }

                break;
            case 4:    //Mirror
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++)
                    {
                        if (j <25)
                    
                        arr[i][j] = ir(oldarr [i][j+25]);
                    }
                }
                break;
            case 5: //Shift Right
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = oldarr[i][ir(j-1)];
                    }
                }
                break;
            case 6: //Shift Down
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = oldarr[ir(i-1)][j];
                    }
                }
                break;
            case 7: //Blur
                for (int i = 0; i < asize; i++) {
                    for (int j = 0; j < asize; j++) {
                        int count = 0;
                        int sum = 0;
                        for (int m = i - 1; m <= i + 1; m++) {
                        for (int l = j-1; l <= j + 1; l++) {
                            sum = sum +oldarr [ir(m)][ir(l)];
                            count++;
                            
                        }
                    }
                    double avg = sum/count;
                    arr[i][j] = (int)avg;
                }
                
        }
                        
                    
                        
                    
               
                break;
            case 8: //Invert
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++)
                    {
                        arr[i][j] = 7 - oldarr[i][j];
                    }
                }       
                break;
            case 9: //Random Square
                int c = randoms.nextInt(8);
                int l = randoms.nextInt(asize - 15);
                int w = randoms.nextInt(asize -15);
                int p = randoms.nextInt(16);
                int al = 1 + p;
                int aw = w +p;
                for (int i = l; i < al; i++){
                    for (int j = w; j < aw; j++ ){
                        arr [i][j] = cr(c);
                    }
                }
                break;
            
            case 10: //Random Shift
                int distx = randoms.nextInt(11);
                int disty = randoms.nextInt(11);
                for (int i = 0; i <asize; i++){
                    for (int j = 0; j <asize; j++ ){
                     arr[i][j] = oldarr[ir(i - distx)][ir(j - disty)];   
                }
            }
        }
    }

    // This sets the array to some specific value
    // As above, the integer indicates which option was
    // selected on the pulldown.
    public void setArray(int whatToDo) {
        switch (whatToDo) {
            case 0:  //Blank
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = 0;
                    }
                }
                break;
            case 1: //Stripes
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = cr(j);
                    }
                }
                break;
            
           case 2: //Checkerboard
                for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                      if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))
                          arr[i][j] = 0;
                      if ((i % 2 == 1 && j % 2 == 0) || (i % 2 == 0 && j % 2 == 1))
                          arr[i][j] = 1;
                    }
                }
                break;
                
           case 3: //Circle
               for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        double dx = asize/2.0 - 0.5 - i;
                        double dy = asize/2.0 - 0.5 - j;
                         double       dist = 0.3* (Math.sqrt(dx * dx + dy * dy));
                         arr[i][j] = cr((int) dist);
                    }
                }
               
               
               break;
               
           case 4: //Diagonals
               for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = cr((i + j) % 8);
                    }
                }
               break;
               
           case 5: //Wider and wider
               int row = 0;
               int color = 0;
               int height = 1;
               x:
               while (true)
               {
                   for (int i = 0; i < height; i++)
                   { 
                       for (int j = 0; j < asize; j++) 
                       {
                           arr[row][j] = color;                       
                        }
                       
                       row = row +1;
                       if (row == asize){
                           break x;
                       }
                   }
                   height++;
                   color = cr(color + 1);
               }
               break;
               
           case 6: //Random Noise
               for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++) 
                    {
                        arr[i][j] = randoms.nextInt(8);
                    }
                }
               break;
               
           case 7: // Cosmic
               double a = randoms.nextDouble();
               double b = randoms.nextDouble();
               double c = randoms.nextDouble();
               for (int i = 0; i < asize; i++) 
                {
                    for (int j = 0; j < asize; j++)
                    {
                        arr[i][j] = cr ((int) ((a * i) + (b * j) + (c * i * j)));
                    }
                }
               
               break;
               
           case 8: //Free Choice 
               
               break;

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

        arrayView = new MyPanel();
        setPattern = new javax.swing.JComboBox();
        patternModify1 = new javax.swing.JComboBox();
        patternModify2 = new javax.swing.JComboBox();
        patternModify3 = new javax.swing.JComboBox();
        startstop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arrayView.setPreferredSize(new java.awt.Dimension(250, 250));

        org.jdesktop.layout.GroupLayout arrayViewLayout = new org.jdesktop.layout.GroupLayout(arrayView);
        arrayView.setLayout(arrayViewLayout);
        arrayViewLayout.setHorizontalGroup(
            arrayViewLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 250, Short.MAX_VALUE)
        );
        arrayViewLayout.setVerticalGroup(
            arrayViewLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 250, Short.MAX_VALUE)
        );

        setPattern.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blank", "Stripes", "Checkerboard", "Circle", "Diagonals", "Wider and wider", "Random Noise", "Cosmic", "Free Choice" }));
        setPattern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPatternActionPerformed(evt);
            }
        });

        patternModify1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Change", "Transpose", "Rotate", "Increment", "Mirror", "Shift Right", "Shift Down", "Blur", "Invert", "Random Square", "Random Shift", "Student Choice" }));
        patternModify1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternModify1ActionPerformed(evt);
            }
        });

        patternModify2.setModel(patternModify1.getModel());
        patternModify2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternModify2ActionPerformed(evt);
            }
        });

        patternModify3.setModel(patternModify1.getModel());
        patternModify3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternModify3ActionPerformed(evt);
            }
        });

        startstop.setText("Start / Stop");
        startstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startstopActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(arrayView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(55, 55, 55)
                        .add(setPattern, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(315, 315, 315)
                        .add(patternModify1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(315, 315, 315)
                        .add(patternModify2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(315, 315, 315)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(startstop)
                            .add(patternModify3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(arrayView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(48, 48, 48)
                        .add(setPattern, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(48, 48, 48)
                        .add(patternModify1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(48, 48, 48)
                        .add(patternModify2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(48, 48, 48)
                        .add(patternModify3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(startstop)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setPatternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPatternActionPerformed
        setArray(setPattern.getSelectedIndex());
        arrayView.repaint();
}//GEN-LAST:event_setPatternActionPerformed

    private void patternModify1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternModify1ActionPerformed
        // Nothing to do when the modify settings change
}//GEN-LAST:event_patternModify1ActionPerformed

    private void patternModify2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternModify2ActionPerformed
}//GEN-LAST:event_patternModify2ActionPerformed

    private void patternModify3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternModify3ActionPerformed
}//GEN-LAST:event_patternModify3ActionPerformed

    private void startstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startstopActionPerformed
        running = !running;
    }//GEN-LAST:event_startstopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HW2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel arrayView;
    private javax.swing.JComboBox patternModify1;
    private javax.swing.JComboBox patternModify2;
    private javax.swing.JComboBox patternModify3;
    private javax.swing.JComboBox setPattern;
    private javax.swing.JButton startstop;
    // End of variables declaration//GEN-END:variables
}
