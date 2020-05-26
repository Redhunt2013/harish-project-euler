package com.kampaeny.euler.solved;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.kampaeny.euler.tools.Audit;

public class Problem011 {

    private static int finalValueAll = 0;

    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();
        final Path path = Paths.get("resources", "Problem11.txt");
        final Charset charSet = Charset.forName("ISO-8859-1");
        final int gridDiagonalLength = 20;
        int[][] regularArray = new int[gridDiagonalLength][gridDiagonalLength];
        int[][] swappedArray = new int[gridDiagonalLength][gridDiagonalLength];
        final List<String> allLines = Files.readAllLines(path, charSet);
        constructRegularArray(regularArray, allLines);
        _L2RMulti(regularArray); // left-to-right
        _R2LMulti(regularArray); // right-to-left
        swapArray(regularArray, swappedArray);
        _L2RMulti(swappedArray); // top-to-bottom
        _R2LMulti(swappedArray); // bottom-to-top
        String strDiagonalValuesForRegularArray;
        String strDiagonalValuesForSwappedArray;
        for (int k = 0; k < gridDiagonalLength * 2; k++) {
            strDiagonalValuesForRegularArray = "";
            strDiagonalValuesForSwappedArray = "";
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < gridDiagonalLength && j < gridDiagonalLength) {
                    strDiagonalValuesForRegularArray = strDiagonalValuesForRegularArray + regularArray[i][j] + " ";
                    strDiagonalValuesForSwappedArray = strDiagonalValuesForSwappedArray + swappedArray[i][j] + " ";
                }
            }
            strDiagonalValuesForRegularArray = strDiagonalValuesForRegularArray.trim();
            strDiagonalValuesForSwappedArray = strDiagonalValuesForSwappedArray.trim();
            if (strDiagonalValuesForRegularArray.length() > 0) {
                _L2RMulti(strDiagonalValuesForRegularArray);
                _R2LMulti(strDiagonalValuesForRegularArray);
            }
            if (strDiagonalValuesForSwappedArray.length() > 0) {
                _L2RMulti(strDiagonalValuesForSwappedArray);
                _R2LMulti(strDiagonalValuesForSwappedArray);
            }
        }
        System.out.println("########################");
        System.out.println("Biggest Value = " + finalValueAll);
        System.out.println("########################");
        System.out.println("Total Time Taken: " + (Audit.timeTaken(startTime, System.currentTimeMillis()) / 1000) + " seconds");
    }

    private static void _L2RMulti(final int[][] regularArray) {
        int finalValueL2R = 0;
        int tempValueL2R;
        final int length = regularArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((j + 3) < length) {
                    tempValueL2R = regularArray[i][j] * regularArray[i][j + 1] * regularArray[i][j + 2] * regularArray[i][j + 3];
                    if (finalValueL2R == 0) {
                        finalValueL2R = tempValueL2R;
                    } else if (tempValueL2R > finalValueL2R) {
                        finalValueL2R = tempValueL2R;
                    }
                }
            }
        }
        System.out.println("#_L2RMulti(int[][]) = " + finalValueL2R + ", big=" + String.valueOf(finalValueL2R).length());
        if (finalValueAll == 0) {
            finalValueAll = finalValueL2R;
        } else if (finalValueL2R > finalValueAll) {
            finalValueAll = finalValueL2R;
        }
    }

    private static void _L2RMulti(final String diagonalizedArray) {
        int finalValueL2R = 0;
        int tempValueL2R;
        String[] splitString = diagonalizedArray.split(" ");
        int[] splitIntegers = convertFormat(splitString);
        int length = splitIntegers.length;
        for (int i = 0; i < length; i++) {
            if ((i + 3) < length) {
                tempValueL2R = splitIntegers[i] * splitIntegers[i + 1] * splitIntegers[i + 2] * splitIntegers[i + 3];
                if (finalValueL2R == 0) {
                    finalValueL2R = tempValueL2R;
                } else if (tempValueL2R > finalValueL2R) {
                    finalValueL2R = tempValueL2R;
                }
            }
        }
        System.out.println("#_L2RMulti(String) = " + finalValueL2R + ", big=" + String.valueOf(finalValueL2R).length());
        if (finalValueAll == 0) {
            finalValueAll = finalValueL2R;
        } else if (finalValueL2R > finalValueAll) {
            finalValueAll = finalValueL2R;
        }
    }

    private static void _R2LMulti(final int[][] regularArray) {
        int finalValueR2L = 0;
        int tempValueR2L;
        final int length = regularArray.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = length - 1; j > 0; j--) {
                if ((j - 3) < length && (j - 3 > 0)) {
                    tempValueR2L = regularArray[i][j] * regularArray[i][j - 1] * regularArray[i][j - 2] * regularArray[i][j - 3];
                    if (finalValueR2L == 0) {
                        finalValueR2L = tempValueR2L;
                    } else if (tempValueR2L > finalValueR2L) {
                        finalValueR2L = tempValueR2L;
                    }
                }
            }
        }
        System.out.println("#_R2LMulti(int[][]) = " + finalValueR2L + ", big=" + String.valueOf(finalValueR2L).length());
        if (finalValueAll == 0) {
            finalValueAll = finalValueR2L;
        } else if (finalValueR2L > finalValueAll) {
            finalValueAll = finalValueR2L;
        }
    }

    private static void _R2LMulti(final String diagonalizedArray) {
        int finalValueR2L = 0;
        int tempValueR2L;
        final String[] splitString = diagonalizedArray.split(" ");
        final int[] splitIntegers = convertFormat(splitString);
        final int length = splitIntegers.length;
        for (int i = length - 1; i > 0; i--) {
            if ((i - 3) < length && (i - 3 > 0)) {
                tempValueR2L = splitIntegers[i] * splitIntegers[i - 1] * splitIntegers[i - 2] * splitIntegers[i - 3];
                if (finalValueR2L == 0) {
                    finalValueR2L = tempValueR2L;
                } else if (tempValueR2L > finalValueR2L) {
                    finalValueR2L = tempValueR2L;
                }
            }
        }
        System.out.println("#_R2LMulti(String) = " + finalValueR2L + ", big=" + String.valueOf(finalValueR2L).length());
        if (finalValueAll == 0) {
            finalValueAll = finalValueR2L;
        } else if (finalValueR2L > finalValueAll) {
            finalValueAll = finalValueR2L;
        }
    }

    /* ################################################## */
    /* All utility methods go below. */
    /* ################################################## */

    /**
     * Construct a 20X20 array from the file.
     */
    private static void constructRegularArray(final int[][] regularArray, final List<String> allLines) {
        int dimA = 0;
        int dimB;
        for (String string1 : allLines) {
            dimB = 0;
            String[] splitString = string1.split(" ");
            for (String string2 : splitString) {
                regularArray[dimA][dimB] = Integer.valueOf(string2);
                ++dimB;
            }
            ++dimA;
        }
    }

    /**
     * Construct a swapped array. Array, 1 2 3 4 5 6 Becomes, 1 4 2 5 3 6
     */
    private static void swapArray(final int[][] regularArray, final int[][] swappedArray) {
        int c = 0;
        while (c < 20) {
            for (int a = 0; a < regularArray.length; a++) {
                swappedArray[c][a] = regularArray[a][c];
            }
            ++c;
        }
    }

    /**
     * Convert the string array to an integer array
     */
    private static int[] convertFormat(final String[] stringArray) {
        final int length = stringArray.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.valueOf(stringArray[i]);
        }
        return array;
    }

}
