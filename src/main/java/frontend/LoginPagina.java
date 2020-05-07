package frontend;

import dao.GebruikerDao;

import javax.persistence.NoResultException;
import javax.swing.*;

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
    private boolean loginIsSucces = false;
    private final GebruikerDao gebruikerDao = new GebruikerDao(mysql());

    public LoginPagina() {

        jButton_login.addActionListener(actionEvent -> {
            try {
                loginIsSucces = gebruikerDao.login(jTextField_email.getText(), jPasswordField.getText()); // TODO: getText -> getPassword
                jPanel_login.setVisible(false);
            } catch (NoResultException e) {
                System.out.println(e);
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel_login;
    }

    public boolean loginIsSucces() {
        return loginIsSucces;
    }
}
