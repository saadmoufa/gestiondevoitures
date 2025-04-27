package org.xproc.locages.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.repositories.CarRepository;

import java.util.List;

@Service
public class CarManagerMetier implements CarManager {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Page<Car> getAllCars(int page, int size) {
        return carRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Car> getAllCarsNoPage() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> searchCar(String keyword, int page, int size) {
        return carRepository.findByNbrPlate(keyword, PageRequest.of(page, size));
    }

    @Override
    public List<Car> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(Long.valueOf(id)).orElse(null);
    }

//    @Override
//    public Car getCarByNbrPlate(String nbrPlate) {
//        return carRepository.findByNbrPlate(nbrPlate,);
//    }



    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public boolean deleteCar(Integer id) {
        try {
            carRepository.deleteById(Long.valueOf(id));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Car getCarByNbrPlate(String nbrPlate) {
        return null;
    }

    @Override
    public Page<Car> findByPlateNbr(String keyword, Pageable pageable) {
        return carRepository.findByNbrPlate(keyword, pageable);
    }


    @Override
    public List<Car> getCarsByAvailability(boolean availability) {
        return carRepository.findByAvailability(availability);
    }
}
