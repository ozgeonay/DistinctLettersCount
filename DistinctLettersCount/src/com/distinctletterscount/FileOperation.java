package com.distinctletterscount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileOperation {

  static List<String> readFileToList(String filePath) {
    List<String> file = new ArrayList<>();
    try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

      file = stream.collect(Collectors.toList());

      file.forEach(element -> {
        FileOperation.validateLine(element);
      });
    } catch (IOException e) {
      throw new ConstraintException("File cannot read");
    }

    return file;
  }

  static void validateLine(String input) {
    if (input.length() < 1) {
      throw new ConstraintException("The minimum character number of the input line should be 1");
    } else if (input.length() > 30000) {
      throw new ConstraintException(
          "The maximum character number of the input line should be 300000.");
    } else if (!input.matches("[a-z]*")) {
      throw new ConstraintException(
          "The string value should consists of only lowercase letters (a-z).");
    }
  }
}
