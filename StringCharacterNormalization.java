package StringOperations;

import java.text.Normalizer;

/**
* A class to show how easy is to substitute a character
* and add new ones into Strings in Java.
*
* @author Ali Adame
* @version 1.0
* @since 2019-02-05
*/
public class StringCharacterNormalization {
    
    public static void main(String[] args) {
        // As you might know in spanish sometimes there's need to substitute 
        // some characters into others when the databases are not meant to work with them
        // For instance: Cabañas blancas needs to be transformed into 'Cabanas Blancas'
        String example1 = StringCharacterNormalization.toCamelCase("Cabañas blancas");
        System.out.println(StringCharacterNormalization.removeLatinCharacters(example1));
        // 'Cigüeña' need to be turned into 'Cigueña'
        String originalWord = "Cigüeña";
        String example2 = StringCharacterNormalization.toCamelCase(originalWord);
        System.out.println(StringCharacterNormalization.denormalizeCharInWord(originalWord, example2, 'ñ'));        
    }
    
    // To CamelCase taken from StackOverFlow: 
    // https://stackoverflow.com/questions/17078347/convert-a-string-to-modified-camel-case-in-java-or-title-case-as-is-otherwise-ca
    public static String toCamelCase(final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(Character.toUpperCase(word.charAt(0)));
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }
    
    /**
     * Remove the latin characters from a String with alike characters.
     * @param src as the input string
     * @return a new string with normalized characters
     * @version 0.1
     * @author Ali Adame
     */
    public static String removeLatinCharacters(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
    
    /**
     * Takes a not normalized word, a normalized one and a character to insert into the nomalized word.
     * @param originalWord the originally intended word
     * @param normalizedWord as the transformed word
     * @param character as the character to be reintroduced into the transformed word
     * @return a new string with the replaced character
     * @version 0.1
     * @author Ali Adame
     */
    public static String denormalizeCharInWord(String originalWord, String normalizedWord, Character character) {
        int positionOfCharToReplace = originalWord.indexOf(character);
        if(positionOfCharToReplace > -1) {
            String newWord = normalizedWord.substring(0,positionOfCharToReplace)+character+normalizedWord.substring(positionOfCharToReplace+1);
            normalizedWord = newWord;
        }
        return normalizedWord;
    }
    
}