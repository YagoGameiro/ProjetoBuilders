package projeto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.Repositorys.ClientesRepository;
import projeto.dtos.Clientes;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Clientes> findAll() {
        return clientesRepository.findAll();
    }

    @RequestMapping(value = "/findAllPaged/{page}", method = RequestMethod.GET)
    public List<Clientes> findAllPaged(@PathVariable("page") int page) {
        return clientesRepository.findAllPaged(page,5);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Clientes findById(@PathVariable("id") int id) {
        return clientesRepository.findById(id);
    }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public Clientes findByName(@PathVariable("name") String name) {
        return clientesRepository.findByName(name);
    }

    @RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
    public Clientes findByEmail(@PathVariable("email") String email) {
        return clientesRepository.findByEmail(email);
    }


    @Transactional
    @RequestMapping(value = "/insereListaClientes", method = RequestMethod.POST)
    public String insereListaClientes(@RequestBody List<Clientes> clientes) {
        return clientesRepository.insertClientes(clientes);
    }

    @Transactional
    @RequestMapping(value = "/insereCliente", method = RequestMethod.POST)
    public String insereCliente(@RequestBody Clientes cliente) {
        return clientesRepository.insertCliente(cliente);
    }

    @Transactional
    @RequestMapping(value = "/updateClienteFull", method = RequestMethod.POST)
    public String updateClienteFull(@RequestBody Clientes cliente) {
            return clientesRepository.updateClienteFull(cliente);
    }

    @Transactional
    @RequestMapping(value = "/updateCliente", method = RequestMethod.POST)
    public String updateCliente(@RequestBody Clientes cliente) {
        return clientesRepository.updateCliente(cliente);
    }

}
