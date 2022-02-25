from getpass import getuser
import os, shlex, subprocess

def classify_files(path: str, extensiones: list()):
    folders = [f for f in os.listdir(path) if os.path.isdir(f)]
    for file in os.listdir(path):
        if os.path.isfile(file):
            e = file[file.find(".")+1:]
            if e in extensiones: change_path(e, folders, file)

def change_path(ext:str, folders:list(), file:str):
    if not(ext in folders):
        subprocess.call(shlex.split(f"mkdir {ext}"))
        folders.append(ext)
    subprocess.call(shlex.split(f"mv {file} {ext}"))

if __name__ == '__main__':
    username = getuser()
    path = "/home/"+username+"/Documents"
    extensions = ["docx", "pdf", "txt"]
    os.chdir(path)
    os.system("clear")
    classify_files(path, extensions)
