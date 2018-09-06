DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(128) DEFAULT NULL COMMENT '内容',
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `level` varchar(16) DEFAULT NULL COMMENT '推荐星级',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL COMMENT '问题ID',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_question_idx` (`question_id`),
  CONSTRAINT `fk_question_answer` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_quiz`;
CREATE TABLE `t_quiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL COMMENT '问题ID',
  `answer_id` int(11) NOT NULL COMMENT '参考答案ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `answer` varchar(1024) DEFAULT NULL COMMENT '回答',
  `score` varchar(32) DEFAULT NULL COMMENT '打分',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_question_idx` (`question_id`),
  CONSTRAINT `fk_question` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `fk_answer_idx` (`answer_id`),
  CONSTRAINT `fk_answer_quiz` FOREIGN KEY (`answer_id`) REFERENCES `t_answer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_user_quiz` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quiz_id` int(11) NOT NULL COMMENT '测试ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_quiz_idx` (`quiz_id`),
  CONSTRAINT `fk_quiz_exam` FOREIGN KEY (`quiz_id`) REFERENCES `t_quiz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_user_exam` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_my_favourite`;
CREATE TABLE `t_my_favourite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL COMMENT '问题ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_question_idx` (`question_id`),
  CONSTRAINT `fk_question_favourite` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_user_favourite` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

