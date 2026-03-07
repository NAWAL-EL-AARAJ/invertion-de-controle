package net.nawal.pres;

import net.nawal.dao.DaoImpl;
import net.nawal.metier.MetierImpl;
import net.nawal.net.nawal.ext.DaoImplV2;

public class Pres1 {
    static void main() {
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d); // injection dep via setter
        System.out.println("res="+metier.calcul());
    }
}
