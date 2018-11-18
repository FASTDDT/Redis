package help.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    private static final String[] digital = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String secret(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(password.getBytes("UTF-8"));
        String miwen = "";
        for (byte b : bytes) {
            int tmp = b;
            if (tmp < 0) {
                tmp += 256;
            }
            int index1 = tmp / 16;
            int index2 = tmp % 16;
            miwen += digital[index1] + digital[index2];


        }
        return miwen;
    }
    public static String finalMD5(String text) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        for (int i=0;i<3;i++){
            text=secret(secret(text)+"love"+text);
        }
        return text;
    }
}
