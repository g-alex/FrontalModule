/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.alma.order;

import fr.alma.dto.central.Item;
import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author indy
 */
@Entity
@Table(name = "Ordering")
public class Ordering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientName;
    private String clientAdress;
    private HashMap<Item, Integer> products;

    public Ordering() {
        super();
    }

    public Ordering(String clientName, String clientAdress) {
        super();
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.products = new HashMap<Item, Integer>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer addProduct(Item product, Integer quantity) {
        if (this.products.containsKey(product)) {
            quantity += this.products.get(product);
        }
        return this.products.put(product, quantity);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.alma.order.Order[id=" + id + "]";
    }
}
