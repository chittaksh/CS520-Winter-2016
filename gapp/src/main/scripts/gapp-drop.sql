
    alter table academic_background 
        drop constraint FK_eo8v9k356wx0p4886vc9hgbqj;

    alter table application 
        drop constraint FK_cq2c80d6nrnl66mno5uhtv6dj;

    alter table application 
        drop constraint FK_tn727fhfb356bi15ccvq11g6s;

    alter table application 
        drop constraint FK_ifiutp9b3etl8fr29g2gq1esr;

    alter table application 
        drop constraint FK_i1cgky1r4mouamoq4rx45evhb;

    alter table application 
        drop constraint FK_s5q8ng9cs65efb10qjt319enx;

    alter table application 
        drop constraint FK_dkr6bo95o1seayk7xddr9g7n5;

    alter table application_log 
        drop constraint FK_tmc6nvh8w4d15em4b7tqchsuk;

    alter table application_log 
        drop constraint FK_sskmdvceq9m8o5kmtt1sudiap;

    alter table application_log 
        drop constraint FK_3w5t9b9g31dbhvef53mksjic9;

    alter table department_requirements 
        drop constraint FK_6qjv0bgh0bxp5x02v86i7x4jr;

    alter table department_requirements 
        drop constraint FK_8a44h5k52voaugqdhdyka0oqc;

    alter table dept_req_values 
        drop constraint FK_3gcqk7y8igrrf1nl0tabo8i2o;

    alter table dept_req_values 
        drop constraint FK_io0rrvllwbbykl85og7p23at2;

    alter table files 
        drop constraint FK_f17q0vio6nggs5c1cknefgp3l;

    alter table files 
        drop constraint FK_d6eycg6uroqcqtkvpmplx9v6d;

    alter table programs 
        drop constraint FK_t38cee5jtiwtw07papp2rjlca;

    alter table users 
        drop constraint FK_krvotbtiqhudlkamvlpaqus0t;

    drop table if exists academic_background cascade;

    drop table if exists app_status cascade;

    drop table if exists application cascade;

    drop table if exists application_log cascade;

    drop table if exists country cascade;

    drop table if exists data_types cascade;

    drop table if exists department cascade;

    drop table if exists department_requirements cascade;

    drop table if exists dept_req_values cascade;

    drop table if exists files cascade;

    drop table if exists gender cascade;

    drop table if exists programs cascade;

    drop table if exists roles cascade;

    drop table if exists term cascade;

    drop table if exists users cascade;

    drop sequence hibernate_sequence;
