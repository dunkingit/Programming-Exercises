-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
select distinct person.person_name, person.birthday
from movie
join movie_actor
on movie_actor.movie_id = movie.movie_id
join person
on person.person_id = movie_actor.actor_id
where person.birthday between '1950-1-1' and '1959-12-31'
and movie.release_date between '1985-1-1' and '1985-12-31'
order by person.birthday;
