/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.alma.client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author indy
 */
@Stateless
public class ClientBean implements ClientBeanRemote {

    @PersistenceContext
    private EntityManager em;

    public long createClient(String name, String adress, String pwd) {
        Client client = new Client(name, adress, pwd);
        em.persist(client);
        return client.getId();
    }

    public Client getClient(long id) {
        Query query = em.createQuery("from Client where id = :id and pwd = :pwd");
        query.setParameter("id", id);
        return (Client) query.getSingleResult();
    }

    public Client getClient(String name, String pwd) {
        Query query = em.createQuery("from Client where name = :name and pwd = :pwd");
        query.setParameter("name", name);
        query.setParameter("pwd", pwd);
        return (Client) query.getSingleResult();
    }

    public long updateClient(Integer id, String name, String adress, String pwd, String oldPwd) {
        Query query = em.createQuery("from Client where id = :id and pwd = :pwd");
        query.setParameter("id", id);
        query.setParameter("pwd", oldPwd);
        Client client = (Client) query.getSingleResult();
        if (client == null) {
            return -1;
        }
        if (name != null) {
            client.setName(name);
        }
        if (adress != null) {
            client.setAdress(adress);
        }
        if (pwd != null) {
            client.setPwd(pwd);
        }
        em.merge(client);
        return client.getId();
    }
}
