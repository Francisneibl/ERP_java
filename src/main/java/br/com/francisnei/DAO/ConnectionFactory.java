package br.com.francisnei.DAO;

import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsável pela configuração do banco de dados
 *
 * @author
 * @since 31/05/2019
 * @version 1.0
 */
public class ConnectionFactory {

    //Objetos
    private static EntityManagerFactory factory = null;
    private static boolean status = false;
    private static Map<String, String> persistenceMap;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {

            init();
        } catch (IOException ex) {

        }
    }

    /**
     * Método responsável pela inicializaçaõ do banco de dados
     *
     * @author
     * @since 31/05/2019
     * @version 1.0
     */
    private static void init() throws IOException {

        try {

            factory = Persistence.createEntityManagerFactory("DatabasePU");
            status = true;
        } catch (Exception e) {
            System.out.println("" + e);
            status = false;
            System.out.println("ERRO");

        }

    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static boolean isStatus() {
        return status;
    }

}
