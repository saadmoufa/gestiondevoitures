package org.xproc.locages.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.entities.Client;
import org.xproc.locages.metier.ClientManagerMetier;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class ClientController {

    @Autowired
    private  ClientManagerMetier clientManager;


    @GetMapping("indexClient")
    public String start(Model model) {
        List<Client> clients = clientManager.getAllClientsNoPage();
        model.addAttribute("clients", clients);
        return "indexClient";
    }

    @GetMapping("/ajouterClient")
    public String ajouterClient(Model model) {
        model.addAttribute("client", new Client());
        return "ajouterClient";
    }

    @PostMapping("/ajouterOnceC")
    public String ajouterClient(Model model,
                             @Valid Client client,
                             BindingResult bindingResult) {
        clientManager.addClient(client);
        return "redirect:indexClient";
    }

    @GetMapping("/deleteClient")
    public String deleteClient(Model model, @RequestParam(name = "id") Integer id) {
        if (clientManager.deleteClient(id)) {
            return "redirect:/indexClient";

        } else {
            return "error";
        }
    }

    @GetMapping("/editClient")
    public String editClient(Model model, @RequestParam(name = "id") Integer id) {
        Client client =   clientManager.getClientById(id);
        if (client != null) {
            model.addAttribute("clientTobeUpdated", client);
            return "updateClient";
        } else {
            return "error";
        }
    }
    @PostMapping("/updateClient")
    public String updateClient(@ModelAttribute("clientTobeUpdated") Client client) {
        clientManager.updateClient(client);
        return "redirect:indexClient";
    }


    @PostMapping("/ajouterC")
    public String ajouterClientAction(Model model,
                                   @Valid Client client,
                                   BindingResult bindingResult) {
        clientManager.addClient(client);
        return "redirect:indexClient";
    }
}


