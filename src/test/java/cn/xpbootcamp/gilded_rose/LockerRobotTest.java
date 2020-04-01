package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Locker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    assertEquals(locker1.getIndex(), ticket.getLockerIndex());
  }

  // 2. Given locker robot 2 lockers with available spaces only in locker No.1, When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to locker No.1
  @Test
  void should_obtain_ticket_from_No1_locker_when_deposit_bag_given_2_lockers_only_No1_with_available_spaces() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(0, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    LockerRobot lockerRobot = new LockerRobot(lockers);

    // When
    Ticket ticket = lockerRobot.depositBag();

    // Then
    assertNotNull(ticket);
    assertEquals(locker1.getIndex(), ticket.getLockerIndex());
  }

  // 3. Given locker robot 2 lockers with available spaces only in locker No.2, When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to locker No.2.
  @Test
  void should_obtain_ticket_from_No2_locker_when_deposit_bag_given_2_lockers_only_No2_with_available_spaces() {
    // Given
    Locker locker1 = new Locker(0, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    LockerRobot lockerRobot = new LockerRobot(lockers);

    // When
    Ticket ticket = lockerRobot.depositBag();

    // Then
    assertNotNull(ticket);
    assertEquals(locker2.getIndex(), ticket.getLockerIndex());
  }

  // 1. Given 2 lockers with 0 available spaces, When deposit the bag, Then deposit failed and obtained "柜子已满".
  @Test
  void should_obtain_error_message_when_deposit_bag_given_2_lockers_both_without_available_spaces() {
    // Given
    Locker locker1 = new Locker(0, 1);
    Locker locker2 = new Locker(0, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    LockerRobot lockerRobot = new LockerRobot(lockers);

    // Then
    assertThrows(NoAvailableSpaceException.class, () -> {
      lockerRobot.depositBag();
    });
  }

}
