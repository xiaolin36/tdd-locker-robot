package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrimaryLockerRobotTest {

  // 1. Given locker robot 2 lockers both with available spaces, When deposit the
  // bag, Then deposit succeed and obtained 1 ticket belongs to locker No.1.
  @Test
  void should_obtain_ticket_from_No1_locker_when_deposit_bag_given_2_lockers_both_with_available_spaces() {
    // Given
    int availableSpaces = 2;
    Locker locker1 = new Locker(availableSpaces, 1);
    Locker locker2 = new Locker(availableSpaces, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
    Bag bag = new Bag();

    // When
    Ticket ticket = primaryLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker1.claimBag(ticket));
  }

  // 2. Given locker robot 2 lockers with available spaces only in locker No.1,
  // When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to
  // locker No.1
  @Test
  void should_obtain_ticket_from_No1_locker_when_deposit_bag_given_2_lockers_only_No1_with_available_spaces() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(0, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
    Bag bag = new Bag();

    // When
    Ticket ticket = primaryLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker1.claimBag(ticket));
  }

  // 3. Given locker robot 2 lockers with available spaces only in locker No.2,
  // When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to
  // locker No.2.
  @Test
  void should_obtain_ticket_from_No2_locker_when_deposit_bag_given_2_lockers_only_No2_with_available_spaces() {
    // Given
    Locker locker1 = new Locker(0, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
    Bag bag = new Bag();

    // When
    Ticket ticket = primaryLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker2.claimBag(ticket));
  }

  // 1. Given 2 lockers with 0 available spaces, When deposit the bag, Then
  // deposit failed and obtained "柜子已满".
  @Test
  void should_obtain_error_message_when_deposit_bag_given_2_lockers_both_without_available_spaces() {
    // Given
    Locker locker1 = new Locker(0, 1);
    Locker locker2 = new Locker(0, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
    Bag bag = new Bag();

    // Then
    assertThrows(NoAvailableSpaceException.class, () -> {
      primaryLockerRobot.depositBag(bag);
    });
  }

  // 1. Given 2 lockers both with available space, 1 valid ticket link to a bag deposited, When claim the bag, Then the deposited bag can be obtained.
  @Test
  void should_obtain_the_deposited_bag_when_claim_bag_given_2_lockers_both_with_available_space_1_valid_ticket() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);

    Bag bag = new Bag();
    Ticket ticket = primaryLockerRobot.depositBag(bag);

    // When
    Bag depositedBag = primaryLockerRobot.claimBag(ticket);

    // Then
    assertNotNull(depositedBag);
    assertEquals(bag, depositedBag);
  }

  // 1. Given 2 lockers both with available spaces, 1 invalid tickets, When claim the bag, Then obtained the bag failed and "票无效".
  @Test
  void should_obtain_error_message_when_claim_bag_given_2_lockers_both_with_available_space_1_invalid_ticket() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);

    Ticket ticket = new Ticket("invalid ticket");

    // Then
    assertThrows(InvalidTicketException.class, () -> {
      primaryLockerRobot.claimBag(ticket);
    });
  }

}