package org.xproc.locages.metier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xproc.locages.dao.entities.Client;
import org.xproc.locages.dao.entities.Maintenance;
import org.xproc.locages.dao.repositories.MaintenanceRepository;

import java.util.List;

@Service
public class MaintenanceManagerMetier implements MaintenanceManager {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Page<Maintenance> getAllMaintenances(int page, int size) {
        return maintenanceRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Maintenance getMaintenanceById(Integer id) {
        return maintenanceRepository.findById(id).orElse(null);
    }
    @Override
    public List<Maintenance> getAllMaintenancesNoPage() {
        return maintenanceRepository.findAll();
    }




    @Override
    public Page<Maintenance> searchMaintenances(String keyword, int page, int size) {
        return maintenanceRepository.findByDescription(keyword, PageRequest.of(page, size));
    }



    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public boolean deleteMaintenance(Integer id) {
        try {
            maintenanceRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Page<Maintenance> findByDescription(String keyword, Pageable pageable) {
        return maintenanceRepository.findByDescription(keyword, pageable);
    }

    @Override
    public void saveMaintenance(Maintenance existingMaintenance) {
        // Implementation can be added if needed
    }

    @Override
    public void setCarId(Integer carId) {
        return ;
    }


}
