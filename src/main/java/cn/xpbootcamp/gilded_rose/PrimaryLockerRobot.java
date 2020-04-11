package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimaryLockerRobot {
  private List<Locker> lockers;
  private Map<String, Ticket> validTickets = new HashMap<>();

  public PrimaryLockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public void setValidTickets(Map<String, Ticket> validTickets) {
    this.validTickets = validTickets;
  }

  public Ticket depositBag(Bag bag) {
    for (int i = 0; i < lockers.size(); i++) {
      Locker locker = lockers.get(i);
      if (locker.getAvailableSpaces() > 0) {
        Ticket ticket = new Ticket(bag.getId(), locker.getIndex());
        return ticket;
      }
    }
    throw new NoAvailableSpaceException();
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