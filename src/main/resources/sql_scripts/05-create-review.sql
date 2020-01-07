use `hb_student_tracker`;

set foreign_key_checks = 0;

drop table if exists `review`;
create table `review`
(
    `id`            int(11) not null auto_increment,
    `comment`         varchar(256) default null,
    `course_id` int(11)      default null,

    primary key (`id`),


    key `fk_course_id_idx` (`course_id`),
    constraint `fk_course`
        foreign key (`course_id`)
            references `course` (`id`)
            on delete no action on update no action
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

set foreign_key_checks = 1;