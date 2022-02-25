#include<unistd.h>
#include<iostream>
#include<string>
#include<filesystem>
#include<vector>
#include<algorithm>
#define len(x) sizeof(x)/sizeof(x[0])

int LastIndex(std::string word, char character){
    for(int i=word.length()-1; i>=0; i--) if(word[i] == character) return i;
    return -1;
}

void change_path(std::string path, std::string ext, std::vector<std::string> &folders, std::string file){
    std::filesystem::current_path(path);
    if(std::find(folders.begin(), folders.end(), ext) == folders.end()){
        system(("mkdir " + ext).c_str());
        folders.push_back(ext);
    }
    system(("mv "+file.substr(LastIndex(file, '/')+1)+" "+ext).c_str());   
}

void classify_files(std::string path, std::string ext[], int length){
    std::vector<std::string> folders, files;
    for(const auto & file : std::filesystem::directory_iterator(path)){
        std::string f = std::string(file.path()).substr(LastIndex(file.path(), '/')+1);
        if(file.is_directory()) folders.push_back(f);
        else files.push_back(f);
    }
    for(std::string f: files){
        std::string e = f.substr(f.find(".")+1);
        std::string * p = std::find (ext, ext+length, e);
        if(p != ext+length) change_path(path, e, folders, f);
    }
}

int main(){
    std::string username = getlogin();
    std::string path = "/home/"+username+"/Documents";
    std::string extensions[] = {"docx", "txt", "pdf"};
    classify_files(path, extensions, len(extensions));
    return 0;
}
