# Create your grading script here

set -e

CPATH=".:hamcrest-core-1.3.jar:junit-4.13.2.jar"

#clone student submission

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

cd student-submission/

if[ -e ListExamples.java ]
then 
    echo "file found"
    echo "recieve 1 point"

else 
    echo "file not found in directory"
    echo "no points recieved"
    exit

fi

cp lib/hamcrest-core-1.3.jar student-submission
cp lib/junit-4.13.2.jar student-submission
cp TestListExamples.java student-submission

cd student-submission

javac ListExamples.java 2> error.txt > output.txt 
if [ $? -eq 0 ]
then
    javac -cp $CPATH TestListExamples.java 2> error.txt > output.txt
    echo "the file you have submitted (ListExamples.java) has been compiled!"
    echo "recieve 1 point"
    echo "total points = 2/3"
else
    echo "the file you have submitted (ListExamples.java) can't be compiled"
    echo "total points = 1/3"
    exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples 2> error2.txt > output.txt
if [ $? -eq 0 ]
then
    echo "All tests have been passed!"
    echo "recieve 1 point"
    echo "total points = 3/3! Congratulations!"
    exit
else
    echo "You have failed one or more tests"
    echo "total points = 2/3"
    exit
fi
