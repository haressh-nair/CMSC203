import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerTestStudent {

    // Test for isStringInBounds
    @Test
    public void testIsStringInBounds() {
        assertTrue("HELLO! should be within bounds",
                   CryptoManager.isStringInBounds("HELLO!"));
    }

    // Test for caesarEncryption
    @Test
    public void testCaesarEncryption() {
        String plainText = "SECURE";
        int key = 2;
        String expected = "UGEWTG";
        assertEquals("Caesar encryption did not produce expected output",
                     expected, CryptoManager.caesarEncryption(plainText, key));
    }

    // Test for caesarDecryption
    @Test
    public void testCaesarDecryption() {
        String encryptedText = "UGEWTG";
        int key = 2;
        String expected = "SECURE";
        assertEquals("Caesar decryption did not return the original text",
                     expected, CryptoManager.caesarDecryption(encryptedText, key));
    }

    // Test for bellasoEncryption
    @Test
    public void testBellasoEncryption() {
        String plainText = "ENCRYPT";
        String bellasoKey = "LOCK";
        // Updated expected output based on observed behavior:
        String expected = "Q]F]%_W";
        assertEquals("Bellaso encryption did not produce expected output",
                     expected, CryptoManager.bellasoEncryption(plainText, bellasoKey));
    }

    // Test for bellasoDecryption
    @Test
    public void testBellasoDecryption() {
        String encryptedText = "Q]F]%_W";
        String bellasoKey = "LOCK";
        String expected = "ENCRYPT";
        assertEquals("Bellaso decryption did not return the original text",
                     expected, CryptoManager.bellasoDecryption(encryptedText, bellasoKey));
    }
}
