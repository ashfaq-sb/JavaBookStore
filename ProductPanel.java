package com.ash.ood;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.ash.ood.MainMenu.addComp;

@SuppressWarnings("serial")
public class ProductPanel extends JPanel {
    private JPanel panel;
    private GridBagLayout gbl;
    private JList<String> list;
    private ProductHandler pHandler;
    private DefaultListModel<String> listModel;
    private JScrollPane listScrollPane, tsPane;
    private JTable table;
    private MyTable model;


    public ProductPanel(ProductHandler pHandler) {


        this.pHandler = pHandler;
        table = new JTable();
        listModel = new DefaultListModel<>();
        gbl = new GridBagLayout();
        setLayout(gbl);
        list = new JList<>();
        ListSelectionModel listSelectionModel = list.getSelectionModel();
        listSelectionModel.addListSelectionListener(
                new SharedListSelectionHandler(this.table, this.pHandler));

        MouseListener tableMouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(table.getValueAt(table.getSelectedRow(), 0));


            }
        };
        //table.addMouseListener(tableMouseListener);

        listModel.addElement("Software");
        listModel.addElement("Book");

        list.setSelectedIndex(0);
        list.setModel(listModel);
        setBackground(Color.gray);
        //	Main.addComp(this.panel, listScrollPane, 0, 1, 1, 1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE);
        //	Main.addComp(this.panel, tsPane, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        listScrollPane = new JScrollPane(list);
        tsPane = new JScrollPane(table);
        tsPane.setViewportView(table);
        addComp(this, listScrollPane, 0, 0, 1, 1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH);
        addComp(this, tsPane, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
        TitledBorder border = BorderFactory.createTitledBorder("Product Catagories");
        list.setBorder(border);

        list.setPreferredSize(new Dimension(90, 90));
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JList<String> getList() {
        return list;
    }

    public void setList(JList<String> list) {
        this.list = list;
    }
}
