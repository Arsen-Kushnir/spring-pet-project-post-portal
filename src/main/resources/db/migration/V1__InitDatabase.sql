create table if not exists user
(
    id         bigint       not null auto_increment,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    age        int          not null,
    username   varchar(255) not null,
    password   varchar(255) not null,
    role       varchar(255) not null,
    active     bit          not null,
    primary key (id)
);

create table if not exists post
(
    id             bigint       not null auto_increment,
    author_user_id bigint       not null,
    title          varchar(255) not null,
    anons          varchar(255) not null,
    full_text      text         not null,
    created_at     datetime     not null,
    primary key (id)
);

alter table user
    add constraint UQ_User_Username unique (username);

alter table post
    add constraint FK_Post_Author foreign key (author_user_id) references user (id);