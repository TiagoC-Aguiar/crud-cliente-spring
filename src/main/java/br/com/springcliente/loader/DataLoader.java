package br.com.springcliente.loader;

import br.com.springcliente.enums.TipoTelefoneDesc;
import br.com.springcliente.model.*;
import br.com.springcliente.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final PerfilService perfilService;
    private final TipoTelefoneService tipoTelefoneService;
    private final ClienteService clienteService;
    private final TelefoneService telefoneService;
    private final EmailService emailService;
    private final UFService ufService;
    private final CidadeService cidadeService;
    private final BairroService bairroService;
    private Cliente cliente;
    private UF uf;
    private Cidade cidade;

    public DataLoader(PerfilService perfilService, TipoTelefoneService tipoTelefoneService,
                      ClienteService clienteService, TelefoneService telefoneService, EmailService emailService,
                      UFService ufService, CidadeService cidadeService, BairroService bairroService) {
        this.perfilService = perfilService;
        this.tipoTelefoneService = tipoTelefoneService;
        this.clienteService = clienteService;
        this.telefoneService = telefoneService;
        this.emailService = emailService;
        this.ufService = ufService;
        this.cidadeService = cidadeService;
        this.bairroService = bairroService;

        this.cliente = new Cliente();
        this.uf = new UF();
        this.cidade = new Cidade();

    }

    @Bean
    public CommandLineRunner loadData() {
        return (args -> {
            System.out.println("Checking config data...");
//            if(!perfilService.findByNome(RoleName.ROLE_ADMIN).isPresent()) {
//                System.out.println("Criando perfil ADMIN...");
//                Perfil perfil = new Perfil();
//                perfil.setNome(RoleName.ROLE_ADMIN);
//                perfilService.save(perfil);
//                System.out.println("Perfil ADMIN criado...");
//            }
//            if(!perfilService.findByNome(RoleName.ROLE_USER).isPresent()) {
//                System.out.println("Criando perfil USER...");
//                Perfil perfil = new Perfil();
//                perfil.setNome(RoleName.ROLE_USER);
//                perfilService.save(perfil);
//                System.out.println("Perfil USER criado...");
//            }
            if(!tipoTelefoneService.findByDescricao(TipoTelefoneDesc.CELULAR).isPresent()) {
                System.out.println("Criando tipo de telefone CELULAR...");
                TipoTelefone tipo = new TipoTelefone();
                tipo.setDescricao(TipoTelefoneDesc.CELULAR);
                tipoTelefoneService.save(tipo);
                System.out.println("Tipo de telefone CELULAR criado...");
            }
            if(!tipoTelefoneService.findByDescricao(TipoTelefoneDesc.COMERCIAL).isPresent()) {
                System.out.println("Criando tipo de telefone COMERCIAL...");
                TipoTelefone tipo = new TipoTelefone();
                tipo.setDescricao(TipoTelefoneDesc.COMERCIAL);
                tipoTelefoneService.save(tipo);
                System.out.println("Tipo de telefone COMERCIAL criado...");
            }
            if(!tipoTelefoneService.findByDescricao(TipoTelefoneDesc.RESIDENCIAL).isPresent()) {
                System.out.println("Criando tipo de telefone RESIDENCIAL...");
                TipoTelefone tipo = new TipoTelefone();
                tipo.setDescricao(TipoTelefoneDesc.RESIDENCIAL);
                tipoTelefoneService.save(tipo);
                System.out.println("Tipo de telefone RESIDENCIAL criado...");
            }
            if(!clienteService.findByNome("Joaozinho").isPresent()) {
            	System.out.println("Criando cliente joãozinho...");
            	cliente.setNome("Joaozinho");
            	cliente.setCpf("00000000001");
            	clienteService.save(cliente);
            	System.out.println("Criado cliente joãozinho");
            }
            if(!telefoneService.findByNumero("61999999999").isPresent()) {
                System.out.println("Criando telefone (61)99999-9999...");
                Telefone telefone = new Telefone();
                telefone.setNumero("61999999999");
                telefone.setCliente(clienteService.findByNome("Joaozinho").get());
                telefone.setTipoTelefone(tipoTelefoneService.findByDescricao(TipoTelefoneDesc.CELULAR).get());
                telefoneService.save(telefone);
                System.out.println("Criado telefone (61)99999-9999");
            }
            if(!emailService.findByEmail("joazinho@email.com").isPresent()) {
                System.out.println("Criando email joãozinho@email.com...");
                EmailEntity email = new EmailEntity();
                email.setEmail("joazinho@email.com");
                email.setCliente(cliente);
                emailService.save(email);
                System.out.println("Criando email do joãozinho");
            }
            if(!ufService.findBySigla("DF").isPresent()) {
                System.out.println("Criando estado Distrito Federal...");
                uf.setSigla("DF");
                uf.setNome("Distrito Federal");
                ufService.save(uf);
                System.out.println("Estado Distrito Federal criado");
            }
            if(!cidadeService.findByNome("Ceilondres").isPresent()) {
                System.out.println("Criando cidade Ceilondres...");
                cidade.setNome("CeiLondres");
                cidade.setUf(uf);
                cidadeService.save(cidade);
                System.out.println("Cidade Ceilondres criada");
            }
            if(!bairroService.findByNome("P Morte").isPresent()) {
                System.out.println("Criando bairro 'P' Morte...");
                Bairro bairro = new Bairro();
                bairro.setNome("P Morte");
                bairro.setCidade(cidade);
                bairroService.save(bairro);
                System.out.println("Bairro 'P' Morte criado");
            }
            System.out.println("Config data OK...");
        });
    }
}
