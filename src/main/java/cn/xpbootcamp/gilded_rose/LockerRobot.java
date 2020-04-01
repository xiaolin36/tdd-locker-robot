package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.model.Locker;

import java.util.List;

public class LockerRobot {
  private List<Locker> lockers;

  public LockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public Ticket depositBag() {
    return new Ticket("001", lockers.get(0).getIndex());
  }
}
