use `hb_student_tracker`;

set foreign_key_checks = 0;

drop table if exists `course`;
create table `course`
(
    `id`            int(11) not null auto_increment,
    `title`         varchar(128) default null,
    `instructor_id` int(11)      default null,

    primary key (`id`),
    unique key `title_unique` (`title`),

    key `fk_instructor_idx` (`instructor_id`),
    constraint `fk_instructor`
        foreign key (`instructor_id`)
            references `instructor` (`id`)
            on delete no action on update no action
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

set foreign_key_checks = 1;