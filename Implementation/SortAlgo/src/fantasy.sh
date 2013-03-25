#!/bin/bash
#Program
# Be free to choose commands to execution#
#History : Mar_25_2013
#@Author : A.C.God
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
echo "Type in number of command you wish to execute , if none , press ENTER to exit ! "
echo "
1. runtest.sh : RunTest.java/smartalgorithm ;
2. multi.sh : RunTestMulti.java/smartalgorithm ;
"
read -p "-------$:" num

case $num in
    "1" )
	echo "Results as follows--------: \n"
	./runtest.sh ; 
	;;
    "2" )
	echo "Results as follows--------: \n"
	./multi.sh   ; 
	;;
    ""  )
	echo "------------EXIT------------"
	exit 0;   
	;;
esac
	