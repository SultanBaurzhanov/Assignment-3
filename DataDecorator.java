import java.util.List;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

//interface for data decorators
interface DataDecorator {
    List<String> decorateData(List<String> data);
}

//Concrete decorators
class EncryptionDecorator implements DataDecorator {
     private static final String encryptionKey = "SecretKey12345";
     private List<String> encryptData(List<String> data) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptionKey.getBytes(StandardCharsets.UTF_8));
            
            for (int i = 0; i < data.size(); i++) {
                byte[] encryptedBytes = cipher.doFinal(data.get(i).getBytes(StandardCharsets.UTF_8));
                data.set(i, new String(encryptedBytes, StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    @Override
    public List<String> decorateData(List<String> data) {
        data = encryptData(data);
        return data;
    }
}

class EncodingDecorator implements DataDecorator {
    private String encoding;

    public EncodingDecorator(String encoding) {
        this.encoding = encoding;
    }

    private List<String> encodeData(List<String> data) {
        try {
            for (int i = 0; i < data.size(); i++) {
                byte[] encodedBytes = data.get(i).getBytes(encoding);
                data.set(i, new String(encodedBytes, encoding));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    @Override
    public List<String> decorateData(List<String> data) {
        data = encodeData(data);
        return data;
    }
}
