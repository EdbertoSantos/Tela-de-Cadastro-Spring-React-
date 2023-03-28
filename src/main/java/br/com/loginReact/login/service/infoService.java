package br.com.loginReact.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import br.com.loginReact.login.model.RespostaModelo;
import br.com.loginReact.login.model.InfoModelo;
import br.com.loginReact.login.repository.infoRepositorio;

@Service
public class infoService {

    @Autowired
    infoRepositorio infoRe;

    @Autowired
    RespostaModelo respMo;

    public Iterable<InfoModelo> listar() {

        return infoRe.findAll();
    }

   public ResponseEntity<?> cadastrarAlterar(InfoModelo infoMo, String acao) {

        if (infoMo.getNome().equals("")) {
            respMo.setMensagem("o Nome é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respMo, HttpStatus.BAD_REQUEST);
        } else if (infoMo.getEmail().equals("")) {
            respMo.setMensagem("o Email é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respMo, HttpStatus.BAD_REQUEST);
        }else if (infoMo.getOkEmail().equals("")) {
            respMo.setMensagem("Confirmação de Email é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respMo, HttpStatus.BAD_REQUEST);
        }else if (infoMo.getSenha().equals("")) {
            respMo.setMensagem("a Senha é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respMo, HttpStatus.BAD_REQUEST);
        }  if (infoMo.getOkSenha().equals("")) {
            respMo.setMensagem("Confirmação de Senha é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respMo, HttpStatus.BAD_REQUEST);
        }else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<InfoModelo>(infoRe.save(infoMo), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<InfoModelo>(infoRe.save(infoMo), HttpStatus.OK);
            }
        }
    }
    
    public ResponseEntity<RespostaModelo> remover(long codigo) {
        infoRe.deleteById(codigo);
        respMo.setMensagem("o usuario foi removido com sucesso");
        return new ResponseEntity<RespostaModelo>(respMo, HttpStatus.OK);
    }
}