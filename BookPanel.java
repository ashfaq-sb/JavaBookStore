package com.ash.ood;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static com.ash.ood.MainMenu.addComp;

@SuppressWarnings("serial")
public class BookPanel extends JPanel {

    private JPanel panel;
    private JTextField authorText;
    private JTextField isbnText;
    private JTextField noOfPagesText;
    private JLabel isbnLable;
    private JLabel authorLabel;
    private JLabel noOfPagesLabel;
    private GridBagLayout gbl;

    public BookPanel() {

        this.setAuthorText(new JTextField(15));
        this.setAuthorLabel(new JLabel("Author: "));
        this.setNoOfPagesLabel(new JLabel("Pages: "));
        this.setNoOfPagesText(new JTextField(5));
        setIsbnLable(new JLabel("ISBN : "));
        setIsbnText(new JTextField(15));
        this.panel = new JPanel();
        setGbl(new GridBagLayout());
        panel.setLayout(getGbl());
        Border border = BorderFactory.createTitledBorder("Book");
        panel.setBorder(border);

        //Create GUI
        // Add items to panel using addComp in Main.java class
        addComp(this.panel, getAuthorLabel(), 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, getAuthorText(), 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this.panel, getIsbnLable(), 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, getIsbnText(), 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this.panel, getNoOfPagesLabel(), 0, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.panel, getNoOfPagesText(), 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        add(panel);

    }

    public void clearTextField() {
        this.getAuthorText().setText("");
        this.getIsbnText().setText("");
        this.getNoOfPagesText().setText("");
    }

    public JTextField getAuthorText() {
        return authorText;
    }

    public void setAuthorText(JTextField authorText) {
        this.authorText = authorText;
    }

    public JTextField getIsbnText() {
        return isbnText;
    }

    public void setIsbnText(JTextField isbnText) {
        this.isbnText = isbnText;
    }

    public JTextField getNoOfPagesText() {
        return noOfPagesText;
    }

    public void setNoOfPagesText(JTextField noOfPagesText) {
        this.noOfPagesText = noOfPagesText;
    }

    public JLabel getIsbnLable() {
        return isbnLable;
    }

    public void setIsbnLable(JLabel isbnLable) {
        this.isbnLable = isbnLable;
    }

    public JLabel getAuthorLabel() {
        return authorLabel;
    }

    public void setAuthorLabel(JLabel authorLabel) {
        this.authorLabel = authorLabel;
    }

    public JLabel getNoOfPagesLabel() {
        return noOfPagesLabel;
    }

    public void setNoOfPagesLabel(JLabel noOfPagesLabel) {
        this.noOfPagesLabel = noOfPagesLabel;
    }

    public GridBagLayout getGbl() {
        return gbl;
    }

    public void setGbl(GridBagLayout gbl) {
        this.gbl = gbl;
    }
}
