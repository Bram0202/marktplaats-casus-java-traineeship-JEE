package domain.categorie;

import javax.inject.Inject;

public class CategorieService {

    @Inject
    private CategorieDao categorieDao;

    public void voegCategorieToe(String naam) {
        categorieDao.insert(new Categorie(naam));
    }

    public Categorie getCategorie(String naam) {
        return categorieDao.select(naam);
    }
}
