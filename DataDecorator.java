import java.util.List;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

// Decorator Pattern
// Interface for data decorators
interface DataDecorator {
    List<String> decorateData(List<String> data);
}

// Concrete decorators
class EncryptionDecorator implements DataDecorator {
    private final String secretKey; // Secret key for encryption

    public EncryptionDecorator(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public List<String> decorateData(List<String> data) {
        try {
            // Go through the list of data and encrypt each string
            for (int i = 0; i < data.size(); i++) {
                String originalData = data.get(i);
                String encryptedData = encrypt(originalData, secretKey);
                data.set(i, encryptedData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private String encrypt(String data, String secretKey) throws Exception {
        // Create SecretKeySpec from the provided secret key, google for more info if ur not familiar
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");

        // make the AES cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Encrypt the data and encode it in Base64
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}

class EncodingDecorator implements DataDecorator {
    @Override
    public List<String> decorateData(List<String> data) {
        // Go through the list of data and apply Base64 encoding to each string
        for (int i = 0; i < data.size(); i++) {
            String originalData = data.get(i);
            String encodedData = encode(originalData);
            data.set(i, encodedData);
        }
        return data;
    }

    private String encode(String data) {
        // Encode the data in Base64 format
        byte[] encodedBytes = data.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(encodedBytes);
    }
}
