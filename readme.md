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