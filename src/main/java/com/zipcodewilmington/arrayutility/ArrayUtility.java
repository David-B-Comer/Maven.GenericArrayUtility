package com.zipcodewilmington.arrayutility;


import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;

    }

    public Integer countNumberOfOccurrences(T[] array, T valueToEvaluate) {
        int numberOfDuplicates = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valueToEvaluate)) {
                numberOfDuplicates++;
            }
        }
        return numberOfDuplicates;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
      return countNumberOfOccurrences(array, valueToEvaluate);
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
       return countNumberOfOccurrences(ArrayUtils.addAll(array, arrayToMerge), valueToEvaluate);

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        HashMap<T, Integer> merged = new HashMap<>();

        T[] both = ArrayUtils.addAll(array, arrayToMerge);

        for (int i = 0; i < both.length; i++) {
            if (merged.containsKey(both[i])) {
                int count = merged.get(both[i]);
                count++;
                merged.put(both[i], count);
            }
            else {
                merged.put(both[i], 1);
            }
        }
        T mostCommon = null;
        int currentHighest = 0;

        for (Map.Entry<T, Integer> entry : merged.entrySet()) {
            if (entry.getValue() >= currentHighest) {
                mostCommon = entry.getKey();
                currentHighest = entry.getValue();
            }
        }

    return mostCommon;
    }

    public T[] removeValue(T valueToRemove) {
    return ArrayUtils.removeAllOccurences(array, valueToRemove);
    }
}
