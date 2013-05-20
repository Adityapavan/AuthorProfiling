#!bin/bash

rm -rf scriptout
mkdir scriptout
rm -rf textout
mkdir textout

javac Parser.java
java Parser $1 textout
./bin/mallet import-dir --input textout/en --output scriptout/entestout.mallet --keep-sequence --remove-stopwords
./bin/mallet import-dir --input textout/es --output scriptout/estestout.mallet --keep-sequence --remove-stopwords
./bin/mallet infer-topics --input scriptout/entestout.mallet --inferencer enage10.model --output-doc-topics scriptout/en10.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/entestout.mallet --inferencer enage20.model --output-doc-topics scriptout/en20.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/entestout.mallet --inferencer enage30.model --output-doc-topics scriptout/en30.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/entestout.mallet --inferencer enmale.model --output-doc-topics scriptout/enmale.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/entestout.mallet --inferencer enfemale.model --output-doc-topics scriptout/enfemale.out  --num-iterations 100


./bin/mallet infer-topics --input scriptout/estestout.mallet --inferencer esage10.model --output-doc-topics scriptout/es10.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/estestout.mallet --inferencer esage20.model --output-doc-topics scriptout/es20.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/estestout.mallet --inferencer esage30.model --output-doc-topics scriptout/es30.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/estestout.mallet --inferencer esmale.model --output-doc-topics scriptout/esmale.out  --num-iterations 100
./bin/mallet infer-topics --input scriptout/estestout.mallet --inferencer esfemale.model --output-doc-topics scriptout/esfemale.out  --num-iterations 100

javac MergeSeparate.java
java MergeSeparate scriptout/en10.out scriptout/en20.out scriptout/en30.out scriptout/enfullage.csv 
java MergeSeparate scriptout/es10.out scriptout/es20.out scriptout/es30.out scriptout/esfullage.csv 

javac Mergeseparategender.java
java Mergeseparategender scriptout/enmale.out scriptout/enfemale.out scriptout/enfullgender.csv
java Mergeseparategender scriptout/esmale.out scriptout/esfemale.out scriptout/esfullgender.csv

javac CSVtoLibSVMage.java
java CSVtoLibSVMage scriptout/enfullage.csv scriptout/enfullage.libsvm
java CSVtoLibSVMage scriptout/esfullage.csv scriptout/esfullage.libsvm


javac CSVtoLibSVM.java
java CSVtoLibSVM scriptout/enfullgender.csv scriptout/enfullgender.libsvm
java CSVtoLibSVM scriptout/esfullgender.csv scriptout/esfullgender.libsvm


./bin/mallet run cc.mallet.classify.tui.SvmLight2Classify --input scriptout/enfullage.libsvm   --output scriptout/enfullage.txt --classifier enfullagelibsvm.classifier
./bin/mallet run cc.mallet.classify.tui.SvmLight2Classify --input scriptout/esfullage.libsvm   --output scriptout/esfullage.txt --classifier esfullagelibsvm.classifier

./bin/mallet run cc.mallet.classify.tui.SvmLight2Classify --input scriptout/enfullgender.libsvm   --output scriptout/enfullgender.txt --classifier engenderlibsvm.classifier
./bin/mallet run cc.mallet.classify.tui.SvmLight2Classify --input scriptout/esfullgender.libsvm   --output scriptout/esfullgender.txt --classifier esgenderlibsvm.classifier


javac finalXML.java
java finalXML scriptout/enfullage.txt scriptout/enfullgender.txt scriptout/en30.out $2
java finalXML scriptout/esfullage.txt scriptout/esfullgender.txt scriptout/es30.out $2






