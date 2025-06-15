insert into company (name)
values ('Google'),
       ('Meta'),
       ('Amazon');

insert into company_locales (company_id, lang, description)
values ((select id from company where name = 'Google'), 'en', 'Google description'),
       ((select id from company where name = 'Google'), 'ru', 'Google описание'),
       ((select id from company where name = 'Meta'), 'en', 'Meta description'),
       ((select id from company where name = 'Meta'), 'ru', 'Meta описание'),
       ((select id from company where name = 'Amazon'), 'en', 'Amazon description'),
       ((select id from company where name = 'Amazon'), 'ru', 'Amazon описание');

insert into users (birth_date, firstname, lastname, role, username, company_id)
values ('1990-01-10', 'Ivan', 'Ivanov', 'ADMIN', 'ivan@gmail.com', (select id from company where name = 'Google')),
       ('1995-10-19', 'Petr', 'Petrov', 'USER', 'petr@gmail.com', (select id from company where name = 'Google')),
       ('2001-12-23', 'Sveta', 'Svetikova', 'USER', 'sveta@gmail.com', (select id from company where name = 'Meta')),
       ('1984-03-14', 'Vlad', 'Vladikov', 'USER', 'vlad@gmail.com', (select id from company where name = 'Meta')),
       ('1984-03-14', 'Kate', 'Smith', 'ADMIN', 'kate@gmail.com', (select id from company where name = 'Amazon'));

insert into payment (amount, receiver_id)
values (100, (select id from users where username = 'ivan@gmail.com')),
       (200, (select id from users where username = 'ivan@gmail.com')),
       (600, (select id from users where username = 'petr@gmail.com')),
       (500, (select id from users where username = 'petr@gmail.com')),
       (400, (select id from users where username = 'sveta@gmail.com')),
       (300, (select id from users where username = 'sveta@gmail.com')),
       (500, (select id from users where username = 'vlad@gmail.com')),
       (700, (select id from users where username = 'vlad@gmail.com')),
       (340, (select id from users where username = 'vlad@gmail.com')),
       (440, (select id from users where username = 'kate@gmail.com')),
       (510, (select id from users where username = 'kate@gmail.com')),
       (630, (select id from users where username = 'kate@gmail.com'));

insert into chat (name)
values ('minsk'),
       ('java'),
       ('database');

insert into users_chat (user_id, chat_id)
values ((select id from users where username = 'ivan@gmail.com'), (select id from chat where name = 'minsk')),
       ((select id from users where username = 'petr@gmail.com'), (select id from chat where name = 'minsk')),
       ((select id from users where username = 'sveta@gmail.com'), (select id from chat where name = 'minsk')),
       ((select id from users where username = 'petr@gmail.com'), (select id from chat where name = 'java')),
       ((select id from users where username = 'sveta@gmail.com'), (select id from chat where name = 'java')),
       ((select id from users where username = 'vlad@gmail.com'), (select id from chat where name = 'java')),
       ((select id from users where username = 'kate@gmail.com'), (select id from chat where name = 'java')),
       ((select id from users where username = 'petr@gmail.com'), (select id from chat where name = 'database')),
       ((select id from users where username = 'kate@gmail.com'), (select id from chat where name = 'database'));