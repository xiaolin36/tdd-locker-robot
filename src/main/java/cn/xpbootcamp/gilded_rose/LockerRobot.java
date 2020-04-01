package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.model.Locker;

import java.util.List;

public class LockerRobot {
  private List<Locker> lockers;

  public LockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public Ticket depositBag() {
    Ticket ticket = null;
    for (int i = 0; i < lockers.size(); i++) {
      Locker locker = lockers.get(i);
      if (locker.getAvailableSpaces() > 0) {
        ticket = new Ticket("001", locker.getIndex());
        break;
      }
    }
    return ticket;
  }
}
