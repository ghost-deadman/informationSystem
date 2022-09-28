/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 8.0.29 : Database - information_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`information_system` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `information_system`;

/*Table structure for table `arrange_plan` */

DROP TABLE IF EXISTS `arrange_plan`;

CREATE TABLE `arrange_plan` (
                                `arrange_plan_id` varchar(100) NOT NULL COMMENT '主键',
                                `money` varchar(100) DEFAULT NULL COMMENT '金额',
                                `describes` varchar(100) DEFAULT NULL COMMENT '安排',
                                `principal_id` varchar(100) DEFAULT NULL COMMENT '负责人id',
                                `approver_id` varchar(100) DEFAULT NULL COMMENT '批准人id',
                                `date` datetime DEFAULT NULL COMMENT '日期',
                                `project_budget_id` varchar(100) DEFAULT NULL COMMENT '项目预算id',
                                `deleted` int DEFAULT '0' COMMENT '逻辑删除标识',
                                PRIMARY KEY (`arrange_plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `arrange_plan` */

/*Table structure for table `financial_progress` */

DROP TABLE IF EXISTS `financial_progress`;

CREATE TABLE `financial_progress` (
                                      `financial_progress_id` varchar(100) NOT NULL COMMENT '主键',
                                      `status` int DEFAULT '0' COMMENT '0 未申请 1 审批中 2 已下拨 3 未通过',
                                      `deleted` int DEFAULT '0' COMMENT '删除标识',
                                      PRIMARY KEY (`financial_progress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `financial_progress` */

/*Table structure for table `process_information` */

DROP TABLE IF EXISTS `process_information`;

CREATE TABLE `process_information` (
                                       `process_information_id` varchar(100) NOT NULL COMMENT '主键',
                                       `project_id` varchar(100) DEFAULT NULL COMMENT '项目id',
                                       `date` datetime DEFAULT NULL COMMENT '状态变更日期',
                                       `status` int DEFAULT '0' COMMENT '0 申请 1 立项成功 2立项失败 3 执行中 4 审批成功 4 审批失败 5 结题',
                                       `deleted` int DEFAULT '0' COMMENT '删除标识',
                                       PRIMARY KEY (`process_information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `process_information` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
                           `project_id` varchar(100) NOT NULL COMMENT '主键',
                           `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
                           `project_budget_id` varchar(100) DEFAULT NULL COMMENT '项目预算表id',
                           `project_category_id` varchar(100) DEFAULT NULL COMMENT '项目类型主键',
                           `financial_progress_id` varchar(100) DEFAULT NULL COMMENT '项目财务进度id',
                           `project_context_id` varchar(100) DEFAULT NULL COMMENT '项目内容',
                           `type` int DEFAULT NULL COMMENT '0 理论 1 实物',
                           `project_user_id` varchar(100) DEFAULT NULL COMMENT '项目负责人id',
                           `unit_id` varchar(100) DEFAULT NULL COMMENT '单位',
                           `approval_opinion_id` varchar(100) DEFAULT NULL COMMENT '项目立项意见id',
                           `create_date` datetime DEFAULT NULL COMMENT '项目创建时间',
                           `execute_status` int DEFAULT '0' COMMENT '0默认 1执行中 2结题成功 3结题失败',
                           `create_status` int DEFAULT '0' COMMENT '0创建 1申请中 2申请失败 3申请成功 4审批成功 5审批失败 6立项成功 7立项失败',
                           `deleted` int DEFAULT '0' COMMENT '删除标识0默认 1删除',
                           PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_name`,`project_budget_id`,`project_category_id`,`financial_progress_id`,`project_context_id`,`type`,`project_user_id`,`unit_id`,`approval_opinion_id`,`create_date`,`execute_status`,`create_status`,`deleted`) values
                                                                                                                                                                                                                                                                 ('1','体验课','1','1',NULL,NULL,1,'1','1',NULL,NULL,0,0,0),
                                                                                                                                                                                                                                                                 ('2','体格','2','2',NULL,NULL,1,'1','1',NULL,NULL,0,0,0),
                                                                                                                                                                                                                                                                 ('3','深度','3','2',NULL,NULL,1,'1','1',NULL,NULL,0,0,0),
                                                                                                                                                                                                                                                                 ('4','填入','4','3',NULL,NULL,NULL,'1','2',NULL,NULL,0,0,0),
                                                                                                                                                                                                                                                                 ('5','企鹅','5','2',NULL,NULL,NULL,'2','2',NULL,NULL,0,0,0);

/*Table structure for table `project_budget` */

DROP TABLE IF EXISTS `project_budget`;

CREATE TABLE `project_budget` (
                                  `project_budget_id` varchar(100) NOT NULL COMMENT '主键',
                                  `money` varchar(100) DEFAULT NULL COMMENT '总金额',
                                  `deleted` int DEFAULT '0' COMMENT '删除标识',
                                  `opinion_id` varchar(100) DEFAULT NULL COMMENT '建设单位负责人审核意见id',
                                  `date` date DEFAULT NULL COMMENT '日期',
                                  `describes` varchar(200) DEFAULT NULL COMMENT '项目预算描述',
                                  `status` int DEFAULT '0' COMMENT '0：默认，1：申请中 ，2：申请成功，3：申请失败，4：审批成功，5：审批失败',
                                  PRIMARY KEY (`project_budget_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project_budget` */

insert  into `project_budget`(`project_budget_id`,`money`,`deleted`,`opinion_id`,`date`,`describes`,`status`) values
                                                                                                                  ('1','200',0,'1','2022-09-14',NULL,1),
                                                                                                                  ('2','300',0,'2','2022-09-07',NULL,0),
                                                                                                                  ('3','566',0,'3','2022-09-04',NULL,0),
                                                                                                                  ('4','478',0,'4','2022-09-10',NULL,0);

/*Table structure for table `project_category` */

DROP TABLE IF EXISTS `project_category`;

CREATE TABLE `project_category` (
                                    `project_category_id` varchar(100) NOT NULL COMMENT '主键',
                                    `name` varchar(100) DEFAULT NULL COMMENT '名称',
                                    `deleted` int DEFAULT '0' COMMENT '删除标识',
                                    PRIMARY KEY (`project_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project_category` */

/*Table structure for table `project_context` */

DROP TABLE IF EXISTS `project_context`;

CREATE TABLE `project_context` (
                                   `project_context_id` varchar(100) NOT NULL COMMENT '主键',
                                   `name` varchar(100) DEFAULT NULL COMMENT '名称',
                                   `describes` varchar(100) DEFAULT NULL COMMENT '概述',
                                   `deleted` int DEFAULT '0' COMMENT '删除标识',
                                   PRIMARY KEY (`project_context_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project_context` */

/*Table structure for table `project_draft` */

DROP TABLE IF EXISTS `project_draft`;

CREATE TABLE `project_draft` (
                                 `project_draft_id` varchar(100) NOT NULL COMMENT '主键',
                                 `project_id` varchar(100) DEFAULT NULL COMMENT '项目外键',
                                 `project_category_id` varchar(100) DEFAULT NULL COMMENT '项目类别id',
                                 `project_user_id` varchar(100) DEFAULT NULL COMMENT '用户外键',
                                 `describes` varchar(100) DEFAULT NULL COMMENT '项目描述',
                                 `name` varchar(100) DEFAULT NULL COMMENT '项目名称',
                                 `type` int DEFAULT '0' COMMENT '0理论 1实物',
                                 `unit_id` varchar(100) DEFAULT NULL COMMENT '单位id',
                                 `create_date` datetime DEFAULT NULL COMMENT '草稿创建时间',
                                 `status` int DEFAULT '0' COMMENT '状态( 0 默认 1 提交 )',
                                 `deleted` int DEFAULT '0' COMMENT '删除标识( 0 默认 1 删除)',
                                 PRIMARY KEY (`project_draft_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project_draft` */

/*Table structure for table `project_file` */

DROP TABLE IF EXISTS `project_file`;

CREATE TABLE `project_file` (
                                `project_file_id` varchar(100) NOT NULL COMMENT '主键',
                                `project_draft_id` varchar(100) DEFAULT NULL COMMENT '项目草稿id',
                                `project_id` varchar(100) DEFAULT NULL COMMENT '项目id',
                                `type` int DEFAULT NULL COMMENT '文件类型 0 申报书草稿 1 项目申报书 2 项目任务书 3 项目正文 4 项目预算信息 5 项目设备信息 6 项目年度验收报告 7 项目中期验收报告 8 项目完结验收报告',
                                `path` varchar(100) DEFAULT NULL COMMENT '路径',
                                `date` datetime DEFAULT NULL COMMENT '日期',
                                `name` varchar(100) DEFAULT NULL COMMENT '名称',
                                `status` int DEFAULT NULL COMMENT '0创建 1申请成功 2申请失败 3待审核 4审批成功 5审批失败',
                                `deleted` int DEFAULT '0' COMMENT '删除标识',
                                PRIMARY KEY (`project_file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project_file` */

/*Table structure for table `project_process` */

DROP TABLE IF EXISTS `project_process`;

CREATE TABLE `project_process` (
                                   `project_process` varchar(100) NOT NULL COMMENT '主键',
                                   `project_id` varchar(100) DEFAULT NULL COMMENT '项目id',
                                   `date` datetime DEFAULT NULL COMMENT '状态变更日期',
                                   `execute_status` int DEFAULT '0' COMMENT '0默认 1执行中 2结题成功 3结题失败',
                                   `create_status` int DEFAULT '0' COMMENT '0创建 1申请中 2申请失败 3申请成功 4审批成功 5审批失败 6立项成功 7立项失败',
                                   `deleted` int DEFAULT '0' COMMENT '删除标识',
                                   PRIMARY KEY (`project_process`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project_process` */

/*Table structure for table `project_subject` */

DROP TABLE IF EXISTS `project_subject`;

CREATE TABLE `project_subject` (
                                   `project_subject_id` varchar(100) NOT NULL COMMENT '主键',
                                   `project_id` varchar(100) DEFAULT NULL COMMENT '项目id',
                                   `subject_id` varchar(100) DEFAULT NULL COMMENT '学科id',
                                   `project_dragt_id` varchar(100) DEFAULT NULL COMMENT '项目草稿id',
                                   PRIMARY KEY (`project_subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `project_subject` */

/*Table structure for table `specialist` */

DROP TABLE IF EXISTS `specialist`;

CREATE TABLE `specialist` (
                              `specialist_id` varchar(100) NOT NULL COMMENT '主键',
                              `specialty` varchar(100) DEFAULT NULL COMMENT '专业',
                              `school` varchar(100) DEFAULT NULL COMMENT '学校',
                              `rank` varchar(100) DEFAULT NULL COMMENT '职称',
                              `user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
                              PRIMARY KEY (`specialist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `specialist` */

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
                           `subject_id` varchar(100) NOT NULL COMMENT '主键',
                           `name` varchar(100) DEFAULT NULL COMMENT '名称',
                           `deleted` int DEFAULT '0' COMMENT '删除标识',
                           PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `subject` */

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `menu_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
                            `url` varchar(100) DEFAULT NULL COMMENT 'url',
                            `path` varchar(200) DEFAULT NULL COMMENT '路由地址',
                            `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
                            `keepAlive` tinyint(1) DEFAULT NULL COMMENT '是否保持激活（0不保存 1保持）',
                            `requireAuth` tinyint(1) DEFAULT '0' COMMENT '是否需要权限（0不需要 1需要）',
                            `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
                            `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用 0未启用1启用',
                            `del_flag` int DEFAULT '0' COMMENT '是否删除（0未删除 1已删除）',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menu_name`,`url`,`path`,`component`,`keepAlive`,`requireAuth`,`icon`,`enabled`,`del_flag`,`remark`) values
                                                                                                                                      (1,'查看全部项目材料列表','/Build/ProjectFile/Unit/List/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (2,'按条件查看项目材料列表','/Build/Project/Unit/Status/List/*',NULL,NULL,1,0,'#',1,0,NULL),
                                                                                                                                      (3,'查看项目材料','/Build/Project/Id/Info/*',NULL,NULL,1,0,'#',1,0,NULL),
                                                                                                                                      (4,'审核项目申报','/Build/Project/Id/Update/*',NULL,NULL,1,0,'#',1,0,NULL),
                                                                                                                                      (5,'填写原因通知','/Build/Notification/Insert/*',NULL,NULL,1,0,'#',1,0,NULL),
                                                                                                                                      (6,'删除项目申请','/Build/Project/Id/Delete',NULL,NULL,1,0,'#',1,0,NULL),
                                                                                                                                      (7,'查看审批意见','/Build/ApprovalOpinion/User/Info/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (8,'填写审批意见','/Build/ApprovalOpinion/Insert/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (9,'查看学科列表','/Build/Subject/List/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (10,'申请项目','/Build/Project/Insert/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (11,'查看项目草稿','/Build/ProjectDaft/Project/Info/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (12,'新建项目草稿','/Build/ProjectDaft/Project/Insert/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (13,'修改项目草稿','/Build/ProjectDaft/Id/Update/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (14,'删除项目草稿','/Build/ProjectDaft/Id/Delete/*',NULL,NULL,NULL,0,'#',1,0,NULL),
                                                                                                                                      (15,'查看项目列表','/Build/User/List/*',NULL,NULL,NULL,0,'#',1,0,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `name` varchar(128) DEFAULT NULL,
                            `role_key` varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
                            `enabled` tinyint(1) DEFAULT '1' COMMENT '角色状态（1正常 0停用）',
                            `del_flag` tinyint(1) DEFAULT '0' COMMENT 'del_flag',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`role_key`,`enabled`,`del_flag`,`remark`) values
                                                                                  (1,'单位管理员','build_admin',1,0,NULL),
                                                                                  (2,'单位负责人','build_principal',1,0,NULL),
                                                                                  (3,'项目负责人','project_principal',1,0,NULL),
                                                                                  (4,'归口部门管理员','centralized_admin',1,0,NULL),
                                                                                  (5,'归口部门负责人','centralized_principal',1,0,NULL),
                                                                                  (6,'总体协调部门管理员','overallCoordination_admin',1,0,NULL),
                                                                                  (7,'总体协调部门负责人','overallCoordination_principal',1,0,NULL),
                                                                                  (8,'财务人员','logistics',1,0,NULL);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
                                 `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                                 `menu_id` bigint NOT NULL DEFAULT '0' COMMENT '菜单id',
                                 PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values
                                                      (1,1),
                                                      (1,2),
                                                      (1,3),
                                                      (1,4),
                                                      (1,5),
                                                      (1,6),
                                                      (2,1),
                                                      (2,2),
                                                      (2,3),
                                                      (2,4),
                                                      (2,5),
                                                      (2,7),
                                                      (2,8),
                                                      (3,3),
                                                      (3,9),
                                                      (3,10),
                                                      (3,11),
                                                      (3,12),
                                                      (3,13),
                                                      (3,14),
                                                      (3,15);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `user_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
                            `nick_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
                            `password` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
                            `enabled` tinyint(1) DEFAULT '1' COMMENT '账号状态（1正常 0停用）',
                            `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
                            `phonenumber` varchar(32) DEFAULT NULL COMMENT '手机号',
                            `sex` char(1) DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
                            `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
                            `user_type` char(1) NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
                            `create_by` bigint DEFAULT NULL COMMENT '创建人的用户id',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` bigint DEFAULT NULL COMMENT '更新人',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_name`,`nick_name`,`password`,`enabled`,`email`,`phonenumber`,`sex`,`avatar`,`user_type`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`) values
                                                                                                                                                                                               (1,'zzx','zzx','$2a$10$zWo...Ydhg/t3j5t.3PbxehsrUyA0Mn/ix6ZitcVv.73rfNO8aSgy',1,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,0),
                                                                                                                                                                                               (2,'zs','张三','$2a$10$KndPjY6vkN16sQdt0HFIgOFcKI51cpwfsBniieyCsF6zImwi6XvzG',1,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
                                 `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
                                 `role_id` bigint NOT NULL DEFAULT '0' COMMENT '角色id',
                                 PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values
                                                      (1,1),
                                                      (2,3);

/*Table structure for table `unit` */

DROP TABLE IF EXISTS `unit`;

CREATE TABLE `unit` (
                        `unit_id` varchar(100) NOT NULL COMMENT '主键',
                        `unit_user_id` varchar(100) DEFAULT NULL COMMENT '单位负责人',
                        `unit_name` varchar(100) DEFAULT NULL COMMENT '名称',
                        `deleted` int DEFAULT '0' COMMENT '删除标识',
                        PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `unit` */

insert  into `unit`(`unit_id`,`unit_user_id`,`unit_name`,`deleted`) values
                                                                        ('1','1','软件学院',0),
                                                                        ('2','2','体育学院',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
