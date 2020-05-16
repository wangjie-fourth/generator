CREATE TABLE `table_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `column_a` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '字符',
  `column_b` int(20) COLLATE utf8_bin NOT NULL COMMENT '整型',
  `column_c` tinyint(4) COLLATE utf8_bin NOT NULL COMMENT '短整型',

  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='测试表';