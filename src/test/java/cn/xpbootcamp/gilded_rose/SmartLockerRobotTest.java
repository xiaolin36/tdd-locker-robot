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

public class SmartLockerRobotTest {

  // 1. Given smart locker robot 2 lockers, locker No.1 with 2 available spaces, locker No.2 with 1 available spaces, When smart locker robot deposit the bag, Then obtained 1 ticket and the bag deposited to locker No.1.
  @Test
  void should_deposit_bag_to_No1_locker_when_deposit_bag_given_No1_locker_has_more_available_spaces() {
    // Given
    Bag bag = new Bag();
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(1, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

    // When
    Ticket ticket = smartLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker1.claimBag(ticket));
  }

  // 2. Given smart locker robot 2 lockers, locker No.1 with 1 available spaces, locker No.2 with 2 available spaces, When smart locker robot deposit the bag, Then obtained 1 ticket and the bag deposited to locker No.2.
  @Test
  void should_deposit_bag_to_No2_locker_when_deposit_bag_given_No2_locker_has_more_available_spaces() {
    // Given
    Bag bag = new Bag();
    Locker locker1 = new Locker(1, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

    // When
    Ticket ticket = smartLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker2.claimBag(ticket));
  }

  // 3. Given smart locker robot 2 lockers, locker No.1 with 1 available spaces, locker No.2 with 1 available spaces, When smart locker robot deposit the bag, Then obtained 1 ticket and the bag deposited to locker No.1.
  @Test
  void should_deposit_bag_to_No1_locker_when_deposit_bag_given_2_lockers_with_same_available_spaces() {
    // Given
    Bag bag = new Bag();
    Locker locker1 = new Locker(2, 2);
    Locker locker2 = new Locker(2, 1);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

    // When
    Ticket ticket = smartLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker2.claimBag(ticket));
  }

  // 1. Given smart locker robot 2 lockers both with 0 available spaces, When smart locker robot deposit the bag, Then deposit failed and obtained "柜子已满".
  @Test
  void should_obtain_error_message_when_deposit_bag_given_2_lockers_both_without_available_spaces() {
    // Given
    Locker locker1 = new Locker(0, 1);
    Locker locker2 = new Locker(0, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
    Bag bag = new Bag();

    // Then
    assertThrows(NoAvailableSpaceException.class, () -> {
      smartLockerRobot.depositBag(bag);
    });
  }

  // 1. Given smart locker robot 2 lockers both with available space, 1 valid ticket link to a bag deposited, When smart locker robot claim the bag, Then the deposited bag can be obtained.
  @Test
  void should_obtain_the_deposited_bag_when_claim_bag_given_2_lockers_and_1_valid_ticket() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

    Bag bag = new Bag();
    Ticket ticket = smartLockerRobot.depositBag(bag);

    // When
    Bag depositedBag = smartLockerRobot.claimBag(ticket);

    // Then
    assertNotNull(depositedBag);
    assertEquals(bag, depositedBag);
  }

  // 1. Given smart locker robot 2 lockers both with available spaces, 1 used ticket, When smart locker robot claim the bag, Then obtained the bag failed and "票无效".
  @Test
  void should_obtain_error_message_when_claim_bag_given_2_lockers_and_1_used_ticket() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

    Bag bag = new Bag();
    Ticket ticket = smartLockerRobot.depositBag(bag);

    smartLockerRobot.claimBag(ticket);

    // Then
    assertThrows(InvalidTicketException.class, () -> {
      smartLockerRobot.claimBag(ticket);
    });
  }

  // 2. Given smart locker robot 2 lockers both with available spaces, 1 ticket not created in our system, When smart locker robot claim the bag, Then obtained the bag failed and "票无效".
  @Test
  void should_obtain_error_message_when_claim_bag_given_2_lockers_and_1_ticket_not_created_in_our_system() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

    Ticket ticket = new Ticket(1);

    // Then
    assertThrows(InvalidTicketException.class, () -> {
      smartLockerRobot.claimBag(ticket);
    });
  }

}
