# Write your MySQL query statement below

select cancelDatesStats.day as Day, if (allDatesStats.number = 0, 0, round(cancelDatesStats.number / allDatesStats.number, 2)) as 'Cancellation Rate'
from
(
    select distinct t2.request_at as day, ifnull(cancellations.number, 0) as number from trips t2
    left join (
        select t1.request_at as day, count(*) as number
        from
            trips t1,
            (select users_id from users where role = 'client' and banned = 'No') as clients,
            (select users_id from users where role = 'driver' and banned = 'No') as drivers
        where
            t1.driver_id = drivers.users_id
            and 
            t1.client_id = clients.users_id
            and
            t1.status in ('cancelled_by_driver', 'cancelled_by_client')
            and
            t1.request_at between '2013-10-01' and '2013-10-03'
        group by t1.request_at
    ) as cancellations on t2.request_at = cancellations.day
 ) as cancelDatesStats,
(select trips.request_at as day, count(*) as number
from
    trips trips,
    (select users_id from users where role = 'client' and banned = 'No') as clients,
    (select users_id from users where role = 'driver' and banned = 'No') as drivers
where
    trips.driver_id = drivers.users_id
    and 
    trips.client_id = clients.users_id
    and
    trips.request_at between '2013-10-01' and '2013-10-03'
group by trips.request_at)
as allDatesStats
where
    cancelDatesStats.day = allDatesStats.day
order by cancelDatesStats.day
