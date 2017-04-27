
    alter table academic_background 
        drop 
        foreign key FK_eo8v9k356wx0p4886vc9hgbqj;

    alter table application 
        drop 
        foreign key FK_cq2c80d6nrnl66mno5uhtv6dj;

    alter table application 
        drop 
        foreign key FK_tn727fhfb356bi15ccvq11g6s;

    alter table application 
        drop 
        foreign key FK_ifiutp9b3etl8fr29g2gq1esr;

    alter table application 
        drop 
        foreign key FK_i1cgky1r4mouamoq4rx45evhb;

    alter table application 
        drop 
        foreign key FK_s5q8ng9cs65efb10qjt319enx;

    alter table application 
        drop 
        foreign key FK_dkr6bo95o1seayk7xddr9g7n5;

    alter table application_log 
        drop 
        foreign key FK_tmc6nvh8w4d15em4b7tqchsuk;

    alter table application_log 
        drop 
        foreign key FK_sskmdvceq9m8o5kmtt1sudiap;

    alter table application_log 
        drop 
        foreign key FK_3w5t9b9g31dbhvef53mksjic9;

    alter table department_requirements 
        drop 
        foreign key FK_6qjv0bgh0bxp5x02v86i7x4jr;

    alter table department_requirements 
        drop 
        foreign key FK_8a44h5k52voaugqdhdyka0oqc;

    alter table dept_req_values 
        drop 
        foreign key FK_3gcqk7y8igrrf1nl0tabo8i2o;

    alter table dept_req_values 
        drop 
        foreign key FK_io0rrvllwbbykl85og7p23at2;

    alter table files 
        drop 
        foreign key FK_f17q0vio6nggs5c1cknefgp3l;

    alter table files 
        drop 
        foreign key FK_d6eycg6uroqcqtkvpmplx9v6d;

    alter table programs 
        drop 
        foreign key FK_t38cee5jtiwtw07papp2rjlca;

    alter table users 
        drop 
        foreign key FK_krvotbtiqhudlkamvlpaqus0t;

    drop table if exists academic_background;

    drop table if exists app_status;

    drop table if exists application;

    drop table if exists application_log;

    drop table if exists country;

    drop table if exists data_types;

    drop table if exists department;

    drop table if exists department_requirements;

    drop table if exists dept_req_values;

    drop table if exists files;

    drop table if exists gender;

    drop table if exists programs;

    drop table if exists roles;

    drop table if exists term;

    drop table if exists users;
