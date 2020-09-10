package com.zzt.io.application;

import cn.hutool.core.util.RandomUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/10 9:35
 */
public class MyFileStore {

    private static String filePath = "D:\\test.xlsx";
    private static Integer count = 10000;

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            count = Integer.valueOf(args[0]);
        }
        Set<String> result = new HashSet<>(count);
        for (int i = 0; i < count; i++) {
            result.add(getName());
        }

        ExcelImport.saveList2Excel(new ArrayList<>(result));
    }

    private static class ExcelImport {
        //        private static String[] titleName = {"序号", "电话号"};
        private static String[] titleName = {"序号", "名称"};
        private static Integer count = 1;

        public static void saveList2Excel(List<String> result) throws IOException {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("免税电话");
            // 创建表头
            Row titleRow = sheet.createRow(0);
            CellStyle style = wb.createCellStyle();
            Cell cell;
            for (int i = 0; i < titleName.length; i++) {
                cell = titleRow.createCell(i);
                cell.setCellValue(titleName[i]);
                cell.setCellStyle(style);
            }
            //把从数据库中取得的数据一一写入excel文件中
            result.forEach(temp -> {
                Row row = sheet.createRow(count);
                row.createCell(0).setCellValue(count++);
                row.createCell(1).setCellValue(temp);
            });

            // 写入数据
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            wb.write(fileOutputStream);
            fileOutputStream.close();
        }


    }

    private static String[] lowercase = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private static String getName() {
        int count1 = RandomUtil.randomInt(4, 8);
        int count2 = RandomUtil.randomInt(4, 8);
        String firstName;
        String lastName;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count1; i++) {
            builder.append(RandomUtil.randomEle(Arrays.asList(lowercase)));
        }
        firstName = builder.toString();
        builder = new StringBuilder();
        for (int i = 0; i < count2; i++) {
            builder.append(RandomUtil.randomEle(Arrays.asList(lowercase)));
        }
        lastName = builder.toString();
        System.out.println(firstName + " " + lastName);
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " "
                + lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }

    private static String getRandomNumber() {
        return RandomUtil.randomInt(200, 999)
                + "-" + RandomUtil.randomNumbers(3)
                + "-" + RandomUtil.randomNumbers(4);
    }
}
