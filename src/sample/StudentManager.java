package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    //Name for file
    private static final String fileName = "students.csv";

    //Secret String for encrypting and decrypting
    private static final String secret = "Coding is my favorite";

    private static void createFile(ArrayList<Student> students) {

        try {
            FileWriter fw = new FileWriter(fileName);
            Security secure = new Security();

            //Write Each user from the ArrayList onto a file
            for(Student student : students) {
                fw.append(student.getId()).append(",");
                fw.append(secure.encrypt(student.getUsername(), secret)).append(",");
                fw.append(secure.encrypt(student.getName(), secret)).append(",");
                fw.append(student.getHashed_password()).append(",");
                fw.append(student.getSalt()).append("\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public static boolean addStudentInFile(String name, String username, String password) throws NoSuchAlgorithmException {
 //       checkForFile();

        ArrayList<Student> students = loadStudentFromFile();

        //create new student
        int nId = students.size() +1;
        Student student = new Student((new Integer(nId)).toString(), username, name, password);
        students.add(student);

        //Save to file
        createFile(students);
        System.out.println("Student added: " + student.toString());

        return true;
    }

    private static void checkForFile() throws NoSuchAlgorithmException {
        File f = new File(fileName);

        if (!f.exists()) {
            //Create Student
            ArrayList<Student> students = new ArrayList<Student>();
            Student student1 = new Student("1", "srmarrs@my.okcu.edu", "Savana Marrs", "password$");
            students.add(student1);

            //Save Student to file
            createFile(students);
        }
    }

    public static Student checkStudentInFile(String username,String password) throws NoSuchAlgorithmException {

        ArrayList<Student> students = loadStudentFromFile();

        return checkStudentPassword(students, username, password);
    }

    private static Student checkStudentPassword(ArrayList<Student> students, String username, String password) {
        boolean match = false;
        Hash hash = new Hash();
        for(Student student : students) {
            if(student.getUsername().equals(username)) {
                String newHash = Hash.getSecurePassword(password, student.getSalt());
                if(newHash.equals(student.getHashed_password())) {
                    return student;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    private static ArrayList<Student> loadStudentFromFile() {
        File f = new File(fileName);
        ArrayList<Student> list = new ArrayList<Student>();
        Security secure = new Security();

        try{
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(",");
                //Decrypt email from file
                values[1] = secure.decrypt(values[1], secret);
                //Decrypt name from file
                values[2] = secure.decrypt(values[2], secret);
                Student student = new Student(values[0], values[1], values[2], values[3], values[4]);
                list.add(student);
            }
            scan.close();
        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return list;
    }

}
