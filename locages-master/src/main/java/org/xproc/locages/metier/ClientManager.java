package org.xproc.locages.metier;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.entities.Client;

import java.util.List;

@Transactional
public interface ClientManager {
    Client addClient(Client client);
    Page<Client> getAllClients(int page, int size);
    Page<Client> searchClients(String keyword, int page, int size);
    Client getClientById(Integer id);
    Client updateClient(Client client);
    boolean deleteClient(Integer id);
    Page<Client> findByNbrCin(String keyword, Pageable pageable);
    void saveClient(Client existingClient);
    public List<Client> getAllClientsNoPage();
}
