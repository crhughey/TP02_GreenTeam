package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorManager {

    private static String strProfFileName = "professors.csv";
    private static String secret = "OKCURowingTeam";

    public static boolean addProfessorInFile( String name, String email, String password)  throws NoSuchAlgorithmException {
        // check for File
        // checkForFile();

        // Retrieve User from file
        ArrayList<Professor> professors = loadProfessorFromFile(strProfFileName);

        // create new one
        int nId = professors.size() +  1;
        Professor professor = new Professor( (new Integer(nId)).toString(), email, name, password);
        professors.add(professor);

        // Save professors to file
        createFile(strProfFileName, professors);
        System.out.println( "Prof added: " + professor.toString());

        return true;
    }

    public static Professor checkProfessorInFile( String email, String password)  throws NoSuchAlgorithmException {
        // check for File
        // checkForFile();

        // Retrieve User from file
        ArrayList<Professor> professors = loadProfessorFromFile(strProfFileName);

        // Enter password hash it and compare to hashed password for user
        return checkProfessorPassword(professors, email, password);
    }

    private static Professor checkProfessorPassword(ArrayList<Professor> professors, String email, String password) {
        boolean match = false;
        Hash hash = new Hash();
        for ( Professor professor : professors) {
            if (professor.getEmail().equals(email)) {
                String newHash = hash.getSecurePassword(password, professor.getSalt());
                if (newHash.equals(professor.getHashed_password())) {
                    return professor;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    private static void checkForFile() throws NoSuchAlgorithmException {
        File f = new File(strProfFileName);

        if (!f.exists()) {
            // Create some professors
            ArrayList<Professor> professors = new ArrayList<Professor>();
            Professor professor1 = new Professor("1", "jmaxwell@okcu.edu", "Jeff Maxwell", "password1");
            professors.add(professor1);

            // Save professors to file
            createFile(strProfFileName, professors);
        }
    }

    // Encrypt some data when writing to file
    private static void createFile(String fileName, ArrayList<Professor> professors) {
        try {
            FileWriter fw = new FileWriter(fileName);
            Security security = new Security();

            for (Professor professor : professors) {
                fw.append(professor.getId());
                fw.append(",");
                // Encrypt some data when writing to file
                fw.append(security.encrypt(professor.getEmail(), secret));
                fw.append(",");
                // Encrypt some data when writing to file
                fw.append(security.encrypt(professor.getName(), secret));
                fw.append(",");
                fw.append(professor.getHashed_password());
                fw.append(",");
                fw.append(professor.getSalt());
                fw.append("\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    // Decrypt some data when read from file
    private static ArrayList<Professor> loadProfessorFromFile(String fileName) throws NoSuchAlgorithmException {
        File f = new File(fileName);
        ArrayList<Professor> list = new ArrayList<Professor>();
        Security security = new Security();

        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(",");
                // Decrypt some data when read from file
                values[1] = security.decrypt(values[1], secret);
                // Decrypt some data when read from file
                values[2] = security.decrypt(values[2], secret);
                Professor professor = new Professor(values[0], values[1], values[2], values[3], values[4]);
                list.add(professor);
            }
            scan.close();
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return list;
    }
}


