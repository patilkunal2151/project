package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.VehicleDao;
import com.app.pojos.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDao vdao;

	public Vehicle findByCustomerId(int id) {
		Vehicle customerId = vdao.findByCustomerId(id);
		return customerId;
	}

	public Optional<Vehicle> findByVehicleId(int id) {
		Optional<Vehicle> vehicleId = vdao.findById(id);
		return vehicleId;
	}

	public List<Vehicle> findAllVehicle() {
		List<Vehicle> list = vdao.findAll();
		return list;
	}

	public Vehicle addVehicle(Vehicle vec) {
		Vehicle vehicle = vdao.save(vec);
		return vehicle;

	}

	public int removeVehicleByVid(int id) {
		if (vdao.existsById(id)) {
			vdao.deleteById(id);
			return 1;
		} else
			return 0;
	}

}
