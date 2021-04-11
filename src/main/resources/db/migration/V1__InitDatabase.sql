create table if not exists "user"
(
    id         bigserial    primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    age        int          not null,
    username   varchar(255) not null,
    password   varchar(255) not null,
    role       varchar(255) not null,
    active     boolean      not null
);

create table if not exists post
(
    id             bigserial    primary key,
    author_user_id bigint       not null,
    title          varchar(255) not null,
    anons          varchar(255) not null,
    full_text      text         not null,
    created_at     timestamp    not null
);

alter table "user"
    add constraint uq_user_username unique (username);

alter table post
    add constraint fk_post_author foreign key (author_user_id) references "user" (id);