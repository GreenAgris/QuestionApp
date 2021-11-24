# QuestionApp

This project is a Java learning project following these requirements:

Overall goal : create a Question and answer program, where the user can add questions and then for each question create/see answers.
The menu is set in terminal output. 
* If the theory about objects is already covered - create and use class objects where it is needed. Use inheritance to get a general data Entity defined.
* Some data should be already present in the applicaiton on run - either by hardcoded initial values or by database connections retrieval.
* Option to insert user name per question or answer is needed.
* Search by text in answers and questions needs to be implemented
* Questions and answers can be modified - by changing the amount of likes/dislikes.
* One Answer per Question can be set as the "approved" answer.

Additional functionality can be added, like comments on Questions and Answers, partial text search, search based on username, etc.

Core entities to be used:
* Menu - prints out the selection options, handles input from the user. 
* Question - has creation date, potentially a list of answers, holds information on likes and dislikes, comments, user who created the question.
* Answers - has creation datetime, likes and dislikes, approved answer status, some form of "link" to the question given, user who created the answer.
* Database connection handler.
