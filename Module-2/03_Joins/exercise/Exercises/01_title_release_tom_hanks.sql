-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)
select movie.title, movie.release_date
from person
join movie_actor
on movie_actor.actor_id = person.person_id
join movie
on movie.movie_id = movie_actor.movie_id
where person_name like 'Tom Hanks%'
order by movie.release_date desc;
