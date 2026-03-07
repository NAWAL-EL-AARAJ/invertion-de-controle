package net.nawal.metier;

import net.nawal.dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;// couplage faible

    /**
     * pour injecter dans l'attribut dao un objet d'une classe qui implemente
     * l'interface IDO au moment de l'instanciation
     */

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t *12 *Math.PI/2 *Math.cos(t);
        return res ;
    }

    /**
     *     pour injecter dans la variable dao un objet de type idao
     *     cad objet d'une classe qui implemente IDO apres instanciation
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
