package br.com.francisnei.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Classe responsável por gerenciar o banco de dados
 *
 * @author Alyson
 * @param <T>
 * @since 31/05/2019
 * @version 1.0
 */
public class GenericDAO<T extends EntidadeBase> {

    private static EntityManager entityManager;

    private boolean status;

    public GenericDAO() {
        entityManager = ConnectionFactory.getEntityManager();
        this.status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Método responsável por Salvar
     *
     * @author Alyson
     * @param obj
     * @since 31/05/2019
     * @version 1.0
     */
    public void saveOrUpdate(T obj) {
        try {
            entityManager = ConnectionFactory.getEntityManager();
            status = true;
            entityManager.getTransaction().begin();
            if (obj.getId() == null) {
                entityManager.persist(obj);

            } else {
                entityManager.merge(obj);

            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();

        } finally {

            entityManager.close();
        }
    }

    /**
     * Método responsável por retornar um item por ID
     *
     * @author Alyson
     * @param clazz
     * @param id
     * @return
     * @since 31/05/2019
     * @version 1.0
     */
    public T findById(Class<T> clazz, Integer id) {
        return entityManager.find(clazz, id);
    }

    /**
     * Método responsável por excluir
     *
     * @author Alyson
     * @param clazz
     * @param id
     * @since 31/05/2019
     * @version 1.0
     */
    public void remove(Class<T> clazz, Integer id) {
        try {
            entityManager = ConnectionFactory.getEntityManager();
            status = true;

            T t = findById(clazz, id);

            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();

        } finally {

            entityManager.close();
        }
    }

    public List<T> list(Class<T> entidade) {
        entityManager = ConnectionFactory.getEntityManager();
        List<T> lista = null;
        try {

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            lista = entityManager.createQuery("from " + entidade.getName()).getResultList();

            transaction.commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {

            entityManager.close();
        }

        return lista;
    }

}
