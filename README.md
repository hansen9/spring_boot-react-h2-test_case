customer management system with spring boot, h2 and react

# application flow
## login
user login -> authentication -> send log data to LOG -> home page

## create/update customer
form data -> customer controller get data and log the activity -> customer data inserted to CUSTOMERS, activity to LOG

# entities
customer: handles GET, POST, PUT customer
user log: handles GET, POST for user log
user: handles user authentication

# tables
CREATE TABLE user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);


CREATE TABLE customers (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(255),
  birth_date DATE,
  stage ENUM('Seed', 'Nurture', 'Lead', 'Opportunity', 'Active', 'Loyal') NOT NULL,
  created_by BIGINT,
  updated_by BIGINT,
  FOREIGN KEY (created_by) REFERENCES users_acc(id),
  FOREIGN KEY (updated_by) REFERENCES users_acc(id)
);

CREATE TABLE logs (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT,
  action_type ENUM('CREATE_CUSTOMER', 'UPDATE_CUSTOMER', 'LOGIN', 'LOGOUT'),
  target_type VARCHAR(50),
  target_id BIGINT,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users_acc(id)
);

INSERT INTO CUSTOMERS VALUES(1, 'HANSEN', 'ABC STREET', '2000-02-26', 'SEED', 1, 1)

INSERT INTO USERS_ACC VALUES(1, 'DEV1', '$2a$04$tnA11y.KytHur2kv0VZIqeGm8u.H3p./RikulTNT9AwRZcNsuzJiG')
