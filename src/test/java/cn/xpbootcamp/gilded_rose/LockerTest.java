package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest {
  // Given 2 available spaces, When deposit the bag, Then deposit succeed and
  // obtained 1 ticket.
  @Test
  void should_obtain_ticket_when_deposit_bag_given_2_available_spaces() {
    // Given
    int availableSpaces = 2;
    LockerSystem lockerSystem = new LockerSystem(availableSpaces);

    // When
    Ticket ticket = lockerSystem.depositBag();

    // Then
    assertNotNull(ticket);
  }

}
