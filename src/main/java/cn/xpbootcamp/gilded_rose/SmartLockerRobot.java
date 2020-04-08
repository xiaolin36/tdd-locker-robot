package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartLockerRobot {
  private List<Locker> lockers;
  private Map<String, Ticket> validTickets = new HashMap<>();

  public SmartLockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public void setValidTickets(Map<String, Ticket> validTickets) {
    this.validTickets = validTickets;
  }

  public Ticket depositBag(Bag bag) {
    Locker lockerWithMaxAvailableSpaces = lockers.get(0);
    for (int i = 1; i < lockers.size(); i++) {
      Locker currentLocker = lockers.get(i);
      if (currentLocker.getAvailableSpaces() > lockerWithMaxAvailableSpaces.getAvailableSpaces()) {
        lockerWithMaxAvailableSpaces = currentLocker;
      }
    }
    Ticket ticket = new Ticket(bag.getId(), lockerWithMaxAvailableSpaces.getIndex());
    return ticket;
  }

  public Bag claimBag(Ticket ticket) {
    if (this.validTickets.containsKey(ticket.getBagId())) {
      Bag bag = new Bag(ticket.getBagId());
      return bag;
    } else {
      throw new InvalidTicketException();
    }
  }
}
