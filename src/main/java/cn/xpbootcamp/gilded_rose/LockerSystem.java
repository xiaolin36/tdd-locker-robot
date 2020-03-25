package cn.xpbootcamp.gilded_rose;

import java.util.Random;
import java.util.Set;

class LockerSystem {
  public int pressOpenButton(int lockerCount, Set<String> ticketQueue) {
    if(lockerCount > 0){
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

public int scanTicket(int originLockerCount, Set<String> ticketQueue, String ticketNumber) {
	return 0;
}
}
