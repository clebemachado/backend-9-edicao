package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.PessoaEntity;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    //TODO filtrar envio de email por tipagem Enum
    //private TipoEmail tipoEmail;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("luppi.gabriel08@gmail.com");
        message.setSubject("Teste");
        message.setText("Se vc esta vendo isso, it works!");
        emailSender.send(message);
    }

    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo("luppi.gabriel08@gmail.com");
            mimeMessageHelper.setSubject("Teste 2");
            mimeMessageHelper.setText(geContentFromTemplate(), true);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendCreateEnderecoEmail(PessoaEntity pessoaEntity, Endereco endereco) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaEntity.getEmail());
            mimeMessageHelper.setSubject("Cadastro de endereço");
            mimeMessageHelper.setText(geContentFromCreateEnderecoTemplate(pessoaEntity, endereco), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendUpdateEnderecoEmail(PessoaEntity pessoaEntity, Endereco endereco) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaEntity.getEmail());
            mimeMessageHelper.setSubject("Atualização de endereço");
            mimeMessageHelper.setText(geContentFromUpdateEnderecoTemplate(pessoaEntity, endereco), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendDeleteEnderecoEmail(PessoaEntity pessoaEntity, Endereco endereco) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaEntity.getEmail());
            mimeMessageHelper.setSubject("Remoção de endereço");
            mimeMessageHelper.setText(geContentFromDeleteEnderecoTemplate(pessoaEntity, endereco), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate() throws  IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "MeuNome");
        dados.put("email", "aaa@aaa");

        Template template =  fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromCreateEnderecoTemplate(PessoaEntity pessoaEntity, Endereco endereco) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getBatata());
        dados.put("tipo", endereco.getTipo());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("numero", endereco.getNumero());
        dados.put("cep", endereco.getCep());

        Template template = fmConfiguration.getTemplate("create-endereco-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromUpdateEnderecoTemplate(PessoaEntity pessoaEntity, Endereco endereco) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getBatata());
        dados.put("tipo", endereco.getTipo());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("numero", endereco.getNumero());
        dados.put("cep", endereco.getCep());

        Template template = fmConfiguration.getTemplate("update-endereco-email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromDeleteEnderecoTemplate(PessoaEntity pessoaEntity, Endereco endereco) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getBatata());
        dados.put("tipo", endereco.getTipo());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("numero", endereco.getNumero());
        dados.put("cep", endereco.getCep());

        Template template = fmConfiguration.getTemplate("delete-endereco-email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

//    public void sendWithAttachment() throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setFrom(from);
//        helper.setTo("luppi.gabriel08@gmail.com");
//        helper.setSubject("Teste mime");
//        helper.setText("Meu segundo email!");
//    }
}
