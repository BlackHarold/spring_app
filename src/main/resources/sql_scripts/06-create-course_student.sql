use `hb_student_tracker`;

set foreign_key_checks = 0;

drop table if exists `student`;
create table  `student`
(
    `id` int(11) not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,

    primary key (`id`)
) engine = InnoDB auto_increment=1 default charset=utf8;


drop table if exists `course_student`;
create table `course_student`
(
    `course_id`  int(11) not null,
    `student_id` int(11) not null,

    primary key (`course_id`, `student_id`),

    key `fk_student_idx` (`student_id`),

    constraint `fk_course_05`
        foreign key (`course_id`)
            references `course` (`id`)
            on delete no action on update no action,

    constraint `fk_student`
        foreign key (`student_id`)
            references `student` (`id`)
            on delete no action on update no action
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

set foreign_key_checks = 1;