//package cn.xpbootcamp.gilded_rose;
//
//import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
//import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class LockerSystem {
//  private int availableSpaces;
//  private Map<String, Ticket> validTickets = new HashMap<>();
//
//  public LockerSystem(int availableSpaces) {
//    this.availableSpaces = availableSpaces;
//  }
//
//  public Ticket depositBag() {
//    if (this.availableSpaces > 0) {
//      Ticket ticket = new Ticket("000");
//      this.validTickets.put(ticket.getBagId(), ticket);
//      return ticket;
//    } else {
//      throw new NoAvailableSpaceException();
//    }
//  }
//
//  public Bag claimBag(Ticket ticket) {
//    if (this.validTickets.containsKey(ticket.getBagId())) {
//      Bag bag = new Bag(ticket.getBagId());
//      return bag;
//    } else {
//      throw new InvalidTicketException();
//    }
//  }
//
//  public void setValidTickets(Map<String, Ticket> validTickets) {
//    this.validTickets = validTickets;
//  }
//
//}
