package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.List;

public class SuperLockerRobot extends Robot {

  public SuperLockerRobot(List<Locker> lockers) {
    super(lockers);
  }

  @Override
  public Ticket depositBag(Bag bag) {
    Locker locker = findDepositedLocker();
    return locker.depositBag(bag);
  }

  private Locker findDepositedLocker() {
    Locker lockerWithHigerRatioOfAvailableSpaces = this.lockers.get(0);
    for(Locker currentLocker: this.lockers) {
      if (currentLocker.getRatioOfAvailableSpaces() > lockerWithHigerRatioOfAvailableSpaces.getRatioOfAvailableSpaces()) {
        lockerWithHigerRatioOfAvailableSpaces = currentLocker;
      }
    }
    return lockerWithHigerRatioOfAvailableSpaces;
  }
}
