create table dorm_build
(
    dormbuild_id     int          not null comment '宿舍楼号码',
    dormbuild_name   varchar(255) not null comment '宿舍楼名称',
    dormbuild_detail varchar(255) not null comment '宿舍楼备注',
    id               int auto_increment comment '主键'
        primary key
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.dorm_build (dormbuild_id, dormbuild_name, dormbuild_detail, id) VALUES (1, '一号楼', '男宿舍', 1);
INSERT INTO dormitory.dorm_build (dormbuild_id, dormbuild_name, dormbuild_detail, id) VALUES (2, '二号楼', '女宿舍', 2);
INSERT INTO dormitory.dorm_build (dormbuild_id, dormbuild_name, dormbuild_detail, id) VALUES (3, '三号楼', '男宿舍', 3);
INSERT INTO dormitory.dorm_build (dormbuild_id, dormbuild_name, dormbuild_detail, id) VALUES (4, '四号楼', '女宿舍', 4);
