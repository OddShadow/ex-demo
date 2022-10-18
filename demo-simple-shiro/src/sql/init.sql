INSERT INTO `user_info` (`id`,`name`,`password`,`salt`,`username`) VALUES (1, '管理员','951cd60dec2104024949d2e0b2af45ae', 'xbNIxrQfn6COSYn1/GdloA==', 'wmyskxz');
INSERT INTO `sys_permission` (`id`,`description`,`name`,`url`) VALUES (1,'查询用户','userInfo:view','/userList');
INSERT INTO `sys_permission` (`id`,`description`,`name`,`url`) VALUES (2,'增加用户','userInfo:add','/userAdd');
INSERT INTO `sys_permission` (`id`,`description`,`name`,`url`) VALUES (3,'删除用户','userInfo:delete','/userDelete');
INSERT INTO `sys_role` (`id`,`description`,`name`) VALUES (1,'管理员','admin');
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `sys_user_role` (`role_id`,`uid`) VALUES (1,1);