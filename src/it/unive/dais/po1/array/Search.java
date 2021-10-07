package it.unive.dais.po1.array;

public class Search {

    /**
     * This method returns true iff value is contained in the given array
     *
     * @param array an ordered array of integer values
     * @param value the value to be searched
     * @return
     *
     * @requires array != null
     * @requires for all i in [0..array.length-2] : array[i]<=array[i+1]
     * [0..array.length-2] = {0, 1, 2, ..., array.length-2}
     */
    boolean contains(int[] array, int value) {
        for(int i = 0; i < array.length && array[i]<=value; i++) {
            if(array[i]==value)
                return true;
        }
        return false;
    }
}
