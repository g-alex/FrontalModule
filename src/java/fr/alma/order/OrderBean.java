/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.alma.order;

import fr.alma.dto.central.Item;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author indy
 */
@Stateless
public class OrderBean implements OrderBeanRemote {

    @PersistenceContext
    private EntityManager em;

    public long createOrder(String clientName, String clientAdress) {
        Ordering order = new Ordering(clientName, clientAdress);
        em.persist(order);
        return order.getId();
    }

    public Integer addProduct(Long orderId, Item product, Integer quantity) {
        Ordering order = this.getOrder(orderId);
        Integer oldQuantity = order.addProduct(product, quantity);
        em.merge(order);
        return oldQuantity;
    }

    public Ordering getOrder(Long orderId) {
        Query query = em.createQuery("from Ordering where id = :id");
        query.setParameter("id", orderId);
        return (Ordering) query.getSingleResult();
    }
}
