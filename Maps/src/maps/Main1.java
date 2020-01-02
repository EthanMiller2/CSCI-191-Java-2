/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author ethanmiller
 */
public class Main1 extends javax.swing.JFrame {

    JFileChooser fileChooser = new JFileChooser();
    public City startCity;
    public City endCity;
    public int mouseX;
    public int mouseY;
    public Leg shorty;
    public Leg fastest;
    public static Leg shortLength[][];
    public static Leg shortTime[][];

    /**
     * Creates new form Main1
     */
    public Main1() {
        initComponents();
        readMap();
        mapPanel.repaint();
    }

    public void readMap() {
        File file = new File("map1.csv");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            boolean readcity = true;
            String[] parse;
            String cityname;
            int cityx, cityy;
            String roadname, startcity, endcity;
            int length, travelTime;
            int cityNum = 0;

            while ((s = reader.readLine()) != null) {

                if (s.equals(",,,,")) {
                    readcity = false;

                } else if (readcity) {
                    parse = s.split(",");
                    cityname = parse[0];
                    cityx = Integer.parseInt(parse[1]);
                    cityy = Integer.parseInt(parse[2]);
                    City c = new City(cityname, cityx, cityy);
                    cityNum++;

                } else if (!readcity) {
                    parse = s.split(",");
                    roadname = parse[0];
                    startcity = parse[1];
                    endcity = parse[2];
                    length = Integer.parseInt(parse[3]);
                    travelTime = Integer.parseInt(parse[4]);
                    Road r1 = new Road(roadname, startcity, endcity, length, travelTime);
                    Road r2 = new Road(roadname, endcity, startcity, length, travelTime);

                }
            }
//            for (City c : City.cities) {
//                System.out.println(c);
//                for (Road r : c.roads) {
//                    System.out.println(r);
//                }
//            }
        } catch (Exception e) {
            statusDisplay.setText("Error" + e);
        }
        shortLength = shortest(new DistanceMetric());
        shortTime = shortest(new TimeMetric());

    }

    public Leg[][] shortest(RoadMetric rm) {
        int n = City.cities.size();
        Leg[][] paths = new Leg[n][n];
        for (City c : City.cities) {
            for (Road r : c.roads) {
                paths[r.startCity.n][r.endCity.n] = new Leg(rm.getMetric(r), r, null);
            }
        }
        boolean change = true;
        while (change) {
            change = false;

            for (City from : City.cities) {
                for (Road r : from.roads) {
                    City via = r.endCity;

                    for (City to : City.cities) {
                        if (to != from && to != via && paths[via.n][to.n] != null) {
                            int d = rm.getMetric(r);

                            if (paths[from.n][to.n] == null || (d + paths[via.n][to.n].total < paths[from.n][to.n].total)) {
                                change = true;
                                paths[from.n][to.n] = new Leg(d + paths[via.n][to.n].total, r, paths[via.n][to.n]);
                            }

                        }

                    }
                }
            }
        }
        return paths;

    }

    public class MyPanel extends JPanel {

        @Override
        public void paint(Graphics g1) {
            super.paint(g1);
            // Place code to draw the map here
            Graphics2D g = (Graphics2D) (g1);
            Graphics2D g2 = (Graphics2D) g;

            RenderingHints rh = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            for (City c : City.cities) {
                if (endCity == c) {
                    g2.setColor(Color.RED);

                } else if (startCity == c) {
                    g2.setColor(Color.GREEN);
                } else {
                    g2.setColor(Color.BLACK);
                }

                g2.drawString(c.name, c.x - 10, c.y - 10);
                g2.fillOval(c.x - 2, c.y - 2, 5, 5);
                for (Road r : c.roads) {
                    g2.setColor(Color.WHITE);
                    g2.drawLine(r.startCity.x, r.startCity.y, r.endCity.x, r.endCity.y);

                }
            }
            if (shorty != null && fastest != null) {
                shorty.draw(g2, Color.BLUE, 5);
                fastest.draw(g2, Color.RED, 2);
            }

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

        mapPanel = new MyPanel();
        directionsButton = new javax.swing.JButton();
        statusDisplay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        routeInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 650));

        mapPanel.setPreferredSize(new java.awt.Dimension(1000, 650));
        mapPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        directionsButton.setText("Directions");
        directionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directionsButtonActionPerformed(evt);
            }
        });

        statusDisplay.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        statusDisplay.setText("Maps");

        routeInfo.setColumns(20);
        routeInfo.setRows(5);
        jScrollPane1.setViewportView(routeInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(statusDisplay)
                .addGap(722, 722, 722))
            .addGroup(layout.createSequentialGroup()
                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directionsButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(98, Short.MAX_VALUE)
                        .addComponent(directionsButton)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(420, 420, 420))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void directionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directionsButtonActionPerformed
        // TODO add your handling code here:

        if (shorty.samePath(fastest)) {
            routeInfo.setText("THESE ROUTES ARE SAME PATH");
            System.out.println("For shortest Route: ");
            shorty.print();
        } else {
            routeInfo.setText("THESE ROUTES ARE NOT THE SAME PATH");
            System.out.println("For shortest Route: ");
            shorty.print();
            System.out.println("For fastest Route: ");
            fastest.print();
        }


    }//GEN-LAST:event_directionsButtonActionPerformed

    private void mapPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMouseClicked
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
        for (City c : City.cities) {
            if (Math.abs(c.x - mouseX) <= 5) {
                if (Math.abs(c.y - mouseY) <= 5) {
                    startCity = endCity;
                    endCity = c;
                }
            }

        }
        if (startCity != null && endCity != null) {
            shorty = shortLength[startCity.n][endCity.n];
            fastest = shortTime[startCity.n][endCity.n];
        }
        mapPanel.repaint();
    }//GEN-LAST:event_mapPanelMouseClicked

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
            java.util.logging.Logger.getLogger(Main1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton directionsButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JTextArea routeInfo;
    private javax.swing.JLabel statusDisplay;
    // End of variables declaration//GEN-END:variables
}
