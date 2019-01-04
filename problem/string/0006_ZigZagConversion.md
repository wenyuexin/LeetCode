# 6. ZigZag Conversion [[Go](https://github.com/Apollo4634/LeetCode/blob/master/solution/string/ZigZagConversion.java)]

```Medium, String```

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string s, int numRows);
```

**Example 1:**

```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

**Example 2:**

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
```

**Java**
```java
class Solution {
    public String convert(String s, int numRows) {
        
    }
}
```

**My Note**  
​        本题要求将字符串转变为Z字形排列的若干字符，然后根据从新排列的字符获取规定的字符串，相当于字符串的变形。例如，对于 `s = "PAYPALISHIRING"，numRows = 4  `  

| row\col | 1 | 2 | 3 | 4 | 5 | 6 | 7 |  |
|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:---|
| 1 | P | | | I | | | N | s1="PIN" |
| 2 | A | | L | S | | I | G | s2="ALSIG" |
| 3 | Y | A | | H | R | | | s3="YAHR" |
| 4 | P | | | I | | | | s4="PI" |

​        按Z字形排列后得到4行7列的一组字符，若各行字符组合的字符串为`s1, s2, s3, s4`，则最终结果`str = s1 + s2 + s3 + s4 = "PINALSIGYAHRPI"`


