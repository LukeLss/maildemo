package com.gree.springboot.maildemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaildemoApplicationTests {

	@Autowired
	private MailUtil mailUtil;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSendEmail() {
		String deliver = "2804220037@qq.com";
		String[] receiver = {"15626022463@163.com"};
		String[] carbonCopy = {"2804220037@qq.com"};
		String subject = "This is a Html content email";
		String content = "<h1>This is a HTML content email</h1>";
		boolean isHtml = true;
		mailUtil.sendSimpleMail(deliver,receiver,carbonCopy,subject,content);
	}

	@Test
	public void testSendHtmlEmail() {
		String deliver = "2804220037@qq.com";
		String[] receiver = {"15626022463@163.com"};
		String[] carbonCopy = {"2804220037@qq.com"};
		String subject = "This is a Html content email";
		String content = "<h1>This is a HTML content email</h1>";
		boolean isHtml = true;
		mailUtil.sendHTMLEmail(deliver,receiver,carbonCopy,subject,content,isHtml);
	}

	@Test
	public void testSendAttachmentEmail() {
		String deliver = "2804220037@qq.com";
		String[] receiver = {"15626022463@163.com"};
		String[] carbonCopy = {"2804220037@qq.com"};
		String subject = "This is a Html content email";
		String content = "This is a simple content email with attachment";
		String filepath = "F:\\小小的翅膀\\20140323_150452.jpg";
		File file = new File(filepath);
		String filename = filepath.substring(filepath.lastIndexOf(File.separator));
		mailUtil.sendAttachmentMail(deliver,receiver,carbonCopy,subject,content,filename,file);
	}

}
