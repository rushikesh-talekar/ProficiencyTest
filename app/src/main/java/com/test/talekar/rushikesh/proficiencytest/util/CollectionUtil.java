package com.test.talekar.rushikesh.proficiencytest.util;

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
   * @param collection
   * @return
   */
  public static boolean isEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }

  /**
   * Checks if collection is not empty.
   *
   * @param collection
   * @return
   */
  public static boolean isNotEmpty(Collection<?> collection) {
    return !isEmpty(collection);
  }
}
