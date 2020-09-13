package br.com.springcliente.loader;

import br.com.springcliente.enums.RoleName;
import br.com.springcliente.model.Perfil;
import br.com.springcliente.services.PerfilService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final PerfilService perfilService;

    public DataLoader(PerfilService perfilService) {
        this.perfilService = perfilService;
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
            System.out.println("Config data OK...");
        });
    }
}
