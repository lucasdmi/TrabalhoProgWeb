
package model;

import java.io.Serializable;


public class Promocao implements Serializable{
    
    private String desconto;
    private String preco; 
    private String validade;
    private String imagem;

   

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

 
    public String getDesconto() {
        return desconto;
    }


    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getImagem() {
        return imagem;
    }


    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    
}
