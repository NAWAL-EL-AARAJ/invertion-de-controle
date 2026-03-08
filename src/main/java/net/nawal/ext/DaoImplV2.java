package net.nawal.ext;

import net.nawal.dao.IDao;

public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version capteurs...");
        double t =12;
        return t ;
    }
}
