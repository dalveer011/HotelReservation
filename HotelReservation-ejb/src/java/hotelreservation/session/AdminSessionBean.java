/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.session;

import hotelreservation.entity.Admins;
import hotelreservation.entity.Rooms;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author DALVEERSINGH
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanRemote, AdminSessionBeanLocal {
 @javax.persistence.PersistenceContext(unitName = "HotelReservation-ejbPU")
 private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
 /*
 Method to update the password for first time login
 */

    @Override
    public Boolean updatePassword(String username,String password) {
        boolean check = false;
        Admins admin = em.find(Admins.class, username);
        if(admin != null){
        admin.setPassword(password);
        em.merge(admin);
        check = true;
        }
        return check;
    }
    /*
    Adding room to the database
    */
    @Override
    public void addRoom(Rooms room) {
        em.persist(room);
    }
    /*
    update room specification
    */
    @Override
    public void updateRoom(int roomNum,Rooms newDetailesOfRoom) {
       Rooms room = em.find(Rooms.class,roomNum);
       if(room != null){
       room.setArea(newDetailesOfRoom.getArea());
       room.setFloor(newDetailesOfRoom.getFloor());
       room.setRoomrate(newDetailesOfRoom.getRoomrate());
       room.setRoomtype(newDetailesOfRoom.getRoomtype());
       em.merge(room);
       }
    }
    /*
    delete room from the database
    */

    @Override
    public void deleteRoom(int roomNum) {
        Rooms room = em.find(Rooms.class,roomNum);
        em.remove(room);
    }
    /*
    data for report  on reserved rooms between specific dates
    */

    @Override
    public void generateReportBasedOnDate(Date startDate, Date endDate) {
    }
    
    
}
