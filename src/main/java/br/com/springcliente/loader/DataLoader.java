package br.com.springcliente.loader;

import br.com.springcliente.enums.RoleName;
import br.com.springcliente.enums.TipoTelefoneNome;
import br.com.springcliente.model.Cliente;
import br.com.springcliente.model.Perfil;
import br.com.springcliente.model.TipoTelefone;
import br.com.springcliente.services.ClienteService;
import br.com.springcliente.services.PerfilService;
import br.com.springcliente.services.TipoTelefoneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final PerfilService perfilService;
    private final TipoTelefoneService tipoTelefoneService;
    private final ClienteService clienteService;

    public DataLoader(PerfilService perfilService, TipoTelefoneService tipoTelefoneService, ClienteService clienteService) {
        this.perfilService = perfilService;
        this.tipoTelefoneService = tipoTelefoneService;
        this.clienteService = clienteService;
    }

    @Bean
    public CommandLineRunner loadData() {
        return (args -> {
            System.out.println("Checking config data...");
            if(!perfilService.findByNome(RoleName.ROLE_ADMIN).isPresent()) {
                System.out.println("Criando perfil ADMIN...");
                Perfil perfil = new Perfil();
                perfil.setNome(RoleName.ROLE_ADMIN);
                perfilService.save(perfil);
                System.out.println("Perfil ADMIN criado...");
            }
            if(!perfilService.findByNome(RoleName.ROLE_USER).isPresent()) {
                System.out.println("Criando perfil USER...");
                Perfil perfil = new Perfil();
                perfil.setNome(RoleName.ROLE_USER);
                perfilService.save(perfil);
                System.out.println("Perfil USER criado...");
            }
            if(!tipoTelefoneService.findByDescricao(TipoTelefoneNome.CELULAR).isPresent()) {
                System.out.println("Criando tipo de telefone CELULAR...");
                TipoTelefone tipo = new TipoTelefone();
                tipo.setDescricao(TipoTelefoneNome.CELULAR);
                tipoTelefoneService.save(tipo);
                System.out.println("Tipo de telefone CELULAR criado...");
            }
            if(!tipoTelefoneService.findByDescricao(TipoTelefoneNome.COMERCIAL).isPresent()) {
                System.out.println("Criando tipo de telefone COMERCIAL...");
                TipoTelefone tipo = new TipoTelefone();
                tipo.setDescricao(TipoTelefoneNome.COMERCIAL);
                tipoTelefoneService.save(tipo);
                System.out.println("Tipo de telefone COMERCIAL criado...");
            }
            if(!tipoTelefoneService.findByDescricao(TipoTelefoneNome.RESIDENCIAL).isPresent()) {
                System.out.println("Criando tipo de telefone RESIDENCIAL...");
                TipoTelefone tipo = new TipoTelefone();
                tipo.setDescricao(TipoTelefoneNome.RESIDENCIAL);
                tipoTelefoneService.save(tipo);
                System.out.println("Tipo de telefone RESIDENCIAL criado...");
            }
            if(!clienteService.findByNome("Joaozinho").isPresent()) {
            	System.out.println("Criando cliente joãozinho...");
            	Cliente cliente = new Cliente();
            	cliente.setNome("Joaozinho");
            	cliente.setCpf("00000000000");
            	cliente.setCep("72146018");
            	clienteService.save(cliente);
            	System.out.println("Criado cliente joãozinho...");
            }
            System.out.println("Config data OK...");
        });
    }
}
