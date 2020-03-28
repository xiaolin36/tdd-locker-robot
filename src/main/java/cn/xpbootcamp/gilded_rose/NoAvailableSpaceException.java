package cn.xpbootcamp.gilded_rose;

public class NoAvailableSpaceException extends RuntimeException {
  public NoAvailableSpaceException(String message) {
    super(message);
  }
}
