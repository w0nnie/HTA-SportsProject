package com.project.sports.task;

import java.io.File; 

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;


@Component
public class SendMail {
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	//savefolder.properties�� sendfile�� �Ӽ� ���� String sendfile�� �����մϴ�.
	@Value("${sendfile}")
	private String sendfile;
	
	private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

	public void sendMail(com.project.sports.domain.MailVO vo) {
			MimeMessagePreparator mp = new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					//�ι�° ���� true�� ��Ƽ ��Ʈ �޽����� ����ϰڴٴ� �ǹ��Դϴ�.
					MimeMessageHelper helper
						=new MimeMessageHelper(mimeMessage, true, "UTF-8");
					helper.setFrom(vo.getFrom());
					helper.setTo(vo.getTo());
					helper.setSubject(vo.getSubject());
					
					//1.���ڷθ� �����ϴ� ���
					//�ι�° ���ڴ� html�� ����ϰڴٴ� ���Դϴ�.
					//helper.setText(vo.getContent(),true);
					
					//2.�̹����� �����ؼ� ������ ���
					//cid(content id)
					String content = "<img src='cid:Home'>" + vo.getContent();
					helper.setText(content, true);
					
					FileSystemResource file = new FileSystemResource(new File(sendfile));
					//addInline�޼����� ù��° �޼��忡�� cid(content id)�� �����մϴ�.
					helper.addInline("Home", file);
					
					//3.������ ÷���ؼ� ������ ���
					//ù��° ���� : ÷�ε� ������ �̸��Դϴ�.
					//�ι�° ���� : ÷������
					helper.addAttachment("�ì����.jpg", file);
				}
			};
			mailSender.send(mp);
			logger.info("���� �����߽��ϴ�.");
	}
}