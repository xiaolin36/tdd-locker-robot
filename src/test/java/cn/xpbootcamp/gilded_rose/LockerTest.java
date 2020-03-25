package cn.xpbootcamp.gilded_rose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LockerTest {
  @Test
  void should_return_ticket_when_press_open_given_17_available_locker(){
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
}
