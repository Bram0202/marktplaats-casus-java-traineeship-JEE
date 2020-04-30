package frame;

import dao.GebruikerDao;

import javax.persistence.NoResultException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static util.Util.mysql;

public class Window {

    JFrame jframe = new JFrame("Marktplaats Online");
    JPanel jPanel_infoBalk = new JPanel();
    JLabel jLabel_email = new JLabel("E-mailadres: ");
    JLabel jLabel_wachtwoord = new JLabel("Wachtwoord: ");
    JLabel jLabel_actieveGebruiker = new JLabel("Bram");
    JTextField textField_email = new JTextField(10);
    JPasswordField textField_wachtwoord = new JPasswordField(10);
    JButton jButton = new JButton("Login");

    public Window() {
        setup();
        loginHandler();
    }

    private void setup() {
        loginPanel();

        jframe.setSize(600, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null); // Centreert het window in het midden van het scherm.
        jframe.setLayout(null);

//        jPanel_infoBalk.setBounds(100, 15, 400, 50);
//        jPanel_infoBalk.setLayout(new GridLayout(1, 1));
//        jPanel_infoBalk.add(jLabel_actieveGebruiker);
    }

    private void loginPanel() {
        JPanel jPanel = new JPanel();
        jPanel.add(jLabel_email);
        jPanel.add(textField_email);
        jPanel.add(jLabel_wachtwoord);
        jPanel.add(textField_wachtwoord);
        jPanel.add(jButton);
        jframe.add(jPanel);
    }

    private void loginHandler() {
        GebruikerDao gebruikerDao = new GebruikerDao(mysql());

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    gebruikerDao.login(textField_email.getText(), textField_wachtwoord.getText());
                } catch (NoResultException noResultException) {
                    System.out.println(noResultException);
                }
            }
        });
    }

}
