package com.kampaeny.euler.tools;

class StringTools {

    public static void split(String oneString) {
        System.out.println(separateString(oneString));
    }

    private static String separateString(String oneString) {
        String[] inStr = oneString.split(" ");
        if (inStr.length == 1) {
            inStr = oneString.split(" ");
            if (inStr.length == 1) {
                inStr[0] = oneString;
            }
        }
        String tmp = "";
        if (inStr.length > 1) {
            for (int j = 0; j < inStr.length; j++) {
                if (j == 0) {
                    tmp += "'" + inStr[j].trim() + "'";
                } else {
                    tmp = tmp.concat(",").concat("'").concat(inStr[j].trim()).concat("'");
                }
            }
        }
        return tmp;
    }

}
