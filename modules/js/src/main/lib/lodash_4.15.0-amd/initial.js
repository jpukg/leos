define(['./_baseSlice'], function(baseSlice) {

  /**
   * Gets all but the last element of `array`.
   *
   * @static
   * @memberOf _
   * @since 0.1.0
   * @category Array
   * @param {Array} array The array to query.
   * @returns {Array} Returns the slice of `array`.
   * @example
   *
   * _.initial([1, 2, 3]);
   * // => [1, 2]
   */
  function initial(array) {
    var length = array ? array.length : 0;
    return length ? baseSlice(array, 0, -1) : [];
  }

  return initial;
});
