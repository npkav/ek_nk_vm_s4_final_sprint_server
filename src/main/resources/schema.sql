CREATE TABLE customers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100)
);

CREATE TABLE departments (
  id INT PRIMARY KEY AUTO_INCREMENT,
  department_name VARCHAR(100),
  description TEXT
);

CREATE TABLE roles (
  id INT PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(100),
  description TEXT,
  department_id INT,
  FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE service_reps (
  id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  department_id INT,
  role_id INT,
  FOREIGN KEY (department_id) REFERENCES departments(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE issues (
  id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT,
  assigned_rep_id INT,
  title VARCHAR(200),
  description TEXT,
  status VARCHAR,
  priority VARCHAR,
  FOREIGN KEY (customer_id) REFERENCES customers(id),
  FOREIGN KEY (assigned_rep_id) REFERENCES service_reps(id)
);

CREATE TABLE feedback (
  id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT,
  rep_id INT,
  issue_id INT,
  rating INT,
  comment TEXT,
  FOREIGN KEY (customer_id) REFERENCES customers(id),
  FOREIGN KEY (rep_id) REFERENCES service_reps(id),
  FOREIGN KEY (issue_id) REFERENCES issues(id)
);