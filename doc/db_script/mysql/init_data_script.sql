delete from SYS_USER_DEPARTMENT;
delete from SYS_USER_ROLE;
delete from SYS_DICT_VALUE;
delete from SYS_ROLE_RES_OPER;

delete from SYS_USER;
delete from SYS_DEPARTMENT;
delete from SYS_OPERATION;
delete from SYS_DICT_FIELD;
delete from SYS_RESOURCE;
delete from SYS_ROLE;


/*SYS_USER*/
insert into SYS_USER (USER_ID, USER_CODE, USER_NAME, PASSWORD, STATUS)
values (1, 'admin', '管理员', '2add84f762bd34340089fffe8bae7b7414ab2bec', '1');

insert into SYS_USER (USER_ID, USER_CODE, USER_NAME, PASSWORD, STATUS)
values (2, 'garden', '李家仁', '1c8fdef04ef5842b68cfcf5994f1a3eba73b9b54', '1');

insert into SYS_USER (USER_ID, USER_CODE, USER_NAME, PASSWORD, STATUS)
values (3, 'jack', '潘大安', '1ae4fd6c055b8c786e25c1b5d229ebe2663012e9', '1');

/*SYS_DEPARTMENT*/
insert into SYS_DEPARTMENT (DEPART_ID, DEPART_CODE, DEPART_NAME, PARENT_ID, STATUS, ORDER_NUM)
values (1, 'ZD', '总店', null, '1', null);

insert into SYS_DEPARTMENT (DEPART_ID, DEPART_CODE, DEPART_NAME, PARENT_ID, STATUS, ORDER_NUM)
values (48, 'NHD', '南海店', 1, '1', null);

insert into SYS_DEPARTMENT (DEPART_ID, DEPART_CODE, DEPART_NAME, PARENT_ID, STATUS, ORDER_NUM)
values (47, 'SSD', '三水店', 1, '1', null);

insert into SYS_DEPARTMENT (DEPART_ID, DEPART_CODE, DEPART_NAME, PARENT_ID, STATUS, ORDER_NUM)
values (49, 'GCD', '桂城店', 1, '1', null);


/*SYS_OPERATION*/
insert into SYS_OPERATION (OPERATION_ID, OPERATION_CODE, OPERATION_NAME, STATUS)
values (1, 'query', '查询', '1');

insert into SYS_OPERATION (OPERATION_ID, OPERATION_CODE, OPERATION_NAME, STATUS)
values (2, 'add', '增加', '1');

insert into SYS_OPERATION (OPERATION_ID, OPERATION_CODE, OPERATION_NAME, STATUS)
values (3, 'delete', '删除', '1');

insert into SYS_OPERATION (OPERATION_ID, OPERATION_CODE, OPERATION_NAME, STATUS)
values (4, 'import', '导入', '1');

insert into SYS_OPERATION (OPERATION_ID, OPERATION_CODE, OPERATION_NAME, STATUS)
values (5, 'export', '导出', '1');

insert into SYS_OPERATION (OPERATION_ID, OPERATION_CODE, OPERATION_NAME, STATUS)
values (6, 'edit', '修改', '1');

/*SYS_DICT_FIELD*/
insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (1, '状态', 'STATUS', '1');

insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (2, '资源类型', 'RESOURCE_TYPE', '1');

insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (3, '是否', 'YES_NO', '1');

insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (4, '班车类型', 'BUS_TYPE', '');

insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (5, '座位状态', 'SEAT_TYPE', '');

insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (6, '订位状态', 'BOOK_TYPE', '');

insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (7, '地点', 'LOCAL', '');

insert into SYS_DICT_FIELD (DICT_ID, DICT_NAME, DICT_CODE, STATUS)
values (8, '性别', 'SEX', '');

/*SYS_DICT_VALUE*/
insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (1, 1, '有效', '1', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (2, 1, '无效', '0', 2, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (3, 2, '菜单', '1', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (4, 2, '操作功能', '2', 2, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (5, 3, '是', '1', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (6, 3, '否', '0', 2, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (7, 4, '19座', '19', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (8, 4, '33座', '33', 2, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (9, 4, '45座', '45', 3, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (10, 4, '47座', '47', 4, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (11, 4, '51座', '51', 5, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (12, 4, '53座', '53', 6, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (13, 4, '55座', '55', 7, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (14, 5, '已售出', '1', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (15, 5, '未售出', '0', 2, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (16, 5, '锁定', '99', 3, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (17, 6, '取消', '0', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (18, 6, '成功', '1', 2, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (19, 7, '三水', 'SS', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (20, 7, '香港', 'HK', 2, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (21, 7, '澳门', 'MC', 3, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (22, 8, '男', '1', 1, '1');

insert into SYS_DICT_VALUE (VALUE_ID, DICT_ID, VALUE_NAME, VALUE, ORDER_NUM, STATUS)
values (23, 8, '女', '0', 2, '1');

/*SYS_RESOURCE*/
insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (2, '1', '部门管理', '/admin/system/department/list.do', 1, '1', 1);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (4, '1', '用户管理', '/admin/system/user/list.do', 1, '1', 2);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (5, '1', '角色管理', '/admin/system/role/list.do', 1, '1', 3);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (6, '1', '资源管理', '/admin/system/resource/list.do', 1, '1', 4);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (7, '2', '首页', '/admin/index.do', null, '1', null);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (23, '2', '部门(树)', '/admin/system/department/tree.do', null, '1', null);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (1, '1', '系统管理', '', null, '1', 1);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (10, '2', '部门管理(修改)', '/admin/system/department/edit.do', 2, '1', 1);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (11, '2', '部门管理(删除)', '/admin/system/department/delete.do', null, '1', 2);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (12, '2', '用户管理(修改)', '/admin/system/user/edit.do', 4, '1', 1);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (13, '2', '用户管理(删除)', '/admin/system/user/delete.do', 4, '1', 2);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (14, '2', '用户管理(增加)', '/admin/system/user/add.do', 4, '1', 3);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (15, '2', '角色管理(删除)', '/admin/system/role/delete.do', 5, '1', 1);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (16, '2', '角色管理(增加)', '/admin/system/role/add.do', 5, '1', 2);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (17, '2', '角色管理(修改)', '/admin/system/role/edit.do', 5, '1', 3);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (18, '2', '资源管理(增加)', '/admin/system/resource/add.do', 6, '1', 1);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (19, '2', '资源管理(删除)', '/admin/system/resource/delete.do', 6, '1', 2);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (20, '2', '资源管理(修改)', '/admin/system/resource/edit.do', 6, '1', 3);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (8, '2', '桌面', '/admin/desktop.do', null, '1', null);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (21, '2', '修改密码', '/admin/changePass.do', null, '1', null);

insert into SYS_RESOURCE (RESOURCE_ID, RESOURCE_TYPE, RESOURCE_NAME, RESOURCE_URL, PARENT_ID, STATUS, ORDER_NUM)
values (9, '2', '部门管理(增加)', '/admin/system/department/add.do', 2, '1', 3);

/*SYS_ROLE*/
insert into SYS_ROLE (ROLE_ID, ROLE_CODE, ROLE_NAME, STATUS)
values (2, 'operator', '操作员', '1');

insert into SYS_ROLE (ROLE_ID, ROLE_CODE, ROLE_NAME, STATUS)
values (3, 'anonymous', '匿名用户', '1');

insert into SYS_ROLE (ROLE_ID, ROLE_CODE, ROLE_NAME, STATUS)
values (1, 'admin', '管理员', '1');

/*SYS_ROLE_RES_OPER*/
insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 2, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 23, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 1, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 7, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 8, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (2, 7, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (2, 8, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 10, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 11, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 12, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 13, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 14, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 15, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 16, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 17, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 18, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 19, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 20, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 21, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 4, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 5, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 6, 1);

insert into SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
values (1, 9, 1);

/*SYS_USER_DEPARTMENT*/
insert into SYS_USER_DEPARTMENT (DEPART_ID, USER_ID)
values (1, 1);

insert into SYS_USER_DEPARTMENT (DEPART_ID, USER_ID)
values (47, 2);

/*SYS_USER_ROLE*/
insert into SYS_USER_ROLE (USER_ID, ROLE_ID)
values (3, 3);

insert into SYS_USER_ROLE (USER_ID, ROLE_ID)
values (1, 1);

insert into SYS_USER_ROLE (USER_ID, ROLE_ID)
values (1, 2);

insert into SYS_USER_ROLE (USER_ID, ROLE_ID)
values (1, 3);

insert into SYS_USER_ROLE (USER_ID, ROLE_ID)
values (2, 2);

commit;