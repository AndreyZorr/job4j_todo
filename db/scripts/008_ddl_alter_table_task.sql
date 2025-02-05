alter table tasks
add column category_id int references category(id);