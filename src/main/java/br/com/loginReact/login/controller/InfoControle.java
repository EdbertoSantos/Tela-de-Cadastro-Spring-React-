package br.com.loginReact.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.loginReact.login.model.InfoModelo;
import br.com.loginReact.login.model.RespostaModelo;
import br.com.loginReact.login.service.infoService;

@RestController
@CrossOrigin(origins = "*")
public class InfoControle{

    @Autowired
    private infoService infoSe;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return infoSe.remover(codigo);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody InfoModelo infoMo){
        return  infoSe.cadastrarAlterar(infoMo, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody InfoModelo infoMo){
        return  infoSe.cadastrarAlterar(infoMo, "cadastra");
    }
    
    @GetMapping("/listar")
    public Iterable<InfoModelo> listar(){
        return infoSe.listar();
    }

    @GetMapping("/")
    public String rota(){
        return " Api Funciona";
    }

}