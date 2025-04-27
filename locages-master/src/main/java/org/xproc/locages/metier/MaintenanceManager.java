package org.xproc.locages.metier;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.xproc.locages.dao.entities.Maintenance
        ;

import java.util.List;

@Transactional
public interface MaintenanceManager {
    Maintenance addMaintenance(Maintenance maintenance);
    Page<Maintenance> getAllMaintenances(int page, int size);
    Page<Maintenance> searchMaintenances(String keyword, int page, int size);
    Maintenance getMaintenanceById(Integer id);
    Maintenance updateMaintenance(Maintenance maintenance);
    boolean deleteMaintenance(Integer id);
    Page<Maintenance> findByDescription(String keyword, Pageable pageable);
    void saveMaintenance(Maintenance existingMaintenance);
    public void setCarId(Integer carId);
    List<Maintenance> getAllMaintenancesNoPage();
}
