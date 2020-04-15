package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Locker {

  private int availableSpaces;
  private int index;
  private Map<String, Bag> storedBags = new HashMap<>();
  private int totalSpaces;

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
      Random random = new Random();
      int number = random.nextInt();
      Ticket ticket = new Ticket(Integer.toString(number));
      this.storedBags.put(ticket.getId(), bag);
      return ticket;
    }
    throw new NoAvailableSpaceException();
  }

  public Bag claimBag(Ticket ticket) {
    if (this.storedBags.containsKey(ticket.getId())) {
      Bag bag = this.storedBags.get(ticket.getId());
      this.storedBags.remove(ticket.getId());
      return bag;
    }
    throw new InvalidTicketException();
  }

  public void setTotalSpaces(int totalSpaces) {
    this.totalSpaces = totalSpaces;
  }

  public double getRatioOfAvailableSpaces(){
    if(this.totalSpaces > 0){
      return ((double) this.availableSpaces) / this.totalSpaces;
    }
    return 0;
  }
}
