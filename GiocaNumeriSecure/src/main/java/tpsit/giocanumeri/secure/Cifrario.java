package tpsit.giocanumeri.secure;

/**
 * Questa classe usa come tecnica di crittografia il cifrario di Vigenère
 * per cifrare parole o frasi
 * @see #cifra(String, String) cifra() per vedere i parametri da passare per cifrare
 * @see #decifra(String, String) decifra() per vedere i parametri da passare per decifrare
 * @see #convalidaParametri(String, String) convalidaParametri() per comprendere la convalida
 * @author TomRiddle901
 * @version 1.1.0
 */
public class Cifrario {
    public Cifrario(){}

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
                int spostamento = keyword.charAt(keyIndex % keyword.length()) - 'A';

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
                parolaInCharArray[i] = (char) ((carattere - 'A' - spostamento + 26) % 26 + 'A');
                keyIndex++;
            }
        }

        return new String(parolaInCharArray); // Restituisce la parola decifrata
    }

    /**
     * Convalida i parametri prima di cifrare/decifrare una parola
     * @param testo Parola o frase da cifrare/decifrare
     * @param keyword Parola chiave per fare gli spostamenti
     * @throws Exception "Devi inserire una parola da cifrare" per il campo <code>testo</code> vuoto o null
     * @throws Exception "La keyword non può essere vuota" per il campo <code>keyword</code> vuoto o null
     * @throws Exception "Testo inserito non valido: puoi inserire solo caratteri (a-z o A-Z)" <code>keyword</code> o <code>testo</code> non rispettano la RegEx <code>[a-zA-Z]+</code>
     */
    public static void convalidaParametri(String testo, String keyword) throws Exception{
        if (testo == null || testo.isEmpty()){
            throw new Exception("Devi inserire una parola da cifrare");
        }

        if (keyword == null || keyword.isEmpty()){
            throw new Exception("La keyword non può essere vuota");
        }

        if (!keyword.matches("[a-zA-Z]+") || !testo.matches("[a-zA-Z]+")){
            throw new Exception("Testo inserito non valido: puoi inserire solo caratteri (a-z o A-Z)");
        }
    }
}
