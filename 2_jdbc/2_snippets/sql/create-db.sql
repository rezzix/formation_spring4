CREATE TABLE IF NOT EXISTS customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255));

CREATE TABLE IF NOT EXISTS sales(id SERIAL, amount NUMBER, currency VARCHAR(3), save_date DATE, customer_id INT, FOREIGN KEY(customer_id) REFERENCES customers(id));
