-- 1

select distinct state, city, zip
from Customer;

-- 2

select empname, department, phone, email
from Employee
where phone Like "3-%";

-- 3

select *
from Resource_tbl
where rate between 10 and 20
order by rate;

-- 4

select *
from EventRequest
where status in("Approved", "Denied") and dateauth like "2018-07-%";

-- 5

select locno, locname
from Facility natural join location
where facname like "Basketball arena";

-- 6

select planno, count(lineno), sum(numberfield)
from EventPlanLine
group by planno
having count(lineno) >= 1;

