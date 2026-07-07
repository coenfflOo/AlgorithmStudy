class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if ((c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9') ||
                c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        while (sb.indexOf("..") != -1) {
            int idx = sb.indexOf("..");
            sb.deleteCharAt(idx);
        }

        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0) {
            sb.append('a');
        }

        if (sb.length() >= 16) {
            sb.setLength(15);
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}