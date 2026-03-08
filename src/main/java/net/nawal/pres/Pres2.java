package net.nawal.pres;

import net.nawal.dao.IDao;
import net.nawal.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner=new Scanner(new File("config.txt"));

        String daoClassName=scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao d =(IDao) cDao.newInstance();

        String metierClassName=scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier= (IMetier) cMetier.getConstructor().newInstance();
        Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(metier, d);
        //IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        System.out.println("res="+metier.calcul());
    }
}
