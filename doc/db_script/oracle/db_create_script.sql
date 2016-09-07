alter table SYS_DICT_VALUE
   drop constraint FK_SYS_DICT_FIELD_VAL_SYS_DICT;

alter table SYS_ROLE_DEPARTMENT
   drop constraint FK_SYS_ROLE_DEP_ROLED_SYS_DEPA;

alter table SYS_ROLE_DEPARTMENT
   drop constraint FK_SYS_ROLE_ROLE1_ROL_SYS_ROLE;

alter table SYS_ROLE_RES_OPER
   drop constraint FK_SYS_ROLE_OPER_ROLE_SYS_OPER;

alter table SYS_ROLE_RES_OPER
   drop constraint FK_SYS_ROLE_RES_ROLER_SYS_RESO;

alter table SYS_ROLE_RES_OPER
   drop constraint FK_SYS_ROLE_ROLE2_ROL_SYS_ROLE;

alter table SYS_USER_DEPARTMENT
   drop constraint FK_SYS_USER_DEP1_USER_SYS_DEPA;

alter table SYS_USER_DEPARTMENT
   drop constraint FK_SYS_USER_USER1_USE_SYS_USER;

alter table SYS_USER_ROLE
   drop constraint FK_SYS_USER_ROLE_USER_SYS_ROLE;

alter table SYS_USER_ROLE
   drop constraint FK_SYS_USER_USER_USER_SYS_USER;

drop table SYS_DEPARTMENT cascade constraints;

drop table SYS_DICT_FIELD cascade constraints;

drop index FIELD_VALUE_FK;

drop table SYS_DICT_VALUE cascade constraints;

drop table SYS_OPERATION cascade constraints;

drop table SYS_RESOURCE cascade constraints;

drop table SYS_ROLE cascade constraints;

drop index DEP_ROLEDEP_FK;

drop index ROLE1_ROLEDEP_FK;

drop table SYS_ROLE_DEPARTMENT cascade constraints;

drop index OPER_ROLERESOPER_FK;

drop index ROLE2_ROLERESOPER_FK;

drop index RES_ROLERESOPER_FK;

drop table SYS_ROLE_RES_OPER cascade constraints;

drop table SYS_USER cascade constraints;

drop index USER1_USERDEP_FK;

drop index DEP1_USERDEP_FK;

drop table SYS_USER_DEPARTMENT cascade constraints;

drop index ROLE_USERROLE_FK;

drop index USER_USERROLE_FK;

drop table SYS_USER_ROLE cascade constraints;

/*==============================================================*/
/* Table: SYS_DEPARTMENT                                        */
/*==============================================================*/
create table SYS_DEPARTMENT  (
   DEPART_ID            INTEGER                         not null,
   DEPART_CODE          VARCHAR2(100),
   DEPART_NAME          VARCHAR2(200),
   PARENT_ID            INTEGER,
   STATUS               VARCHAR2(10),
   ORDER_NUM            INTEGER,
   constraint PK_SYS_DEPARTMENT primary key (DEPART_ID),
   constraint AK_SYS_DEPARTMENT_COD_SYS_DEPA unique (DEPART_CODE)
);

/*==============================================================*/
/* Table: SYS_DICT_FIELD                                        */
/*==============================================================*/
create table SYS_DICT_FIELD  (
   DICT_ID              INTEGER                         not null,
   DICT_NAME            VARCHAR2(200),
   DICT_CODE            VARCHAR2(200),
   STATUS               VARCHAR2(10),
   constraint PK_SYS_DICT_FIELD primary key (DICT_ID),
   constraint AK_SYS_DICT_FIELD_COD_SYS_DICT unique (DICT_CODE)
);

/*==============================================================*/
/* Table: SYS_DICT_VALUE                                        */
/*==============================================================*/
create table SYS_DICT_VALUE  (
   VALUE_ID             INTEGER                         not null,
   DICT_ID              INTEGER,
   VALUE_NAME           VARCHAR2(400),
   VALUE                VARCHAR2(100),
   ORDER_NUM            INTEGER,
   STATUS               VARCHAR2(10),
   constraint PK_SYS_DICT_VALUE primary key (VALUE_ID),
   constraint AK_SYS_DICT_VALUE_DIC_SYS_DICT unique (DICT_ID, VALUE)
);

/*==============================================================*/
/* Index: FIELD_VALUE_FK                                        */
/*==============================================================*/
create index FIELD_VALUE_FK on SYS_DICT_VALUE (
   DICT_ID ASC
);

/*==============================================================*/
/* Table: SYS_OPERATION                                         */
/*==============================================================*/
create table SYS_OPERATION  (
   OPERATION_ID         INTEGER                         not null,
   OPERATION_CODE       VARCHAR2(100),
   OPERATION_NAME       VARCHAR2(200),
   STATUS               VARCHAR2(10),
   constraint PK_SYS_OPERATION primary key (OPERATION_ID),
   constraint AK_SYS_OPERATION_CODE_SYS_OPER unique (OPERATION_CODE)
);

/*==============================================================*/
/* Table: SYS_RESOURCE                                          */
/*==============================================================*/
create table SYS_RESOURCE  (
   RESOURCE_ID          INTEGER                         not null,
   RESOURCE_TYPE        VARCHAR2(10),
   RESOURCE_NAME        VARCHAR2(200),
   RESOURCE_URL         VARCHAR2(1024),
   PARENT_ID            INTEGER,
   STATUS               VARCHAR2(10),
   ORDER_NUM            INTEGER,
   constraint PK_SYS_RESOURCE primary key (RESOURCE_ID)
);

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE  (
   ROLE_ID              INTEGER                         not null,
   ROLE_CODE            VARCHAR2(100),
   ROLE_NAME            VARCHAR2(200),
   STATUS               VARCHAR2(10),
   constraint PK_SYS_ROLE primary key (ROLE_ID),
   constraint AK_SYS_ROLE_CODE_SYS_ROLE unique (ROLE_CODE)
);

/*==============================================================*/
/* Table: SYS_ROLE_DEPARTMENT                                   */
/*==============================================================*/
create table SYS_ROLE_DEPARTMENT  (
   DEPART_ID            INTEGER,
   ROLE_ID              INTEGER,
   constraint AK_SYS_ROLE_DEPARTMEN_SYS_ROLE unique (DEPART_ID, ROLE_ID)
);

/*==============================================================*/
/* Index: ROLE1_ROLEDEP_FK                                      */
/*==============================================================*/
create index ROLE1_ROLEDEP_FK on SYS_ROLE_DEPARTMENT (
   ROLE_ID ASC
);

/*==============================================================*/
/* Index: DEP_ROLEDEP_FK                                        */
/*==============================================================*/
create index DEP_ROLEDEP_FK on SYS_ROLE_DEPARTMENT (
   DEPART_ID ASC
);

/*==============================================================*/
/* Table: SYS_ROLE_RES_OPER                                     */
/*==============================================================*/
create table SYS_ROLE_RES_OPER  (
   ROLE_ID              INTEGER,
   RESOURCE_ID          INTEGER,
   OPERATION_ID         INTEGER,
   constraint AK_SYS_ROLE_RES_OPER_SYS_ROLE unique (ROLE_ID, RESOURCE_ID, OPERATION_ID)
);

/*==============================================================*/
/* Index: RES_ROLERESOPER_FK                                    */
/*==============================================================*/
create index RES_ROLERESOPER_FK on SYS_ROLE_RES_OPER (
   RESOURCE_ID ASC
);

/*==============================================================*/
/* Index: ROLE2_ROLERESOPER_FK                                  */
/*==============================================================*/
create index ROLE2_ROLERESOPER_FK on SYS_ROLE_RES_OPER (
   ROLE_ID ASC
);

/*==============================================================*/
/* Index: OPER_ROLERESOPER_FK                                   */
/*==============================================================*/
create index OPER_ROLERESOPER_FK on SYS_ROLE_RES_OPER (
   OPERATION_ID ASC
);

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER  (
   USER_ID              INTEGER                         not null,
   USER_CODE            VARCHAR2(100),
   USER_NAME            VARCHAR2(200),
   PASSWORD             VARCHAR2(200),
   STATUS               VARCHAR2(10),
   constraint PK_SYS_USER primary key (USER_ID),
   constraint AK_SYS_USER_CODE_SYS_USER unique (USER_CODE)
);

/*==============================================================*/
/* Table: SYS_USER_DEPARTMENT                                   */
/*==============================================================*/
create table SYS_USER_DEPARTMENT  (
   DEPART_ID            INTEGER,
   USER_ID              INTEGER,
   constraint AK_SYS_USER_DEPARTMEN_SYS_USER unique (DEPART_ID, USER_ID)
);

/*==============================================================*/
/* Index: DEP1_USERDEP_FK                                       */
/*==============================================================*/
create index DEP1_USERDEP_FK on SYS_USER_DEPARTMENT (
   DEPART_ID ASC
);

/*==============================================================*/
/* Index: USER1_USERDEP_FK                                      */
/*==============================================================*/
create index USER1_USERDEP_FK on SYS_USER_DEPARTMENT (
   USER_ID ASC
);

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE  (
   USER_ID              INTEGER,
   ROLE_ID              INTEGER,
   constraint AK_SYS_USER_ROLE_SYS_USER unique (USER_ID, ROLE_ID)
);

/*==============================================================*/
/* Index: USER_USERROLE_FK                                      */
/*==============================================================*/
create index USER_USERROLE_FK on SYS_USER_ROLE (
   USER_ID ASC
);

/*==============================================================*/
/* Index: ROLE_USERROLE_FK                                      */
/*==============================================================*/
create index ROLE_USERROLE_FK on SYS_USER_ROLE (
   ROLE_ID ASC
);

alter table SYS_DICT_VALUE
   add constraint FK_SYS_DICT_FIELD_VAL_SYS_DICT foreign key (DICT_ID)
      references SYS_DICT_FIELD (DICT_ID);

alter table SYS_ROLE_DEPARTMENT
   add constraint FK_SYS_ROLE_DEP_ROLED_SYS_DEPA foreign key (DEPART_ID)
      references SYS_DEPARTMENT (DEPART_ID);

alter table SYS_ROLE_DEPARTMENT
   add constraint FK_SYS_ROLE_ROLE1_ROL_SYS_ROLE foreign key (ROLE_ID)
      references SYS_ROLE (ROLE_ID);

alter table SYS_ROLE_RES_OPER
   add constraint FK_SYS_ROLE_OPER_ROLE_SYS_OPER foreign key (OPERATION_ID)
      references SYS_OPERATION (OPERATION_ID);

alter table SYS_ROLE_RES_OPER
   add constraint FK_SYS_ROLE_RES_ROLER_SYS_RESO foreign key (RESOURCE_ID)
      references SYS_RESOURCE (RESOURCE_ID);

alter table SYS_ROLE_RES_OPER
   add constraint FK_SYS_ROLE_ROLE2_ROL_SYS_ROLE foreign key (ROLE_ID)
      references SYS_ROLE (ROLE_ID);

alter table SYS_USER_DEPARTMENT
   add constraint FK_SYS_USER_DEP1_USER_SYS_DEPA foreign key (DEPART_ID)
      references SYS_DEPARTMENT (DEPART_ID);

alter table SYS_USER_DEPARTMENT
   add constraint FK_SYS_USER_USER1_USE_SYS_USER foreign key (USER_ID)
      references SYS_USER (USER_ID);

alter table SYS_USER_ROLE
   add constraint FK_SYS_USER_ROLE_USER_SYS_ROLE foreign key (ROLE_ID)
      references SYS_ROLE (ROLE_ID);

alter table SYS_USER_ROLE
   add constraint FK_SYS_USER_USER_USER_SYS_USER foreign key (USER_ID)
      references SYS_USER (USER_ID);
