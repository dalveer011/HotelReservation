/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.session;

import hotelreservation.entity.Addresses;
import hotelreservation.entity.Billingaddress;
import hotelreservation.entity.Customers;
import hotelreservation.entity.Mailingaddress;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author mazhar
 */
@Stateless
public class CustomerSessionBean implements CustomerSessionBeanRemote, CustomerSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @javax.persistence.PersistenceContext(unitName = "HotelReservation-ejbPU")
    private EntityManager em;

    @Override
    public Boolean registerCustomer(Customers customer, ArrayList addresses) {
        Addresses mailingAdd = null;
        Addresses billingAdd = null;
        Billingaddress b = new Billingaddress();
        Mailingaddress m = new Mailingaddress();
        boolean check = true;
        Customers cus = (Customers)customer;
        Customers isCustomerThere = em.find(Customers.class,cus.getCustomerusername());
        if (isCustomerThere != null){
            check = false;
        }else{
            if(addresses.size() == 1){
            mailingAdd = (Addresses)addresses.get(0);
            em.persist(mailingAdd);
           }else{
           mailingAdd = (Addresses)addresses.get(0);
           billingAdd = (Addresses)addresses.get(1);
                em.persist(mailingAdd);
                em.persist(billingAdd);
            }
            
            if(billingAdd != null){
            b.setAddressid(billingAdd);
            em.persist(b);
            }else{
            b.setAddressid(mailingAdd);
            em.persist(b);
            }
            m.setAddressid(mailingAdd);
            em.persist(m);

            cus.setBillingaddressid(b);
            cus.setMailingaddressid(m);

            em.persist(cus);
            }
        
        
        return check;
    }
    
    
    
    
}
