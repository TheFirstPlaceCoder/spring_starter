create table if not exists company
(
    id serial primary key ,
    "name" varchar(64) not null unique
);

create table if not exists company_locales
(
    company_id int references company (id),
    lang varchar(2),
    description varchar(255) not null ,
    primary key (company_id, lang)
);

create table if not exists users
(
    id bigserial primary key ,
    username varchar(64) not null unique ,
    birth_date date,
    firstname varchar(64),
    lastname varchar(64),
    role varchar(32),
    company_id int references company (id)
);

create table if not exists payment
(
    id bigserial primary key ,
    amount int not null ,
    receiver_id bigint not null references users (id)
);

create table if not exists chat
(
    id bigserial primary key,
    "name" varchar(64) not null
);

create table if not exists users_chat
(
    id bigserial primary key,
    user_id bigint references users (id),
    chat_id bigint references chat (id)
);