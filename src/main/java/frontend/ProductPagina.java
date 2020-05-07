package frontend;

import javax.swing.*;

public class ProductPagina {
    private JPanel jPanel_producten;
    private JPanel jPanel_menu;
    private JPanel jPanel_main_producten;
    private JButton button1;
    private JTextField jTextField_zoeken;
    private JButton jButton_zoeken;
    private JList jList_zoekResultaten;
    private JLabel jLabel_titel;

    public JPanel getjPanel_producten() {
//        jPanel_producten.setVisible(true);
        return jPanel_producten;
    }

    public JPanel getjPanel_menu() {
//        jPanel_menu.setVisible(true);
        return jPanel_menu;
    }

    public JPanel getjPanel_main_producten() {
//        jPanel_main_producten.setVisible(true);
        return jPanel_main_producten;
    }

    public void setJPanelToVisible() {
        jPanel_producten.setVisible(true);
        jPanel_menu.setVisible(true);
        jPanel_main_producten.setVisible(true);
    }
}
