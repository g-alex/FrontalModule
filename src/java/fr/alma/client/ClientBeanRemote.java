/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.alma.client;

import javax.ejb.Remote;

/**
 *
 * @author indy
 */
@Remote
public interface ClientBeanRemote {

    public long createClient(String name, String adress, String pwd);

    public Client getClient(long id);

    public Client getClient(String name, String pwd);

    public long updateClient(Integer id, String name, String adress, String pwd, String oldPwd);
}
