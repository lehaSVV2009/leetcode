class Solution {
    public int compareVersion(String version1, String version2) {
        // Only dots and digits
        // Don't start and end with dots, not 2 consecutive dots
        // Might be a leading zero
        // Empty -> 0
        // Nullable -> exception
        // 1.0.1 vs 1.0.01 -> 0
        // "" vs "1" -> 1
        // "1" vs "" -> -1
        // 7.5.3.0 vs 7.5.3 -> 0
        // 7.5.3 vs 7.5.3.0 -> 0
        // 7.5.3.0.0 vs 7.5.3 -> 0
        // 7.5.3.4 vs 7.5.3 -> 1
        // Maximum version number?? (greater than int?)

        // Solution 1
        // split both by dot
        // while i < maxLength
        //   if (i >= firstLength) 
        //      firstElement = 0
        //   if (i >= secondLength)
        //      secondElement = 0
        //   parseInt().compare(parseInt())
        //   if not same return 
        // end while
        // 
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        
        int maxLength = Math.max(version1Array.length, version2Array.length);

        for (int i = 0; i < maxLength; ++i) {
            int firstElementSubVersion = 0;
            int secondElementSubVersion = 0;
            if (i < version1Array.length) {
                firstElementSubVersion = Integer.parseInt(version1Array[i]);
            }
            if (i < version2Array.length) {
                secondElementSubVersion = Integer.parseInt(version2Array[i]);
            }

            if (firstElementSubVersion < secondElementSubVersion) {
                return -1;
            }
            if (firstElementSubVersion > secondElementSubVersion) {
                return 1;
            }
        }
        
        return 0;
    }
}