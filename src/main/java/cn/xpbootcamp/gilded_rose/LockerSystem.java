package cn.xpbootcamp.gilded_rose;

import java.util.Random;
import java.util.Set;

class LockerSystem {
  public int pressOpenButton(int lockerCount, Set<String> ticketQueue) {
    if (lockerCount > 0) {
      lockerCount = lockerCount - 1;
      Random random = new Random();
      String ticket = Integer.toString(random.nextInt());
      while (ticketQueue.contains(ticket)) {
        ticket = Integer.toString(random.nextInt());
      }
      ticketQueue.add(ticket);
    }

    return lockerCount;
  }

  public int scanTicket(int lockerCount, Set<String> ticketQueue, String ticketNumber) {
    if(ticketQueue.contains(ticketNumber)){
      lockerCount = lockerCount + 1;
      ticketQueue.remove(ticketNumber);
    }
    return lockerCount;
  }
}
