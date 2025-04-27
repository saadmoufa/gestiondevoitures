package org.xproc.locages.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.xproc.locages.dao.entities.Car;

import java.util.List;


    public interface CarManager {
        public Car addCar(Car car);
        public Page<Car> getAllCars(int page, int size);
        public List<Car> getAllCarsNoPage();
        public Page<Car> searchCar(String keyword, int page, int size);
        public List<Car> getByKeyword(String keyword);
        public Car getCarById(Integer id);
        public Car updateCar(Car Car);
        public boolean deleteCar(Integer id);
        public Car getCarByNbrPlate(String nbrPlate);
        Page<Car> findByPlateNbr(String keyword, Pageable pageable);

        List<Car> getCarsByAvailability(boolean availability);
//        void saveCar(Car existingCar);
}
