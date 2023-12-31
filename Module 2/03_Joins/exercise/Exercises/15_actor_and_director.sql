-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)

select movie.title, person.person_name
from person
join movie_actor
on movie_actor.actor_id = person.person_id
join movie
on movie.movie_id = movie_actor.movie_id
where actor_id = director_id
order by movie.title;


