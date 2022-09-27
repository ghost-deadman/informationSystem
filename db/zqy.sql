create table arrange_plan
(
    arrange_plan_id   varchar(100)  not null comment '主键'
        primary key,
    money             varchar(100)  null comment '金额',
    describes         varchar(100)  null comment '安排',
    principal_id      varchar(100)  null comment '负责人id',
    approver_id       varchar(100)  null comment '批准人id',
    date              datetime      null comment '日期',
    project_budget_id varchar(100)  null comment '项目预算id',
    deleted           int default 0 null comment '逻辑删除标识'
);

create table financial_progress
(
    financial_progress_id varchar(100)  not null comment '主键'
        primary key,
    status                int default 0 null comment '0 未申请 1 审批中 2 已下拨 3 未通过',
    deleted               int default 0 null comment '删除标识'
);

create table process_information
(
    process_information_id varchar(100)  not null comment '主键'
        primary key,
    project_id             varchar(100)  null comment '项目id',
    date                   datetime      null comment '状态变更日期',
    status                 int default 0 null comment '0 申请 1 立项成功 2立项失败 3 执行中 4 审批成功 4 审批失败 5 结题',
    deleted                int default 0 null comment '删除标识'
);

create table project
(
    project_id            varchar(100)  not null comment '主键'
        primary key,
    project_budget_id     varchar(100)  null comment '项目预算表id',
    project_category_id   varchar(100)  null comment '项目类型主键',
    financial_progress_id varchar(100)  null comment '项目财务进度id',
    project_context_id    varchar(100)  null comment '项目内容',
    type                  int           null comment '0 理论 1 实物',
    project_user_id       varchar(100)  null comment '项目负责人id',
    unit_id               varchar(100)  null comment '单位',
    approval_opinion_id   varchar(100)  null comment '项目立项意见id',
    create_date           datetime      null comment '项目创建时间',
    execute_status        int default 0 null comment '0默认 1执行中 2结题成功 3结题失败',
    create_status         int default 0 null comment '0创建 1申请中 2申请失败 3申请成功 4审批成功 5审批失败 6立项成功 7立项失败',
    deleted               int default 0 null comment '删除标识0默认 1删除'
);

create table project_budget
(
    project_budget_id varchar(100)  not null comment '主键'
        primary key,
    money             varchar(100)  null comment '总金额',
    deleted           int default 0 null comment '删除标识',
    opinion_id        varchar(100)  null comment '建设单位负责人审核意见id',
    date              date          null comment '日期',
    describes         varchar(200)  null comment '项目预算描述',
    status            int default 0 null comment '0：默认，1：申请中 ，2：申请成功，3：申请失败，4：审批成功，5：审批失败'
);

create table project_category
(
    project_category_id varchar(100)  not null comment '主键'
        primary key,
    name                varchar(100)  null comment '名称',
    deleted             int default 0 null comment '删除标识'
);

create table project_context
(
    project_context_id varchar(100)  not null comment '主键'
        primary key,
    name               varchar(100)  null comment '名称',
    describes          varchar(100)  null comment '概述',
    deleted            int default 0 null comment '删除标识'
);

create table project_draft
(
    project_draft_id    varchar(100)  not null comment '主键'
        primary key,
    project_id          varchar(100)  null comment '项目外键',
    project_category_id varchar(100)  null comment '项目类别id',
    project_user_id     varchar(100)  null comment '用户外键',
    describes           varchar(100)  null comment '项目描述',
    name                varchar(100)  null comment '项目名称',
    type                int default 0 null comment '0理论 1实物',
    unit_id             varchar(100)  null comment '单位id',
    create_date         datetime      null comment '草稿创建时间',
    status              int default 0 null comment '状态( 0 默认 1 提交 )',
    deleted             int default 0 null comment '删除标识( 0 默认 1 删除)'
);

create table project_file
(
    project_file_id  varchar(100)  not null comment '主键'
        primary key,
    project_draft_id varchar(100)  null comment '项目草稿id',
    project_id       varchar(100)  null comment '项目id',
    type             int           null comment '文件类型 0 申报书草稿 1 项目申报书 2 项目任务书 3 项目正文 4 项目预算信息 5 项目设备信息 6 项目年度验收报告 7 项目中期验收报告 8 项目完结验收报告',
    path             varchar(100)  null comment '路径',
    date             datetime      null comment '日期',
    name             varchar(100)  null comment '名称',
    status           int           null comment '0创建 1申请成功 2申请失败 3待审核 4审批成功 5审批失败',
    deleted          int default 0 null comment '删除标识'
);

create table project_process
(
    project_process varchar(100)  not null comment '主键'
        primary key,
    project_id      varchar(100)  null comment '项目id',
    date            datetime      null comment '状态变更日期',
    execute_status  int default 0 null comment '0默认 1执行中 2结题成功 3结题失败',
    create_status   int default 0 null comment '0创建 1申请中 2申请失败 3申请成功 4审批成功 5审批失败 6立项成功 7立项失败',
    deleted         int default 0 null comment '删除标识'
);

create table project_subject
(
    project_subject_id varchar(100) not null comment '主键'
        primary key,
    project_id         varchar(100) null comment '项目id',
    subject_id         varchar(100) null comment '学科id',
    project_dragt_id   varchar(100) null comment '项目草稿id'
);

create table specialist
(
    specialist_id varchar(100) not null comment '主键'
        primary key,
    specialty     varchar(100) null comment '专业',
    school        varchar(100) null comment '学校',
    `rank`        varchar(100) null comment '职称',
    user_id       varchar(100) null comment '用户id'
);

create table subject
(
    subject_id varchar(100)  not null comment '主键'
        primary key,
    name       varchar(100)  null comment '名称',
    deleted    int default 0 null comment '删除标识'
);

create table unit
(
    unit_id      varchar(100)  not null comment '主键'
        primary key,
    unit_user_id varchar(100)  null comment '单位负责人',
    name         varchar(100)  null comment '名称',
    deleted      int default 0 null comment '删除标识'
);

INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10001, 'Georgi', 'Facello', 'M');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10002, 'Bezalel', 'Simmel', 'F');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10003, 'Parto', 'Bamford', 'M');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10004, 'Chirstian', 'Koblick', 'M');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10005, 'Kyoichi', 'Maliniak', 'M');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10006, 'Anneke', 'Preusig', 'F');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10007, 'Tzvetan', 'Zielinski', 'F');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10008, 'Saniya', 'Kalloufi', 'M');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10009, 'Sumant', 'Peac', 'F');
INSERT INTO MY_TABLE(id, first_name, last_name, birth) VALUES (10010, 'Duangkaew', 'Piveteau', 'F');
