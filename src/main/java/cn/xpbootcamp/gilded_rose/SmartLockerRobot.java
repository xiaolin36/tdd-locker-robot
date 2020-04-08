package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartLockerRobot {
  private List<Locker> lockers;
  private Map<String, Ticket> validTickets = new HashMap<>();

  public SmartLockerRobot(List<Locker> lockers) {
    this.lockers = sortLockersByIndex(lockers);
  }

  private List<Locker> sortLockersByIndex(List<Locker> lockers) {
    lockers.sort(Comparator.comparingInt(Locker::getIndex));
    return lockers;
  }

  public Ticket depositBag(Bag bag) {
    Locker lockerWithMaxAvailableSpaces = lockers.get(0);
    for (int i = 1; i < lockers.size(); i++) {
      Locker currentLocker = lockers.get(i);
      if (currentLocker.getAvailableSpaces() > lockerWithMaxAvailableSpaces.getAvailableSpaces()) {
        lockerWithMaxAvailableSpaces = currentLocker;
      }
    }
    if(lockerWithMaxAvailableSpaces.getAvailableSpaces() > 0){
      Ticket ticket = new Ticket(bag.getId(), lockerWithMaxAvailableSpaces.getIndex());
      this.validTickets.put(bag.getId(), ticket);
      return ticket;
    }
    throw new NoAvailableSpaceException();
  }

  public Bag claimBag(Ticket ticket) {
    if (this.validTickets.containsKey(ticket.getBagId())) {
      Bag bag = new Bag(ticket.getBagId());
      this.validTickets.remove(bag.getId());
      return bag;
    } else {
      throw new InvalidTicketException();
    }
  }
}
