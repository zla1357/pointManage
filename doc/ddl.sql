create table hibernate_sequence (
   next_val bigint
);
insert into hibernate_sequence values ( 1 );
    
create table bonus_point_hist (
    id bigint not null,
    input_date timestamp(6),
	place_id varchar(255),
	place_point integer not null,
	review_id varchar(255),
	user_id varchar(255),
	primary key (id)
)
;

create index idx_user_id on bonus_point_hist(user_id);
create index idx_place_id on bonus_point_hist(place_id);

;   
create table point (
   id bigint not null,
	input_date timestamp(6),
	point_amount integer not null,
	user_id varchar(255),
	primary key (id)
)
;

create index idx_user_id on point(user_id);
 
;
create table point_hist (
   id bigint not null,
	content_point integer not null,
	image_point integer not null,
	input_date timestamp(6),
	review_id varchar(255),
	user_id varchar(255),
	primary key (id)
)
;

create index idx_user_id_review_id on point_hist(user_id, review_id);
