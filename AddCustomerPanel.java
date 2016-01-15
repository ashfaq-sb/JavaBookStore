package com.ash.ood;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.ash.ood.MainMenu.addComp;

@SuppressWarnings("serial")
public class AddCustomerPanel extends JPanel {
    private JLabel cNameLbl, cAddressLbl, cardNoLbl, expiryDateLbl;
    private JTextField cNameTxt, cAddressTxt, cardNoTxt, expiryDateTxt;
    private JButton submitBtn, clearBtn;
    private GridBagLayout gbl;
    private ArrayList<Product> pids;
    private OrderHandler oHandler;
    private int items;
    private double orderTotal;

    public AddCustomerPanel() {
        // TODO Auto-generated constructor stub
        //this.getoHandler();
    }

    public AddCustomerPanel(JInternalFrame iframe, ArrayList<Product> pids, double orderTotal, int items) {
        this.gbl = new GridBagLayout();
        this.cNameLbl = new JLabel("Name: ");
        this.cAddressLbl = new JLabel("Address: ");

        this.cardNoLbl = new JLabel("Card No.: ");

        this.expiryDateLbl = new JLabel("Card Expiry Date: ");

        this.cNameTxt = new JTextField(15);
        this.cAddressTxt = new JTextField(15);
        this.cardNoTxt = new JTextField(15);
        this.expiryDateTxt = new JTextField(10);
        this.submitBtn = new JButton("Submit Order");
        this.clearBtn = new JButton("Clear");
        this.oHandler = new OrderHandler();
        this.pids = pids;
        this.items = items;
        setLayout(gbl);
        setSize(400, 400);
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(submitBtn);
        btnPanel.add(clearBtn);
        this.orderTotal = orderTotal;

        addComp(this, cNameLbl, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this, cNameTxt, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this, cAddressLbl, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this, cAddressTxt, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this, cardNoLbl, 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this, cardNoTxt, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this, expiryDateLbl, 0, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this, expiryDateTxt, 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this, btnPanel, 1, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        submitBtn.addActionListener(e -> {
            if ((!emptyTextFields(cNameTxt)) && (!emptyTextFields(cAddressTxt)) && (!emptyTextFields(cardNoTxt))
                    && (!emptyTextFields(expiryDateTxt))) {
                String cName, cAddress, cardNo, expiryDate;
                cName = cNameTxt.getText();
                cAddress = cAddressTxt.getText();
                cardNo = cardNoTxt.getText();
                expiryDate = expiryDateTxt.getText();
                Customer c = new Customer(cName, cAddress, cardNo, expiryDate);
                // Order o = new Order(this.orderTotal, c,this.items,this.pids);
                OrderPanel.oh.addObject(new Order(this.getOrderTotal(), c, this.getItems(), this.getPids()));
                OrderPanel.oListModel.addElement(OrderPanel.oh.getOrder().getOrderDetails());
                try {
                    clearTextFields();
                    iframe.setClosed(true);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        clearBtn.addActionListener(e -> clearTextFields());
    }


    public boolean emptyTextFields(JTextField tf) {
        return tf.getText().isEmpty();
    }

    public void clearTextFields() {
        this.getcNameTxt().setText("");
        this.getcAddressTxt().setText("");
        this.getCardNoTxt().setText("");
        this.getExpiryDateTxt().setText("");

    }
    // public static void main(String[] args) {
    // JFrame f = new JFrame();
    // // f.setContentPane(new AddCustomerPanel());
    // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // f.setSize(400,400);
    // f.setVisible(true);
    // }

    /**
     * @return the cNameLbl
     */
    public JLabel getcNameLbl() {
        return cNameLbl;
    }

    /**
     * @param cNameLbl the cNameLbl to set
     */
    public void setcNameLbl(JLabel cNameLbl) {
        this.cNameLbl = cNameLbl;
    }

    /**
     * @return the cAddressLbl
     */
    public JLabel getcAddressLbl() {
        return cAddressLbl;
    }

    /**
     * @param cAddressLbl the cAddressLbl to set
     */
    public void setcAddressLbl(JLabel cAddressLbl) {
        this.cAddressLbl = cAddressLbl;
    }

    /**
     * @return the cardNoLbl
     */
    public JLabel getCardNoLbl() {
        return cardNoLbl;
    }

    /**
     * @param cardNoLbl the cardNoLbl to set
     */
    public void setCardNoLbl(JLabel cardNoLbl) {
        this.cardNoLbl = cardNoLbl;
    }

    /**
     * @return the expiryDateLbl
     */
    public JLabel getExpiryDateLbl() {
        return expiryDateLbl;
    }

    /**
     * @param expiryDateLbl the expiryDateLbl to set
     */
    public void setExpiryDateLbl(JLabel expiryDateLbl) {
        this.expiryDateLbl = expiryDateLbl;
    }

    /**
     * @return the cNameTxt
     */
    public JTextField getcNameTxt() {
        return cNameTxt;
    }

    /**
     * @param cNameTxt the cNameTxt to set
     */
    public void setcNameTxt(JTextField cNameTxt) {
        this.cNameTxt = cNameTxt;
    }

    /**
     * @return the cAddressTxt
     */
    public JTextField getcAddressTxt() {
        return cAddressTxt;
    }

    /**
     * @param cAddressTxt the cAddressTxt to set
     */
    public void setcAddressTxt(JTextField cAddressTxt) {
        this.cAddressTxt = cAddressTxt;
    }

    /**
     * @return the cardNoTxt
     */
    public JTextField getCardNoTxt() {
        return cardNoTxt;
    }

    /**
     * @param cardNoTxt the cardNoTxt to set
     */
    public void setCardNoTxt(JTextField cardNoTxt) {
        this.cardNoTxt = cardNoTxt;
    }

    /**
     * @return the expiryDateTxt
     */
    public JTextField getExpiryDateTxt() {
        return expiryDateTxt;
    }

    /**
     * @param expiryDateTxt the expiryDateTxt to set
     */
    public void setExpiryDateTxt(JTextField expiryDateTxt) {
        this.expiryDateTxt = expiryDateTxt;
    }

    /**
     * @return the submitBtn
     */
    public JButton getSubmitBtn() {
        return submitBtn;
    }

    /**
     * @param submitBtn the submitBtn to set
     */
    public void setSubmitBtn(JButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    /**
     * @return the clearBtn
     */
    public JButton getClearBtn() {
        return clearBtn;
    }

    /**
     * @param clearBtn the clearBtn to set
     */
    public void setClearBtn(JButton clearBtn) {
        this.clearBtn = clearBtn;
    }

    /**
     * @return the gbl
     */
    public GridBagLayout getGbl() {
        return gbl;
    }

    /**
     * @param gbl the gbl to set
     */
    public void setGbl(GridBagLayout gbl) {
        this.gbl = gbl;
    }

    /**
     * @return the pids
     */
    public ArrayList<Product> getPids() {
        return pids;
    }

    /**
     * @param pids the pids to set
     */
    public void setPids(ArrayList<Product> pids) {
        this.pids = pids;
    }

    /**
     * @return the oHandler
     */
    public OrderHandler getoHandler() {
        return oHandler;
    }

    /**
     * @param oHandler the oHandler to set
     */
    public void setoHandler(OrderHandler oHandler) {
        this.oHandler = oHandler;
    }

    /**
     * @return the items
     */
    public int getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(int items) {
        this.items = items;
    }

    /**
     * @return the orderTotal
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * @param orderTotal the orderTotal to set
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }


}
