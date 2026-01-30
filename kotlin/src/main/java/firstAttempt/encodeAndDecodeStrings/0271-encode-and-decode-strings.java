package firstAttempt.encodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/string-encode-and-decode?list=blind75
class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();

        for (var str : strs) {
            sb.append(str.length()).append(":").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        var result = new ArrayList<String>();

        var startIndex = 0;
        while (true) {
            // 3:abc2:bc
            // 012345678, len = 9
            var endIndex = str.indexOf(":", startIndex + 1);
            if (endIndex == -1) break;

            var length = Integer.parseInt(str.substring(startIndex, endIndex));
            var s = str.substring(endIndex + 1, endIndex + 1 + length);

            result.add(s);

            startIndex = endIndex + 1 + length;
        }

        return result;
    }
}