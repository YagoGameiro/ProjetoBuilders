package projeto.Repositorys;

import org.springframework.stereotype.Repository;
import projeto.dtos.Clientes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ClientesRepository{

    @PersistenceContext
    private EntityManager em;

    public List<Clientes> findAll(){
        return em.createQuery("SELECT c FROM Clientes c", Clientes.class).getResultList();
    }

    public List<Clientes> findAllPaged(int pageNumber, int count){
        Query q = em.createQuery("SELECT c FROM Clientes c", Clientes.class);
        q.setFirstResult((pageNumber-1) * count);
        q.setMaxResults(count);
        return q.getResultList();
    }

    public Clientes findById(int id){
        Query q = em.createQuery("SELECT c FROM Clientes c WHERE id = :id", Clientes.class);
        q.setParameter("id", id);
        return (Clientes) q.getSingleResult();
    }

    public Clientes findByName(String name){
        Query q = em.createQuery("SELECT c FROM Clientes c WHERE name = :name", Clientes.class);
        q.setParameter("name", name);
        return (Clientes) q.getSingleResult();
    }

    public Clientes findByEmail(String email){
        Query q = em.createQuery("SELECT c FROM Clientes c WHERE email = :email", Clientes.class);
        q.setParameter("email", email);
        return (Clientes) q.getSingleResult();
    }

    public String insertClientes(List<Clientes> clientes){
        String retorno = "Inserido com sucesso";
        for (Clientes c : clientes) {
            if(c.getName() == null || c.getName().length() == 0){
                retorno = "Nome não pode estar vazio";
                break;
            } else if (c.getBirthDate() == null) {
                retorno = "Data de nascimento não pode estar vazia";
                break;
            }
            em.persist(c);
        };
        return retorno;
    }

    public String insertCliente(Clientes cliente){
        if(cliente.getName() == null || cliente.getName().length() == 0){
            return "Nome não pode estar vazio";
        } else if (cliente.getBirthDate() == null) {
            return "Data de nascimento não pode estar vazia";
        }
        em.persist(cliente);
        return "Inserido com sucesso";
    }

    public String updateClienteFull(Clientes cliente){
        em.merge(cliente);
        return "Atualizado com sucesso";
    }

    public String updateCliente(Clientes cliente){
        if (cliente.getId() == 0) {
            return "Favor informar o id para realizar o update";
        }
        Query q = em.createQuery("SELECT c FROM Clientes c WHERE id = :id", Clientes.class);
        q.setParameter("id", cliente.getId());
        Clientes original = (Clientes) q.getSingleResult();
        if(cliente.getName() == null || cliente.getName().length() == 0){
            cliente.setName(original.getName());
        }
        if(cliente.getEmail() == null || cliente.getEmail().length() == 0){
            cliente.setEmail(original.getEmail());
        }
        if(cliente.getBirthDate() == null){
            cliente.setBirthDate(original.getBirthDate());
        }
        if(cliente.getCreatedDate() == null){
            cliente.setCreatedDate(original.getCreatedDate());
        }
        em.merge(cliente);
        return "Atualizado com sucesso";
    }


}
