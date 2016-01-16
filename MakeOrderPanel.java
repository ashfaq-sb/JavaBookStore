package com.ash.ood;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MakeOrderPanel extends JPanel {

    public static boolean check = false;
    public static ArrayList<Product> orderList;
    javax.swing.JDesktopPane desktop;
    int c = 0;
    private JList<String> pList, oList;
    private JScrollPane spOList, tsPane, spPList;
    private DefaultListModel<String> oListModel;
    private GridBagLayout gbl;
    private JTable table;
    private JButton addBtn, removeBtn, clearBtn, checkoutBtn;
    private JLabel totalLbl;
    private double orderTotal;
    private OrderHandler pHandler;

    public MakeOrderPanel(javax.swing.JDesktopPane desktop2, ProductHandler pHandler) {
        super();
        this.desktop = desktop2;
        gbl = new GridBagLayout();
        setLayout(gbl);
        // TODO Auto-generated constructor stub
        this.addBtn = new JButton("Add to order");
        this.removeBtn = new JButton("Remove from order");
        this.clearBtn = new JButton("Clear");
        this.checkoutBtn = new JButton("Checkout");
        this.totalLbl = new JLabel("Total: ");
        oList = new JList<>();
        oListModel = new DefaultListModel<>();
        //oList.setModel(oListModel);
        spOList = new JScrollPane(oList);
        //listModel = new DefaultListModel<String>();
        ProductPanel p = new ProductPanel(pHandler);
        table = p.getTable();
        tsPane = new JScrollPane(table);
        pList = p.getList();
        spPList = new JScrollPane(pList);
        TitledBorder border = BorderFactory.createTitledBorder("Product Catagories");
        pList.setBorder(border);
        TitledBorder border2 = BorderFactory.createTitledBorder("Order\n\nasddsadsa");
        oList.setBorder(border2);


        orderList = new ArrayList<Product>();
        addBtn.addActionListener(e -> {

            if (table != null && !pHandler.object.isEmpty()) {
                try {
                    orderTotal = orderTotal + Double.parseDouble(table.getValueAt(table.getSelectedRow(), 2).toString());
                    String tl = "Total: £" + (float) orderTotal;

                    totalLbl.setText(tl);
                    int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));


                    c++;
                    Product prod = pHandler.getProductById(id - 1);
                    orderList.add(prod);
                    oListModel.addElement(c + " | " + " " + prod.productDetails() + " | " + prod.getCost() + " | " + prod.getCat());
                    //System.out.println(s);
                    String sid = (String) table.getValueAt(table.getSelectedRow(), 0);
                    int pid = Integer.parseInt(sid);

                    // orderList.add(pHandler.getProductById(id - 1));
                    id = 0;

                    oList.setModel(oListModel);


                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    //e1.printStackTrace();
                }


            } else {
                JOptionPane.showMessageDialog(this, JOptionPane.INFORMATION_MESSAGE, "No Orders added yet", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        clearBtn.addActionListener(e -> {
            if (table != null && !pHandler.object.isEmpty()) {
                oListModel.removeAllElements();
                //orderList.remove(c);
                for (int i = 0; i < orderList.size(); i++) {
                    orderList.remove(i);
                }
                c = 0;
                orderTotal = 0.0;
                String tl = "Total: £" + orderTotal;
                totalLbl.setText(tl);

            }
        });
        checkoutBtn.addActionListener(e -> addCustomerPanel());
        MainMenu.addComp(this, spPList, 0, 0, 1, 1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.SOUTH);

        MainMenu.addComp(this, tsPane, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        JPanel btnGroup = new JPanel(new FlowLayout());
        btnGroup.add(addBtn);
        btnGroup.add(removeBtn);
        btnGroup.add(clearBtn);
        btnGroup.add(checkoutBtn);

        MainMenu.addComp(this, btnGroup, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);

        MainMenu.addComp(this, totalLbl, 3, 1, 1, 1, GridBagConstraints.PAGE_END, GridBagConstraints.BOTH);
        MainMenu.addComp(this, spOList, 3, 0, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
    }

    public void addCustomerPanel() {
        if (!oListModel.isEmpty()) {

            int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
            //System.out.println(pHandler.getProductById(1).getName());
            //Customer panel
            //AddCustomerPanel panel = new AddCustomerPanel(orderList,orderTotal,c); // create new panel
            JInternalFrame of = new JInternalFrame("ASD");
            of.setContentPane(new AddCustomerPanel(of, orderTotal, c));

            for (Product p : MakeOrderPanel.orderList) {

                JOptionPane.showMessageDialog(null, p.productDetails() + "\n");
            }


            desktop.add(of);
            of.setVisible(true);
            of.setClosable(true);
            of.setMaximizable(true);
            of.setResizable(true);
        }
    }
    //public
}
