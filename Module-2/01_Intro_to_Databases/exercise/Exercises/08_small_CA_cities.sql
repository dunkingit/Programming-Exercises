-- 8. The name and population of cities in California (CA) with a population less than 150,000 people (37 rows)
select city_name, population from city where population < 150000 and state_abbreviation = 'CA';
