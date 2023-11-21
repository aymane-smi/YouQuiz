# YouQuiz
## Project class digram 
![class.png](class.png)
## Api documentation
### Level
endpoint| method | payload | description
-|--------|-|-
/api/level| `POST` |`{description:string, maxScore: int, minScore: int}`| create a level
/api/level/{id}| `GET`  | `-` | find level by id
/api/level/{id}| `PUT`  | `{description:string, maxScore: int, minScore: int}` | edit a level
/api/level/{id}/questions | `GET` | `-` | get questions of a specific level
/api/level| `GET` | `-` | get all levels

### Subject
endpoint| method | payload                          | description
-|--------|----------------------------------|-
/api/level| `POST` | `{title:string, parend_id: int}` | create a subject
/api/subject/{id}| `GET`  | `-`                              | find subject by id
/api/subject/{id}| `PUT`  | `{title:string, parent_id: int}` | edit a subject
/api/subject/{id}/questions | `GET` | `-`                              | get questions of a specific subject
/api/level| `GET` | `-`                              | get all subjects

### Question
endpoint| method | payload                                                                                                                                                                        | description                         
-|-------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------
/api/question| `POST` | `{responseNbr:int, correctResponseNbr: int, questionText: string, type: string, totalScore: double, subject_id: int, level_id: int, medias: Array{name:string, type: string}}` | create a question                   
/api/question/{id}| `GET` | `-`                                                                                                                                                                            | find question by id                 
/api/question/{id}| `PUT` | `{responseNbr:int, correctResponseNbr: int, questionText: string, type: string, totalScore: double, subject_id: int, level_id: int, medias: Array{name:string, type: string}}`| edit question                      
/api/question/{id}/medias | `GET` | `-`                                                                                                                                                                            | get medias of a specific media 
/api/question| `GET` | `-`                                                                                                                                                                            | get all questions
/api/question/{id}/responses| `GET` | `-`| find response of question
/api/question/{id} | `DELETE` | `-` | delete question by id

### Quiz
endpoint | method | payload                                                                                                                                                     | description
-| - |-------------------------------------------------------------------------------------------------------------------------------------------------------------| - 
/api/quizz | `POST` | `{score: double, showAnswers: double, showFinalResults: boolean, chanceNbr: int, durationInMinutes: int, remark: string, trainer_id: int, subject_id: int}` | create a quiz
/api/quizz | `GET` | `-`                                                                                                                                                         | final all quizzes
/api/quiz/{id} | `GET` | `-`                                                                                                                                                         | final specific id |
/api/quiz/{id} | `PUT` | `{score: double, showAnswers: double, showFinalResults: boolean, chanceNbr: int, durationInMinutes: int, remark: string, trainer_id: int, subject_id: int}` | edit specific quiz
/api/quiz/{id} | `DELETE` | `-` | delete a specific quiz

### Response

endpoint | method | payload | description 
- | - | - |-------------
/api/response | `POST` | `{response: int, point: double, question_id: int}` | create a response and assigned to a question
/api/response/{id} | `PUT` | `{response: int, point: double, question_id: int}` | edit a specific response
/api/response/{id} | `GET` | `-` | find a speicifc response by id

### Student

endpoint | method | payload | description
- | - | - | - 
/api/student | `POST` | `{firstName: string, lastName: string, birthday: localDate, address: string, dateOfInscription: localDate}` | create a student
/api/student | `GET` | `-` | get all students
/api/student/{id} | `GET` | `-` | get a specific student by id
/api/student/{id} | `PUT` | `{firstName: string, lastName: string, birthday: localDate, address: string, dateOfInscription: localDate}` | edit a specific student
/api/student/{id} | `DELETE` | `-` | delete a specific student

### Trainer
endpoint | method | payload                                                                                     | description
- | - |---------------------------------------------------------------------------------------------| - 
/api/trainer | `POST` | `{firstName: string, lastName: string, birthday: localDate, address: string, role: string}` | create a trainer
/api/trainer | `GET` | `-`                                                                                         | get all trainers
/api/trainer/{id} | `GET` | `-`                                                                                         | get a specific trainer by id
/api/trainer/{id} | `PUT` | `{firstName: string, lastName: string, birthday: localDate, address: string, role: string}` | edit a specific trainer
/api/trainer/{id} | `DELETE` | `-`                                                                                         | delete a specific trainer

### AssignQuiz

endpoint | method | payload | descrption 
- | - | - |------------
/api/assignQuiz | `POST` | `[{score: double, played: int, reason: string, result: string, debutDate: localDateTime, endDate: localDateTime, student_id: int, quiz_id: int}]` | create an assignquiz for one or multiple student
/api/assignQuiz | `GET` | `-` | get all assignedQuiz
/api/assignQuiz/{id} | `GET` | `-` | get specific assigned quiz
/api/assignQuiz/{id} | `PUT` | `{score: double, played: int, reason: string, result: string, debutDate: localDateTime, endDate: localDateTime, student_id: int, quiz_id: int}` | update a specific assigned quiz
/api/assignQuiz/{id} | `DELELTE` | `-` | delete a specific quiz
