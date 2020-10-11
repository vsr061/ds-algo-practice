package com.practice.ds.stack;

import java.util.HashMap;
import java.util.Map;

public class Problem_1410_HTMLEntityParser {

    private static String entityParser(String text) {
        Map<String, String> lookUpTable = new HashMap<String, String>() {{
            put("&quot;", "\"");
            put("&apos;", "'");
            put("&amp;", "&");
            put("&gt;", ">");
            put("&lt;", "<");
            put("&frasl;", "/");
        }};

        StringBuilder specialChar = new StringBuilder();
        StringBuilder unEscapedString = new StringBuilder();
        boolean specialCharStartFlag = false;
        for (char c : text.toCharArray()) {
            if (c == '&') {
                if (specialCharStartFlag) {
                    unEscapedString.append(specialChar);
                    specialChar.setLength(0);
                } else {
                    specialCharStartFlag = true;
                    specialChar.append(c);
                }
            } else if (c == ';') {
                if (specialCharStartFlag) {
                    specialChar.append(c);
                    unEscapedString.append(lookUpTable.
                            getOrDefault(specialChar.toString(), specialChar.toString()));
                    specialChar.setLength(0);
                    specialCharStartFlag = false;
                } else {
                    unEscapedString.append(c);
                }
            } else if (specialCharStartFlag) {
                specialChar.append(c);
            } else {
                unEscapedString.append(c);
            }
        }

        return unEscapedString.toString();
    }

    public static void main(String[] args) {
        String output = entityParser("&amp; is an HTML entity but &ambassador; is not.");
        System.out.println(output);
        output = entityParser("&gt; is an HTML entity but &amp; is not.");
        System.out.println(output);
    }
}
