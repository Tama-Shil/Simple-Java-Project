# Simple-Java-Project
## To run the project:
### Prerequisites:
1. Ensure Git is installed on your PC. If not, download and install it from https://git-scm.com/downloads
2. Ensure you have Java installed to run the project. If not, download and install the JDK from
3. Install IntelliJ IDEA from https://www.jetbrains.com/idea/download/?section=windows
## Steps to Download and Run the Project

1. **Open IntelliJ IDEA**
2. **Clone the Repository**:
   * File -> New -> Project from Version Control -> Git.
   * Enter URL: `https://github.com/Tama-Shil/AssignmentOnJava.git`.
   * Choose directory and Clone.
3. **Open the Project if not automatically opened**
4. **Configure Project SDK if needed**:
   * File -> Project Structure -> Project.
   * Set Project SDK.
5. **Run the java files from src folder**

## Project Description
In this software system, admin can save multiple MCQ with 4 options with their answer key in a **quiz.json** file. And, when any student logs in to the system, system will tell the student to give MCQ exam from the quiz bank.

If a user logs in by admin credential, system will say the admin user to add new questions to question bank
and if any user logs in  by student credential, system will say the user to give quiz. 

To enable the login feature to your system, create a **users.json** file where admin user info and student user info will be contained.

[

  {
  
    "username": "admin",
    "password": "1234",
    "role": "admin"
  },
  
  {
  
    "username": "salman",
    "password": "1234",
    "role": "student"
    
  }
  
]


_Output:**[For admin user]**_

_System:> Enter your username_

_User:> admin_

_System:> Enter password_

_User:> 1234_

_System:> Welcome admin! Please create new questions in the question bank._ 

_Output:**[For student user]**_

_System:> Enter your username_

_User:> salman_

_System:> Enter password_

_User:> 1234_

_System:> Welcome salman to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start._


**Your task:**

As an admin logged in user, until you press 'q' from keyboard, you can add multiple MCQ. Add atleast 30 questions in quiz bank. The 30 questions must be SQA related questions. For an 
example:

_System:> Input your question_

_Admin:> Which is not part of system testing?_

_System: Input option 1:_

_Admin: Regression Testing_

_System: Input option 2:_

_Admin: Sanity Testing_

_System: Input option 3:_

_Admin: Load Testing_

_System: Input option 4:_

_Admin: Unit Testing_

_System: What is the answer key?_

_Admin: 4_

_System:> Saved successfully! Do you want to add more questions? (press s for start and q for quit)_


Here is the example of architecture of **quiz.json** file.


[

{

    "question": "Which is not part of system testing?",
    "option 1": "Regression Testing",
    "option 2": "Sanity Testing",
    "option 3": "Load Testing",
    "option 4": "Unit Testing",
    "answerkey": 4
    
  },
  
  {
  
  
    "question": "Which is whitebox testing technique?",
    "option 1": "Equivalent Partitioning",
    "option 2": "Boundary value testing",
    "option 3": "Decision table testing",
    "option 4": "Adhoc Testing",
    "answerkey": 3
      
  }
  
]

Now its time to role play as a student.
When you login as a student to the system, system will generate 10 random questions from the quiz bank. Don't confuse if system will return you the duplicate questions. The more you add questions in quiz bank, probability of showing duplicate questions will be less. 
Let show an example of output when student will login to the system.

_System:> Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' for start._

_Student:> s_

_System:> _

_[Question 1] Which is not part of system testing?_

_1. Regression Testing_

_2. Sanity Testing_

_3. Load Testing_

_4. Unit Testing_

_Student:> 4_

_[Question 2] Which is whitebox testing technique?_

_1.Equivalent Partitioning_

_2. Boundary value testing_

_3. Decision table testing_

_4. Adhoc Testing_

_Student:> 3_

In this way, 10 questions will be shown and finally the system will show the result. You will not show the answer from the json. Just match the json file answer key with the user input key. If matches, score should be counted. Otherwise if user input wrong or invalid number from keyboard, it will be considered as 0 mark and generate the next question.

For an example output:

if mark is above 8>= message: **Excellent! You have got [marks] out of 10**

if mark is above 5>= but less than 8, message: **Good. You have got [marks] out of 10**

if mark is above 2>= but less than 5, message: **Very poor! You have got [marks] out of 10**
if mark is 0 or less than 2 message: **Very sorry you are failed. You have got [marks] out of 10**

Would you like to start again? press s for start or q for quit

## Project Demo video
https://github.com/Tama-Shil/Simple-Java-Project/assets/51587530/0bd9b10c-807c-4907-a41a-e932cfb55ff8


