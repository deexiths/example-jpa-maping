-- Create the 'employees' table
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the 'employee_details' table
CREATE TABLE employee_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT UNIQUE,  -- Ensures one-to-one relationship
    address VARCHAR(255),
    phone_number VARCHAR(15),
    date_of_birth DATE,
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);
