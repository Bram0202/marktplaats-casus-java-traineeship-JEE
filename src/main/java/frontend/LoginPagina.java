package frontend;

import dao.GebruikerDao;

import javax.persistence.NoResultException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static util.Util.mysql;

public class LoginPagina {

    /*
    Een aantal velden worden aangemerkt als 'never used', sommige worden wel gebruikt in de frontend,
     maar niet opgemerkt door IntelliJ! Deze dus NIET verwijderen!
     */
    private JButton jButton_login;
    private JPanel jPanel_login;
    private JTextField jTextField_email;
    private JLabel jLabel_email;
    private JLabel jLabel_wachtwoord;
    private JPasswordField jPasswordField;
    private JLabel jLabel_titel;

    private final GebruikerDao gebruikerDao = new GebruikerDao(mysql());

    public LoginPagina() {
        setup();

        jButton_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gebruikerDao.login(jTextField_email.getText(), jPasswordField.getText()); // TODO: getText -> getPassword
                } catch (NoResultException noResultException) {
                    System.out.println(noResultException);
                }
            }
        });
    }

    private void setup() {
        JFrame jFrame = new JFrame("Marktplaats Online");
        jFrame.setContentPane(jPanel_login);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1200, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
