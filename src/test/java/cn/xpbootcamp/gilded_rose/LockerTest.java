package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

  // Given 0 available spaces, When deposit the bag, Then deposit failed and
  // obtained "柜子已满".
  @Test
  void should_obtain_error_message_when_deposit_bag_given_0_available_spaces() {
    // Given
    int availableSpaces = 0;
    LockerSystem lockerSystem = new LockerSystem(availableSpaces);

    // Then
    Throwable noAvailableSpaceException = assertThrows(NoAvailableSpaceException.class, () -> {
      lockerSystem.depositBag();
    });
    assertEquals("柜子已满", noAvailableSpaceException.getMessage());
  }

  // Given 2 available space, 1 valid ticket link to a bag deposited, When claim
  // the bag, Then the deposited bag can be obtained.
  @Test
  void should_obtain_the_deposited_bag_when_claim_bag_given_2_available_space_1_valid_ticket() {
    // Given
    String bagId = "002";
    Ticket ticket = new Ticket(bagId);
    int availableSpaces = 2;
    Map<String, Ticket> validTickets = new HashMap<>();
    validTickets.put(bagId, ticket);
    LockerSystem lockerSystem = new LockerSystem(availableSpaces);
    lockerSystem.setValidTickets(validTickets);

    // When
    Bag bag = lockerSystem.claimBag(ticket);

    // Then
    assertNotNull(bag);
    assertEquals(bag.getId(), ticket.getBagId());
  }

  // Given 17 available spaces, 1 invalid tickets, When claim the bag, Then
  // obtained the bag failed and "票无效".
  @Test
  void should_obtain_error_message_when_claim_bag_given_17_available_space_1_invalid_ticket() {
    // Given
    int availableSpaces = 17;
    LockerSystem lockerSystem = new LockerSystem(availableSpaces);
    String bagId = "0022";
    Ticket ticket = new Ticket(bagId);

    // Then
    Throwable invalidTicketException = assertThrows(InvalidTicketException.class, () -> {
      lockerSystem.claimBag(ticket);
    });
    assertEquals("票无效", invalidTicketException.getMessage());
  }

}
