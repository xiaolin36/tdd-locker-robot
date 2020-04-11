package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;

import java.util.HashMap;
import java.util.Map;

public class Locker {

  private int availableSpaces;
  private int index;
  private Map<String, Ticket> validTickets = new HashMap<>();

  public Locker(int availableSpaces, int index) {
    this.availableSpaces = availableSpaces;
    this.index = index;
  }

  public int getIndex() {
    return this.index;
  }

  public void setValidTickets(Map<String, Ticket> validTickets) {
    this.validTickets = validTickets;
  }

  public int getAvailableSpaces() {
    return availableSpaces;
  }

  public Ticket depositBag() {
    if (this.availableSpaces > 0) {
      Ticket ticket = new Ticket("000", 0);
      this.validTickets.put(ticket.getBagId(), ticket);
      return ticket;
    } else {
      throw new NoAvailableSpaceException();
    }
  }

  public Bag claimBag(Ticket ticket) {
    if (this.validTickets.containsKey(ticket.getBagId())) {
      Bag bag = new Bag(ticket.getBagId());
      return bag;
    } else {
      throw new InvalidTicketException();
    }
  }
}
