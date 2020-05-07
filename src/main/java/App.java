import frontend.LoginPagina;
import frontend.ProductPagina;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;

import static util.Util.mysql;

public class App {
    private final JFrame jFrame = new JFrame("Marktplaats Online");
    private Container container;

    public static void main(String[] args) {
        new App() {
        };
    }

    App() {
        EntityManager em = mysql();
        setupJFrame();

        ProductPagina pp = new ProductPagina();
        LoginPagina loginPagina = new LoginPagina();
//        jFrame.setContentPane(lp.getjPanel_login());
        container.add(loginPagina.getjPanel());
        jFrame.setVisible(true);

        while (!loginPagina.loginIsSucces()) {
            if (loginPagina.loginIsSucces()) {
//                pp.setJPanelToVisible();
                //TODO: Waar blijft app hangen nu na inloggen
                container.add(pp.getjPanel_producten());
                container.add(pp.getjPanel_menu());
                container.add(pp.getjPanel_main_producten());
//            jFrame.setContentPane(pp.getjPanel_producten());
                jFrame.setVisible(true);
            }
        }
    }

    private void setupJFrame() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1200, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        container = jFrame.getContentPane();
    }

}
