CREATE TABLE tasks_to_category
(
    id   SERIAL PRIMARY KEY,
    tasks_id INT NOT NULL REFERENCES tasks (id),
    category_id INT NOT NULL REFERENCES category (id),
    UNIQUE (tasks_id, category_id)
);