package com.jaki.jserver.login.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCode {

    /**
     * 验证码图片格式：jpg / jpeg
     */
    public static final String TYPE_JPG = "jpg";
    /**
     * 验证码图片格式：png
     */
    public static final String TYPE_PNG = "png";
    /**
     * 验证码图片格式：bmp
     */
    public static final String TYPE_BMP = "bmp";

    private static VerifyCode instance;

    public static VerifyCode getInstance() {
        if (instance == null) {
            synchronized (VerifyCode.class) {
                if (instance == null) {
                    instance = new VerifyCode();
                }
            }
        }
        return instance;
    }

    private VerifyCode() { }

    /**
     * 验证码图片的宽度
     */
    private int width = 70;
    /**
     * 验证码图片的高度
     */
    private int height = 30;

    /**
     * 随机字符串个数
     */
    private int charCount = 4;
    /**
     * 随机干扰线的条数
     */
    private int lineCount = 4;
    /**
     * 产生的字符串
     */
    private String text;
    /**
     * 验证码图片的格式
     */
    private String imageType = TYPE_JPG;

    private Random random = new Random();
    private String[] fonts = {"宋体", "华文楷体", "黑体", "微软雅黑"};
    private String characters = "23456789abcdefghijkmnpqrtuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getImageType() {
        return imageType;
    }

    public String getText() {
        return text;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    private Font randomFont() {
        int index = random.nextInt(fonts.length);
        //普通0；斜体1；粗体2；斜体粗体3
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(fonts[index], style, size);
    }


    private String randomCharacter() {
        int index = random.nextInt(characters.length());
        return characters.charAt(index) + "";
    }

    private Color randomColor() {
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return new Color(red, green, blue);
    }

    /**
     * 绘制随机干扰线
     *
     * @param image
     */
    private void drawLine(BufferedImage image) {
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        for (int i = 0; i < lineCount; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.setStroke(new BasicStroke(1f));
            graphics.setColor(randomColor());
            graphics.drawLine(x1, y1, x2, y2);
        }
    }
    /**
     * 获取验证码
     *
     * @param out 验证码图片输出流
     * @return 生成的验证码
     */
    public String getVerifyCode(OutputStream out) {
        try {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            text = generateVerifyCode(bi);
            //验证码图片写到输出流中
            ImageIO.write(bi, imageType, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    private String generateVerifyCode(BufferedImage bi) {
        Graphics2D graphics = (Graphics2D) bi.getGraphics();
        graphics.setColor(randomColor());
        graphics.fillRect(0, 0, width, height);
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < charCount; i++) {
            graphics.setFont(randomFont());
            graphics.setColor(randomColor());
            float x = i * 1.0f * width / charCount;
            String ch = randomCharacter();
            buffer.append(ch);
            graphics.drawString(ch, x, height - 5);
        }
        drawLine(bi);
        return buffer.toString();
    }

    /**
     * 获取验证码
     *
     * @param savePath 验证码图片保存地址
     * @return 生成的验证码
     */
    public String getVerifyCode(String savePath) {
        FileOutputStream out = null;
        try {
            if (isStringEmpty(savePath)) {
                throw new RuntimeException("验证码保存地址不能为空，savePath = " + savePath);
            }

            //确定生成验证码图片的格式
            String[] split = savePath.split("\\.");
            String last = split[split.length - 1];
            if (!imageType.equalsIgnoreCase(last)) {
                imageType = last;
            }

            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            text = generateVerifyCode(bi);
            out = new FileOutputStream(savePath);
            ImageIO.write(bi, imageType, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException("图片输出流关闭异常，" + e.getMessage());
                }
            }
        }
        return text;
    }


    public boolean isStringEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

}
