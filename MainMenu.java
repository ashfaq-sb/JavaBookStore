package com.ash.ood;


import javax.swing.*;
import java.awt.*;

/**
 * Created by ash on 02/11/2015.
 */
@SuppressWarnings("serial")
public class MainMenu extends JFrame {
    static boolean catSelected;
    private ProductHandler pHandler;
    private JPanel panel;
    private ProductPanel pPanel;
    private JTabbedPane tabbedPane;
    private MakeOrderPanel makeOrderPanel;
    private JDesktopPane desktop;
    private GridBagLayout gbl;

    public MainMenu() {

        pHandler = new ProductHandler();
        pHandler.addTestObjects(100);

        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);
        //Set up the GUI.
        desktop = new JDesktopPane();
        gbl = new GridBagLayout();
        setLayout(gbl);

        desktop.setLayout(gbl);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        //Make dragging a little faster but perhaps uglier.
        desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabbedPane.setPreferredSize(new Dimension(desktop.getWidth() - 50, desktop.getHeight() - 50));
        tabbedPane.addTab("Add Products", null, new AddProductPanel(pHandler, new ProductPanel(pHandler)), null);

        tabbedPane.addTab("Products", null, new ProductPanel(pHandler), null);
        tabbedPane.addTab("Make Order", null, new MakeOrderPanel(this.desktop, pHandler), null);
        tabbedPane.addTab("Orders", null, new OrderPanel(), null);

        addComp(desktop, tabbedPane, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComp(this, desktop, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        setVisible(true);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu();
            }
        });
    }

    public static void addComp(Container container, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch) {

        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5, 5, 5, 5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        container.add(comp, gridConstraints);

    }

    public void makeUI() {


    }


}
