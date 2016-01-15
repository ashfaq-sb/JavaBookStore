package com.ash.ood;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SharedListSelectionHandler implements ListSelectionListener {
    JTable t;
    ProductHandler ph;
    OrderHandler oh;
    MyTable model;

    public SharedListSelectionHandler() {
        // TODO Auto-generated constructor stub
    }

    public SharedListSelectionHandler(JTable t, ProductHandler ph) {
        this.ph = ph;
        this.t = t;
        model = new MyTable();

    }

    public SharedListSelectionHandler(JTable table, OrderHandler oh) {
        this.oh = oh;
        this.t = table;
        model = new MyTable();

    }

    public void valueChanged(ListSelectionEvent e) {

        ListSelectionModel lsm = (ListSelectionModel) e.getSource();

        if (lsm.isSelectionEmpty()) {
            // output.append(" <none>");
            System.out.println("none");
        }
        if (lsm.isSelectedIndex(1)) {

            String[] bookColumn = new String[]{"Id", "Name", "Cost", "Pub-year", "Pub-House", "Author", "ISBN", "Pages"};
            Class[] bookColClass = new Class[]{Integer.class, String.class, Double.class, Integer.class, String.class, String.class, String.class, Integer.class};

            model = new MyTable(ph.getCatList(Catagory.Book), bookColumn, bookColClass);
            t.setModel(model);
            t.revalidate();
            t.repaint();
        }
        if (lsm.isSelectedIndex(0)) {
            String[] softcolumn = new String[]{"Id", "Name", "Cost", "Pub-year", "Pub-House", "Processor", "RAM"};
            Class[] softcolClass = new Class[]{Integer.class, String.class, Double.class, Integer.class, String.class, String.class, String.class};

            model = new MyTable(ph.getCatList(Catagory.Software), softcolumn, softcolClass);
            t.setModel(model);
            t.revalidate();
            t.repaint();
        }

        ListSelectionModel tsm = (ListSelectionModel) e.getSource();
        if (tsm.isSelectionEmpty()) {
            System.out.println("asddas");
        }

    }

}
