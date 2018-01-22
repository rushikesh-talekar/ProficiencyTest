package com.test.talekar.rushikesh.util;

import java.util.Collection;

/**
 * To perform collection related operations.
 *
 * @author Rushikesh_Talekar
 */

public class CollectionUtil {

  /**
   * Checks if collection is empty.
   *
   * @param collection - collection object to check for empty state
   * @return true if empty
   */
  public static boolean isEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }

  /**
   * Checks if collection is not empty.
   *
   * @param collection - collection object to check for empty state
   * @return true if is not empty
   */
  public static boolean isNotEmpty(Collection<?> collection) {
    return !isEmpty(collection);
  }
}
