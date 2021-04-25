package sample;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Security {
    /* Cipher Transformations
     * AES/CBC/NoPadding (128)
     * AES/CBC/PKCS5Padding (128)
     * AES/ECB/NoPadding (128)
     * AES/ECB/PKCS5Padding (128)
     * AES/GCM/NoPadding (128)
     * DESede/CBC/NoPadding (168)
     * DESede/CBC/PKCS5Padding (168)
     * DESede/ECB/NoPadding (168)
     * DESede/ECB/PKCS5Padding (168)
     * RSA/ECB/PKCS1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
     */
    private String CIPHER_TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private String CIPHER_KEYSPEC = "AES";
    private String CHARACTER_SET = "UTF-8";
    private String DIGEST_ALGORIHM_NAME = "SHA-512";
    private String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
    private SecretKeySpec secretKey;
    private byte[] key;

    private void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(CHARACTER_SET);
            sha = MessageDigest.getInstance(DIGEST_ALGORIHM_NAME);
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, CIPHER_KEYSPEC);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte [] strToEncryptBytes = strToEncrypt.getBytes(CHARACTER_SET);
            byte [] finalCipher = cipher.doFinal(strToEncryptBytes);
            return Base64.getEncoder().encodeToString(finalCipher);
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte [] finalByteString = Base64.getDecoder().decode(strToDecrypt);
            return new String(cipher.doFinal(finalByteString));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public String hash(String stringToHash, byte[] salt, boolean useSalt)
    {
        String generatedPassword = null;
        try {
            /*
             * Algorithm Name
             *    MD2
             *    MD5
             *    SHA-1
             *    SHA-256
             *    SHA-384
             *    SHA-512
             */

            MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORIHM_NAME);
            if (useSalt)
                md.update(salt);
            byte[] bytes = md.digest(stringToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(String.format("%02x", bytes[i]));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public byte[] getSalt()
    {
        try {
            SecureRandom random = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
