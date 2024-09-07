DROP TABLE IF EXISTS cms_tag;
CREATE TABLE cms_tag(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    tag_code VARCHAR(64)    COMMENT '标签编码' ,
    tag_name VARCHAR(128)    COMMENT '标签名称' ,
    tag_name_en VARCHAR(128)    COMMENT '标签英文名称' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '标签管理';

DROP TABLE IF EXISTS cms_tag_bind;
CREATE TABLE cms_tag_bind(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    tag_id VARCHAR(19)    COMMENT '标签ID' ,
    tag_code VARCHAR(64)    COMMENT '标签编码' ,
    bind_type INT    COMMENT '关联类型（1文章 2图片 3视频 4音频 5产品）' ,
    bind_id VARCHAR(19)    COMMENT '关联ID' ,
    bind_code VARCHAR(64)    COMMENT '关联编码' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '标签绑定';

DROP TABLE IF EXISTS cms_article_type;
CREATE TABLE cms_article_type(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    parent_id VARCHAR(19)    COMMENT '父级分类' ,
    type_code VARCHAR(64)    COMMENT '分类编码' ,
    type_name VARCHAR(128)    COMMENT '分类名称' ,
    type_name_en VARCHAR(128)    COMMENT '分类英文名称' ,
    type_remark VARCHAR(255)    COMMENT '分类描述' ,
    type_remark_en VARCHAR(255)    COMMENT '分类英文描述' ,
    type_icon VARCHAR(255)    COMMENT '分类图标' ,
    sort INT    COMMENT '分类排序' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '文章分类';

DROP TABLE IF EXISTS cms_article;
CREATE TABLE cms_article(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    type_id VARCHAR(19) NOT NULL   COMMENT '分类ID' ,
    type_code VARCHAR(64) NOT NULL   COMMENT '分类编码' ,
    article_type INT    COMMENT '文章类型（1原创 2转载 3翻译）' ,
    article_title VARCHAR(128)    COMMENT '文章标题' ,
    article_title_en VARCHAR(128)    COMMENT '文章英文标题' ,
    article_sub_title VARCHAR(255)    COMMENT '文章副标题' ,
    article_sub_title_en VARCHAR(255)    COMMENT '文章英文副标题' ,
    article_content TEXT    COMMENT '文章内容' ,
    article_content_en TEXT    COMMENT '文章英文内容' ,
    article_summary VARCHAR(255)    COMMENT '文章摘要' ,
    article_summary_en VARCHAR(255)    COMMENT '文章英文摘要' ,
    article_url VARCHAR(255)    COMMENT '文章路径' ,
    article_image VARCHAR(255)    COMMENT '文章封面图' ,
    publish_time DATETIME    COMMENT '文章发布时间' ,
    is_comment INT    COMMENT '是否评论（0关闭 1开启）' ,
    is_recommend VARCHAR(19)    COMMENT '是否推荐（0关闭 1开启）' ,
    sort INT    COMMENT '分类排序' ,
    status INT    COMMENT '是否启用（0草稿 1发布）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '文章内容';

DROP TABLE IF EXISTS cms_content_like;
CREATE TABLE cms_content_like(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    bind_type INT    COMMENT '关联类型（1文章 2图片 3视频）' ,
    bind_id VARCHAR(19)    COMMENT '关联表ID' ,
    bind_code VARCHAR(64)    COMMENT '关联表编码' ,
    user_id VARCHAR(19)    COMMENT '用户ID' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '点赞记录';

DROP TABLE IF EXISTS cms_content_comment;
CREATE TABLE cms_content_comment(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    parent_id VARCHAR(19)    COMMENT '父级ID' ,
    bind_type INT    COMMENT '关联类型（1文章 2图片 3视频）' ,
    bind_id VARCHAR(19)    COMMENT '关联表ID' ,
    bind_code VARCHAR(19)    COMMENT '关联表编码' ,
    content VARCHAR(19)    COMMENT '评论内容' ,
    user_id VARCHAR(19)    COMMENT '用户ID' ,
    user_name VARCHAR(64)    COMMENT '用户名称' ,
    user_avatar VARCHAR(255)    COMMENT '用户头像' ,
    phone VARCHAR(128)    COMMENT '联系电话' ,
    email VARCHAR(128)    COMMENT '联系邮箱' ,
    status INT    COMMENT '是否审核（0未审 1审核）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '评论记录';

DROP TABLE IF EXISTS cms_storage;
CREATE TABLE cms_storage(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    file_code VARCHAR(64)    COMMENT '文件编码' ,
    file_name VARCHAR(255)    COMMENT '文件名称' ,
    file_type VARCHAR(64)    COMMENT '文件类型' ,
    file_path VARCHAR(255)    COMMENT '存储路径' ,
    file_size VARCHAR(64)    COMMENT '图片大小' ,
    access_level INT    COMMENT '访问级别（1Public 2Private）' ,
    mime_type VARCHAR(128)    COMMENT 'MIME类型，用于存储文件的MIME类型（例如“application/pdf”）' ,
    width INT    COMMENT '图片宽度，用于存储图片的宽度（像素）。' ,
    height INT    COMMENT '图片高度，用于存储图片的高度（像素）。' ,
    thumbnail VARCHAR(255)    COMMENT '缩略图路径，用于显示文件的缩略图（适用于图片和视频）。' ,
    resolution VARCHAR(64)    COMMENT '分辨率，用于存储图片或视频的分辨率（例如“1920x1080”）。' ,
    duration INT    COMMENT '持续时间，用于存储音频或视频的持续时间（秒）。' ,
    sample INT    COMMENT '音频采样率，用于存储音频的采样率（Hz）。' ,
    bitrate INT    COMMENT '音频比特率，用于存储音频的比特率（kbps）' ,
    channels INT    COMMENT '音频通道数，用于存储音频的通道数（单声道或多声道）。' ,
    checksum VARCHAR(255)    COMMENT '文件校验和，用于验证文件完整性（例如MD5或SHA-256）。' ,
    uploader VARCHAR(19)    COMMENT '上传者ID，外键，关联到 users 表。' ,
    metadata JSON    COMMENT '其他元数据，可以是JSON格式，用于存储额外的信息。' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '文件资源';

DROP TABLE IF EXISTS cms_storage_type;
CREATE TABLE cms_storage_type(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    type_code VARCHAR(64)    COMMENT '分类编码' ,
    type_name VARCHAR(128)    COMMENT '分类名称' ,
    type_name_en VARCHAR(128)    COMMENT '分类英文名称' ,
    type_icon VARCHAR(255)    COMMENT '分类图标' ,
    type_remark VARCHAR(255)    COMMENT '分类描述' ,
    sort INT    COMMENT '分类排序' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '资源分类';

DROP TABLE IF EXISTS cms_notice;
CREATE TABLE cms_notice(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    notice_icon VARCHAR(64)    COMMENT '公告图标' ,
    notice_title VARCHAR(19)    COMMENT '公告标题' ,
    notice_content TEXT    COMMENT '公告内容' ,
    notice_content_en TEXT    COMMENT '公告英文内容' ,
    views VARCHAR(19)    COMMENT '浏览次数' ,
    priority INT    COMMENT '优先级（1低 2中 3高）' ,
    pinned INT    COMMENT '是否置顶（0正常 1置顶）' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    expires_at DATETIME    COMMENT '到期时间' ,
    publish_at DATETIME    COMMENT '发布时间' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '通知公告';

DROP TABLE IF EXISTS cms_section;
CREATE TABLE cms_section(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    parent_id VARCHAR(255)    COMMENT '父栏目ID' ,
    section_code VARCHAR(64)    COMMENT '栏目编码' ,
    section_name VARCHAR(128)    COMMENT '栏目名称' ,
    section_name_en VARCHAR(128)    COMMENT '栏目英文名称' ,
    section_type INT    COMMENT '栏目类型（1首页 2聚合页 3列表页 4内容页 5单页 6外链）' ,
    section_icon VARCHAR(255)    COMMENT '栏目图标' ,
    section_remark VARCHAR(255)    COMMENT '栏目描述' ,
    sort INT    COMMENT '显示顺序' ,
    open INT    COMMENT '弹出方式（0当前窗口block 1新窗口_blank）' ,
    visible INT    COMMENT '导航显示（0隐藏 1显示）' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0可用 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '栏目管理';

DROP TABLE IF EXISTS cms_carousel;
CREATE TABLE cms_carousel(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    carousel_type INT    COMMENT '轮播类型（1图片 2视频）' ,
    storage_url VARCHAR(255)    COMMENT '资源路径或外部链接' ,
    target_url VARCHAR(255)    COMMENT '点击后跳转地址' ,
    carousel_title VARCHAR(128)    COMMENT '轮播标题' ,
    carousel_title_en VARCHAR(128)    COMMENT '轮播标题英文' ,
    carousel_sub_title VARCHAR(255)    COMMENT '轮播副标题' ,
    carousel_sub_title_en VARCHAR(255)    COMMENT '轮播副标题英文' ,
    carousel_remark VARCHAR(255)    COMMENT '轮播描述' ,
    carousel_remark_en VARCHAR(255)    COMMENT '轮播描述英文' ,
    sort INT    COMMENT '轮播排序' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '轮播管理';

DROP TABLE IF EXISTS cms_message;
CREATE TABLE cms_message(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    name VARCHAR(128)    COMMENT '留言者姓名' ,
    email VARCHAR(128)    COMMENT '留言者邮箱' ,
    phone VARCHAR(64)    COMMENT '留言者电话' ,
    subject VARCHAR(255)    COMMENT '留言的主题' ,
    message TEXT    COMMENT '留言的内容' ,
    ip_address VARCHAR(64)    COMMENT '留言者的IP地址' ,
    user_agent VARCHAR(255)    COMMENT '留言者的浏览器' ,
    form_id VARCHAR(19)    COMMENT '关联的表单ID' ,
    submission JSON    COMMENT '提交的动态数据，可以使用 JSON 格式存储。' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '留言记录';

DROP TABLE IF EXISTS cms_link;
CREATE TABLE cms_link(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    link_type INT    COMMENT '链接类型' ,
    link_name VARCHAR(255)    COMMENT '网站名称' ,
    link_name_en VARCHAR(255)    COMMENT '网站英文名称' ,
    link_url VARCHAR(255)    COMMENT '网站链接' ,
    link_remark VARCHAR(255)    COMMENT '公司描述' ,
    link_remark_en VARCHAR(255)    COMMENT '公司英文描述' ,
    sort INT    COMMENT '网站排序' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '友情链接';

DROP TABLE IF EXISTS cms_config;
CREATE TABLE cms_config(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    type VARCHAR(19)    COMMENT '配置项类型（1基础配置 2邮件配置 3存储配置 4主题信息 5插件配置 6客服配置 99其他配置）' ,
    code VARCHAR(128)    COMMENT '配置项编码' ,
    name VARCHAR(128)    COMMENT '配置项名称' ,
    value VARCHAR(255)    COMMENT '配置项的值' ,
    status INT    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT    COMMENT '是否删除（0正常 1删除）' ,
    revision INT    COMMENT '乐观锁' ,
    dept_tenant_id VARCHAR(19)    COMMENT '部门租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '全局配置';

