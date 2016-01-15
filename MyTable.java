package com.ash.ood;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MyTable extends AbstractTableModel {
    private ArrayList datalist = new ArrayList();
    private String[] columns = null;
    private Class[] colClass = null;

    public MyTable() {

    }

    public MyTable(ArrayList list) {
        addList(list);
    }

    public MyTable(ArrayList list, String[] columns, Class[] colClass) {
        this.columns = columns;
        this.setColClass(colClass);

        this.datalist.addAll(list);
        // setColumns(columns);
    }

    @Override
    public int getRowCount() {
        return datalist.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String getColumnName(int col) {
        return this.columns[col];
    }

    @Override
    public String getValueAt(int row, int col) {
        boolean isPList = true;
        Product p = null;
        Order o = null;
        try {
            p = (Product) datalist.get(row);

        } catch (Exception e) {
            o = (Order) datalist.get(row);
            isPList = false;
        }

        if (!isPList) {
            switch (col) {
                case 0:
                    return String.valueOf(o.getOrderNo());
                case 1:
                    return Integer.toString(o.getNoOfitems());
                case 2:
                    return o.getOrderDate();
                case 3:
                    return Double.toString(o.getOrderTotal());
                case 4:
                    return o.getC().getcName();
                case 5:
                    return o.getC().getcAddress();
                default:
                    return null;
            }
        } else {
            boolean book = p.getCat().equals(Catagory.Book);
            boolean soft = p.getCat().equals(Catagory.Software);
            if (book) {
                Book b = (Book) datalist.get(row);
                switch (col) {
                    case 0:
                        return Integer.toString(b.getid());
                    case 1:
                        return b.getName();
                    case 2:
                        return Double.toString(b.getCost());
                    case 3:
                        return Integer.toString(b.getYearOfPubl());
                    case 4:
                        return b.getPublishingHouse();
                    case 5:
                        return b.getAuthor();
                    case 6:
                        return b.getISBN();
                    case 7:
                        return Integer.toString(b.getNoOfPages());
                    default:
                        return null;
                }
            } else if (soft) {
                Software s = (Software) datalist.get(row);

                switch (col) {
                    case 0:
                        return Integer.toString(s.getid());
                    case 1:
                        return s.getName();
                    case 2:
                        return Double.toString(s.getCost());
                    case 3:
                        return Integer.toString(s.getYearOfPubl());
                    case 4:
                        return s.getPublishingHouse();
                    case 5:
                        return s.getProcessorRequired();
                    case 6:
                        return s.getRAM();
                    default:
                        return null;

                }
            }

        }
        return null;

    }

    public void addList(ArrayList list) {
        this.datalist.addAll(list);
        fireTableDataChanged();
    }

    public void addProduct(Product p) {
        this.datalist.add(p);
        fireTableDataChanged();
    }

    public void addRow(String[] rowData) {
        int row = datalist.size();
        this.datalist.add(rowData);
        fireTableRowsInserted(row, row);
    }

    public Class[] getColClass() {
        return colClass;
    }

    public void setColClass(Class[] colClass) {
        this.colClass = colClass;
    }


    public void addRow(Order orderbyId) {
        int row = datalist.size();
        this.datalist.add(orderbyId);
        fireTableRowsInserted(row, row);

    }

}

