#!/bin/bash

for i in 10000 20000 40000 80000 160000 320000 640000 1280000
do
   java SortTypes $i merge random 1 1000
   java SortTypes $i merge ordered 
   java SortTypes $i merge reverse
   java SortTypes $i merge nearly
done
for i in 10000 20000 40000 80000 160000 320000 640000 1280000

do
   java SortTypes $i quick random 1 1000
   java SortTypes $i quick ordered 
   java SortTypes $i quick reverse
   java SortTypes $i quick nearly
done
for i in 10000 20000 40000 80000 160000 320000 640000 1280000
do
   java SortTypes $i rquick random 1 1000
   java SortTypes $i rquick ordered 
   java SortTypes $i rquick reverse
   java SortTypes $i rquick nearly
done
for i in 10000 20000 40000 80000 160000 320000 640000 1280000
do
   java SortTypes $i 3quick random 1 1000
   java SortTypes $i 3quick ordered 
   java SortTypes $i 3quick reverse
   java SortTypes $i 3quick nearly
done