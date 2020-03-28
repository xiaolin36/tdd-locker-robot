package cn.xpbootcamp.gilded_rose;

class LockerSystem {
  private int availableSpaces;

  public LockerSystem(int availableSpaces) {
    this.availableSpaces = availableSpaces;
  }

  public Ticket depositBag() {
    if (this.availableSpaces > 0) {
      Ticket ticket = new Ticket();
      return ticket;
    } else {
      throw new NoAvailableSpaceException("柜子已满");
    }

  }

}
