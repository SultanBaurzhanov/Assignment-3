import java.util.List;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

//decorator pattern
//interface for data decorations
interface DataDecorator {
    List<String> decorateData(List<String> data);
}

//concrete decorators
//look up how to encrypt files
class EncryptionDecorator implements DataDecorator {
    private /*'final' here if goes wrong*/ String secretKey = "BIGSHOT"; //secret key for encryption

    public EncryptionDecorator(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public List<String> decorateData(List<String> data) {
        try {
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
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}

class EncodingDecorator implements DataDecorator {
    @Override
    public List<String> decorateData(List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            String originalData = data.get(i);
            String encodedData = encode(originalData);
            data.set(i, encodedData);
        }
        return data;
    }

    private String encode(String data) {
        byte[] encodedBytes = data.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(encodedBytes);
    }
}
