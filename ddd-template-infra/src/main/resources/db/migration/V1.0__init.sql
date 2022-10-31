-- fund splits
create table if not exists public.fund_split
(
    id varchar
(
    256
) not null,
    account_id varchar
(
    256
) not null,
    source_id varchar
(
    256
) not null,
    source_type varchar
(
    64
) not null,
    currency varchar
(
    64
) not null,
    amount numeric not null,
    destination varchar
(
    256
) not null,
    split_type varchar
(
    256
) not null,
    status varchar
(
    64
) not null,
    version int not null,
    created_at timestamp,
    updated_at timestamp,
    constraint fund_splits_pkey
    primary key
(
    id
)
    );
