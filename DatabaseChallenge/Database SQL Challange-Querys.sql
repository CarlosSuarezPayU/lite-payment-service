-- Senior Developer Test
-- Carlos Eduardo Suárez Silvestre
-- 1. Database SQL Challenge

-- 1.1. Calculate profits of the platform monthly in the 2020 year.
select TO_CHAR(m.movement_date, 'Month') as movement_month,
SUM(value) as profit
from public.movement m
where m.movement_type = 'COMISSION'
and m.movement_date between '2020-01-01' and '2020-12-31'
group by movement_month
;


-- 1.2. Calculate total taxes for each client
select c.client_id, 
c.name, 
sum(m.value) as taxes
from public.movement m
join public.transaction t on t.transaction_id = m.transaction_id
join public.client c on c.client_id = t.client_id::text
where m.movement_type = 'TAX'
group by c.client_id, c.name
;

-- 1.3. Find for each client: Total taxes, Commissions, Transaction values
select c.client_id, 
c.name, 
m.movement_type, 
sum(m.value) as total_value
from public.movement m
join public.transaction t on t.transaction_id = m.transaction_id
join public.client c on c.client_id = t.client_id::text
group by c.client_id, c.name, m.movement_type
order by c.client_id, m.movement_type
;

-- 1.4. Find approval rates by payment method
select t.payment_method,
SUM(CASE t.state WHEN 'APPROVED' THEN 1 ELSE 0 END)*100/count(*) as approval_rate
from public.transaction t
group by t.payment_method
;

-- 1.5. Max transaction amount monthly for each client
select c.client_id,
c.name,
TO_CHAR(t.transaction_date, 'Month') as transaction_month,
TO_CHAR(t.transaction_date, 'YYYY') as transaction_year,
MAX(t.value) as max_transaction_amount
from public.client c 
join public.transaction t on c.client_id = t.client_id::text
group by c.client_id, t.transaction_date
order by c.client_id, c.name, t.transaction_date