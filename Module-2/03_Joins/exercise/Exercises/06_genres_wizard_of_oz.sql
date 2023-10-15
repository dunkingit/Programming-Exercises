-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)
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
where movie.title = 'The Wizard of Oz'
order by genre_name;
