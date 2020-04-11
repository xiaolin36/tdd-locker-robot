package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoAvailableSpaceException;
import cn.xpbootcamp.gilded_rose.model.Bag;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Ticket;
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
    Locker locker = new Locker(availableSpaces,1);

    // When
    Ticket ticket = locker.depositBag();

    // Then
    assertNotNull(ticket);
  }

  // Given 0 available spaces, When deposit the bag, Then deposit failed and
  // obtained "柜子已满".
  @Test
  void should_obtain_error_message_when_deposit_bag_given_0_available_spaces() {
    // Given
    int availableSpaces = 0;
    Locker locker = new Locker(availableSpaces, 0);

    // Then
    assertThrows(NoAvailableSpaceException.class, () -> {
      locker.depositBag();
    });
  }

  // Given 2 available space, 1 valid ticket link to a bag deposited, When claim
  // the bag, Then the deposited bag can be obtained.
  @Test
  void should_obtain_the_deposited_bag_when_claim_bag_given_2_available_space_1_valid_ticket() {
    // Given
    String bagId = "002";
    Ticket ticket = new Ticket(bagId, 1);
    int availableSpaces = 2;
    Map<String, Ticket> validTickets = new HashMap<>();
    validTickets.put(bagId, ticket);
    Locker locker = new Locker(availableSpaces, 0);
    locker.setValidTickets(validTickets);

    // When
    Bag bag = locker.claimBag(ticket);

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
    Locker locker = new Locker(availableSpaces, 0);
    String bagId = "0022";
    Ticket ticket = new Ticket(bagId, 1);

    // Then
    assertThrows(InvalidTicketException.class, () -> {
      locker.claimBag(ticket);
    });
  }

}
