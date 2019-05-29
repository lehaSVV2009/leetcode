class Solution {
    
    private static final int A_NUMBER = (int) 'a';
    private static final int Z_NUMBER = (int) 'z';
    private static final int ALPHABET_LENGTH = 26;
    
    public String shiftingLetters(String text, int[] shifts) {
        if (shifts.length == 0) {
            return text;
        }
        
        int[] alphabetShifts = getAlphabetShifts(shifts);
        int minLength = text.length() > alphabetShifts.length ? alphabetShifts.length : text.length();

        StringBuilder result = new StringBuilder(minLength);
        for (int i = 0; i < minLength; ++i) {
            result.append(shiftChar(text.charAt(i), alphabetShifts[i]));
        }
        
        return result.toString();
    }
    
    public int[] getAlphabetShifts(int[] shifts) {
        shifts[shifts.length - 1] = shifts[shifts.length - 1] % ALPHABET_LENGTH;

        if (shifts.length == 1) {
            return shifts;
        }

        for (int i = shifts.length - 2; i >= 0; --i) {
            shifts[i] = (shifts[i + 1] + shifts[i]) % ALPHABET_LENGTH;
        }

        return shifts;
    }

    public char shiftChar(char character, int shift) {
        int charNumber = (int) character;

        int shiftedNumber = charNumber + shift;
        
        if (shiftedNumber > Z_NUMBER) {
            shiftedNumber = A_NUMBER - 1 + (shiftedNumber - Z_NUMBER);
        }
        
        return (char) shiftedNumber;
    }
}