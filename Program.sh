#!/bin/bash

# 
#   By: Alex Rodrìguez
#

path=$1
extensions=${@:2}

contains(){
    local n=$# 
    local value=${!n}
    for ((i=1;i < $#;i++));do if [ "${!i}" == "${value}" ]; then 
	echo "y" 
	return 0 
    fi done
    echo "n" 
    return 1
}

change_path(){
    local FILE=$2
    if [ $(contains ${folders[@]} $1) == "n" ];then
    	mkdir "$3$1"
	folders+=($1)
    fi
    mv $3$2 $3$1
}

classify_files(){
    folders=()
    local files=()
    for x in $(ls $1); do if [ -d $1$x ];then folders+=($x); 
	                  elif [ -f $1$x ];then files+=($x); 
    fi done
    
    for file in ${files[@]}; do
	search="." 
	e=${file#*$search}
	if [ $(contains ${extensions[@]} $e) == "y" ];then change_path $e $file $path
    fi done 
}

classify_files $path

