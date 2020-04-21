-- Question - 1

select count(*) 
from film 
where special_features like 'Deleted Scenes' and film_id in (select film_id 
														     from film_category
                                                             where category_id in (select category_id 
																				  from category 
                                                                                  where name ='Documentary'));
                                                                                  
-- Question - 2


select count(*)
from film
where film_id in (select film_id
				  from film_category
				  where category_id in (select category_id 
					                    from category 
			                            where name ='Sci-Fi')) and film_id in (select film_id
																			  from inventory
																			  where store_id in (select store_id
																								 from store
																								 where manager_staff_id in (select staff_id
																															from staff
																															where first_name like "Jon" and last_name like "Stephens")));
                                                                                                                            
                                                                                                                            
																														
-- Question - 3



select total_sales
from sales_by_film_category
where category like "Animation";


-- Question - 4

select title
from film
where film_id in (select film_id
				  from inventory
				  where inventory_id in (select inventory_id
										 from rental
										 where customer_id in (select customer_id
															   from customer
															   where first_name like "PATRICIA" AND last_name like "JOHNSON")))
group by film_id					
order by count(*) desc limit 3;
                    






-- Question - 5

select count(*)
from film
where rating like "R" and film_id in (select film_id
							          from inventory
									  where inventory_id in (select inventory_id
															 from rental
															 where customer_id in (select customer_id
																				   from customer
																				   where first_name like "SUSAN" AND last_name like "WILSON")));

