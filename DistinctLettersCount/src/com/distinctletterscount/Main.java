package com.distinctletterscount;

import java.util.List;

public class Main {


  public static void main(String[] args) {

    if (args.length == 0) {
      throw new ConstraintException("You should send input file path as command line argument.");
    }

    List<String> fileToList = FileOperation.readFileToList(args[0]);

    List<Integer> deletedCountsList = DistinctLetter.process(fileToList);

    deletedCountsList
        .forEach(
            element -> System.out
                .println((deletedCountsList.indexOf(element) + 1) + "- " + element));

  }
}
