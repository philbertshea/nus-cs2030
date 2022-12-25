By employing the various object-oriented design principles, design a more general
question-answer class QA that can take the place of both MCQ and TFQ types of
questions (and possibly more in future, each with their own type of exceptions).

Here are some design issues that needs to be addressed:
• Abstract out common code in TFQ and MCQ to a common place QA
• MCQ and TFQ inherits from QA
• QA’s abstract method getAnswer throws a more general exception than MCQ and
TFQ
• Create the general exception class InvalidQuestionException