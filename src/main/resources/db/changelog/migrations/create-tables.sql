create table address (
                         id BIGSERIAL PRIMARY KEY,
                         city varchar(255) not null,
                         house varchar(255) not null,
                         street varchar(255) not null,
                         created_at timestamp with time zone default now() not null,
                         updated_at timestamp with time zone default now() not null,
                         created_by varchar(50) default 'app',
                         updated_by varchar(50) default 'app'
);
create table cas (
                     id BIGSERIAL PRIMARY KEY,
                     name varchar(255) not null unique,
                     address_id bigint not null unique,
                     created_at timestamp with time zone default now() not null,
                     updated_at timestamp with time zone default now() not null,
                     created_by varchar(50) default 'app',
                     updated_by varchar(50) default 'app'
)