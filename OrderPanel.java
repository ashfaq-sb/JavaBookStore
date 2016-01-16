package com.ash.ood;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static com.ash.ood.MainMenu.addComp;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {

    public static OrderHandler oh;
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
        oh = new OrderHandler();
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
        tableModel.setColumnIdentifiers(new String[]{"OrderNo.", "Total Items", "Order Date", "Total Cost",
                "Customer Name", "Customer Address"});
        tableModel.addRow(OrderPanel.oh.getProductDetails().split(" "));
        tableModel.fireTableDataChanged();
        orderTable.setModel(tableModel);
        orderTable.revalidate();
        orderTable.repaint();
    }

    public void createInvoice() {
        String products = "";
//        for(Order o: OrderPanel.oh.object) {
//
//           products =""+o.getPDetails().;
//        }

        this.invoice.setText("" + products + oh.getPDetails());

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refresh) {

            //fill table
            fillOrderTable();

        }
        if (e.getSource() == showOrderDetails) {
            createInvoice();
        }

    }
}



