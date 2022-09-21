-- we don't know how to generate root <with-no-name> (class Root) :(
grant audit_abort_exempt, select, system_user on *.* to 'mysql.infoschema'@localhost;

grant audit_abort_exempt, backup_admin, clone_admin, connection_admin, persist_ro_variables_admin, session_variables_admin, shutdown, super, system_user, system_variables_admin on *.* to 'mysql.session'@localhost;

grant audit_abort_exempt, system_user on *.* to 'mysql.sys'@localhost;

grant alter, alter routine, application_password_admin, audit_abort_exempt, audit_admin, authentication_policy_admin, backup_admin, binlog_admin, binlog_encryption_admin, clone_admin, connection_admin, create, create role, create routine, create tablespace, create temporary tables, create user, create view, delete, drop, drop role, encryption_key_admin, event, execute, file, flush_optimizer_costs, flush_status, flush_tables, flush_user_resources, group_replication_admin, group_replication_stream, index, innodb_redo_log_archive, innodb_redo_log_enable, insert, lock tables, passwordless_user_admin, persist_ro_variables_admin, process, references, reload, replication client, replication slave, replication_applier, replication_slave_admin, resource_group_admin, resource_group_user, role_admin, select, sensitive_variables_observer, service_connection_admin, session_variables_admin, set_user_id, show databases, show view, show_routine, shutdown, super, system_user, system_variables_admin, table_encryption_admin, trigger, update, xa_recover_admin, grant option on *.* to root@localhost;

create table sys_menu
(
    id          bigint auto_increment
        primary key,
    menu_name   varchar(64)  default 'NULL' not null comment '菜单名',
    url         varchar(100)                null comment 'url',
    path        varchar(200)                null comment '路由地址',
    component   varchar(255)                null comment '组件路径',
    keepAlive   tinyint(1)                  null comment '是否保持激活（0不保存 1保持）',
    requireAuth tinyint(1)   default 0      null comment '是否需要权限（0不需要 1需要）',
    perms       varchar(100)                null comment '权限标识',
    icon        varchar(100) default '#'    null comment '菜单图标',
    parentId    int                         null comment '父id',
    enabled     tinyint(1)                  null comment '是否启用 0未启用1启用',
    del_flag    int          default 0      null comment '是否删除（0未删除 1已删除）',
    remark      varchar(500)                null comment '备注'
)
    comment '菜单表' charset = utf8mb4;

create table sys_role
(
    id       bigint auto_increment
        primary key,
    name     varchar(128)         null,
    role_key varchar(100)         null comment '角色权限字符串',
    enabled  tinyint(1) default 1 null comment '角色状态（1正常 0停用）',
    del_flag int        default 0 null comment 'del_flag',
    remark   varchar(500)         null comment '备注'
)
    comment '角色表' charset = utf8mb4;

create table sys_role_menu
(
    role_id bigint auto_increment comment '角色ID',
    menu_id bigint default 0 not null comment '菜单id',
    primary key (role_id, menu_id)
)
    charset = utf8mb4;

create table sys_user
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_name   varchar(64) default 'NULL' not null comment '用户名',
    nick_name   varchar(64) default 'NULL' not null comment '昵称',
    password    varchar(64) default 'NULL' not null comment '密码',
    enable      tinyint(1)  default 1      null comment '账号状态（1正常 0停用）',
    email       varchar(64)                null comment '邮箱',
    phonenumber varchar(32)                null comment '手机号',
    sex         char                       null comment '用户性别（0男，1女，2未知）',
    avatar      varchar(128)               null comment '头像',
    user_type   char        default '1'    not null comment '用户类型（0管理员，1普通用户）',
    create_by   bigint                     null comment '创建人的用户id',
    create_time datetime                   null comment '创建时间',
    update_by   bigint                     null comment '更新人',
    update_time datetime                   null comment '更新时间',
    del_flag    tinyint(1)  default 0      null comment '删除标志（0代表未删除，1代表已删除）'
)
    comment '用户表' charset = utf8mb4;

create table sys_user_role
(
    user_id bigint auto_increment comment '用户id',
    role_id bigint default 0 not null comment '角色id',
    primary key (user_id, role_id)
)
    charset = utf8mb4;

