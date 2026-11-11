package tpsit.giocanumeri.secure;

/**
 * Questa classe usa come tecnica di crittografia il cifrario di Vigenère
 * @author TomRiddle901
 * @version 1.0.1
 */
public class Cifrario {
    public Cifrario(){

    }

    /**
     * Cifra una parola passata come parametro e restituisce la parola cifrata
     * @param parolaDaCifrare Parola/frase da cifrare
     * @param keyword Parola chiave
     * @return java.lang.String
     */
    public static String cifra(String parolaDaCifrare, String keyword){
        // Trasforma la String in un array di char (tutti maiuscoli)
        char[] parolaInCharArray = parolaDaCifrare.toUpperCase().toCharArray();
        keyword = keyword.toUpperCase();
        int keyIndex = 0;

        for (int i = 0; i < parolaInCharArray.length; i++){
            char carattere = parolaInCharArray[i];

            if (carattere >= 'A' && carattere <= 'Z'){ // Vengono gestite solo le lettere maiuscole
                int spostamento = keyword.charAt(keyIndex % keyword.length());

                // Cifratura
                parolaInCharArray[i] = (char) ((carattere - 'A' + spostamento) % 26 + 'A');
                keyIndex++;
            }
        }

        return new String(parolaInCharArray); // Restituisce una string dei char (parola cifrata)
    }

    /**
     * Decifra una parola passata come parametro e restituisce la parola decifrata
     * @param parolaCifrata Parola/frase da decifrare
     * @param keyword Parola chiave
     * @return java.lang.String
     */
    public static String decifra(String parolaCifrata, String keyword){
        // Trasforma la String in un array di char tutti maiuscoli
        char[] parolaInCharArray = parolaCifrata.toUpperCase().toCharArray();
        keyword = keyword.toUpperCase();
        int keyIndex = 0;

        for (int i = 0; i < parolaInCharArray.length; i++){
            char carattere = parolaInCharArray[i];

            if (carattere >= 'A' && carattere <= 'Z'){ // Gestione solo dei caratteri maiuscoli
                int spostamento = keyword.charAt(keyIndex % keyword.length()) - 'A';

                // Decifratura
                parolaInCharArray[i] = (char) ((carattere - 'A' + spostamento) % 26 + 'A');
                keyIndex++;
            }
        }

        return new String(parolaInCharArray); // Restituisce la parola decifrata
    }
}
