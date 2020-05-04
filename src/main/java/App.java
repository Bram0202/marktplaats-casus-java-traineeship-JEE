import dao.CategorieDao;
import dao.GebruikerDao;
import dao.ProductDao;
import domain.Categorie;
import domain.Gebruiker;
import domain.Product;
import domain.Soort;
import frontend.LoginPagina;

import javax.persistence.EntityManager;

import java.math.BigDecimal;

import static domain.Soort.PRODUCT;
import static util.Util.mysql;

public class App {

    public static void main(String[] args) {
        new App() {};
    }

    App() {
        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);
        ProductDao productDao = new ProductDao(em);
        CategorieDao cd = new CategorieDao(em);

        new LoginPagina();
        cd.insert(new Categorie("Fietsen"));
        Categorie fietsen = cd.select("Fietsen");
        productDao.insert(new Product("Ouwe kroegfiets", BigDecimal.valueOf(15), PRODUCT, fietsen));
    }

}
