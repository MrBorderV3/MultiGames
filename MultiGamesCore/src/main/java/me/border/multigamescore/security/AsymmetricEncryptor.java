package me.border.multigamescore.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class AsymmetricEncryptor {
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private static final Charset FORMAT = StandardCharsets.UTF_8;

    public AsymmetricEncryptor() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(512, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            this.privateKey = keyPair.getPrivate();
            this.publicKey = keyPair.getPublic();
        } catch (NoSuchProviderException | NoSuchAlgorithmException var4) {
            var4.printStackTrace();
        }

    }

    public AsymmetricEncryptor(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String encrypt(String str) {
        try {
            Cipher eCipher = Cipher.getInstance("RSA");
            eCipher.init(Cipher.ENCRYPT_MODE, this.publicKey);
            byte[] encryptedPassBytes = eCipher.doFinal(str.getBytes(FORMAT));
            byte[] encodedPass = Base64.getEncoder().encode(encryptedPassBytes);
            return new String(encodedPass, FORMAT);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public String decrypt(String str) {
        try {
            Cipher dCipher = Cipher.getInstance("RSA");
            dCipher.init(Cipher.DECRYPT_MODE, this.privateKey);
            byte[] decoded = Base64.getDecoder().decode(str.getBytes(FORMAT));
            byte[] decipheredTextBytes = dCipher.doFinal(decoded);
            return new String(decipheredTextBytes, FORMAT);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public static String encrypt(PublicKey publicKey, String data) {
        try {
            Cipher eCipher = Cipher.getInstance("RSA");
            eCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedPassBytes = eCipher.doFinal(data.getBytes(FORMAT));
            byte[] encodedPass = Base64.getEncoder().encode(encryptedPassBytes);
            return new String(encodedPass, FORMAT);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static String decrypt(PrivateKey privateKey, String data) {
        try {
            Cipher dCipher = Cipher.getInstance("RSA");
            dCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decoded = Base64.getDecoder().decode(data.getBytes(FORMAT));
            byte[] decipheredTextBytes = dCipher.doFinal(decoded);
            return new String(decipheredTextBytes, FORMAT);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException var5) {
            var5.printStackTrace();
            return null;
        }
    }
}

