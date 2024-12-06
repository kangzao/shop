package com.jep.shop.user.service;

/**
 * @author enping.jep
 * @date 2024/11/15 20:39
 **/
public interface MailService {

    /**
     * 发送邮件
     */
    void sendMail(String to, String subject, String content);
}
