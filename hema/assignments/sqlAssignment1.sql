-- Question- 1 

select *
from film
where rating like "PG-13" and film_id in(select film_id
										 from film_category inner join category on film_category.category_id = category.category_id
                                         where name like "Comedy");


-- Question - 2

select title
from film f, (select join2.film_id , c.name
			 from category c, (select join1 .film_id, f_c.category_id 
							   from film_category f_c, (select inventory.film_id 
														from rental , inventory 
														where rental.inventory_id = inventory.inventory_id ) as join1 
							   where f_c.film_id = join1 .film_id  ) as join2 
			where  c.category_id = join2.category_id and c.name = 'horror' ) as join3
where f.film_id = join3.film_id
group by f.film_id 
order by count(*) desc limit 3;
 










-- Question- 3


select first_name, last_name
from customer
where address_id in (select address_id
					 from address
					 where city_id in (select city_id
									   from city inner join country on country.country_id = city.country_id
									   where country like "India" and city_id in (select city_id
																				 from customer inner join address on customer.address_id = address.address_id))) and customer_id in (select customer_id
																																												     from inventory, rental
																																												     where rental.inventory_id = inventory.inventory_id and film_id in (select film_id
																																																														from (film_category inner join category on film_category.category_id = category.category_id) where name like "Sports"));
-- Question - 4
                                                          
select first_name, last_name
from customer
where address_id in (select address_id
					 from address
					 where city_id in (select city_id
									   from city inner join country on country.country_id = city.country_id
									   where country like "Canada" and city_id in (select city_id
																				 from customer inner join address on customer.address_id = address.address_id))) and customer_id in (select customer_id
																																												     from inventory, rental
																																												     where rental.inventory_id = inventory.inventory_id and film_id in (select film_id
																																																												        from film_actor
																																																														where actor_id in (select actor_id
																																																																           from actor
																																																																           where first_name like "NICK" AND last_name like "WAHLBERG")));
                                                                                                                                                                                                                                                                           
                                                                                                                                                                                                                                                                           
                                                                                                                                                                                                                                                                           
-- Question - 5

select count(*)
from film_actor
where actor_id in (select actor_id
				   from actor
				   where first_name like "SEAN" AND last_name like "WILLIAMS");

