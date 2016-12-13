package com.imudges.utils;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    /*
    private static String username = "luo.xxx@163.com";
    private static String password = "xxx";
    private static String smtpServer = "smtp.163.com";
    private static String fromMailAddress = "luo.xxx@163.com";
    private static String toMailAddress = "xxx@sina.com";
    */
    private static PropertiesLoader propertiesLoader = new PropertiesLoader("bdsc-web.properties");//读取配置文件
    public static void mailSimple(String toMailSAddress,String subject,String content) {
        // 发送器
        JavaMailSenderImpl mailSender= new JavaMailSenderImpl();
        // 建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = mailSender.createMimeMessage();
        // 为防止乱码，添加编码集设置
        MimeMessageHelper messageHelper = null;
        try {
            //发送附件 则 参数为 multipart 为 ture
            messageHelper = new MimeMessageHelper(mailMessage,true,"UTF-8");
        } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //设定mail server
        mailSender.setHost(propertiesLoader.getProperty("mail.smtp.host"));
        mailSender.setUsername(propertiesLoader.getProperty("mail.smtp.username"));
        mailSender.setPassword(propertiesLoader.getProperty("mail.smtp.password"));
        mailSender.setPort(Integer.parseInt(propertiesLoader.getProperty("mail.smtp.port")));
        //配置文件，用于实例化java.mail.session
        Properties pro = System.getProperties();

        //登录SMTP服务器,需要获得授权，网易163邮箱新近注册的邮箱均不能授权。
        //测试 sohu 的邮箱可以获得授权
        pro.put("mail.smtp.auth", "true");

        pro.put("mail.smtp.socketFactory.fallback", "false");

        //通过文件获取信息
        mailSender.setJavaMailProperties(pro);

        //建立邮件消息
        //设置收件人、寄件人
        try {
            messageHelper.setTo(toMailSAddress);
            messageHelper.setFrom(propertiesLoader.getProperty("mail.smtp.username"));
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            //附件内容
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //发送邮件
        mailSender.send(mailMessage);
        System.out.println("邮件发送成功!");
    }
}
