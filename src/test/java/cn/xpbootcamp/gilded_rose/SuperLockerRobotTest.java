package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperLockerRobotTest {
  //  1. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 18 available spaces,
  //  locker No.2 with 10 total spaces and 8 available spaces, When super locker robot deposit the bag,
  //  Then obtained 1 ticket and the bag deposited to locker No.1.
  @Test
  void should_deposit_bag_to_No1_locker_when_deposit_bag_given_No1_locker_has_higher_ratio_of_available_spaces() {
    // Given
    Bag bag = new Bag();
    Locker locker1 = new Locker(18, 1);
    Locker locker2 = new Locker(8, 2);
    locker1.setTotalSpaces(20);
    locker2.setTotalSpaces(10);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);

    // When
    Ticket ticket = superLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker1.claimBag(ticket));
  }

  //  2. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 14 available spaces,
  //  locker No.2 with 10 total spaces and 8 available spaces, When super locker robot deposit the bag,
  //  Then obtained 1 ticket and the bag deposited to locker No.2.
  @Test
  void should_deposit_bag_to_No2_locker_when_deposit_bag_given_No2_locker_has_higher_ratio_of_available_spaces() {
    // Given
    Bag bag = new Bag();
    Locker locker1 = new Locker(14, 1);
    Locker locker2 = new Locker(8, 2);
    locker1.setTotalSpaces(20);
    locker2.setTotalSpaces(10);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);

    // When
    Ticket ticket = superLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker2.claimBag(ticket));
  }

  //  3. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 18 available spaces,
  //  locker No.2 with 10 total spaces and 9 available spaces, When super locker robot deposit the bag,
  //  Then obtained 1 ticket and the bag deposited to locker No.1.
  @Test
  void should_deposit_bag_to_No2_locker_when_deposit_bag_given_2_lockers_has_same_ratio_of_available_spaces() {
    // Given
    Bag bag = new Bag();
    Locker locker1 = new Locker(18, 2);
    Locker locker2 = new Locker(9, 1);
    locker1.setTotalSpaces(20);
    locker2.setTotalSpaces(10);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);

    // When
    Ticket ticket = superLockerRobot.depositBag(bag);

    // Then
    assertNotNull(ticket);
    assertEquals(bag, locker2.claimBag(ticket));
  }

  //  1. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 0 available spaces,
  //  locker No.2 with 10 total spaces and 0 available spaces, When super locker robot deposit the bag,
  //  Then deposit failed and obtained "柜子已满".
  @Test
  void should_obtain_error_message_when_deposit_bag_given_2_lockers_both_without_available_spaces() {
    // Given
    Locker locker1 = new Locker(0, 1);
    Locker locker2 = new Locker(0, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);
    Bag bag = new Bag();

    // Then
    assertThrows(NoAvailableSpaceException.class, () -> {
      superLockerRobot.depositBag(bag);
    });
  }

  //  1. Given super locker robot 2 lockers both with available space,
  //  1 valid ticket link to a bag deposited, When super locker robot claim the bag,
  //  Then the deposited bag can be obtained.
  @Test
  void should_obtain_the_deposited_bag_when_claim_bag_given_2_lockers_and_1_valid_ticket() {
    // Given
    Locker locker1 = new Locker(2, 1);
    Locker locker2 = new Locker(2, 2);
    List<Locker> lockers = new ArrayList<>();
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);

    Bag bag = new Bag();
    Ticket ticket = superLockerRobot.depositBag(bag);

    // When
    Bag depositedBag = superLockerRobot.claimBag(ticket);

    // Then
    assertNotNull(depositedBag);
    assertEquals(bag, depositedBag);
  }


  //  1. Given super locker robot 2 lockers both with available spaces,
  //  1 used ticket, When super locker robot claim the bag,
  //  Then obtained the bag failed and "票无效".

  //  2. Given super locker robot 2 lockers both with available spaces,
  //  1 ticket not created in our system, When super locker robot claim the bag,
  //  Then obtained the bag failed and "票无效".

}
