package org.enricogiurin.ocp17.book.ch4;

public class UsageOfStringBuilder {

  public static void main(String[] args) {
    new UsageOfStringBuilder().deleteInDoWhile();
  }

  void notEfficient() {
    //This sequence of events continues, and after 26 iterations through the loop,
    // a total of 27 objects are instantiated,
    // most of which are immediately eligible for garbage collection.
    String target = "";
    for (char c = 'a'; c <= 'z'; c++) {
      target += c;
    }
    //abcdefghijklmnopqrstuvwxyz
    System.out.println(target);
  }

  void withStringBuilder() {
    //this doesn't create intermediate string(s)
    StringBuilder target = new StringBuilder();
    for (char c = 'a'; c <= 'z'; c++) {
      target.append(c);
    }
    //abcdefghijklmnopqrstuvwxyz
    System.out.println(target);
  }

  //NOTE: insert() is not present in java.lang.String
  void insert() {
    StringBuilder sb = new StringBuilder("animals");
    sb.insert(0, "--");
    //--animals
    System.out.println(sb);
    sb.insert(sb.length(), "--");
    //--animals--
    System.out.println(sb);
  }

  void delete() {
    StringBuilder sb = new StringBuilder("animals");
    sb.delete(0, 3);
    //mals -> ani mals
    System.out.println(sb);
    //als -> m als
    sb.deleteCharAt(0);
    System.out.println(sb);
    //now the sb has length 3 -> als
    //Exception in thread "main" java.lang.StringIndexOutOfBoundsException: index 20, length 3
    sb.deleteCharAt(20);
  }

  void deleteInDoWhile() {
    StringBuilder sb = new StringBuilder("I am really sleepy");
    do {
      sb.delete(0, 3);
    } while (sb.length() > 3);
    System.out.println(sb);  //epy
  }

  void replace() {
    StringBuilder sb = new StringBuilder("Mario Silvestri");
    sb.replace(0, sb.indexOf("o") + 1, "Giorgio");
    //Giorgio Silvestri
    System.out.println(sb);
  }

  void reverse() {
    StringBuilder sb = new StringBuilder("0123456789");
    sb.reverse();
    System.out.println(sb);
  }


}