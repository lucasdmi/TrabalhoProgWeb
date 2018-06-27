
package bean;

import model.Promocao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ManagedBean 
@SessionScoped
public class PromocoesBean implements Serializable {
    
    private List<Promocao> promocoes;
    private List<Promocao> filteredpromocao;
    private Promocao promocaoSelecionada;
    private String preco;
    private String validade;
    private String desconto;
    private String imagem;
   
    
    @PostConstruct
    public void inicializar(){        
       promocoes = new ArrayList<>();
    }
    
    
    public void inserir(){
        Promocao p = new Promocao();
        p.setDesconto(desconto);
        p.setPreco(preco);
        p.setValidade(validade);
        p.setImagem(getImagem());
        promocoes.add(p);
        limpar();
        
    }
     public void limpar() {
        desconto = "";
        preco = "";
        validade = "";
        imagem = "";

    }
     public void excluir(){
         
         if(promocaoSelecionada != null){
            promocoes.remove(promocaoSelecionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão de Clientes", "Cliente excluído com sucesso!"));
            System.out.println(promocaoSelecionada.getPreco());
        }
        
        
     }
      public void alterar(){
        for(Promocao p : promocoes){
            if(p.getValidade().equals(validade)){
                p.setDesconto(desconto);
                p.setPreco(preco);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração de Clientes", "Cliente alterado com sucesso!"));
            }
        }
        redefinir();
    }
      
      public void redefinir(){
        for(Promocao p : promocoes){
            if(p.getValidade().equals(validade)){
                desconto = p.getDesconto();
                preco = p.getPreco();
            }
        }
    }
      
      public void carregarObj(){
        if(promocaoSelecionada!=null){
            desconto = promocaoSelecionada.getDesconto();
            validade = promocaoSelecionada.getValidade();
            preco = promocaoSelecionada.getPreco();
            
        }
      }
   
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

    public List<Promocao> getPromocoes() {
        return promocoes;
    }


    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
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

    public Promocao getPromocaoSelecionada() {
        return promocaoSelecionada;
    }

    public void setPromocaoSelecionada(Promocao promocaoSelecionada) {
        this.promocaoSelecionada = promocaoSelecionada;
    } 

    public List<Promocao> getFilteredpromocao() {
        return filteredpromocao;
    }


    public void setFilteredpromocao(List<Promocao> filteredpromocao) {
        this.filteredpromocao = filteredpromocao;
    }
}
    
    
    
   