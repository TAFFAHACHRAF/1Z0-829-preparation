package org.enricogiurin.ocp17.ch13.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachOrdered {

  public static void main(String[] args) {
    ForEachOrdered instance = new ForEachOrdered();
    instance.forEach();
    instance.forEach();

  }


  void forEachOrdered() {
    //in this case I will have always 100
    //as I use forEachOrdered
    List<Integer> data = new ArrayList<>();
    IntStream.range(0,100)
        .parallel()
        .forEachOrdered(s -> data.add(s));
    System.out.println(data.size());
  }

  //this method does not guarantee to have 100
  //as the collection is not synchro
  void forEach() {
    List<Integer> data = new ArrayList<>();
    IntStream.range(0,100)
        .parallel()
        .forEach(s -> data.add(s));
    System.out.println(data.size());
  }

}
