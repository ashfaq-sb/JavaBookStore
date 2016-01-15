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
    private JButton refresh;
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
        setLayout(gbl);
        //Make GUI
        //addComp(this, spOList, 0, 0, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
        addComp(this, otsPane, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
        addComp(this, spTextPane, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComp(this, refresh, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        //tableModel.TableModelListener(new SharedListSelectionHandler(orderTable,oh){});
        MouseListener mouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println(table.getValueAt(table.getSelectedRow(), 0));

                //int index= Integer.parseInt(oList.getSelectedValue().substring(0,1));
                //Get first item in the order JList which is id of Product and fill table
                //fillOrderTable(oh);
                JTable ot = (JTable) e.getSource();
                System.out.println(ot.getValueAt(ot.getSelectedRow(), 0));


                //try{
                //if(tableModel.getRowCount()>0){
                //int selectedRow = (int) orderTable.getValueAt(orderTable.getSelectedRow(), 0);
                //int id = Integer.parseInt(String.valueOf());


                //	}catch (Exception es){
//
//	}

                //

                //}
            }
        };
        // add order list to mouse adapter
        //this.otsPane.addMouseListener(mouseListener);
        //orderTable.addMouseListener(mouseListener);
        oList.setModel(oListModel);
        refresh.addActionListener(this);

//		getOrderTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//
//			}
//		});

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
        //tableModel..setColClass(new Class[]{Integer.class,Double.class,String.class,Double.class,String.class,
        //	String.class});
        tableModel.addRow(OrderPanel.oh.getProductDetails().split(" "));
        tableModel.fireTableDataChanged();
        orderTable.setModel(tableModel);
        orderTable.revalidate();
        orderTable.repaint();
    }

    public void createInvoice() {
        // Custom Table Model
        //OrderHandler orderh = new OrderHandler();
        //System.out.println(id);
        //System.out.println(oh.object.size()+">>>>>");
        //System.out.println(oh.object.size());
        //Order o = OrderPanel.oh.getOrderbyId(id);
        String orderDetail = OrderPanel.oh.getProductDetails() + "\n";
        //System.out.println(orderDetail);
        this.invoice.setText(orderDetail.replace(" ", "\t"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refresh) {

            //fill table
            fillOrderTable();
            //getOrderTable().setRowSelectionAllowed(true);
            //System.out.println(getOrderTable().getSelectedRow());
            createInvoice();
        }

    }
}



