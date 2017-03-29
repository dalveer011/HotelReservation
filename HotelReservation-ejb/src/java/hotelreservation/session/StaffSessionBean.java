/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.session;

import hotelreservation.entity.Rooms;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author mazhar
 */
@Stateless
public class StaffSessionBean implements StaffSessionBeanRemote, StaffSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @javax.persistence.PersistenceContext(unitName = "HotelReservation-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Rooms> findAvailableRooms(Date startDate, Date endDate) {
        
        String query = "SELECT r FROM Rooms r"
                + "WHERE r.roomnum NOT IN "
                + "(SELECT b.roomnum FROM Bookings b "
                + "WHERE b.startdate >=" + startDate + "AND b.enddate <= " + endDate;
        
        List<Rooms> roomList = em.createQuery(query, Rooms.class).getResultList();
        
        return roomList;
    }

    @Override
    public Boolean bookRoom(Rooms room) {
        try{
            em.persist(room);
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        
        
        
    }
    
    
    
}
