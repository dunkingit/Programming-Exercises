-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)
select person.person_name, person.birthday
from person
join movie_actor
on movie_actor.actor_id = person.person_id
join movie
on movie.movie_id = movie_actor.movie_id
where movie.title = 'The Fifth Element'
order by person_name;