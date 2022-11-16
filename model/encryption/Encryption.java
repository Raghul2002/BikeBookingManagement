package bbm.model.encryption;

import bbm.model.IEncryption;

public class Encryption implements IEncryption {
    public String encryptPassword(String pw){
        StringBuilder password = new StringBuilder();
        for (char c : pw.toCharArray()) {
            password.append((char)(c + 5));
        }
        return password.toString();
    }
}
