package secondAttempt.encodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final String SEPARATOR = ";";

    public String encode(List<String> strs) {
        var sb = new StringBuilder();

        for (var str : strs) {
            sb.append(str.length()).append(SEPARATOR).append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        var idx = 0;
        var result = new ArrayList<String>();

        while (idx < str.length()) {
            var sepIdx = str.indexOf(SEPARATOR, idx);
            if (sepIdx == -1) break;

            var length = Integer.parseInt(str.substring(idx, sepIdx));
            var s = str.substring(sepIdx + 1, sepIdx + 1 + length);
            result.add(s);

            idx = sepIdx + 1 + length;
        }

        return result;
    }
}

