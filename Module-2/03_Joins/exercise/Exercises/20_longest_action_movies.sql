-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. 
-- Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

select movie.title, movie.length_minutes, movie.release_date
from movie
join movie_genre
on movie_genre.movie_id = movie.movie_id
join genre
on genre.genre_id = movie_genre.genre_id
where genre.genre_name = 'Action'
order by movie.length_minutes desc, movie.release_date desc
limit 5;