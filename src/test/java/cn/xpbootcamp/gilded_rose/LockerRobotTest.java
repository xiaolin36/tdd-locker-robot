package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.model.Locker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerRobotTest {

  // 1. Given locker robot 2 lockers both with available spaces, When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to locker No.1.
  @Test
  void should_obtain_ticket_from_No1_locker_when_deposit_bag_given_2_lockers_both_with_available_spaces() {
    // Given
    int availableSpaces = 2;
    Locker locker1 = new Locker(availableSpaces, 1);
    Locker locker2 = new Locker(availableSpaces, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    LockerRobot lockerRobot = new LockerRobot(lockers);

    // When
    Ticket ticket = lockerRobot.depositBag();

    // Then
    assertNotNull(ticket);
    assertEquals(ticket.getLockerIndex(), locker1.getIndex());
  }
}
