CREATE TABLE tickets (
   ticket_id BIGSERIAL PRIMARY KEY,
   title VARCHAR(100) NOT NULL,
   description VARCHAR(255),
   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP,
   status VARCHAR(50) NOT NULL,
   user_id BIGINT,

   FOREIGN KEY (user_id) REFERENCES users(id)
);