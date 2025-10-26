CREATE TABLE project (
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    client_name VARCHAR(100)
);

CREATE TABLE employee_project (
    emp_id INT NOT NULL,
    project_id INT NOT NULL,
    role VARCHAR(50),
    PRIMARY KEY (emp_id, project_id),
    CONSTRAINT fk_emp
        FOREIGN KEY (emp_id)
        REFERENCES employee(emp_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_project
        FOREIGN KEY (project_id)
        REFERENCES project(project_id)
        ON DELETE CASCADE
);
