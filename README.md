# Clasificar-archivos-en-carpetas-de-acuerdo-a-su-extensión
Estos algoritmo clasifican los archivos de una carpeta de acuerdo a su extensión.

Estos algoritmos están hechos en 4 lenguajes de programación distintos.

## Algoritmos para Windows
- Program.cs es el algoritmo realizado en CSharp
- Program.java es el algoritmo realizado en Java

## Algoritmos para Linux
- Program.py es el algoritmo realizado en Python
- Program.cpp es el algoritmo realizado en C++

## Pseudocódigo de los algoritmos
    path <- "C:\\Users\\...."

    extensions <- ["docx", "pdf", ....]

    classify_files(path, extensions)



    Function classify_files(path, extensions)

      folders <- getDirectories(path)

      files <- getFiles(path)

      For file in files Do

        e <- getExtension(f)

        If e in extensions So

          change_path(path, e, folders, file)

    EndFunction



    Function change_path(path, ext, folders, file)
    
      If ext not in folders So
      
        ExecuteCommand(mkdir ext)
        
      ExecuteCommand(move file ext)
      
    EndFunction

