package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.*;

public class SmartLockerRobot {
  private List<Locker> lockers;

  public SmartLockerRobot(List<Locker> lockers) {
    this.lockers = sortLockersByIndex(lockers);
  }

  private List<Locker> sortLockersByIndex(List<Locker> lockers) {
    lockers.sort(Comparator.comparingInt(Locker::getIndex));
    return lockers;
  }

  private Locker findDepositedLocker() {
    Locker lockerWithMaxAvailableSpaces = lockers.get(0);
    for (int i = 1; i < lockers.size(); i++) {
      Locker currentLocker = lockers.get(i);
      if (currentLocker.getAvailableSpaces() > lockerWithMaxAvailableSpaces.getAvailableSpaces()) {
        lockerWithMaxAvailableSpaces = currentLocker;
      }
    }
    return lockerWithMaxAvailableSpaces;
  }

  public Ticket depositBag(Bag bag) {
    Locker locker = findDepositedLocker();
    return locker.depositBag(bag);
  }

  public Bag claimBag(Ticket ticket) {
    Locker locker = findClaimedLocker(ticket);
    if (locker != null) {
      return locker.claimBag(ticket);
    }
    throw new InvalidTicketException();
  }

  private Locker findClaimedLocker(Ticket ticket) {
    for(int i = 0; i < this.lockers.size(); i++) {
      Locker locker = this.lockers.get(i);
      if (locker.getStoredBags().containsKey(ticket.getId())) {
        return locker;
      }
    }
    return null;
  }
}
