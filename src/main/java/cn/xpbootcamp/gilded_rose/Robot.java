package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.Comparator;
import java.util.List;

public abstract class Robot {
  protected List<Locker> lockers;

  public Robot(List<Locker> lockers) {
    this.lockers = sortLockersByIndex(lockers);
  }

  private List<Locker> sortLockersByIndex(List<Locker> lockers) {
    lockers.sort(Comparator.comparingInt(Locker::getIndex));
    return lockers;
  }

  abstract Ticket depositBag(Bag bag);

  public Bag claimBag(Ticket ticket) {
    Locker locker = findClaimedLocker(ticket);
    if (locker != null) {
      return locker.claimBag(ticket);
    }
    throw new InvalidTicketException();
  }

  private Locker findClaimedLocker(Ticket ticket) {
    for (Locker locker : this.lockers) {
      if (locker.getStoredBags().containsKey(ticket.getId())) {
        return locker;
      }
    }
    return null;
  }
}
