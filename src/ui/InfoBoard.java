package ui;

import javax.swing.*;

public class InfoBoard {
    private JPanel infoPanel;
    private JTextArea description;

    public InfoBoard(){
        infoPanel=new JPanel();
        description=new JTextArea();
        infoPanel.add(description);
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }
}
