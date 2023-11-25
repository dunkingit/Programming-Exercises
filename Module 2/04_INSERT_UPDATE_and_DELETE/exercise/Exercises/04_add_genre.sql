-- 4. Add a "Sports" genre to the genre table. 
-- Add the movie "Coach Carter" to the newly created genre. (1 row each)

insert into genre (genre_name)
values('Sports');

insert into movie_genre (movie_id, genre_id)
values (
  (select movie_id from movie where title = 'Coach Carter'),
  (select genre_id from genre where genre_name = 'Sports')
);

-- insert into movie (title, length_minutes) 
-- values ('Coach Carter', 136);

-- SELECT genre_id 
-- FROM genre 
-- WHERE genre_name = 'Sports';

-- select *
-- from movie
-- where title = 'Coach Carter'
-- select movie.title, genre.genre_id, movie.movie_id, genre.genre_name
-- select *
-- from movie
-- join movie_genre
-- on movie_genre.movie_id = movie.movie_id
-- join genre
-- on movie_genre.genre_id = movie_genre.movie_id
-- where title = 'Coach Carter';



-- UPDATE movie
-- SET movie_id = (select movie_id from movie_genre where genre_id = (select genre_id from genre where genre_name = 'Sports'))
-- where title = (select title from movie where title = 'Coach Carter')

-- INSERT INTO movie_genre (movie_id, genre_id)
-- SELECT 
--    (SELECT movie_id FROM movie WHERE title = 'Coach Carter'),
--    (SELECT genre_id FROM genre WHERE genre_name = 'Sports');