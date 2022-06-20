create table point (
       id bigint not null,
        images varchar(255),
        input_date datetime,
        place_id varchar(255),
        point integer not null,
        review_id varchar(255),
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB