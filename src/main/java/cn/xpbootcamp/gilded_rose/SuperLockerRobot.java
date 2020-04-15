package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;

import java.util.Comparator;
import java.util.List;

public class SuperLockerRobot {
  private List<Locker> lockers;

  public SuperLockerRobot(List<Locker> lockers) {
    this.lockers = sortLockersByIndex(lockers);
  }

  private List<Locker> sortLockersByIndex(List<Locker> lockers) {
    lockers.sort(Comparator.comparingInt(Locker::getIndex));
    return lockers;
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

  public Ticket depositBag(Bag bag) {
    Locker locker = findDepositedLocker();
    return locker.depositBag(bag);
  }

}
