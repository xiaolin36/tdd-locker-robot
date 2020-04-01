package cn.xpbootcamp.gilded_rose;

public class Ticket {
  private String bagId;

  public Ticket(String bagId) {
    this.bagId = bagId;
  }

  public String getBagId() {
    return this.bagId;
  }

  public int getLockerIndex() {
    return 0;
  }
}
