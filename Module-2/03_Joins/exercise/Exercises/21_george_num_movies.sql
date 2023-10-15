-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)
select distinct person.person_name, count(title) as num_of_movies
from person
left join movie_actor
on movie_actor.actor_id = person.person_id
left join movie
on movie.movie_id = movie_actor.movie_id
where person.person_name like 'George %' 
or person.person_name like 'Georges%'
group by person.person_name
order by person.person_name asc

