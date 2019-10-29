select 
    m.movie_title,
    m.movie_year,
    concat(d.director_first_name, d.director_last_name) as director_name,
    concat(a.actor_first_name, a.actor_last_name) as actor_name,
    mc.role
from movies m
join movies_cast mc on m.movie_id = mc.movie_id
join movies_directors md on m.movie_id = md.movie_id
join directors d on md.director_id = d.director_id
join actors a on mc.actor_id = a.actor_id
where m.movie_time = (select min(m2.movie_time) from movies m2)