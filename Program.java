package javaapplication;
import java.io.File;
import java.io.IOException;
import java.util.*;
/*
  By: Alex Rodríguez
*/
public class JavaApplication {
    public static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        String path = "C:\\Users\\Windows 10\\Documents\\Pruebas";
        classify_files(path, new String[]{"docx", "csv"});
    }
    
    public static void classify_files(String path, String[] ext) {
        File folder = new File(path);
        ArrayList<String> folders = new ArrayList<>();
        ArrayList<String> files = new ArrayList<>();
        
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) folders.add(file.getName());
            else if (file.isFile()) files.add(file.getName());
        }
        
        for (String f : files) {
            String e = f.substring(f.lastIndexOf(".") + 1);
            if(Arrays.asList(ext).indexOf(e) != -1) change_path(path, e, folders, f);
	}
    }
    public static void change_path(String path, String ext, ArrayList<String> folders, String file){
        Runtime r = Runtime.getRuntime();
        try {
            if(folders.indexOf(ext) == -1){
                r.exec("cmd.exe /C mkdir "+ext, null, new File(path));
                folders.add(ext);
            }
            System.out.println("cmd.exe /C move " + file + " .\\" + ext + "\\");
            r.exec("cmd.exe /C move \"" + file + "\" .\\" + ext + "\\", null, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}