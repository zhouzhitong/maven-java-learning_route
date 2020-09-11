package com.zzt;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class LineMark {

    public static void clean(String fromPath, String toPath) throws IOException {
        File file1 = new File(fromPath);
        BufferedImage image = ImageIO.read(file1);

        BufferedImage sourceImg = ImageIO.read(new FileInputStream(file1));  // 获取图片的长宽
        int width = sourceImg.getWidth();
        int height = sourceImg.getHeight();

        /**
         * 创建3维数组用于保存图片rgb数据
         */
        int[][][] array = new int[width][height][3];
        for (int i = 0; i < width; i++) { // 获取图片中所有像素点的rgb
            for (int j = 0; j < height; j++) {
                int pixel = image.getRGB(i, j); //获得坐标(i,j)的像素
                int red = (pixel & 0xff0000) >> 16;
                int green = (pixel & 0xff00) >> 8;
                int blue = (pixel & 0xff);  //通过坐标(i,j)的像素值获得r,g,b的值
                array[i][j][0] = red;
                array[i][j][1] = green;
                array[i][j][2] = blue;
            }
        }

        /**
         * 清除表格线：
         * 竖线：绝大多数点的x值都为255
         */
        for (int i = 0; i < width; i++) {
            int nums = 0;
            for (int j = 0; j < height; j++) {
                if (array[i][j][0] < 128 && array[i][j][1] < 128 && array[i][j][2] < 128) {
                    nums += 1;
                }
            }
            if (nums > height * 0.8) {
                for (int n = 0; n < height; n++) {
                    array[i][n][0] = 255;
                    array[i][n][1] = 255;
                    array[i][n][2] = 255;
                }
            }
        }

        /**
         * 清除表格线：
         *     横线：绝大多数点的y值都为255
         */
        for (int j = 0; j < height; j++) {
            int nums = 0;
            for (int i = 0; i < width; i++) {
                if (array[i][j][0] < 128 && array[i][j][1] < 128 && array[i][j][2] < 128) {
                    nums += 1;
                }
            }
            if (nums > height * 0.8) {
                for (int n = 0; n < width; n++) {
                    array[n][j][0] = 255;
                    array[n][j][1] = 255;
                    array[n][j][2] = 255;
                }
            }
        }
        /**
         * 大点
         */
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int cover = new Color(array[i][j][0], array[i][j][1], array[i][j][2]).getRGB();
                image.setRGB(i, j, cover);
            }
        }
        File file2 = new File(toPath);
        ImageIO.write(image, "png", file2);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String fromPath = "D:\\QQ123.png";
        String toPath = "D:\\112.png";
        try {
            LineMark.clean(fromPath, toPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
