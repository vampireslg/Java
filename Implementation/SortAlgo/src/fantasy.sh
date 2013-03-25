#!/bin/bash
#Program
# Be free to choose commands to execution#
#History : Mar_25_2013
#@Author : A.C.God
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
echo "Type in number of command you wish to execute , if none , press ENTER to exit ! "
echo "
0. ssh panda-30
1. runtest.sh : RunTest.java/smartalgorithm 
2. multi.sh : RunTestMulti.java/smartalgorithm 
3. This won't do anything 
"
read -p "-------$:" num

case $num in
    "0" )
	echo "Going to ssh panda -- 30:\n "
	ssh gaoang@192.168.1.30
	;;
    "1" )
	echo "Results as follows--------: \n"
	./runtest.sh ; 
	;;
    "2" )
	echo "Results as follows--------: \n"
	./multi.sh   ; 
	;;
    "3"  )
	echo "-----I told you this won't do anything , why don't you listen ??------ "
	exit 0;
	;;
esac
	