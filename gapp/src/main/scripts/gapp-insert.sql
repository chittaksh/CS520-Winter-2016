INSERT INTO roles(id, role_name, deleted) VALUES( 1, 'Admin', false);
INSERT INTO roles(id, role_name, deleted) VALUES( 2, 'Staff', false);
INSERT INTO roles(id, role_name, deleted) VALUES( 3, 'Student', false);

INSERT INTO gender(id, gender_name, deleted) VALUES(1, 'Male', false);
INSERT INTO gender(id, gender_name, deleted) VALUES(2, 'Female', false);
INSERT INTO gender(id, gender_name, deleted) VALUES(3, 'Other', false);

INSERT INTO app_status(id, status_name, deleted) VALUES(1, 'Not Sumbitted', false);
INSERT INTO app_status(id, status_name, deleted) VALUES(2, 'New', false);
INSERT INTO app_status(id, status_name, deleted) VALUES(3, 'Pending Review', false);
INSERT INTO app_status(id, status_name, deleted) VALUES(4, 'Denied', false);
INSERT INTO app_status(id, status_name, deleted) VALUES(5, 'Recommend Admit', false);
INSERT INTO app_status(id, status_name, deleted) VALUES(6, 'Recommend Admit w/ Condition', false);

INSERT INTO country (id, country_name, deleted) VALUES(1, 'United States', false);
INSERT INTO country (id, country_name, deleted) VALUES(2, 'India', false);
INSERT INTO country (id, country_name, deleted) VALUES(3, 'Canada', false);

INSERT INTO term(id, quarter, deleted) VALUES(1, 'Fall 2016', false);
INSERT INTO term(id, quarter, deleted) VALUES(2, 'Winter 2016', false);
INSERT INTO term(id, quarter, deleted) VALUES(3, 'Spring 2016', false);

INSERT INTO data_types(id, data_type, deleted) VALUES(1, 'String', false);
INSERT INTO data_types(id, data_type, deleted) VALUES(2, 'Double', false);
INSERT INTO data_types(id, data_type, deleted) VALUES(3, 'File', false);

INSERT INTO department(id, department_name, deleted) VALUES(1, 'Computer Science', false);
INSERT INTO department(id, department_name, deleted) VALUES(2, 'Accounting Department', false);

INSERT INTO programs(id, program_name, department_id, deleted) VALUES(1, 'M.S.', 1, false);
INSERT INTO programs(id, program_name, department_id, deleted) VALUES(2, 'M.S.', 2, false);

INSERT INTO department_requirements(id, required, field_name, datatype_id, department_id, deleted) VALUES(1, true, 'GMAT', 2, 2, false );
INSERT INTO department_requirements(id, required, field_name, datatype_id, department_id, deleted) VALUES(2, true, 'GRE', 2, 1, false );

INSERT INTO users(id, email, fname, lname, password, enabled, role_id) 
VALUES(1, 'admin@localhost.localdomain', 'The', 'One', 'abcd', true, 1);

INSERT INTO users(id, email, fname, lname, password, enabled, role_id) 
VALUES(2, 'staff1@localhost.localdomain', 'Staff', 'One', 'abcd', true, 2);

INSERT INTO users(id, email, fname, lname, password, enabled, role_id) 
VALUES(3, 'staff2@localhost.localdomain', 'Staff', 'Two', 'abcd', true, 2);

INSERT INTO users(id, email, fname, lname, password, enabled, role_id) 
VALUES(4, 'student1@localhost.localdomain', 'Student', 'One', 'abcd', true, 3);

INSERT INTO users(id, email, fname, lname, password, enabled, role_id) 
VALUES(5, 'student2@localhost.localdomain', 'Student', 'Two', 'abcd', true, 3);


--INSERT INTO student(id, dob, cin, citizenship, phone, gender_id) VALUES(4, '10/12/2016', '305058538', 'India', '9503555206', 1);
--INSERT INTO student(id, dob, cin, citizenship, phone, gender_id) VALUES(5, '09/11/2016', '305058765', 'Dubai', '3234648186', 2);

--INSERT INTO education_background(id, ended, started, university, gpa, college, degree, student_id) VALUES(1, '10/12/2008', '11/12/2013', 'Sant Gadge Baba Amravati University', 3.8, 'G. H. Raisoni College of Engineering', 'B.E.', 4);
--INSERT INTO education_background(id, ended, started, university, gpa, college, degree, student_id) VALUES(2, '10/12/2006', '11/12/2008', 'Maharashtra State Univeristy', 3.5, 'Brijlal Biyani Science College', 'Junior College', 4);

--INSERT INTO application(id, toefl, department_id, programs_id, student_id, term_id) VALUES(1, 105, 2, 1, 4, 1);

--INSERT INTO dept_req_values(id, value, application_id, deptreq_id) VALUES(1, '6.5',1 ,1);

--INSERT INTO application_log(id, comment, change_date, application_id, applicationstatus_id) VALUES(1, 'Messed Up!!', '02/12/2013', 1, 1);

--INSERT INTO dept_req_values(id, value, application_id, deptreq_id) VALUES(2, '105',2 ,2);

