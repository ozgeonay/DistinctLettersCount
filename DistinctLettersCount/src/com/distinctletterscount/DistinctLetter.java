package com.distinctletterscount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class DistinctLetter {

  static List<Integer> process(List<String> list) {

    List<Integer> deletedCountList = new ArrayList<>();
    list.forEach(element -> {
      Map<Character, Integer> letterCountMap = new HashMap<>();
      for (int i = 0; i < element.length(); i++) {
        Optional<Integer> countOfLetter = Optional
            .ofNullable(letterCountMap.get(element.charAt(i)));

        if (!countOfLetter.isPresent()) {
          letterCountMap.put(element.charAt(i), 1);
        } else {
          letterCountMap.put(element.charAt(i), countOfLetter.get() + 1);
        }
      }

      List<Integer> countsOfLetters = letterCountMap.values().stream()
          .sorted(Comparator.reverseOrder())
          .collect(Collectors.toList());

      List<Integer> uniqueCount = new ArrayList<>();
      AtomicInteger deletedLetterCount = new AtomicInteger();

      countsOfLetters.forEach(count -> {
        while (uniqueCount.contains(count)) {
          count--;
          deletedLetterCount.getAndIncrement();
        }
        if (!count.equals(0)) {
          uniqueCount.add(count);
        }
      });
      deletedCountList.add(deletedLetterCount.get());
    });

    return deletedCountList;
  }

}
