package org.xproc.locages.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.entities.Client;
import org.xproc.locages.dao.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientManagerMetier implements ClientManager {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Page<Client> getAllClients(int page, int size) {
        return clientRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }




    @Override
    public Page<Client> searchClients(String keyword, int page, int size) {
        return clientRepository.findByNbrCin(keyword, PageRequest.of(page, size));
    }



    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean deleteClient(Integer id) {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Page<Client> findByNbrCin(String keyword, Pageable pageable) {
        return clientRepository.findByNbrCin(keyword, pageable);
    }

    @Override
    public void saveClient(Client existingClient) {
        // Implementation can be added if needed
    }

    @Override
    public List<Client> getAllClientsNoPage() {
        return clientRepository.findAll();
    }


}
