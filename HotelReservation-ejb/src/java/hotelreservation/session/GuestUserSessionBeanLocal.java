/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.session;

import hotelreservation.entity.Rooms;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mazhar
 */
@Local
public interface GuestUserSessionBeanLocal {

    List<Rooms> findAvailableRooms(Date startDate, Date endDate);

    
}
