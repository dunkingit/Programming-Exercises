-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person
--     table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)

insert into person (person_name, birthday)
values ('Steven Rebuck', '10-11-1987');
update movie 
set director_id = (select person_id from person where person_name = 'Steven Rebuck')
where title = 'The Blob';


-- select * from movie where director_id = (select person_id from person where person_name = 'Steven Rebuck')
-- select * from person where person_name = 'Steven Rebuck';
-- select distinct person_name, director_id, title
-- from movie
-- join person
-- on person_id = director_id
-- join movie_actor
-- on movie_actor.movie_id = movie.movie_id
-- join person 
-- on movie_actor.actor_id = person.person_id
-- where title = 'The Blob'
