package coursescheduleapp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import coursescheduleapp.model.Model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * submitPanel.java
 *
 * Created on Apr 6, 2010, 7:26:03 PM
 */

/**
 *
 * @author drew
 */
public class submitPanel extends javax.swing.JPanel implements ActionListener{

	private Model model;
	private SubmitController control;
    /** Creates new form submitPanel */
    public submitPanel() {
        initComponents();
    }

    public void setModel(Model model)
    {
    	this.model = model;
    	control = new SubmitController();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitBt = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        submitBt.setText("Submit");
        submitBt.setActionCommand("Submit");
        submitBt.addActionListener(this);
        add(submitBt, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton submitBt;
    // End of variables declaration//GEN-END:variables
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if ("Submit".equals(arg0.getActionCommand()))
		{
			control.createSchedule(model);
			
			
		}
	}

	

}
