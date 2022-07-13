package com.dbc.pessoaapi.service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("rafael.lazzari@dbccompany.com.br");
        message.setSubject("Assunto 1");
        message.setText("Meu e-mail!");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo("rafael.lazzari@dbccompany.com.br");
        helper.setSubject("Assunto 1");
        helper.setText("Meu e-mail!");

          // Forma 1
//        File file1 = new File("imagem.jpg");
//        FileSystemResource file
//                = new FileSystemResource(file1);
//        helper.addAttachment(file1.getName(), file);

        // Forma 2
        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("imagem.jpg").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

//        System.out.println("F: " + file2.getPath());
        // src/main/resources/imagem.jpg

        emailSender.send(message);
    }

    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Assunto 3");
            mimeMessageHelper.setText(geContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String geContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "MeuNome");
        dados.put("email", "aaa@aaa");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
