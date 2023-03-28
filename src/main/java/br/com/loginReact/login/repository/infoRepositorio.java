package br.com.loginReact.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loginReact.login.model.InfoModelo;

@Repository
public interface infoRepositorio extends CrudRepository<InfoModelo, Long>{

    
}
