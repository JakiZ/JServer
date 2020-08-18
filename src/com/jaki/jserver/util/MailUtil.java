package com.jaki.jserver.util;

import sun.applet.Main;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MailUtil {


    /**
     * 创建Session
     * @param mailServerAddress 邮件服务器 smtp.xxx.com
     * @param userMailAddress 用户邮箱地址
     * @param userMailPassword 用户邮箱密码
     * @return
     */
    public static Session createSession(String mailServerAddress, String userMailAddress, String userMailPassword) {
        Properties properties = new Properties();
        //设置邮件服务器地址
        properties.setProperty("mail.host", mailServerAddress);
        //是否需要验证
        properties.setProperty("mail.smtp.auth", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userMailAddress, userMailPassword);
            }
        };
        return Session.getInstance(properties, authenticator);
    }


    /**
     * 发送邮件
     * @param session 邮件的session
     * @param mail 邮件
     * @throws MessagingException
     * @throws IOException
     */
    public static void send(Session session, Mail mail) throws MessagingException, IOException {
        MimeMessage message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress(mail.getFromAddress()));
        addRecipients(message, mail.getRecieverList(), Message.RecipientType.TO);
        addRecipients(message, mail.getCarbonCopyList(), Message.RecipientType.CC);
        addRecipients(message, mail.getBlindCarbonCopyList(), Message.RecipientType.BCC);
        message.setSubject(mail.getSubject());

        MimeMultipart multipart = new MimeMultipart();

        //添加文本
        String textContent = mail.getTextContent();
        if (textContent != null) {
            MimeBodyPart part = new MimeBodyPart();
            part.setContent(textContent, "text/html;charset=utf-8");
            multipart.addBodyPart(part);
        }

        //添加附件
        List<Mail.Attach> attachList = mail.getAttachList();
        if (attachList != null && !attachList.isEmpty()) {
            for (int i = 0; i < attachList.size(); i++) {
                MimeBodyPart filePart = new MimeBodyPart();
                filePart.attachFile(attachList.get(i).getFile());
                filePart.setFileName(MimeUtility.encodeText(attachList.get(i).getFileName()));
                multipart.addBodyPart(filePart);
            }
        }
        message.setContent(multipart);
        Transport.send(message);
    }

    /**
     * 添加各种收件人
     *
     * @param message 邮件消息
     * @param list    各种收件人地址集合
     * @param type    收件人类型： Message.RecipientType.TO收件人；Message.RecipientType.CC抄送人；Message.RecipientType.BCC密送人
     * @throws MessagingException
     */
    private static void addRecipients(MimeMessage message, List<String> list, Message.RecipientType type) throws MessagingException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            message.addRecipients(type, list.get(i));
        }
    }


    /**
     * 邮件实体类
     *
     * @author Jaki
     * @time created at  2020/1/14 17:46
     * @email 654641423@qq.com
     */
    public static class Mail {
        /**
         * 发件人地址
         */
        private String fromAddress;
        /**
         * 收件人地址集合
         */
        private List<String> receiverList ;
        /**
         * 抄送人地址集合
         */
        private List<String> carbonCopyList;
        /**
         * 密送人地址集合
         */
        private List<String> blindCarbonCopyList;
        /**
         * 邮件主题
         */
        private String subject;
        /**
         * 邮件的文本内容
         */
        private String textContent;
        /**
         * 邮件的附件
         */
        private List<Attach> attachList;

        public Mail(String fromAddress, List<String> receiverList) {
            this.fromAddress = fromAddress;
            this.receiverList = receiverList;
        }

        public Mail(String fromAddress, String receiverAddress, String subject, String textContent) {
            this.fromAddress = fromAddress;
            receiverList = new ArrayList<>();
            receiverList.add(receiverAddress);
            this.subject = subject;
            this.textContent = textContent;

            carbonCopyList = new ArrayList<>();
            blindCarbonCopyList = new ArrayList<>();
            attachList = new ArrayList<>();
        }

        public Mail(String fromAddress, List<String> receiverList, String subject, String textContent) {
            this.fromAddress = fromAddress;
            this.receiverList = receiverList;
            this.subject = subject;
            this.textContent = textContent;

            carbonCopyList = new ArrayList<>();
            blindCarbonCopyList = new ArrayList<>();
            attachList = new ArrayList<>();
        }


        public Mail addReceivers(List<String> recievers) {
            checkAndAddAddress(recievers, receiverList);
            return this;
        }

        /**
         * 检查source中的数据，如果它是email地址且从未添加到dest中，则添加进去，否则添加
         *
         * @param source 需要检查的集合
         * @param dest   被添加的集合
         */
        private void checkAndAddAddress(List<String> source, List<String> dest) {
            if (source == null || source.isEmpty()) {
                return;
            }

            for (int i = 0; i < source.size(); i++) {
                String address = source.get(i);
                if (CommonUtil.isEmailAddress(address)) {
                    continue;
                }
                if (!dest.contains(address)) {
                    dest.add(address);
                }
            }
        }

        public String getFromAddress() {
            return fromAddress;
        }

        public List<String> getRecieverList() {
            return receiverList;
        }

        public List<String> getCarbonCopyList() {
            return carbonCopyList;
        }

        public List<String> getBlindCarbonCopyList() {
            return blindCarbonCopyList;
        }

        public String getSubject() {
            return subject;
        }

        public String getTextContent() {
            return textContent;
        }

        public List<Attach> getAttachList() {
            return attachList;
        }

        public Mail addReciver(String reciever) {
            List<String> list = new ArrayList();
            list.add(reciever);
            return addReceivers(list);
        }

        public void setFromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
        }

        public void setRecieverList(List<String> recieverList) {
            this.receiverList = recieverList;
        }

        public void setCarbonCopyList(List<String> carbonCopyList) {
            this.carbonCopyList = carbonCopyList;
        }

        public void setBlindCarbonCopyList(List<String> blindCarbonCopyList) {
            this.blindCarbonCopyList = blindCarbonCopyList;
        }

        public void setAttachList(List<Attach> attachList) {
            this.attachList = attachList;
        }

        public Mail addCarbonCopies(List<String> carbonCopies) {
            checkAndAddAddress(carbonCopies, carbonCopyList);
            return this;
        }

        public Mail addCarbonCopy(String carbonCopy) {
            List<String> list = new ArrayList();
            list.add(carbonCopy);
            return addCarbonCopies(list);
        }

        public Mail addBlindCarbonCopies(List<String> blindCarbonCopies) {
            checkAndAddAddress(blindCarbonCopies, blindCarbonCopyList);
            return this;
        }

        public Mail addBlindCarbonCopy(String blindCarbonCopy) {
            List<String> list = new ArrayList();
            list.add(blindCarbonCopy);
            return addCarbonCopies(list);
        }

        public Mail setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Mail setTextContent(String textContent) {
            this.textContent = textContent;
            return this;
        }

        public Mail addAttachList(List<Attach> attachList) {
            if (attachList == null || attachList.isEmpty()) {
                return this;
            }
            this.attachList.addAll(attachList);
            return this;
        }

        public Mail addAttach(Attach attach) {
            if (attach == null) {
                return this;
            }
            this.attachList.add(attach);
            return this;
        }



        /**
         * 附件
         *
         * @author Jaki
         * @time created at  2020/1/14 17:12
         * @email 654641423@qq.com
         */
        public static class Attach {
            /**
             * 文件地址
             */
            private String filePath;
            /**
             * 文件
             */
            private File file;
            /**
             * 文件名
             */
            private String fileName;

            public Attach(String filePath) {
                this.filePath = filePath;
                this.file = new File(filePath);
                this.fileName = file.getName();
            }

            public String getFilePath() {
                return filePath;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
                this.file = new File(filePath);
                this.fileName = file.getName();
            }

            public File getFile() {
                return file;
            }

            public String getFileName() {
                return fileName;
            }
        }
    }
}


