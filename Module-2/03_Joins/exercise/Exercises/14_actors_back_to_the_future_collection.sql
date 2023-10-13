-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)

select distinct person.person_name
from movie
join collection
on collection.collection_id = movie.collection_id
join movie_actor
on movie_actor.movie_id = movie.movie_id
join person
on person.person_id = movie_actor.actor_id
where collection.collection_name = 'Back to the Future Collection'
order by person.person_name;