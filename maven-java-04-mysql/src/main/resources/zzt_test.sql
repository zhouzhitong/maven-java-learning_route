/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.4.31_3306
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 192.168.4.31:3306
 Source Schema         : zzt_test

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 13/10/2020 16:30:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `caption` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade_id` int(11) NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `grade_id`(`grade_id`) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`grade_id`) REFERENCES `class_grade` (`gid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '一年一班', 1);
INSERT INTO `class` VALUES (2, '一年二班', 1);
INSERT INTO `class` VALUES (3, '一年三班', 1);
INSERT INTO `class` VALUES (4, '一年四班', 1);
INSERT INTO `class` VALUES (5, '一年五班', 1);
INSERT INTO `class` VALUES (6, '二年一班', 2);
INSERT INTO `class` VALUES (7, '二年二班', 2);
INSERT INTO `class` VALUES (8, '三年一班', 3);
INSERT INTO `class` VALUES (9, '三年二班', 3);
INSERT INTO `class` VALUES (10, '四年一班', 4);
INSERT INTO `class` VALUES (11, '四年二班', 4);
INSERT INTO `class` VALUES (12, '五年一班', 5);

-- ----------------------------
-- Table structure for class_grade
-- ----------------------------
DROP TABLE IF EXISTS `class_grade`;
CREATE TABLE `class_grade`  (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`gid`) USING BTREE,
  UNIQUE INDEX `gname`(`gname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_grade
-- ----------------------------
INSERT INTO `class_grade` VALUES (1, '一年级');
INSERT INTO `class_grade` VALUES (3, '三年级');
INSERT INTO `class_grade` VALUES (2, '二年级');
INSERT INTO `class_grade` VALUES (5, '五年级');
INSERT INTO `class_grade` VALUES (4, '四年级');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '生物', 1);
INSERT INTO `course` VALUES (2, '体育', 1);
INSERT INTO `course` VALUES (3, '物理', 2);
INSERT INTO `course` VALUES (4, '化学', 3);
INSERT INTO `course` VALUES (5, '美术', 4);
INSERT INTO `course` VALUES (6, '音乐', 2);
INSERT INTO `course` VALUES (7, '语文', 3);
INSERT INTO `course` VALUES (8, '数学', 4);
INSERT INTO `course` VALUES (9, '地理', 2);
INSERT INTO `course` VALUES (10, '研究', 1);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`student_id`, `course_id`) USING BTREE,
  UNIQUE INDEX `sid`(`sid`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 1, 60);
INSERT INTO `score` VALUES (2, 1, 2, 59);
INSERT INTO `score` VALUES (3, 1, 3, 58);
INSERT INTO `score` VALUES (4, 1, 4, 22);
INSERT INTO `score` VALUES (5, 1, 5, 59);
INSERT INTO `score` VALUES (6, 1, 6, 60);
INSERT INTO `score` VALUES (7, 1, 7, 99);
INSERT INTO `score` VALUES (8, 1, 8, 100);
INSERT INTO `score` VALUES (9, 1, 9, 88);
INSERT INTO `score` VALUES (10, 2, 1, 99);
INSERT INTO `score` VALUES (11, 2, 2, 99);
INSERT INTO `score` VALUES (12, 2, 3, 89);
INSERT INTO `score` VALUES (13, 2, 4, 60);
INSERT INTO `score` VALUES (14, 2, 5, 59);
INSERT INTO `score` VALUES (15, 2, 6, 33);
INSERT INTO `score` VALUES (16, 2, 7, 56);
INSERT INTO `score` VALUES (17, 2, 8, 59);
INSERT INTO `score` VALUES (18, 2, 9, 60);
INSERT INTO `score` VALUES (19, 3, 1, 59);
INSERT INTO `score` VALUES (20, 3, 3, 30);
INSERT INTO `score` VALUES (21, 3, 5, 28);
INSERT INTO `score` VALUES (22, 3, 7, 70);
INSERT INTO `score` VALUES (23, 3, 9, 60);
INSERT INTO `score` VALUES (24, 4, 2, 59);
INSERT INTO `score` VALUES (25, 4, 4, 100);
INSERT INTO `score` VALUES (26, 4, 6, 90);
INSERT INTO `score` VALUES (27, 4, 8, 80);
INSERT INTO `score` VALUES (28, 4, 10, 88);
INSERT INTO `score` VALUES (29, 5, 1, 59);
INSERT INTO `score` VALUES (30, 5, 2, 33);
INSERT INTO `score` VALUES (31, 5, 3, 12);
INSERT INTO `score` VALUES (32, 5, 4, 88);
INSERT INTO `score` VALUES (33, 6, 1, 60);
INSERT INTO `score` VALUES (34, 6, 3, 99);
INSERT INTO `score` VALUES (35, 6, 5, 100);
INSERT INTO `score` VALUES (36, 6, 6, 60);
INSERT INTO `score` VALUES (37, 6, 7, 59);
INSERT INTO `score` VALUES (38, 6, 8, 100);
INSERT INTO `score` VALUES (39, 6, 9, 88);
INSERT INTO `score` VALUES (41, 7, 1, 36);
INSERT INTO `score` VALUES (42, 7, 3, 57);
INSERT INTO `score` VALUES (43, 7, 5, 60);
INSERT INTO `score` VALUES (44, 7, 8, 60);
INSERT INTO `score` VALUES (40, 7, 9, 20);
INSERT INTO `score` VALUES (45, 7, 10, 60);
INSERT INTO `score` VALUES (46, 8, 2, 61);
INSERT INTO `score` VALUES (47, 8, 4, 59);
INSERT INTO `score` VALUES (48, 8, 6, 62);
INSERT INTO `score` VALUES (50, 9, 1, 60);
INSERT INTO `score` VALUES (51, 9, 2, 61);
INSERT INTO `score` VALUES (52, 9, 3, 21);
INSERT INTO `score` VALUES (49, 9, 8, 59);
INSERT INTO `score` VALUES (53, 10, 1, 70);
INSERT INTO `score` VALUES (54, 10, 3, 88);
INSERT INTO `score` VALUES (55, 10, 5, 68);
INSERT INTO `score` VALUES (56, 10, 9, 99);
INSERT INTO `score` VALUES (57, 11, 1, 89);
INSERT INTO `score` VALUES (58, 11, 7, 99);
INSERT INTO `score` VALUES (59, 12, 3, 100);
INSERT INTO `score` VALUES (60, 12, 8, 60);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` enum('女','男') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '女',
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '孙尚香', '女', 1);
INSERT INTO `student` VALUES (2, '貂蝉', '女', 1);
INSERT INTO `student` VALUES (3, '刘备', '男', 2);
INSERT INTO `student` VALUES (4, '孙二娘', '女', 2);
INSERT INTO `student` VALUES (5, '张飞', '男', 3);
INSERT INTO `student` VALUES (6, '关羽', '男', 4);
INSERT INTO `student` VALUES (7, '林黛玉', '女', 5);
INSERT INTO `student` VALUES (8, '薛宝钗', '女', 6);
INSERT INTO `student` VALUES (9, '宋江', '男', 6);
INSERT INTO `student` VALUES (10, '白骨精', '女', 7);
INSERT INTO `student` VALUES (11, '猪八戒', '男', 8);
INSERT INTO `student` VALUES (12, '王熙凤', '女', 1);
INSERT INTO `student` VALUES (13, '李师师', '女', 2);
INSERT INTO `student` VALUES (14, '金翠莲', '女', 9);
INSERT INTO `student` VALUES (15, '如花', '女', 1);
INSERT INTO `student` VALUES (16, '沙僧', '男', 2);
INSERT INTO `student` VALUES (17, '李美丽', '女', 3);
INSERT INTO `student` VALUES (18, '金角大王', '男', 4);

-- ----------------------------
-- Table structure for teach2cls
-- ----------------------------
DROP TABLE IF EXISTS `teach2cls`;
CREATE TABLE `teach2cls`  (
  `tcid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`tid`, `cid`) USING BTREE,
  UNIQUE INDEX `tcid`(`tcid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `teach2cls_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teach2cls_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `class` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teach2cls
-- ----------------------------
INSERT INTO `teach2cls` VALUES (1, 1, 1);
INSERT INTO `teach2cls` VALUES (2, 1, 2);
INSERT INTO `teach2cls` VALUES (3, 1, 3);
INSERT INTO `teach2cls` VALUES (4, 1, 5);
INSERT INTO `teach2cls` VALUES (5, 2, 4);
INSERT INTO `teach2cls` VALUES (6, 2, 6);
INSERT INTO `teach2cls` VALUES (7, 2, 8);
INSERT INTO `teach2cls` VALUES (8, 2, 9);
INSERT INTO `teach2cls` VALUES (9, 2, 1);
INSERT INTO `teach2cls` VALUES (10, 2, 5);
INSERT INTO `teach2cls` VALUES (11, 3, 7);
INSERT INTO `teach2cls` VALUES (12, 3, 1);
INSERT INTO `teach2cls` VALUES (13, 3, 3);
INSERT INTO `teach2cls` VALUES (14, 3, 5);
INSERT INTO `teach2cls` VALUES (15, 3, 9);
INSERT INTO `teach2cls` VALUES (16, 4, 7);
INSERT INTO `teach2cls` VALUES (17, 4, 2);
INSERT INTO `teach2cls` VALUES (18, 4, 4);
INSERT INTO `teach2cls` VALUES (19, 4, 6);
INSERT INTO `teach2cls` VALUES (20, 4, 8);
INSERT INTO `teach2cls` VALUES (21, 4, 1);
INSERT INTO `teach2cls` VALUES (22, 1, 12);
INSERT INTO `teach2cls` VALUES (23, 2, 12);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张三');
INSERT INTO `teacher` VALUES (2, '李四');
INSERT INTO `teacher` VALUES (3, '王五');
INSERT INTO `teacher` VALUES (4, '李杰');
INSERT INTO `teacher` VALUES (5, '赵六');

SET FOREIGN_KEY_CHECKS = 1;
