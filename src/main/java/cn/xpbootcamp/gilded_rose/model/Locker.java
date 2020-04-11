package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;

import java.util.HashMap;
import java.util.Map;

public class Locker {

  private int availableSpaces;
  private int index;
  private Map<String, Bag> storedBags = new HashMap<>();

  public Locker(int availableSpaces, int index) {
    this.availableSpaces = availableSpaces;
    this.index = index;
  }

  public int getIndex() {
    return this.index;
  }

  public int getAvailableSpaces() {
    return availableSpaces;
  }

  public Map<String, Bag> getStoredBags() {
    return storedBags;
  }

  public Ticket depositBag(Bag bag) {
    if (this.availableSpaces > 0) {
      Ticket ticket = new Ticket(0);
      this.storedBags.put(ticket.getId(), bag);
      return ticket;
    } else {
      throw new NoAvailableSpaceException();
    }
  }

  public Bag claimBag(Ticket ticket) {
    if (this.storedBags.containsKey(ticket.getId())) {
      Bag bag = this.storedBags.get(ticket.getId());
      this.storedBags.remove(ticket.getId());
      return bag;
    } else {
      throw new InvalidTicketException();
    }
  }
}
