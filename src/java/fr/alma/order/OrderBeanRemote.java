/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.alma.order;

import fr.alma.dto.central.Item;
import javax.ejb.Remote;

/**
 *
 * @author indy
 */
@Remote
public interface OrderBeanRemote {

    public long createOrder(String clientName, String clientAdress);

    public Integer addProduct(Long orderId, Item product, Integer quantity);

    public Ordering getOrder(Long orderId);
}
