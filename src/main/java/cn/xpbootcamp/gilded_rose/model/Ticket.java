package cn.xpbootcamp.gilded_rose.model;

public class Ticket {
  private String id;
  private int lockerIndex;

  public String getId() {
    return id;
  }

  public Ticket(int lockerIndex) {
    this.lockerIndex = lockerIndex;
  }

  public int getLockerIndex() {
    return this.lockerIndex;
  }
}
