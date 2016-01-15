package com.ash.ood;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.ash.ood.MainMenu.addComp;


@SuppressWarnings("serial")
public class AddProductPanel extends JPanel {
    ProductHandler pHandler;
    JLabel nameLabel, costLabel, yearLabel, pubHouseLabel, catgLabel, isbnLable, pagesLabel, ramLabel, processorLabel;
    JTextField nameText, costText, yearText, isbnText, pageText, ramText, processorText, pubHouseText;
    JPanel panel;
    GridBagLayout gbl;
    JComboBox<String> comboBox;
    SoftwarePanel sPanel;
    BookPanel bPanel = new BookPanel();
    Boolean cbSelected;
    JButton addButton;
    ProductPanel productPanel;
    private JButton clearButton;

    //Constructor
    public AddProductPanel(ProductHandler pHandler, ProductPanel pPanel) {
        //setSize(400,800);
        gbl = new GridBagLayout();
        String comoLabels[] = {"Select Catagory", "Book", "Software"};
        comboBox = new JComboBox<>(comoLabels);
        this.productPanel = pPanel;
        this.panel = new JPanel();
        this.panel.setLayout(gbl);
        TitledBorder border2 = BorderFactory.createTitledBorder("Product");
        this.panel.setBorder(border2);
        this.clearButton = new JButton("Clear");
        cbSelected = true;
        // Add components to the panel

        //
        this.pHandler = pHandler;
        productPanel = new ProductPanel(pHandler);
        // Create labels,text fields
        createPanel();
        clearButton.setVisible(false);

        comboBox.addActionListener(e -> comboBoxChanged(e));
        addButton.addActionListener(e -> addProduct());
        sPanel = new SoftwarePanel();

        setLayout(gbl);
        addComp(this, panel, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);


    }

    public void createPanel() {
        this.nameText = new JTextField(15);
        this.costText = new JTextField(15);
        this.yearText = new JTextField(15);
        this.pubHouseText = new JTextField(15);
        this.addButton = new JButton("Add");
        // GridBagLayout
        /// Labels
        nameLabel = new JLabel("Name of Product : ");
        costLabel = new JLabel("Cost of Product : ");
        yearLabel = new JLabel("Year of Publication : ");
        pubHouseLabel = new JLabel("Publising House : ");
        catgLabel = new JLabel("Catagory : ");

        // product name
        addComp(this.panel, nameLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, nameText, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        // product cost
        addComp(this.panel, costLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, costText, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        // year of publication

        addComp(this.panel, yearLabel, 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, yearText, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        // publisihing house
        addComp(this.panel, pubHouseLabel, 0, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, pubHouseText, 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        // combo box
        addComp(this.panel, catgLabel, 0, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, comboBox, 1, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        addComp(panel, addButton, 0, 13, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(panel, clearButton, 1, 13, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addButton.setVisible(false);
    }

    private void addProduct() {

        // Get All textFields data
        String name = nameText.getText();
        String pubHouse = pubHouseText.getText();
        String ram = sPanel.getRamText().getText();
        String proccesor = sPanel.getProcessorText().getText();
        String author = this.bPanel.getAuthorText().getText();
        String isbn = this.bPanel.getIsbnText().getText();
        int pages = 0;
        int year = 0;
        double cost = 0.0;

        try {
            cost = Double.parseDouble(costText.getText());
            year = Integer.parseInt(yearText.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter a number");
        }

        if (comboBox.getSelectedItem().toString().equals("Software")) {

            pHandler.addObject(new Software(Catagory.Software, name, cost, year, pubHouse, ram, proccesor));

        } else if (comboBox.getSelectedItem().toString().equals("Book")) {
            try {
                pages = Integer.parseInt(this.bPanel.getNoOfPagesText().getText());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter a number");
            }
            pHandler.addObject(new Book(Catagory.Book, name, cost, year, pubHouse, author, isbn, pages));

        }

        clearTextFields();

    }


    public void comboBoxChanged(ActionEvent e) {

        JComboBox<String> cb = (JComboBox<String>) e.getSource();

        switch (cb.getSelectedItem().toString()) {

            case "Select Catagory":
                hidePanels();
                break;
            case "Book":
                displayBookPanel();
                break;
            case "Software":
                displaySoftwarePanel();
                break;
            default:
                break;
        }

    }

    public void clearTextFields() {
        this.nameText.setText("");
        this.costText.setText("");
        this.yearText.setText("");
        this.pubHouseText.setText("");
        sPanel.clearTextField();
        bPanel.clearTextField();
    }

    public void hidePanels() {
        sPanel.setVisible(false);
        bPanel.setVisible(false);
        addButton.setVisible(false);
        clearButton.setVisible(false);

    }

    public void displayBookPanel() {
        bPanel.setVisible(true);
        sPanel.setVisible(false);
        addButton.setVisible(true);
        clearButton.setVisible(true);
        addComp(panel, bPanel, 0, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);

    }

    public void displaySoftwarePanel() {
        sPanel.setVisible(true);
        bPanel.setVisible(false);
        addButton.setVisible(true);
        clearButton.setVisible(true);

        addComp(this.panel, sPanel, 0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.REMAINDER);

    }
}
