#!/bin/bash

oldFile="jedRectl.png"

for i in {0..8}
do
 mv ${oldFile/j/${i}}  ${oldFile/j/${i}j}
done
