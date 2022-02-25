using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
/*
  By: Alex Rodríguez
*/
namespace program{
    public class program{
        public static void Main(){
            string path = "C:\\Users\\"+Environment.UserName+"\\Documents\\Pruebas";
            string [] extensions = {"docx", "csv"};
            classify_files(path, extensions);
        }
        public static void classify_files(string path, string[] ext){
            List<string> folders = new List<string>();
            foreach(string f in Directory.GetDirectories(@path)) folders.Add(f.Substring(f.LastIndexOf("\\")+1));
            
            string [] files = Directory.GetFiles(@path);
            foreach(string file in files){
                int aux = file.LastIndexOf(".");
                string e = file.Substring(aux+1);
                if(Array.IndexOf(ext, e) != -1) change_path(path, e, folders, file);             
            }
        }
        public static void change_path(string path, string ext, List<string> folders, string file){
            String cd_dir = "/C cd "+path+" && ";
            if(folders.IndexOf(ext) == -1){
                string command = cd_dir+"mkdir "+ext;
                System.Diagnostics.Process.Start("CMD.exe", command);
                folders.Add(ext);
            }
            System.Diagnostics.Process.Start("CMD.exe", 
            cd_dir+"move \""+file.Substring(file.LastIndexOf("\\")+1)+"\" .\\"+ext+"\\"); 
        }
    }
}