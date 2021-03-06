package gui;

import bbms.GlobalFuncs;
import clock.Clock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class GUI_NB extends javax.swing.JFrame {
    
    private boolean DEBUG_MOUSECURSOR = true; // Shows mouse cursor coordinates for all panes
    
    
    public GUIMainDisp GMD = new GUIMainDisp();

    /**
     * Creates new form BBGUI
     */
    public GUI_NB() {
        initComponents();
        setJMenuBar(new GUIMenu());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        DisplayPanel = new javax.swing.JPanel();
        DisplayTabs = new javax.swing.JTabbedPane();
        MainDisplay = new GUIMainDisp();
        InformationPanel = new javax.swing.JPanel();
        BasicInfoPane = new GUIBasicInfo();
        DetailedInfoPane = new GUIInfoPane();
        MiniMap = new javax.swing.JPanel();
        ConsolePanel = new javax.swing.JPanel();
        ConsoleScroll = new javax.swing.JScrollPane();
        GUIConsole = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bare Bones Military Simulator");
        setMaximumSize(new java.awt.Dimension(1024, 800));
        setMinimumSize(new java.awt.Dimension(1024, 800));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        DisplayPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));

        DisplayTabs.setPreferredSize(new java.awt.Dimension(710, 530));

        MainDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainDisplayMouseClicked(evt);
            }
        });
        MainDisplay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MainDisplayMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout MainDisplayLayout = new javax.swing.GroupLayout(MainDisplay);
        MainDisplay.setLayout(MainDisplayLayout);
        MainDisplayLayout.setHorizontalGroup(
            MainDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        MainDisplayLayout.setVerticalGroup(
            MainDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        DisplayTabs.addTab("Main Display", MainDisplay);

        javax.swing.GroupLayout DisplayPanelLayout = new javax.swing.GroupLayout(DisplayPanel);
        DisplayPanel.setLayout(DisplayPanelLayout);
        DisplayPanelLayout.setHorizontalGroup(
            DisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DisplayTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DisplayPanelLayout.setVerticalGroup(
            DisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DisplayTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        InformationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51), 3));

        BasicInfoPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic Info"));
        BasicInfoPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BasicInfoPaneMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout BasicInfoPaneLayout = new javax.swing.GroupLayout(BasicInfoPane);
        BasicInfoPane.setLayout(BasicInfoPaneLayout);
        BasicInfoPaneLayout.setHorizontalGroup(
            BasicInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BasicInfoPaneLayout.setVerticalGroup(
            BasicInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        DetailedInfoPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Unit Info"));
        DetailedInfoPane.setMaximumSize(new java.awt.Dimension(32767, 443));
        DetailedInfoPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DetailedInfoPaneMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout DetailedInfoPaneLayout = new javax.swing.GroupLayout(DetailedInfoPane);
        DetailedInfoPane.setLayout(DetailedInfoPaneLayout);
        DetailedInfoPaneLayout.setHorizontalGroup(
            DetailedInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        DetailedInfoPaneLayout.setVerticalGroup(
            DetailedInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        MiniMap.setBackground(new java.awt.Color(0, 0, 0));
        MiniMap.setMaximumSize(new java.awt.Dimension(240, 209));

        javax.swing.GroupLayout MiniMapLayout = new javax.swing.GroupLayout(MiniMap);
        MiniMap.setLayout(MiniMapLayout);
        MiniMapLayout.setHorizontalGroup(
            MiniMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        MiniMapLayout.setVerticalGroup(
            MiniMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout InformationPanelLayout = new javax.swing.GroupLayout(InformationPanel);
        InformationPanel.setLayout(InformationPanelLayout);
        InformationPanelLayout.setHorizontalGroup(
            InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MiniMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(BasicInfoPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DetailedInfoPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InformationPanelLayout.setVerticalGroup(
            InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationPanelLayout.createSequentialGroup()
                .addComponent(BasicInfoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DetailedInfoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MiniMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ConsolePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 3));

        GUIConsole.setEditable(false);
        GUIConsole.setColumns(20);
        GUIConsole.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        GUIConsole.setRows(5);
        GUIConsole.setFocusable(false);
        ConsoleScroll.setViewportView(GUIConsole);

        javax.swing.GroupLayout ConsolePanelLayout = new javax.swing.GroupLayout(ConsolePanel);
        ConsolePanel.setLayout(ConsolePanelLayout);
        ConsolePanelLayout.setHorizontalGroup(
            ConsolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsoleScroll)
        );
        ConsolePanelLayout.setVerticalGroup(
            ConsolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsoleScroll)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConsolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConsolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void MainDisplayMouseMoved(java.awt.event.MouseEvent evt) {                                       
        GUIMainDisp.MouseMotionEvents(evt);
    }                                      

    private void MainDisplayMouseClicked(java.awt.event.MouseEvent evt) {                                         
        GMD.MouseClickedEvents(evt);
    }                                        

    private void BasicInfoPaneMouseMoved(java.awt.event.MouseEvent evt) {                                         
        if (DEBUG_MOUSECURSOR) {
            GUIBasicInfo.mouseX = evt.getX();
            GUIBasicInfo.mouseY = evt.getY();
            GlobalFuncs.gui.BasicInfoPane.repaint();
        }
    }                                        

    private void DetailedInfoPaneMouseMoved(java.awt.event.MouseEvent evt) {                                            
        if (DEBUG_MOUSECURSOR) {
            GUIBasicInfo.mouseX = evt.getX();
            GUIBasicInfo.mouseY = evt.getY();
            GlobalFuncs.gui.BasicInfoPane.repaint();
        }
    }                                           

    private void formMouseMoved(java.awt.event.MouseEvent evt) {                                
        GUIBasicInfo.uniMouseX = evt.getX();
        GUIBasicInfo.uniMouseY = evt.getY();
        GlobalFuncs.gui.BasicInfoPane.repaint();
    }                               

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
        javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        }
        catch (Exception e) {
            System.err.println("ERROR: Cannot load Windows-like displays.");
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GlobalFuncs.gui = new GUI_NB();
                GlobalFuncs.gui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    public javax.swing.JPanel BasicInfoPane;
    private javax.swing.JPanel ConsolePanel;
    private javax.swing.JScrollPane ConsoleScroll;
    public javax.swing.JPanel DetailedInfoPane;
    private javax.swing.JPanel DisplayPanel;
    private javax.swing.JTabbedPane DisplayTabs;
    public static javax.swing.JTextArea GUIConsole;
    private javax.swing.JPanel InformationPanel;
    public javax.swing.JPanel MainDisplay;
    private javax.swing.JPanel MiniMap;
    // End of variables declaration                   

    /**
     * Prints output to the GUI Console output.  Automatically appends newline.
     */
    public static void GCO(String str) {
    	GUIConsole.append(str + "\n");
    	GUIConsole.setCaretPosition(GUIConsole.getDocument().getLength());		
    }
    
    /**
     * Prints out to the GUI Console output with a timestamp.  Automatically appends newline.
     */
    public static void GCODTG(String str) {    	
    	GUIConsole.append(Clock.DisplayTimeNorm() + "> " + str + "\n");
    	GUIConsole.setCaretPosition(GUIConsole.getDocument().getLength());	    
    }
}
