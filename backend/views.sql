create materialized view stays_per_host as
select h.id        as host_id,
       count(s.id) as num_stays
from host h
         left join
     stay s on s.host_id = h.id
group by h.id;

create materialized view hosts_per_country as
select c.id as country_id,
       count(h.id) as num_hosts
from country c left join
    host h on c.id = h.country_id
group by c.id;