class Solution {
    class OddEvenChars {
        String oddChars = "";
        String evenChars = "";

        public OddEvenChars(char[] oddChars, char[] evenChars) {
            this.oddChars = new String(oddChars);
            this.evenChars = new String(evenChars);
        }

        public int hashCode() {
            return 31 * oddChars.hashCode() + evenChars.hashCode();
        }

        public boolean equals(OddEvenChars obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!this.getClass().equals(obj.getClass())) {
                return false;
            }
            return oddChars.equals(obj.oddChars) && evenChars.equals(obj.evenChars);
        }
    }
    
    public int numSpecialEquivGroups(String[] A) {
        if (A.length == 0) {
            return 0;
        }
        
        if (A.length == 1) {
            return 1;
        }

        int charsLength = A[0].length();
        if (charsLength == 1 || charsLength == 2) {
            return new HashSet<String>(Arrays.asList(A)).size();
        }

        int groupsNumber = 0;
        
        Set<OddEvenChars> previousTexts = new HashSet<>();
        for (int index = 0; index < A.length; ++index) {
            String text = A[index];
            OddEvenChars oddEvenChars = parseTextToSortedOddEvenChars(text);

            if (previousTexts.stream().noneMatch(previousOddEvenChars -> {
                return oddEvenChars.equals(previousOddEvenChars);
            })) {
                groupsNumber++;
            }

            previousTexts.add(oddEvenChars);
        }
        
        return groupsNumber;
    }

    private OddEvenChars parseTextToSortedOddEvenChars(String text) {
        int textLength = text.length();
        int halfLength = textLength / 2;

        int oddCharsIndex = 0;
        char[] oddChars = new char[textLength % 2 == 1 ? halfLength + 1 : halfLength];
        int evenCharsIndex = 0;
        char[] evenChars = new char[halfLength];
        
        for (int index = 0; index < textLength; ++index) {
            char character = text.charAt(index);
            if (index % 2 == 0) {
                oddChars[oddCharsIndex] = character;
                oddCharsIndex++;
            } else {
                evenChars[evenCharsIndex] = character;
                evenCharsIndex++;
            }
        }

        Arrays.sort(oddChars);
        Arrays.sort(evenChars);
        
        return new OddEvenChars(oddChars, evenChars);
    }
}