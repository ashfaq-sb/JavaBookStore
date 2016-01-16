package com.ash.ood;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static com.ash.ood.MainMenu.addComp;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {

    public static OrderHandler oh = new OrderHandler();
    static DefaultListModel<String> oListModel;
    private JList<String> oList;
    private JScrollPane spOList, otsPane, ptsPane, spTextPane;
    private GridBagLayout gbl;
    private JButton refresh, showOrderDetails;
    private JTable orderTable, productTable;
    private DefaultTableModel tableModel;
    private JTextPane invoice;

    //Constructor
    public OrderPanel() {
        /*
        This Class is using its own JList and populate  tables using custom MyTable model
		Initialise fields
		*/
        this.oList = new JList<>();
        oListModel = new DefaultListModel<>();
        oList.setModel(oListModel);
        this.gbl = new GridBagLayout();
        this.orderTable = new JTable();
        this.productTable = new JTable();

        this.ptsPane = new JScrollPane(oList);
        this.spOList = new JScrollPane(oList);
        ptsPane.setViewportView(productTable);
        spOList.setViewportView(oList);
        this.otsPane = new JScrollPane(orderTable);
        otsPane.setViewportView(orderTable);
        this.invoice = new JTextPane();
        this.spTextPane = new JScrollPane(invoice);
        spTextPane.setViewportView(invoice);
        this.refresh = new JButton("Refresh");
        this.showOrderDetails = new JButton("Order Detail");
        setLayout(gbl);
        //Make GUI
        //addComp(this, spOList, 0, 0, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
        addComp(this, otsPane, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
        addComp(this, spTextPane, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComp(this, refresh, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this, showOrderDetails, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);


        //tableModel.TableModelListener(new SharedListSelectionHandler(orderTable,oh){});
        MouseListener mouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                JTable ot = (JTable) e.getSource();
                System.out.println(ot.getValueAt(ot.getSelectedRow(), 0));


            }
        };

        oList.setModel(oListModel);
        refresh.addActionListener(this);
        this.showOrderDetails.addActionListener(this);

    }

    public JTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(JTable orderTable) {
        this.orderTable = orderTable;
    }

    public void fillOrderTable() {
        // Custom Table Model
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"OrderNo.", "Total Items", "Order Date", "Total Cost", "",
                "Customer Name", "Customer Address"});
        tableModel.addRow(oh.getProductDetails().split(" "));
        tableModel.fireTableDataChanged();
        orderTable.setModel(tableModel);
        orderTable.revalidate();
        orderTable.repaint();
    }

    public void createInvoice() {
        final String[] products = {""};
//        for(Order o: OrderPanel.oh.object) {
//
//           products =""+o.getPDetails().;
//        }
        if (oh.object.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No orders Added yet");

        } else {
            //oh.getOrder().getProducts().forEach(products2 -> {

            int id = 0;
            try {
                id = Integer.parseInt((String) this.getOrderTable().getValueAt(this.getOrderTable().getSelectedRow(), 0));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            Order o = oh.getOrderbyId(id - 1);

            //  " | " + " " + prod.productDetails() + " | " + prod.getCost() + " | " + prod.getCat()
            String s = "";
            for (Product p : o.getProducts()
                    ) {

                s = s + p.productDetails().replace(" ", ",") + "," + p.getCat() + "\n";
                invoice.setText(s);
            }


            // } );
            //.replace(" ","\t"));

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refresh) {
            try {
            //fill table
            fillOrderTable();
                tableModel.fireTableDataChanged();
                orderTable.revalidate();
                orderTable.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No orders Added yet");
                System.out.println(ex);
            }
        }
        if (e.getSource() == showOrderDetails) {

            createInvoice();
            System.out.println(getOrderTable().getSelectedColumn());

        }



    }
}



