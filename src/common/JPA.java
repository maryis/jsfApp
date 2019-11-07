package common;

import exception.DBException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {

    private JPA() {
    }

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("X");

    public static EntityManager getEntityManager() throws DBException {
        try {
            return factory.createEntityManager();
        } catch (Exception e) {
            throw new DBException("error in creating entity manager", e);
        }
    }
}
