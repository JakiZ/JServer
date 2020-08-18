package com.jaki.jserver.p10.mail;

import com.jaki.jserver.util.MailUtil;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Mail1 {


    @Test
    public void mail() throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.126.com");
        properties.setProperty("mail.smtp.auth", Boolean.toString(true));

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wyzzw123456789@126.com", "199105185");
            }
        };

        Session session = Session.getInstance(properties, authenticator);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("wyzzw123456789@126.com"));
        message.setRecipients(Message.RecipientType.TO, "834561005@qq.com");
        message.setRecipients(Message.RecipientType.CC, "zzw123456789@qq.com");
        message.setRecipients(Message.RecipientType.BCC, "834561005@qq.com");

        message.setSubject("主题");
        message.setContent("邮件内容", "text/html;charset=utf-8");

        Transport.send(message);
    }


    @Test
    public void mailWithAttachment() throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.126.com");
        properties.setProperty("mail.smtp.auth", Boolean.toString(true));

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wyzzw123456789@126.com", "199105185");
            }
        };

        Session session = Session.getInstance(properties, authenticator);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("wyzzw123456789@126.com"));
        message.setRecipients(Message.RecipientType.TO, "834561005@qq.com");
        message.setRecipients(Message.RecipientType.CC, "zzw123456789@qq.com");
        message.setRecipients(Message.RecipientType.BCC, "834561005@qq.com");

        message.setSubject("主题:有附件");

        MimeMultipart multipart = new MimeMultipart();

        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent("邮件文本内容", "text/html;charset=utf-8");
        multipart.addBodyPart(bodyPart);

        MimeBodyPart bodyPart2 = new MimeBodyPart();
        bodyPart2.attachFile(new File("D:\\张三.png"));
        bodyPart2.setFileName(MimeUtility.encodeText("张三.jpg"));
        multipart.addBodyPart(bodyPart2);

        message.setContent(multipart);

        Transport.send(message);
    }

    @Test
    public void testMailUtil() throws IOException, MessagingException {
        Session session = MailUtil.createSession("smtp.126.com", "wyzzw123456789@126.com", "199105185");
        MailUtil.send(session,new MailUtil.Mail("wyzzw123456789@126.com","834561005@qq.com","subject","content"));
    }

    @Test
    public void testMailUtil2() throws IOException, MessagingException {
        Session session = MailUtil.createSession("smtp.126.com", "wyzzw123456789@126.com", "199105185");
        MailUtil.Mail mail = new MailUtil.Mail("wyzzw123456789@126.com", "834561005@qq.com", "subject", "content");
        mail.addAttach(new MailUtil.Mail.Attach("D:\\张三.png"));
        MailUtil.send(session, mail);
    }
}
