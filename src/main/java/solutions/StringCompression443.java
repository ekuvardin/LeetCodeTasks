package solutions;


/*
        StringCompression443 stringCompression443 = new StringCompression443();
        stringCompression443.compress(new char[] { 'a','a','b','b','c','c','c'});

        Yandex
 */
public class StringCompression443 {
    public int compress(char[] chars) {
        char prev = chars[0];
        StringBuilder compressed = new StringBuilder();
        compressed.append(prev);

        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                if (count > 1) {
                    compressed.append(count);
                }
                compressed.append(chars[i]);
                count = 1;
                prev = chars[i];
            }
        }

        if (count > 1) {
            compressed.append(count);
        }

        for (int j = 1; j < compressed.length(); j++) {
            chars[j] = compressed.charAt(j);
        }

        return compressed.length();
    }

}
