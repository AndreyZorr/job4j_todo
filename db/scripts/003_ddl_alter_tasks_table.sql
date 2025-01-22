ALTER TABLE tasks
ADD COLUMN todo_user_id int
REFERENCES todo_user(id);