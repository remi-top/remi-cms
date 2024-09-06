/*
 Navicat Premium Dump SQL

 Source Server         : remi-vip
 Source Server Type    : MySQL
 Source Server Version : 80100 (8.1.0)
 Source Host           : 192.168.31.200:30636
 Source Schema         : dev-remi-cms

 Target Server Type    : MySQL
 Target Server Version : 80100 (8.1.0)
 File Encoding         : 65001

 Date: 06/09/2024 22:52:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `type_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类ID',
  `type_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类编码',
  `article_type` int NOT NULL COMMENT '文章类型（1原创 2转载 3翻译）',
  `article_title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `article_sub_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章副标题',
  `article_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章内容',
  `article_summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章摘要',
  `article_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章路径',
  `article_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章封面图',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '文章发布时间',
  `is_comment` int NULL DEFAULT NULL COMMENT '是否评论（0关闭 1开启）',
  `is_recommend` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否推荐（0关闭 1开启）',
  `sort` int NULL DEFAULT NULL COMMENT '分类排序',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0草稿 1发布）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章内容' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_article
-- ----------------------------
INSERT INTO `cms_article` VALUES ('1832011268128260097', '1832008756373504001', '技术框架', 1, '11', '1', '<p>111</p>', '111', '', '', NULL, 1, '0', NULL, 0, NULL, NULL, '7208565987619246080', '1810715183884599298', '7212873250467090432', '2024-09-06 19:01:38', '7212873250467090432', '2024-09-06 21:58:18');
INSERT INTO `cms_article` VALUES ('1832054330363756545', '1832008756373504001', '技术框架', 1, '11', '111', '<p>111</p>', '111', '', '', NULL, 1, '0', NULL, 1, NULL, NULL, '7208565987619246080', '1810715183884599298', '7212873250467090432', '2024-09-06 21:52:45', '7212873250467090432', '2024-09-06 21:52:44');

-- ----------------------------
-- Table structure for cms_image
-- ----------------------------
DROP TABLE IF EXISTS `cms_image`;
CREATE TABLE `cms_image`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `type_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类ID',
  `type_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类编码',
  `file_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件ID',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名称',
  `file_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件类型',
  `image_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片名称',
  `image_size` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片大小',
  `image_url` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预览地址',
  `link_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接地址',
  `cdn_url` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'CDN地址',
  `width` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片宽',
  `height` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片高',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图片管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_image
-- ----------------------------

-- ----------------------------
-- Table structure for cms_keep
-- ----------------------------
DROP TABLE IF EXISTS `cms_keep`;
CREATE TABLE `cms_keep`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `bind_type` int NULL DEFAULT NULL COMMENT '关联类型（1文章 2图片 3视频）',
  `bind_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表ID',
  `bind_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表编码',
  `user_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '收藏记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_keep
-- ----------------------------

-- ----------------------------
-- Table structure for cms_leave
-- ----------------------------
DROP TABLE IF EXISTS `cms_leave`;
CREATE TABLE `cms_leave`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `parent_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级ID',
  `bind_type` int NULL DEFAULT NULL COMMENT '关联类型（1文章 2图片 3视频）',
  `bind_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表ID',
  `bind_code` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表编码',
  `leave_type` int NULL DEFAULT NULL COMMENT '是否审核（1评论 2留言 3建议 4反馈）',
  `leave_content` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `user_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名称',
  `phone` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `status` int NULL DEFAULT NULL COMMENT '是否审核（0未审 1审核）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_leave
-- ----------------------------

-- ----------------------------
-- Table structure for cms_like
-- ----------------------------
DROP TABLE IF EXISTS `cms_like`;
CREATE TABLE `cms_like`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `bind_type` int NULL DEFAULT NULL COMMENT '关联类型（1文章 2图片 3视频）',
  `bind_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表ID',
  `bind_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表编码',
  `user_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '点赞记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_like
-- ----------------------------

-- ----------------------------
-- Table structure for cms_link
-- ----------------------------
DROP TABLE IF EXISTS `cms_link`;
CREATE TABLE `cms_link`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `link_type` int NULL DEFAULT NULL COMMENT '链接类型',
  `link_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网站名称',
  `link_name_en` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网站英文名称',
  `link_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网站链接',
  `link_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司描述',
  `link_remark_en` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司英文描述',
  `sort` int NULL DEFAULT NULL COMMENT '网站排序',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '友情链接' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_link
-- ----------------------------

-- ----------------------------
-- Table structure for cms_notice
-- ----------------------------
DROP TABLE IF EXISTS `cms_notice`;
CREATE TABLE `cms_notice`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `notice_type` int NULL DEFAULT NULL COMMENT '通知类型',
  `notice_icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '通知图标',
  `notice_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '通知内容',
  `notice_content_en` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '通知英文内容',
  `link_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接地址',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '通知公告' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_notice
-- ----------------------------

-- ----------------------------
-- Table structure for cms_repost
-- ----------------------------
DROP TABLE IF EXISTS `cms_repost`;
CREATE TABLE `cms_repost`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `bind_type` int NULL DEFAULT NULL COMMENT '关联类型（1文章 2图片 3视频）',
  `bind_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表ID',
  `bind_code` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表编码',
  `user_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '转发记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_repost
-- ----------------------------

-- ----------------------------
-- Table structure for cms_tag
-- ----------------------------
DROP TABLE IF EXISTS `cms_tag`;
CREATE TABLE `cms_tag`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `tag_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签编码',
  `tag_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签名称',
  `tag_name_en` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签英文名称',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '标签管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_tag
-- ----------------------------
INSERT INTO `cms_tag` VALUES ('1832008923210334210', 'JAVA', 'JAVA', 'JAVA', 1, NULL, NULL, '7208565987619246080', '1810715183884599298', '7212873250467090432', '2024-09-06 18:52:19', '7212873250467090432', '2024-09-06 18:52:19');
INSERT INTO `cms_tag` VALUES ('1832014075732443137', NULL, '11', NULL, 1, NULL, NULL, '7208565987619246080', '1810715183884599298', '7212873250467090432', '2024-09-06 19:12:47', '7212873250467090432', '2024-09-06 19:12:47');

-- ----------------------------
-- Table structure for cms_tag_bind
-- ----------------------------
DROP TABLE IF EXISTS `cms_tag_bind`;
CREATE TABLE `cms_tag_bind`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `tag_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签ID',
  `tag_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签编码',
  `bind_type` int NULL DEFAULT NULL COMMENT '关联类型（1文章 2图片 3视频）',
  `bind_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联ID',
  `bind_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联编码',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '标签绑定' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_tag_bind
-- ----------------------------

-- ----------------------------
-- Table structure for cms_type
-- ----------------------------
DROP TABLE IF EXISTS `cms_type`;
CREATE TABLE `cms_type`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `parent_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级分类',
  `type_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类编码',
  `type_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名称',
  `type_name_en` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类英文名称',
  `type_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类图标',
  `sort` int NULL DEFAULT NULL COMMENT '分类排序',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_type
-- ----------------------------
INSERT INTO `cms_type` VALUES ('1832008756373504001', '0', '技术框架', '技术框架', '技术框架', NULL, 1, 1, NULL, NULL, '7208565987619246080', '1810715183884599298', '7212873250467090432', '2024-09-06 18:51:39', '7212873250467090432', '2024-09-06 18:52:09');
INSERT INTO `cms_type` VALUES ('1832009009927569409', '1832008756373504001', '后端框架', '后端框架', '后端框架', NULL, 1, 1, NULL, NULL, '7208565987619246080', '1810715183884599298', '7212873250467090432', '2024-09-06 18:52:40', '7212873250467090432', '2024-09-06 18:52:39');

-- ----------------------------
-- Table structure for cms_video
-- ----------------------------
DROP TABLE IF EXISTS `cms_video`;
CREATE TABLE `cms_video`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `type_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类ID',
  `type_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类编码',
  `file_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件ID',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名称',
  `file_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件类型',
  `video_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频名称',
  `video_size` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频大小',
  `video_url` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '播放地址',
  `thumbnail` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缩略图',
  `resolution` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分辨率',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '视频管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_video
-- ----------------------------

-- ----------------------------
-- Table structure for cms_view
-- ----------------------------
DROP TABLE IF EXISTS `cms_view`;
CREATE TABLE `cms_view`  (
  `id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `bind_type` int NULL DEFAULT NULL COMMENT '关联类型（1文章 2图片 3视频）',
  `bind_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表ID',
  `bind_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联表编码',
  `user_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
  `status` int NULL DEFAULT NULL COMMENT '是否启用（0停用 1启用）',
  `deleted` int NULL DEFAULT NULL COMMENT '是否删除（0正常 1删除）',
  `revision` int NULL DEFAULT NULL COMMENT '乐观锁',
  `dept_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门租户ID',
  `company_tenant_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司租户ID',
  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '在看记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_view
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
