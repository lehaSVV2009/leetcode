# Description

Write a SQL Query to find those lowest duration movies along with the year, director’s name(first and last name combined), actor’s name(first and last name combined) and his/her role in that production.

# Output Schema:

```
movie_title,movie_year,director_name,actor_name,role
```

# NOTE:

Output column name has to match the given output schema.
Any name is the concatenation(without any delimiter) of first and last name if present
(E.g. if director_first_name is ‘Alfred’ and director_last_name is ‘Hitchcock’ then director_name is ‘AlfredHitchcock’)

# Example Output:

```
movie_title,movie_year,director_name,actor_name,role
Vertigo,1958,AlfredHitchcock,JamesStewart,JohnFerguson
```

# Schema Design:

![Schema](https://s3-us-west-2.amazonaws.com/ib-assessment-tests/problem_images/sql_course.jpg)
