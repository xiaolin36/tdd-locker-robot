package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.List;

public class PrimaryLockerRobot extends Robot {

  public PrimaryLockerRobot(List<Locker> lockers) {
    super(lockers);
  }

  @Override
  public Ticket depositBag(Bag bag) {
    Locker locker = findDepositedLocker();
    if (locker != null) {
      return locker.depositBag(bag);
    }
    throw new NoAvailableSpaceException();
  }

  private Locker findDepositedLocker() {
    for (Locker locker : this.lockers) {
      if (locker.getAvailableSpaces() > 0) {
        return locker;
      }
    }
    return null;
  }
}