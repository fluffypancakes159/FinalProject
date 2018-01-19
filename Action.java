// import com.sun.org.apache.bcel.internal.classfile.Code;
// import com.sun.org.apache.bcel.internal.classfile.*;

import java.io.*;
import java.util.*;


public class Action{

    String[] command;

    public static class Codefight{

        static String question;
        static String testCases;
        static String editPath = "codefight.py";
        static String absPath;


        public Codefight(String q, String t) {
            String intro = "Welcome to the codefight! Each time you close " +
                    "this window your code will be automatically run with the " +
                    "test cases. If this window reopens, you have failed. You can fail " +
                    "from either incorrect output or failing to meet the time constraints. "+
                    "If this window doesn't reopen, you passed the test! Of course, coding will " +
                    "be in python. Writing this in java was completely awful so I decided to spare you " +
                    "the pain and suffering of not having any primitives. I apologize for the awfully" +
                    " automatically generated formatting in advance. \n\n";
            question = q;
            testCases = t;

            //Create the file and add the question

            writeToFile(editPath, enforcePythonPEP8(intro) + enforcePythonPEP8(question));

            //Get absolute path so it can be run from terminal

            File f = new File(editPath);
            absPath = f.getAbsolutePath();
        }


        public static void go(){
            String newPath = absPath.substring(0, absPath.length()-3) + "Test.py";
            while(true) {
                runTerminalCommand("gedit " + absPath);
                String s = readFileToString(absPath);
                writeToFile(newPath, s + "\n" + testCases + "\nprint(\"Success!\")");
                String f = runTerminalCommand("python " + newPath);
                System.out.println(f);
                if (f.equals("Success!")) break;
            }
        }
    }

    public Action(){
        String[] cmd = {"Print", ""};
        this.command = cmd;
    }

    public Action(String[] cmd){
        this.command = cmd;
    }

    public static String readFileToString(String path){
        try {
            Scanner scanner = new Scanner(new File(path));
            String text = scanner.useDelimiter("\\A").next();
            scanner.close();
            return text;
        }catch(FileNotFoundException F){}
        return "";
    }

    public static String runTerminalCommand(String command){
        try{

            // Run command

            Process proc = Runtime.getRuntime().exec(command);

            // Read the output

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String res = "";
            String line = "";
            while((line = reader.readLine()) != null) {
                res += line;
            }
            proc.waitFor();

            return res;

        }catch (Exception e){
        }
        return "";
    }

    public static String enforcePythonPEP8(String s){

        //PEP-8 says that lines should cap out at 79 characters
        //I agree
        //This function inserts newlines into a string every 79 characters and comments it out

        if (s.length() < 79) return "#" + s;
        int start = 0;
        int end = 79;
        String res = "";
        while (end <= s.length()){
            res += "#" + s.substring(start, end) + '\n';
            start += 79;
            end += 79;
        }
        if (end==s.length()+79) return res;
        return res + "#" + s.substring(end-79, s.length()) + "\n";

    }

    public static boolean writeToFile(String path, String s){

        try {
            PrintWriter p = new PrintWriter(path, "UTF-8");
            p.println(s);
            p.close();
        }catch (Exception E) {
            System.out.println("ERROR WHEN WRITING");
            System.out.println(E.getStackTrace());
            return false;
        }
        return true;

    }

    public static void createCodefight(String q, String t){
        Codefight c = new Codefight(q, t);
        c.go();
    }

    public void run(String[] args){
        if (args[0].equals("createCodefight")){
            createCodefight(args[1], args[2]);
        } if (args[0].equals("print")){
            System.out.println(args[1]);
        }
        if (args[0].equals("battle")){
            // System.out.println(args[1]);
            Character A = new Player ( 30 , 5 , 2 , 2 , 0 , 0 , "Player" );
            Character B = new Enemy ( 20 , 4 , 1 , 1 , 10 , 10 , "Enemy" );
            Character.battle( A , B );
        }
    }

    public void run(){
        run(command);
    }

    public static void main(String[] args){
        Codefight c = new Codefight("", "assert func(32) == 33");
        c.go();
    }

}
