
    create table academic_background (
        id integer not null auto_increment,
        gpa double precision,
        ended datetime not null,
        started datetime not null,
        college varchar(255) not null,
        degree varchar(255) not null,
        university varchar(255) not null,
        application_id integer not null,
        primary key (id)
    );

    create table app_status (
        id integer not null auto_increment,
        deleted boolean not null,
        status_name varchar(255) not null,
        primary key (id)
    );

    create table application (
        id integer not null auto_increment,
        dob datetime not null,
        cin varchar(255),
        email varchar(255) not null,
        phone varchar(255) not null,
        fname varchar(255) not null,
        lname varchar(255) not null,
        toefl integer,
        submit_date datetime,
        citizenship_id integer not null,
        department_id integer not null,
        gender_id integer not null,
        programs_id integer not null,
        term_id integer not null,
        user_id integer not null,
        primary key (id)
    );

    create table application_log (
        id integer not null auto_increment,
        comment varchar(255),
        change_date datetime not null,
        application_id integer,
        applicationStatus_id integer,
        user_id integer,
        primary key (id)
    );

    create table country (
        id integer not null auto_increment,
        deleted boolean not null,
        country_name varchar(255) not null,
        primary key (id)
    );

    create table data_types (
        id integer not null auto_increment,
        deleted boolean not null,
        data_type varchar(255) not null,
        primary key (id)
    );

    create table department (
        id integer not null auto_increment,
        deleted boolean not null,
        department_name varchar(255) not null,
        primary key (id)
    );

    create table department_requirements (
        id integer not null auto_increment,
        deleted boolean not null,
        required boolean not null,
        field_name varchar(255) not null,
        dataType_id integer not null,
        department_id integer not null,
        primary key (id)
    );

    create table dept_req_values (
        id integer not null auto_increment,
        strValue varchar(255),
        application_id integer not null,
        deptReq_id integer not null,
        primary key (id)
    );

    create table files (
        intId integer not null auto_increment,
        data tinyblob not null,
        comment varchar(255) not null,
        name varchar(255) not null,
        type varchar(255) not null,
        uploadDate datetime not null,
        academic_id integer,
        deptReqFile_id integer,
        primary key (intId)
    );

    create table gender (
        id integer not null auto_increment,
        deleted boolean not null,
        gender_name varchar(255) not null,
        primary key (id)
    );

    create table programs (
        id integer not null auto_increment,
        deleted boolean not null,
        program_name varchar(255) not null,
        department_id integer not null,
        primary key (id)
    );

    create table roles (
        id integer not null auto_increment,
        deleted boolean not null,
        role_name varchar(255) not null,
        primary key (id)
    );

    create table term (
        id integer not null auto_increment,
        deleted boolean not null,
        quarter varchar(255) not null,
        primary key (id)
    );

    create table users (
        id integer not null auto_increment,
        enabled boolean not null,
        email varchar(255) not null,
        fname varchar(255) not null,
        lname varchar(255) not null,
        password varchar(255) not null,
        role_id integer not null,
        primary key (id)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table academic_background 
        add index FK_eo8v9k356wx0p4886vc9hgbqj (application_id), 
        add constraint FK_eo8v9k356wx0p4886vc9hgbqj 
        foreign key (application_id) 
        references application (id);

    alter table application 
        add index FK_cq2c80d6nrnl66mno5uhtv6dj (citizenship_id), 
        add constraint FK_cq2c80d6nrnl66mno5uhtv6dj 
        foreign key (citizenship_id) 
        references country (id);

    alter table application 
        add index FK_tn727fhfb356bi15ccvq11g6s (department_id), 
        add constraint FK_tn727fhfb356bi15ccvq11g6s 
        foreign key (department_id) 
        references department (id);

    alter table application 
        add index FK_ifiutp9b3etl8fr29g2gq1esr (gender_id), 
        add constraint FK_ifiutp9b3etl8fr29g2gq1esr 
        foreign key (gender_id) 
        references gender (id);

    alter table application 
        add index FK_i1cgky1r4mouamoq4rx45evhb (programs_id), 
        add constraint FK_i1cgky1r4mouamoq4rx45evhb 
        foreign key (programs_id) 
        references programs (id);

    alter table application 
        add index FK_s5q8ng9cs65efb10qjt319enx (term_id), 
        add constraint FK_s5q8ng9cs65efb10qjt319enx 
        foreign key (term_id) 
        references term (id);

    alter table application 
        add index FK_dkr6bo95o1seayk7xddr9g7n5 (user_id), 
        add constraint FK_dkr6bo95o1seayk7xddr9g7n5 
        foreign key (user_id) 
        references users (id);

    alter table application_log 
        add index FK_tmc6nvh8w4d15em4b7tqchsuk (application_id), 
        add constraint FK_tmc6nvh8w4d15em4b7tqchsuk 
        foreign key (application_id) 
        references application (id);

    alter table application_log 
        add index FK_sskmdvceq9m8o5kmtt1sudiap (applicationStatus_id), 
        add constraint FK_sskmdvceq9m8o5kmtt1sudiap 
        foreign key (applicationStatus_id) 
        references app_status (id);

    alter table application_log 
        add index FK_3w5t9b9g31dbhvef53mksjic9 (user_id), 
        add constraint FK_3w5t9b9g31dbhvef53mksjic9 
        foreign key (user_id) 
        references users (id);

    alter table department_requirements 
        add index FK_6qjv0bgh0bxp5x02v86i7x4jr (dataType_id), 
        add constraint FK_6qjv0bgh0bxp5x02v86i7x4jr 
        foreign key (dataType_id) 
        references data_types (id);

    alter table department_requirements 
        add index FK_8a44h5k52voaugqdhdyka0oqc (department_id), 
        add constraint FK_8a44h5k52voaugqdhdyka0oqc 
        foreign key (department_id) 
        references department (id);

    alter table dept_req_values 
        add index FK_3gcqk7y8igrrf1nl0tabo8i2o (application_id), 
        add constraint FK_3gcqk7y8igrrf1nl0tabo8i2o 
        foreign key (application_id) 
        references application (id);

    alter table dept_req_values 
        add index FK_io0rrvllwbbykl85og7p23at2 (deptReq_id), 
        add constraint FK_io0rrvllwbbykl85og7p23at2 
        foreign key (deptReq_id) 
        references department_requirements (id);

    alter table files 
        add index FK_f17q0vio6nggs5c1cknefgp3l (academic_id), 
        add constraint FK_f17q0vio6nggs5c1cknefgp3l 
        foreign key (academic_id) 
        references academic_background (id);

    alter table files 
        add index FK_d6eycg6uroqcqtkvpmplx9v6d (deptReqFile_id), 
        add constraint FK_d6eycg6uroqcqtkvpmplx9v6d 
        foreign key (deptReqFile_id) 
        references dept_req_values (id);

    alter table programs 
        add index FK_t38cee5jtiwtw07papp2rjlca (department_id), 
        add constraint FK_t38cee5jtiwtw07papp2rjlca 
        foreign key (department_id) 
        references department (id);

    alter table users 
        add index FK_krvotbtiqhudlkamvlpaqus0t (role_id), 
        add constraint FK_krvotbtiqhudlkamvlpaqus0t 
        foreign key (role_id) 
        references roles (id);
