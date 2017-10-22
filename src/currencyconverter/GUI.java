/**
 *
 * @author Pavel Nevmovenko
 */
package currencyconverter;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class GUI extends javax.swing.JFrame {

    String firstCurrency;
    String secondCurrency;
    String amountValue;

    //GUI constructor
    public GUI() {
        setLookAndFeel();
        initComponents();
        setResizable(false);
    }

    //set answer (calculation) to label
    public void setAnswer(String ans) {
        answer.setText(ans);
    }

    //fullfill the ComboBoxes with data from HashMap
    public void fillBoxes(HashMap<String, String> codes) {
        for (String name : codes.keySet()) {
            currencyFrom.addItem(name);
            currencyTo.addItem(name);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        currencyFrom = new javax.swing.JComboBox<>();
        currencyTo = new JComboBox();
        amount = new javax.swing.JTextField();
        labelTo = new javax.swing.JLabel();
        answer = new javax.swing.JLabel();
        convert = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 350));

        jPanel1.setMaximumSize(new java.awt.Dimension(450, 350));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 350));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 350));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        currencyFrom.setMaximumRowCount(200);
        currencyFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyFromActionPerformed(evt);
            }
        });

        currencyTo.setMaximumRowCount(200);
        currencyTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyToActionPerformed(evt);
            }
        });

        amount.setText("Enter amount");
        amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amountMouseClicked(evt);
            }
        });
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        labelTo.setText("to");

        answer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        convert.setText("Convert");
        convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currencyFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currencyTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTo))
                        .addGap(114, 114, 114))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(convert)
                            .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 135, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currencyFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelTo)
                .addGap(18, 18, 18)
                .addComponent(currencyTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(convert)
                .addGap(18, 18, 18)
                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        setAmountValue(amount.getText());
    }//GEN-LAST:event_amountActionPerformed

    private void currencyFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyFromActionPerformed
        setFirstCurrency(currencyFrom.getSelectedItem().toString());
    }//GEN-LAST:event_currencyFromActionPerformed

    private void currencyToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyToActionPerformed
        setSecondCurrency(currencyTo.getSelectedItem().toString());
    }//GEN-LAST:event_currencyToActionPerformed

    private void convertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertActionPerformed
        CurrencyConverter converter = new CurrencyConverter();
        String ans = "Calculation failed, Please enter amount to convert";
        try {

            double amounts = Double.parseDouble(amount.getText());
            ans = converter.convert(getFirstCurrency(), getSecondCurrency(), amounts);
        } catch (Exception ex) {
            System.out.println("PLEASE ENTER RIGHT AMOUNT AS INTEGER OR DOUBLE");
        }
        answer.setText(ans);
    }//GEN-LAST:event_convertActionPerformed

    //erase everything in the textbox onClick
    private void amountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountMouseClicked
        if (amount.getText().equals("Enter amount")) {
            amount.setText("");
        }

    }//GEN-LAST:event_amountMouseClicked

    //set text to "Enter amount" if its empty and onClick on Jpanel1
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (amount.getText().equals("")) {
            amount.setText("Enter amount");
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    public void setAmountValue(String value) {
        amountValue = value;
    }

    public String getAmountValue() {
        return amountValue;
    }

    public void setFirstCurrency(String currency) {
        firstCurrency = currency;
    }

    public void setSecondCurrency(String currency) {
        secondCurrency = currency;
    }

    public String getFirstCurrency() {
        return firstCurrency;
    }

    public String getSecondCurrency() {
        return secondCurrency;
    }

    public static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JLabel answer;
    private javax.swing.JButton convert;
    private javax.swing.JComboBox<String> currencyFrom;
    private javax.swing.JComboBox<String> currencyTo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelTo;
    // End of variables declaration//GEN-END:variables

}
