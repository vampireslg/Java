#!/bin/bash
#Program
# Plus tow integer number ;
#history
#Mar_25 2013 Author: A.C.God First Release
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
echo -e "Input two numbers to Plus !"
read -p "firstNum: " firstnu
read -p "secondNum: " secondnu
total=$(($firstnu + $secondnu))
echo -e "Sum : $total"

