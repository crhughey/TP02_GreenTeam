package sample;

import java.security.NoSuchAlgorithmException;

public class Student {

    Hash hash = new Hash();

    private String id;
    private String name;
    private String email;
    private String password;
    private String hashed_password;
    private String salt;

    public Student(String id, String email, String name, String password) throws NoSuchAlgorithmException {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;

        //Hash Password with a salt
        this.salt = hash.getSalt();
        this.hashed_password = Hash.getSecurePassword(this.password, salt);
    }

    public Student(String id, String email, String name, String hashed_password, String salt) {
        this.email = email;
        this.name = name;
        this.hashed_password = hashed_password;
        this.salt = salt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getHashed_password() { return hashed_password; }
    public void setHashed_password(String hashed_password) { this.hashed_password = hashed_password; }
    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }
}
