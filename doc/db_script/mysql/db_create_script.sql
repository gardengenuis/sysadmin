drop table if exists SYS_DEPARTMENT;

drop table if exists SYS_DICT_FIELD;

drop table if exists SYS_DICT_VALUE;

drop table if exists SYS_OPERATION;

drop table if exists SYS_RESOURCE;

drop table if exists SYS_ROLE;

drop table if exists SYS_ROLE_DEPARTMENT;

drop table if exists SYS_ROLE_RES_OPER;

drop table if exists SYS_USER;

drop table if exists SYS_USER_DEPARTMENT;

drop table if exists SYS_USER_ROLE;

/*==============================================================*/
/* Table: SYS_DEPARTMENT                                        */
/*==============================================================*/
create table SYS_DEPARTMENT
(
   DEPART_ID            bigint not null auto_increment,
   DEPART_CODE          varchar(100),
   DEPART_NAME          varchar(200),
   PARENT_ID            bigint,
   STATUS               varchar(10),
   ORDER_NUM            bigint,
   primary key (DEPART_ID),
   unique key AK_SYS_DEPARTMENT_CODE (DEPART_CODE)
);

/*==============================================================*/
/* Table: SYS_DICT_FIELD                                        */
/*==============================================================*/
create table SYS_DICT_FIELD
(
   DICT_ID              bigint not null auto_increment,
   DICT_NAME            varchar(200),
   DICT_CODE            varchar(200),
   STATUS               varchar(10),
   primary key (DICT_ID),
   unique key AK_SYS_DICT_FIELD_CODE (DICT_CODE)
);

/*==============================================================*/
/* Table: SYS_DICT_VALUE                                        */
/*==============================================================*/
create table SYS_DICT_VALUE
(
   VALUE_ID             bigint not null auto_increment,
   DICT_ID              bigint,
   VALUE_NAME           varchar(400),
   VALUE                varchar(100),
   ORDER_NUM            bigint,
   STATUS               varchar(10),
   primary key (VALUE_ID),
   unique key AK_SYS_DICT_VALUE_DICT_ID_VALUE (DICT_ID, VALUE)
);

/*==============================================================*/
/* Table: SYS_OPERATION                                         */
/*==============================================================*/
create table SYS_OPERATION
(
   OPERATION_ID         bigint not null auto_increment,
   OPERATION_CODE       varchar(100),
   OPERATION_NAME       varchar(200),
   STATUS               varchar(10),
   primary key (OPERATION_ID),
   unique key AK_SYS_OPERATION_CODE (OPERATION_CODE)
);

/*==============================================================*/
/* Table: SYS_RESOURCE                                          */
/*==============================================================*/
create table SYS_RESOURCE
(
   RESOURCE_ID          bigint not null auto_increment,
   RESOURCE_TYPE        varchar(10),
   RESOURCE_NAME        varchar(200),
   RESOURCE_URL         varchar(1024),
   PARENT_ID            bigint,
   STATUS               varchar(10),
   ORDER_NUM            bigint,
   primary key (RESOURCE_ID)
);

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
   ROLE_ID              bigint not null auto_increment,
   ROLE_CODE            varchar(100),
   ROLE_NAME            varchar(200),
   STATUS               varchar(10),
   primary key (ROLE_ID),
   unique key AK_SYS_ROLE_CODE (ROLE_CODE)
);

/*==============================================================*/
/* Table: SYS_ROLE_DEPARTMENT                                   */
/*==============================================================*/
create table SYS_ROLE_DEPARTMENT
(
   DEPART_ID            bigint,
   ROLE_ID              bigint,
   unique key AK_SYS_ROLE_DEPARTMENT (DEPART_ID, ROLE_ID)
);

/*==============================================================*/
/* Table: SYS_ROLE_RES_OPER                                     */
/*==============================================================*/
create table SYS_ROLE_RES_OPER
(
   ROLE_ID              bigint,
   RESOURCE_ID          bigint,
   OPERATION_ID         bigint,
   unique key AK_SYS_ROLE_RES_OPER (ROLE_ID, RESOURCE_ID, OPERATION_ID)
);

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
   USER_ID              bigint not null auto_increment,
   USER_CODE            varchar(100),
   USER_NAME            varchar(200),
   PASSWORD             varchar(200),
   STATUS               varchar(10),
   primary key (USER_ID),
   unique key AK_SYS_USER_CODE (USER_CODE)
);

/*==============================================================*/
/* Table: SYS_USER_DEPARTMENT                                   */
/*==============================================================*/
create table SYS_USER_DEPARTMENT
(
   DEPART_ID            bigint,
   USER_ID              bigint,
   unique key AK_SYS_USER_DEPARTMENT (DEPART_ID, USER_ID)
);

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE
(
   USER_ID              bigint,
   ROLE_ID              bigint,
   unique key AK_SYS_USER_ROLE (USER_ID, ROLE_ID)
);

alter table SYS_DICT_VALUE add constraint FK_FIELD_VALUE foreign key (DICT_ID)
      references SYS_DICT_FIELD (DICT_ID) on delete restrict on update restrict;

alter table SYS_ROLE_DEPARTMENT add constraint FK_DEP_ROLEDEP foreign key (DEPART_ID)
      references SYS_DEPARTMENT (DEPART_ID) on delete restrict on update restrict;

alter table SYS_ROLE_DEPARTMENT add constraint FK_ROLE1_ROLEDEP foreign key (ROLE_ID)
      references SYS_ROLE (ROLE_ID) on delete restrict on update restrict;

alter table SYS_ROLE_RES_OPER add constraint FK_OPER_ROLERESOPER foreign key (OPERATION_ID)
      references SYS_OPERATION (OPERATION_ID) on delete restrict on update restrict;

alter table SYS_ROLE_RES_OPER add constraint FK_RES_ROLERESOPER foreign key (RESOURCE_ID)
      references SYS_RESOURCE (RESOURCE_ID) on delete restrict on update restrict;

alter table SYS_ROLE_RES_OPER add constraint FK_ROLE2_ROLERESOPER foreign key (ROLE_ID)
      references SYS_ROLE (ROLE_ID) on delete restrict on update restrict;

alter table SYS_USER_DEPARTMENT add constraint FK_DEP1_USERDEP foreign key (DEPART_ID)
      references SYS_DEPARTMENT (DEPART_ID) on delete restrict on update restrict;

alter table SYS_USER_DEPARTMENT add constraint FK_USER1_USERDEP foreign key (USER_ID)
      references SYS_USER (USER_ID) on delete restrict on update restrict;

alter table SYS_USER_ROLE add constraint FK_ROLE_USERROLE foreign key (ROLE_ID)
      references SYS_ROLE (ROLE_ID) on delete restrict on update restrict;

alter table SYS_USER_ROLE add constraint FK_USER_USERROLE foreign key (USER_ID)
      references SYS_USER (USER_ID) on delete restrict on update restrict;
