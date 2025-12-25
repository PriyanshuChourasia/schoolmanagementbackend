drop database if exists schooldb;
create database schooldb;
use schooldb;
-- admission type direct, management quota, referal admission and all what

create table admission_types(
	id bigint unsigned primary key auto_increment,
    name varchar(120) not null,
    code varchar(100) unique,
    -- admission_type_document_master_id bigint,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
  --  foreign key(admission_type_document_master_id)
);

-- create table admission_type_document_masters(
-- 	id bigint unsigned primary key auto_increment,
--     name varchar(50),
--     admission_type_document_id bigint,
-- 	created_at timestamp not null default current_timestamp,
--     updated_at timestamp not null default current_timestamp on update current_timestamp,
--
--     foreign key(admission_type_document_id) references admission_type_documents(id)
-- );

create table standards(
	id bigint unsigned primary key auto_increment,
    name varchar(50),
    code varchar(50) unique,
    alias_name varchar(50),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table sections(
	id bigint unsigned primary key auto_increment,
    name varchar(50),
    code varchar(50) unique,
    alias_name varchar(50),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table shift_types(
	id bigint unsigned primary key auto_increment,
    name varchar(50),
    code varchar(50) unique,
    alias_name varchar(50),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);




create table academic_sessions(
	id bigint unsigned primary key auto_increment,
    code varchar(50) unique,
    alias_name varchar(50),
    session_name varchar(120),
	is_active boolean,
	start_year date not null,
    end_year date not null,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);




create table religions(
	id bigint unsigned primary key auto_increment,
    name varchar(40) not null unique,
    code varchar(20),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


-- application status accpeted, rejected , lottery
create table application_statuses(
	id bigint unsigned primary key auto_increment,
    name varchar(100) not null unique,
    code varchar(50) unique,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table address_types(
	id bigint unsigned primary key auto_increment,
    name varchar(120),
    code varchar(120),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table countries(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique,
    code varchar(255) unique,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table states(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique,
    code varchar(255) unique,

    country_id bigint unsigned,

    foreign key(country_id) references countries(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);



create table cities(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique,
    code varchar(255) unique,

    state_id bigint unsigned,

    foreign key(state_id) references states(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);




create table addresses(
	id bigint unsigned primary key auto_increment,
    is_primary boolean,
    address_line_one varchar(255) not null,
    address_line_two varchar(255),
    addressable_type varchar(255) not null,
    addressable_type_id bigint unsigned not null,

    address_type_id bigint unsigned not null,
    city_id bigint unsigned not null,

    foreign key(address_type_id) references address_types(id),
    foreign key(city_id) references cities(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

CREATE TABLE scholarship_programs (
    id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code VARCHAR(30) unique,
    is_active boolean default true,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);



create table document_types(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(120) unique,
    description text,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table documents(
	id bigint unsigned primary key auto_increment,

    document_type_id bigint unsigned,
    user_type varchar(255),
    user_type_id bigint unsigned,

    foreign key(document_type_id) references document_types(id),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table students(
	id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	student_registration_identifier VARCHAR(255) NOT NULL,
    first_name VARCHAR(150) NOT NULL,
    middle_name varchar(40) ,
    last_name varchar(60) not null,
    email VARCHAR(150) unique,
    contact VARCHAR(20) NOT NULL,
    alt_contact VARCHAR(20),
    password varchar(50),
    age INT,
    dob date,
    gender ENUM('MALE','FEMALE','OTHER'),
    standard_id bigint unsigned,
    gaurdian_name varchar(50) not null,

    address_id bigint unsigned not null,
    religion_id bigint unsigned not null,
    academic_session_id BIGINT UNSIGNED NOT NULL,
    admission_type_id BIGINT UNSIGNED NOT NULL,
    document_id bigint unsigned not null,

    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    foreign key(standard_id) references standards(id),
    foreign key(academic_session_id) references academic_sessions(id),
    foreign key(admission_type_id) REFERENCES admission_types(id),
    foreign key (religion_id) references religions(id),
    foreign key(address_id) references addresses(id),
	foreign key(document_id) references documents(id)
);

-- promoted, tranfered, demoted, left rejoined,alumini
create table enrollment_statuses(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(255) unique,
    is_active boolean,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table shifts(
    id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(255) unique,
    is_active boolean,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table books(
    id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(255) unique,

    standard_id bigint unsigned,
    subject_id bigint unsigned,
    publication_id bigint unsigned,

    foreign key(subject_id) references subjects(id),
    foreign key(publication_id) references publications(id),
    foreign key(standard_id) references standards(id)

    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- courses table
create table courses(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(255) unique,
    is_active boolean default true,
    effective_date date,
    termination_date date,

    standard_id bigint unsigned,

    foreign key(standard_id) references standards(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table course_subjects(
    id bigint unsigned primary key auto_increment,
    code varchar(255) unique,

    course_id bigint unsigned,
    subject_id bigint unsigned,

    foreign key(course_id) references courses(id),
    foreign key(subject_id) references subjects(id),

    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table course_subject_details(
	id bigint unsigned primary key auto_increment,
    code varchar(255) unique,
    weightage decimal(10,2) not null,
    is_weightage_percentage boolean default false,

	subject_id bigint unsigned not null,
    course_id bigint unsigned not null,

    foreign key(subject_id) references subjects(id),
    foreign key(course_id) references courses(id),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);



create table course_fees(
    id bigint unsigned primary key auto_increment,
    code varchar(255) unique,

    course_id bigint unsigned,
    amount decimal(10,2),

    foreign key(course_id) references courses(id),

    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

/***
    course
    classOneCourse class-1
    classTwoCourse class-2
    classThreeCourse class-3
**/




create table subjects(
	id bigint unsigned primary key auto_increment,
    name varchar(200) unique not null,
    code varchar(125) unique,

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);





create table student_sessions(
	id bigint unsigned primary key auto_increment,

    student_id bigint unsigned,
    roll_no int,
    section_id bigint unsigned,
    enrollment_status_id bigint unsigned,
    course_id bigint unsigned,

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    foreign key(student_id) references students(id),
	foreign key(section_id) references sections(id),
	foreign key(enrollment_status_id) references enrollment_statuses(id)
);


-- half yearly, full year, weekly, quarterly specially designed for exams
create table academic_periods(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    start_date date not null,
    end_date date not null,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table student_scholarships(
	id bigint unsigned primary key auto_increment,
	amount decimal(12,2),
    status enum('approved','rejected','stopped','expired','pending'),

    scholarship_id bigint unsigned not null,
    student_id bigint unsigned not null,
    academic_session_id bigint unsigned not null,

    foreign key(scholarship_id) references scholarship_programs(id),
	foreign key(academic_session_id) references academic_sessions(id),
	foreign key(student_id) references students(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table gaurdian_types(
	id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) not null unique,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table gaurdians(
	id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) not null,
    occupation_id bigint unsigned,
    email varchar(255) unique,
    contact_no bigint,
	is_primary boolean,
    is_local_gaurdian boolean,

    gaurdian_type_id bigint unsigned not null,

    foreign key(gaurdian_type_id) references gaurdian_types(id),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


CREATE TABLE applicants (
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(150) NOT NULL,
    middle_name varchar(40) ,
    last_name varchar(60) not null,
    email VARCHAR(150) unique,
    contact VARCHAR(20) NOT NULL,
    alt_contact VARCHAR(20),
    password varchar(50),
    age INT,
    gender ENUM('MALE','FEMALE','OTHER'),

	gaurdian_id bigint unsigned,
    standard_id bigint unsigned,
	application_status_id bigint unsigned not null,
    religion_id bigint unsigned not null,
    academic_session_id BIGINT UNSIGNED NOT NULL,
    admission_type_id BIGINT UNSIGNED NOT NULL,
    application_number VARCHAR(50) NOT NULL,
    is_converted_to_student BOOLEAN DEFAULT FALSE,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    foreign key(standard_id) references standards(id),
    foreign key(academic_session_id) references academic_sessions(id),
    foreign key(admission_type_id) REFERENCES admission_types(id),
    foreign key (religion_id) references religions(id),
    foreign key(application_status_id) references application_statuses(id),
	foreign key(gaurdian_id) references gaurdians(id)
);




create table publications(
    id bigint unsigned primary key auto_increment,
    name varchar(200) unique not null,
    code varchar(125) unique,
    is_active boolean default true,
    academic_session_id bigint unsigned,

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table subject_details(
    id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(120) unique,

    subject_id bigint unsigned,
    publication_id bigint unsigned,

    foreign key(subject_id) references subjects(id),
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- for promotion
-- summative exam, formative exam, class test, practical
create table academic_assessment_types(
	id bigint unsigned primary key auto_increment,
    name varchar(255) not null unique,
    code varchar(120) unique,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table academic_assessment_periods(
	id bigint unsigned primary key auto_increment,

    academic_period_id bigint unsigned, -- Half yearly
	academic_assessment_type_id bigint unsigned, -- practical
    academic_session_id bigint unsigned, -- 2025-2026
    foreign key(academic_period_id) references academic_periods(id),
	foreign key(academic_assessment_type_id) references academic_assessment_types(id),
    foreign key(academic_session_id) references academic_sessions(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table academic_marks(
	id bigint unsigned primary key auto_increment,


	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table student_academic_assessments(
	id bigint unsigned primary key auto_increment,


    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- create table student_academic_assesment_histories(
-- 	id bigint unsigned primary key auto_increment,

--   created_at timestamp not null default current_timestamp,
--    updated_at timestamp not null default current_timestamp on update current_timestamp
-- );



-- part time full time contract
create table employee_types(
	id bigint unsigned primary key auto_increment,
	name varchar(200) unique not null,
    code varchar(125) unique,
    is_active boolean default true,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table designations(
	id bigint unsigned primary key auto_increment,
	name varchar(200) unique not null,
    code varchar(125) unique,
    description text,
	is_active boolean default true,
	created_at timestamp not null default current_timestamp,
	updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table departments(
	id bigint unsigned primary key auto_increment,
	name varchar(200) unique not null,
    code varchar(125) unique,
    description text,
	is_active boolean default true,
	created_at timestamp not null default current_timestamp,
	updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table employees(
	id bigint unsigned primary key auto_increment,
	name varchar(200) not null,
    code varchar(125) unique,
    employee_identifier varchar(200) unique not null,
    is_active boolean default true,
    email VARCHAR(150) unique,
    contact VARCHAR(20) NOT NULL,
    alt_contact VARCHAR(20),
    password varchar(50),
    age INT,
    dob date,
    joining_date date,
    gender ENUM('MALE','FEMALE','OTHER'),
    specialization varchar(200),

    employee_type_id bigint unsigned not null,
    designation_id bigint unsigned not null,
	department_id bigint unsigned not null,
	address_id bigint unsigned not null,
    religion_id bigint unsigned not null,
	document_id bigint unsigned not null,


    foreign key (religion_id) references religions(id),
    foreign key(document_id) references documents(id),
    foreign key(address_id) references addresses(id),
	foreign key (employee_type_id) references employee_types(id),
    foreign key (designation_id) references designations(id),
    foreign key (department_id) references departments(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);



create table teacher_sessions(
	id bigint unsigned primary key auto_increment,
	code varchar(255) unique,

    teacher_id bigint unsigned not null,
    academic_session_id bigint unsigned not null,
    standard_id bigint unsigned not null,
    section_id bigint unsigned,

    foreign key(teacher_id) references employees(id),
	foreign key(academic_session_id) references academic_sessions(id),
	foreign key(standard_id) references standards(id),
	foreign key(section_id) references sections(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table teacher_subject_sessions(
	id bigint unsigned primary key auto_increment,
	code varchar(255) unique,

    teacher_session_id bigint unsigned not null,
    subject_detail_id bigint unsigned not null,

	foreign key(teacher_session_id) references employees(id),
	foreign key(subject_detail_id) references subject_details(id),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- 	id bigint unsigned primary key auto_increment,
-- 	code varchar(255) unique,
-- 	created_at timestamp not null default current_timestamp,
--     updated_at timestamp not null default current_timestamp on update current_timestamp


create table employee_occupation_details(
	id bigint unsigned primary key auto_increment,
    code varchar(255) unique,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table bank_account_types(
	id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
	code varchar(255) unique,
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

create table bank_account_details(
	id bigint unsigned primary key auto_increment,
    code varchar(255) unique,
    account_number bigint unique not null,
    ifsc_code varchar(255) unique not null,
    branch_name varchar(255),
    branch_code varchar(255),
    bank_name varchar(255),

    bank_account_detail_type varchar(255),
    bank_account_detail_type_id bigint unsigned,

    account_type_id bigint unsigned,
    document_id bigint unsigned,
    foreign key(account_type_id) references bank_account_types(id),
	foreign key(document_id) references documents(id),
	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);







-- user organisation

-- User A (admin)  schoolmaster  school (organisation)
--   Sub User A
--   Sub User B
--   Sub User C
-- account creation for new school is going on it means deciding financial year to be effective on
--

create table user_types(
    id bigint unsigned primary key auto_increment,
    name varchar(255) not null,
    code varchar(200) unique,

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- active inactive merged
create table organisation_statuses(
    id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(200) unique,

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- school , nursery school, Secondary School, Higher Secondary school, college university
create table organisation_types(
    id bigint unsigned primary key auto_increment,
    name varchar(255) unique not null,
    code varchar(200) unique,
    description text,

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


create table organisations(
    id bigint unsigned primary key auto_increment,
    name varchar(255) not null unique,
    code varchar(200) unique,
    is_branch boolean default false,
    establishment_year date,
    termination_year date,
    organisation_schema_id varchar(255) not null unique,

    organisation_status_id bigint unsigned,
    organisation_type_id bigint unsigned,

    foreign key(organisation_status_id) references organisation_statuses(id),
    foreign key(organisation_type_id) references organisation_types(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


-- roles superadmin admin developer administrator

create table users(
    id bigint unsigned primary key auto_increment,
    name varchar(255) not null,
    code varchar(200) unique,
    email varchar(255) not null unique,
    password varchar(255) not null,
    contact_no varchar(14) not null,
    alt_contact_no varchar(14),
    dob date,
    age int,
    gender enum('male','female','others'),

    organisation_id bigint unsigned,

    foreign key(organisation_id) organisations(id),

	created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);


