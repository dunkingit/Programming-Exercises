-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.
select actor_id, person_name, movie.movie_id
from movie
join movie_actor
on movie_actor.movie_id = movie.movie_id
join person
on person_id = actor_id
where title = 'Avengers: Infinity War';

delete from movie_actor
where movie_id = (select movie_id from movie
				  where title = 'Avengers: Infinity War')


