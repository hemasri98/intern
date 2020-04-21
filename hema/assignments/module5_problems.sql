-- 1

select eventno, dateheld, count(planno)
from EventRequest natural join EventPlan
where workdate like "2018-12-%"
group by eventno
having count(planno) > 1;

-- 2

select eventno, planno, activity, workdate
from EventPlan 
where workdate LIKE "2018-12-%" and eventno in (select eventno 
												from EventRequest natural join Facility
												where facname LIKE "Basketball arena");
                                                
-- 3

select eventno, dateheld, status, estcost
from EventRequest natural join Facility
where facname Like "Basketball arena" and (dateheld between '01-10-2018' AND '31-12-2018' )and eventno in (select eventno
																											from Employee natural join EventPlan
																											where empname LIKE "Mary Manager");

-- 4



select planno, lineno, timestart, timeend, numberfield, locname, resname
from EventPlanLine natural join location natural join Resource_tbl
where planno in (select planno
				 from EventPlan 
				 where activity like "Operation" and (workdate between '01-10-2018' AND '31-12-2018') and locno in (select locno 
																													 from location natural join Facility
																													 where facname LIKE "Basketball arena"));


-- Database manipulation

-- 1
Insert into Facility (facno,facname) values ('F104','Swimming Pool');

-- 2
Insert into location (locno,facno,locname) values ('L107','F104','Door');

-- 3
Insert into location (locno,facno,locname) values ('L108','F104','Locker Room');

-- 4
update location SET locname = 'Gate' where locno = 'L107';

-- 5
delete from location where locno = 'L108'



