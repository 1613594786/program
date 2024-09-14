create table dorm_room
(
    dormroom_id      int           not null comment '宿舍房间号'
        primary key,
    dormbuild_id     int           not null comment '宿舍楼号',
    floor_num        int           not null comment '楼层',
    max_capacity     int default 4 not null comment '房间最大入住人数',
    current_capacity int default 0 not null comment '当前房间入住人数',
    first_bed        varchar(255)  null comment '一号床位',
    second_bed       varchar(255)  null comment '二号床位',
    third_bed        varchar(255)  null comment '三号床位',
    fourth_bed       varchar(255)  null comment '四号床位'
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.dorm_room (dormroom_id, dormbuild_id, floor_num, max_capacity, current_capacity, first_bed, second_bed, third_bed, fourth_bed) VALUES (1101, 1, 1, 4, 2, 'stu22', null, null, 'stu4');
INSERT INTO dormitory.dorm_room (dormroom_id, dormbuild_id, floor_num, max_capacity, current_capacity, first_bed, second_bed, third_bed, fourth_bed) VALUES (1103, 1, 1, 4, 4, 'stu8', 'stu9', 'stu10', 'stu11');
INSERT INTO dormitory.dorm_room (dormroom_id, dormbuild_id, floor_num, max_capacity, current_capacity, first_bed, second_bed, third_bed, fourth_bed) VALUES (1104, 1, 1, 4, 2, 'stu2', 'stu3', null, null);
INSERT INTO dormitory.dorm_room (dormroom_id, dormbuild_id, floor_num, max_capacity, current_capacity, first_bed, second_bed, third_bed, fourth_bed) VALUES (1201, 1, 2, 3, 2, 'stu1', 'stu5', null, null);
INSERT INTO dormitory.dorm_room (dormroom_id, dormbuild_id, floor_num, max_capacity, current_capacity, first_bed, second_bed, third_bed, fourth_bed) VALUES (2101, 2, 1, 4, 3, 'stu12', 'stu13', 'stu14', null);
INSERT INTO dormitory.dorm_room (dormroom_id, dormbuild_id, floor_num, max_capacity, current_capacity, first_bed, second_bed, third_bed, fourth_bed) VALUES (3101, 3, 1, 4, 3, 'stu15', 'stu16', 'stu16', null);
INSERT INTO dormitory.dorm_room (dormroom_id, dormbuild_id, floor_num, max_capacity, current_capacity, first_bed, second_bed, third_bed, fourth_bed) VALUES (4102, 4, 1, 4, 3, 'stu17', 'stu18', 'stu19', null);
