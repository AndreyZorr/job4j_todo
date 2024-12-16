CREATE TABLE tasks (
   id SERIAL PRIMARY KEY,
   title TEXT,
   description TEXT not null,
   created TIMESTAMP not null,
   done BOOLEAN
);