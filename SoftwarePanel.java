package com.ash.ood;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static com.ash.ood.MainMenu.addComp;

@SuppressWarnings("serial")
public class SoftwarePanel extends JPanel {
    private JTextField ramText;
    private JTextField processorText;
    private JLabel ramLabel;
    private JLabel processorLabel;
    private GridBagLayout gbl;
    private JPanel panel;

    public SoftwarePanel() {
        this.setRamText(new JTextField(8));
        this.setRamLabel(new JLabel("Ram Size: "));
        this.setProcessorLabel(new JLabel("Processor Req: "));
        this.setProcessorText(new JTextField(8));

        this.setGbl(new GridBagLayout());
        this.setPanel(new JPanel());
        this.getPanel().setLayout(getGbl());
        Border border = BorderFactory.createTitledBorder("Software");
        getPanel().setBorder(border);

        //Create GUI
        addComp(this.getPanel(), getRamLabel(), 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.getPanel(), getRamText(), 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(this.getPanel(), getProcessorLabel(), 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(this.getPanel(), getProcessorText(), 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);


        add(getPanel());
    }

    public void clearTextField() {
        this.getRamText().setText("");
        this.getProcessorText().setText("");
    }

    public JTextField getRamText() {
        return ramText;
    }

    public void setRamText(JTextField ramText) {
        this.ramText = ramText;
    }

    public JTextField getProcessorText() {
        return processorText;
    }

    public void setProcessorText(JTextField processorText) {
        this.processorText = processorText;
    }

    public JLabel getRamLabel() {
        return ramLabel;
    }

    public void setRamLabel(JLabel ramLabel) {
        this.ramLabel = ramLabel;
    }

    public JLabel getProcessorLabel() {
        return processorLabel;
    }

    public void setProcessorLabel(JLabel processorLabel) {
        this.processorLabel = processorLabel;
    }

    public GridBagLayout getGbl() {
        return gbl;
    }

    public void setGbl(GridBagLayout gbl) {
        this.gbl = gbl;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
