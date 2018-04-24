package com.gree.springboot.maildemo;

import com.gree.springboot.maildemo.model.MailContentTypeEnum;
import com.gree.springboot.maildemo.model.MailEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class MailSender {
    //邮件实体
    private static MailEntity mail = new MailEntity();

    /**
     * 设置邮件标题
     * @param title
     * @return
     */
    public MailSender title(String title) {
        mail.setTitle(title);
        return this;
    }

    /**
     * 设置邮件内容
     * @param content
     * @return
     */
    public MailSender content(String content) {
        mail.setContent(content);
        return this;
    }

    /**
     * 设置邮件格式
     * @param typeEnum
     * @return
     */
    public MailSender contentType(MailContentTypeEnum typeEnum) {
        mail.setContentType(typeEnum.getValue());
        return this;
    }

    /**
     * 设置请求目标邮件地址
     * @param targets
     * @return
     */
    public MailSender targets(List<String> targets) {
        mail.setList(targets);
        return this;
    }

    /**
     * 发送邮件
     */
    public void send() {
        if (mail.getContentType() == null) {
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }
        if (StringUtils.isEmpty(mail.getTitle())) {
            throw  new RuntimeException("邮件标题不能为空");
        }
        if (StringUtils.isEmpty(mail.getContent())) {
            throw  new RuntimeException("邮件内容不能为空");
        }
        if (CollectionUtils.isEmpty(mail.getList())) {
            throw new RuntimeException("收件人地址不能为空");
        }
    }
}
