package cn.xpbootcamp.gilded_rose;

class LockerSystem {
  private int availableSpaces;

  public LockerSystem(int availableSpaces) {
    this.availableSpaces = availableSpaces;
  }

  public Ticket depositBag() {
    if (this.availableSpaces > 0) {
      Ticket ticket = new Ticket("000");
      return ticket;
    } else {
      throw new NoAvailableSpaceException("柜子已满");
    }
  }

  public Bag claimBag(Ticket ticket) {
    Bag bag = new Bag(ticket.getBagId());
    return bag;
  }

}
