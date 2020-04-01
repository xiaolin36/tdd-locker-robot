package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Locker;

import java.util.List;
import java.util.Map;

public class LockerRobot {
  private List<Locker> lockers;

  public LockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public void setValidTickets(Map<String, Ticket> validTickets) {

  }

  public Ticket depositBag() {
    for (int i = 0; i < lockers.size(); i++) {
      Locker locker = lockers.get(i);
      if (locker.getAvailableSpaces() > 0) {
        Ticket ticket = new Ticket("001", locker.getIndex());
        return ticket;
      }
    }
    throw new NoAvailableSpaceException();
  }

  public Bag claimBag(Ticket ticket) {
    Bag bag = new Bag(ticket.getBagId());
    return bag;
  }
}
