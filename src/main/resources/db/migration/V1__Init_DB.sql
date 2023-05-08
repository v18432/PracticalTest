create table accounts (
                          id bigint generated by default as identity,
                          account_number integer not null,
                          balance numeric(19,2),
                          beneficiary_name varchar(255),
                          pin_code varchar(255),
                          primary key (id)
);

create table transactions (
                              id bigint generated by default as identity,
                              amount numeric(19,2),
                              from_account_number integer not null,
                              timestamp timestamp,
                              to_account_number integer not null,
                              account_id bigint,
                              primary key (id)
);

alter table transactions
    add constraint account_fk
        foreign key (account_id)
            references accounts;

insert
into
    accounts
(account_number, balance, beneficiary_name, pin_code)
values
    (837595045, 0.00, 'Svetlana', '1234');

insert
into
    accounts
(account_number, balance, beneficiary_name, pin_code)
values
    (837594336, 0.00, 'Vladimir', '5555');