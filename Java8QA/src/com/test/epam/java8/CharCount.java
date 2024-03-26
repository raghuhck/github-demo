package com.test.epam.java8;

/*For a string input the function returns output encoded as follows:

"a" -> "a1"
"aa" -> "a2"
"aabbb" -> "a2b3"
"aabbbaa" -> "a2b3a2"

Signature :
String rle(String input) {
}

Test Case:
Input : aaabbbaad
Output: a3b3a2d1*/

public class CharCount {
    public static void main(String[] args) {
        System.out.println(rle("aaabbbaad")); // Output: a3b3a2d1
        System.out.println(rleJava8("aaabbbaad"));
    }

    public static String rle(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                result.append(input.charAt(i)).append(count);
                count = 1;
            }
        }

        return result.toString();
    }
    
    
    public static String rleJava8(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new,
                        (sb, c) -> {
                            if (sb.length() > 0 && sb.charAt(sb.length() - 2) == c) {
                                int count = Character.getNumericValue(sb.charAt(sb.length() - 1)) + 1;
                                sb.delete(sb.length() - 2, sb.length());
                                sb.append(c).append(count);
                            } else {
                                sb.append(c).append(1);
                            }
                        },
                        StringBuilder::append)
                .toString();
    }
}
