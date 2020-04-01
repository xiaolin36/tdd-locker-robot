package cn.xpbootcamp.gilded_rose.model;

public class Locker {

  private int availableSpaces;
  private int index;

  public Locker(int availableSpaces, int index) {
    this.availableSpaces = availableSpaces;
    this.index = index;
  }

  public int getIndex() {
    return this.index;
  }
}
