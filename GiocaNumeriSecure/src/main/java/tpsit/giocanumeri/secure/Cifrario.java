package tpsit.giocanumeri.secure;

/**
 * Questa classe usa come tecnica di crittografia il cifrario di Vigenère
 * per cifrare parole o frasi
 * @see #cifra(String, String) cifra() per vedere i parametri da passare per cifrare
 * @see #decifra(String, String) decifra() per vedere i parametri da passare per decifrare
 * @see #convalidaParametri(String, String) convalidaParametri() per comprendere la convalida
 * @author TomRiddle901
 * @version 1.1.5
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
     * Convalida i parametri prima di cifrare/decifrare una parola.
     * Se entrambi i parametri risultano errati, i messaggi vengono concatenati in un'unica eccezione.
     * @param testo Parola o frase da cifrare/decifrare
     * @param keyword Parola chiave per fare gli spostamenti
     * @throws Exception se uno o entrambi i parametri non sono validi, con uno o più dei seguenti messaggi:
     * <ul>
     *     <li><code>"Devi inserire una parola da cifrare"</code> se <code>testo</code> è nullo o vuoto</li>
     *     <li><code>"Parola non valida: puoi inserire solo caratteri (a-z o A-Z)"</code> se <code>testo</code> non rispetta la RegEx <code>[a-zA-Z]+</code></li>
     *     <li><code>"La keyword non può essere vuota"</code> se <code>keyword</code> è nulla o vuota</li>
     *     <li><code>"Keyword non valida: puoi inserire solo caratteri (a-z o A-Z)"</code> se <code>keyword</code> non rispetta la RegEx <code>[a-zA-Z]+</code></li>
     * </ul>
     */
    public static void convalidaParametri(String testo, String keyword) throws Exception{
        String messaggioException = "";
        if (testo == null || testo.isEmpty()){
            messaggioException += "La parola da cifrare non può essere vuota\n";
        }else if (!testo.matches("[a-zA-Z]+")){
            messaggioException += "Parola non valida: puoi inserire solo caratteri (a-z o A-Z)\n";
        }

        if (keyword == null || keyword.isEmpty()){
            messaggioException += "La keyword non può essere vuota\n";
        }else if (!keyword.matches("[a-zA-Z]+")){
            messaggioException += "Keyword non valida: puoi inserire solo caratteri (a-z o A-Z)\n";
        }

        if (!messaggioException.isEmpty()){
            throw new Exception(messaggioException.trim()); // Trim() rimuove \n alla fine del messaggio
        }
    }
}
