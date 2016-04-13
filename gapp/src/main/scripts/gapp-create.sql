
    create table academic_background (
        id int4 not null,
        gpa float8,
        ended timestamp not null,
        started timestamp not null,
        college varchar(255) not null,
        degree varchar(255) not null,
        university varchar(255) not null,
        application_id int4 not null,
        primary key (id)
    );

    create table app_status (
        id int4 not null,
        deleted boolean not null,
        status_name varchar(255) not null,
        primary key (id)
    );

    create table application (
        id int4 not null,
        dob timestamp not null,
        cin varchar(255),
        email varchar(255) not null,
        phone varchar(255) not null,
        fname varchar(255) not null,
        lname varchar(255) not null,
        toefl int4,
        submit_date timestamp,
        citizenship_id int4 not null,
        department_id int4 not null,
        gender_id int4 not null,
        programs_id int4 not null,
        term_id int4 not null,
        user_id int4 not null,
        primary key (id)
    );

    create table application_log (
        id int4 not null,
        comment varchar(255),
        change_date timestamp not null,
        application_id int4,
        applicationStatus_id int4,
        user_id int4,
        primary key (id)
    );

    create table country (
        id int4 not null,
        deleted boolean not null,
        country_name varchar(255) not null,
        primary key (id)
    );

    create table data_types (
        id int4 not null,
        deleted boolean not null,
        data_type varchar(255) not null,
        primary key (id)
    );

    create table department (
        id int4 not null,
        deleted boolean not null,
        department_name varchar(255) not null,
        primary key (id)
    );

    create table department_requirements (
        id int4 not null,
        deleted boolean not null,
        required boolean not null,
        field_name varchar(255) not null,
        dataType_id int4 not null,
        department_id int4 not null,
        primary key (id)
    );

    create table dept_req_values (
        id int4 not null,
        strValue varchar(255),
        application_id int4 not null,
        deptReq_id int4 not null,
        primary key (id)
    );

    create table files (
        intId int4 not null,
        data bytea not null,
        comment varchar(255) not null,
        name varchar(255) not null,
        type varchar(255) not null,
        uploadDate timestamp not null,
        academic_id int4,
        deptReqFile_id int4,
        primary key (intId)
    );

    create table gender (
        id int4 not null,
        deleted boolean not null,
        gender_name varchar(255) not null,
        primary key (id)
    );

    create table programs (
        id int4 not null,
        deleted boolean not null,
        program_name varchar(255) not null,
        department_id int4 not null,
        primary key (id)
    );

    create table roles (
        id int4 not null,
        deleted boolean not null,
        role_name varchar(255) not null,
        primary key (id)
    );

    create table term (
        id int4 not null,
        deleted boolean not null,
        quarter varchar(255) not null,
        primary key (id)
    );

    create table users (
        id int4 not null,
        enabled boolean not null,
        email varchar(255) not null,
        fname varchar(255) not null,
        lname varchar(255) not null,
        password varchar(255) not null,
        role_id int4 not null,
        primary key (id)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table academic_background 
        add constraint FK_eo8v9k356wx0p4886vc9hgbqj 
        foreign key (application_id) 
        references application;

    alter table application 
        add constraint FK_cq2c80d6nrnl66mno5uhtv6dj 
        foreign key (citizenship_id) 
        references country;

    alter table application 
        add constraint FK_tn727fhfb356bi15ccvq11g6s 
        foreign key (department_id) 
        references department;

    alter table application 
        add constraint FK_ifiutp9b3etl8fr29g2gq1esr 
        foreign key (gender_id) 
        references gender;

    alter table application 
        add constraint FK_i1cgky1r4mouamoq4rx45evhb 
        foreign key (programs_id) 
        references programs;

    alter table application 
        add constraint FK_s5q8ng9cs65efb10qjt319enx 
        foreign key (term_id) 
        references term;

    alter table application 
        add constraint FK_dkr6bo95o1seayk7xddr9g7n5 
        foreign key (user_id) 
        references users;

    alter table application_log 
        add constraint FK_tmc6nvh8w4d15em4b7tqchsuk 
        foreign key (application_id) 
        references application;

    alter table application_log 
        add constraint FK_sskmdvceq9m8o5kmtt1sudiap 
        foreign key (applicationStatus_id) 
        references app_status;

    alter table application_log 
        add constraint FK_3w5t9b9g31dbhvef53mksjic9 
        foreign key (user_id) 
        references users;

    alter table department_requirements 
        add constraint FK_6qjv0bgh0bxp5x02v86i7x4jr 
        foreign key (dataType_id) 
        references data_types;

    alter table department_requirements 
        add constraint FK_8a44h5k52voaugqdhdyka0oqc 
        foreign key (department_id) 
        references department;

    alter table dept_req_values 
        add constraint FK_3gcqk7y8igrrf1nl0tabo8i2o 
        foreign key (application_id) 
        references application;

    alter table dept_req_values 
        add constraint FK_io0rrvllwbbykl85og7p23at2 
        foreign key (deptReq_id) 
        references department_requirements;

    alter table files 
        add constraint FK_f17q0vio6nggs5c1cknefgp3l 
        foreign key (academic_id) 
        references academic_background;

    alter table files 
        add constraint FK_d6eycg6uroqcqtkvpmplx9v6d 
        foreign key (deptReqFile_id) 
        references dept_req_values;

    alter table programs 
        add constraint FK_t38cee5jtiwtw07papp2rjlca 
        foreign key (department_id) 
        references department;

    alter table users 
        add constraint FK_krvotbtiqhudlkamvlpaqus0t 
        foreign key (role_id) 
        references roles;

    create sequence hibernate_sequence;
