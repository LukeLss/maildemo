package com.gree.springboot.maildemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class MailEntity implements Serializable{
    private static final long serialVersionUID = -690866158342504423L;
    //SMTP服务器
    private String smtpService;
    //端口号
    private String smtpPort;
    //发送邮箱
    private String from;
    //发送邮箱的SMTP口令
    private String fromPwd;
    //邮件标题
    private String title;
    //邮件内容
    private String content;
    //内容格式(默认HTML)
    private String contentType;
    //接收邮件地址列表
    private List<String> list = new ArrayList<>();
}
