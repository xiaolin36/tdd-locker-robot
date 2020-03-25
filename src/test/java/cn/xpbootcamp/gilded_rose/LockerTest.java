package cn.xpbootcamp.gilded_rose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LockerTest {
  @Test
  void should_return_ticket_when_press_open_given_17_available_locker() {
    // Given
    int originLockerCount = 17;
    Set<String> ticketQueue = new HashSet<>();
    ticketQueue.add("001");
    ticketQueue.add("002");

    // When
    LockerSystem lockerSystem = new LockerSystem();
    int currentLockerCount = lockerSystem.pressOpenButton(originLockerCount, ticketQueue);

    // Then
    assertEquals((originLockerCount - 1), currentLockerCount);
    assertEquals(3, ticketQueue.size());
  }

  @Test
  void should_not_return_ticket_when_press_open_given_0_available_locker() {
    // Given
    int originLockerCount = 0;
    Set<String> ticketQueue = new HashSet<>();
    ticketQueue.add("001");
    ticketQueue.add("002");
    ticketQueue.add("003");
    ticketQueue.add("004");
    ticketQueue.add("005");
    ticketQueue.add("006");
    ticketQueue.add("007");
    ticketQueue.add("008");
    ticketQueue.add("009");
    ticketQueue.add("010");
    ticketQueue.add("011");
    ticketQueue.add("012");
    ticketQueue.add("013");
    ticketQueue.add("014");
    ticketQueue.add("015");
    ticketQueue.add("016");
    ticketQueue.add("017");
    ticketQueue.add("018");
    ticketQueue.add("019");

    // When
    LockerSystem lockerSystem = new LockerSystem();
    int currentLockerCount = lockerSystem.pressOpenButton(originLockerCount, ticketQueue);

    // Then
    assertEquals(originLockerCount, currentLockerCount);
    assertEquals(19, ticketQueue.size());
  }

  @Test
  void should_release_locker_when_scan_ticket_given_ticket_not_used() {
    // Given
    int originLockerCount = 17;
    Set<String> ticketQueue = new HashSet<>();
    ticketQueue.add("001");
    ticketQueue.add("002");

    // When
    LockerSystem lockerSystem = new LockerSystem();
    int currentLockerCount = lockerSystem.scanTicket(originLockerCount, ticketQueue, "001");

    // Then
    assertEquals((originLockerCount + 1), currentLockerCount);
    assertEquals(1, ticketQueue.size());
  }

  @Test
  void should_not_release_locker_when_scan_ticket_given_ticket_used() {
    // Given
    int originLockerCount = 17;
    Set<String> ticketQueue = new HashSet<>();
    ticketQueue.add("001");
    ticketQueue.add("002");

    // When
    LockerSystem lockerSystem = new LockerSystem();
    int currentLockerCount = lockerSystem.scanTicket(originLockerCount, ticketQueue, "003");

    // Then
    assertEquals(originLockerCount, currentLockerCount);
    assertEquals(2, ticketQueue.size());
  }

}
