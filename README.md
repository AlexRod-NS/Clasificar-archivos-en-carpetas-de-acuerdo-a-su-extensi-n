# Clasificar-archivos-en-carpetas-de-acuerdo-a-su-extensión
Estos algoritmo clasifican los archivos de una carpeta de acuerdo a su extensión.

Estos algoritmos están hechos en 4 lenguajes de programación distintos.

## Algoritmos para Windows
- Program.cs es el algoritmo realizado en CSharp
- Program.java es el algoritmo realizado en Java

## Algoritmos para Linux
- Program.py es el algoritmo realizado en Python
- Program.cpp es el algoritmo realizado en C++
- Program.sh es el algoritmo realizado en Bash

### Algoritmo en Bash
    - Antes de ejecutar, darle permisos de ejecuciòn al archivo.sh
      # chmod +x Program.sh
    - Forma de ejecutar el archivo
      # ./Program.sh path_of_folder extension1 extension2 extension3 ......
      Ejemplo:
         # ./Program.sh /home/user/Documents/ docx sql pdf
         
## Pseudocódigo de los algoritmos
    path <- "C:\\Users\\...."   |   path <- "/home/user/...."
    extensions <- ["docx", "pdf", ....]
    classify_files(path, extensions)

    Function classify_files(path, extensions)
      folders <- getDirectories(path)
      files <- getFiles(path)
      For file in files Do
        e <- getExtension(file)
        If e in extensions So
          change_path(path, e, folders, file)
        EndIf
      EndFor
    EndFunction

    Function change_path(path, ext, folders, file)
      If ext not in folders So
        ExecuteCommand(mkdir ext)
      EndIf
      ExecuteCommand(move file ext)
    EndFunction

