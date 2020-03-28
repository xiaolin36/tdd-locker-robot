package cn.xpbootcamp.gilded_rose;

public class InvalidTicketException extends RuntimeException {
  public InvalidTicketException(String message) {
    super(message);
  }
}
