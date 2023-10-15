-- 4. Add a "Sports" genre to the genre table. 
-- Add the movie "Coach Carter" to the newly created genre. (1 row each) 11772

-- insert into genre (genre_name)
-- values('Sports')

select *
from genre
join movie_genre
on movie_genre.genre_id = genre.genre_id
join movie
on movie.movie_id = movie_genre.movie_id;

insert into movie (title)
values ('Coach Carter')



