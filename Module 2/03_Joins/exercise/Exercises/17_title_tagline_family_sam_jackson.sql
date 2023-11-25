-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)

select distinct movie.title, movie.tagline
from person
join movie_actor
on movie_actor.actor_id = person.person_id
join movie
on movie.movie_id = movie_actor.movie_id
join movie_genre
on movie_genre.movie_id = movie.movie_id
join genre
on genre.genre_id = movie_genre.genre_id
where genre.genre_name = 'Family'
and person.person_name = 'Samuel L. Jackson'
order by movie.title