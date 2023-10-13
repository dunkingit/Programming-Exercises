-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.

select distinct genre.genre_name
from movie
join movie_genre
on movie_genre.movie_id = movie.movie_id
join movie_actor
on movie_actor.movie_id =movie_genre.movie_id 
join genre
on genre.genre_id = movie_genre.genre_id
join person
on person.person_id = movie_actor.actor_id
where person.person_name = 'Christopher Lloyd'
order by genre_name;