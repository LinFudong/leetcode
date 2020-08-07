package org.linfd.leetcode.topliked;

import java.util.ArrayList;
import java.util.List;

/**
 * #6 ZigZag Conversion
 *
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class _6_ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i=0; i < Math.min(numRows, s.length()); i++) rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows -1) goingDown = !goingDown;
            curRow = goingDown ? curRow + 1 : curRow - 1;
        }

        StringBuffer res = new StringBuffer();
        for (StringBuilder row : rows) res.append(row);

        return res.toString();
    }
}
