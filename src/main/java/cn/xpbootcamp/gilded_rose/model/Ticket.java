package cn.xpbootcamp.gilded_rose.model;

public class Ticket {
  private String bagId;
  private int lockerIndex;

  public Ticket(String bagId, int lockerIndex) {
    this.bagId = bagId;
    this.lockerIndex = lockerIndex;
  }

  public String getBagId() {
    return this.bagId;
  }

  public int getLockerIndex() {
    return this.lockerIndex;
  }
}
