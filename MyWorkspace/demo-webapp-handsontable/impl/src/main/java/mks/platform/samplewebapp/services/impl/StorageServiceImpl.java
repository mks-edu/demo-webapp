package mks.platform.samplewebapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mks.platform.samplewebapp.entity.Product;
import mks.platform.samplewebapp.repository.ProductRepository;
import mks.platform.samplewebapp.services.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
	@Autowired
	ProductRepository productRepo;
	/**
	 * Demo only
	 */
	@Override
	public List<Object[]> saveProductList(List<Object[]> data) {
		List<Object[]> savedList = new ArrayList<Object[]>();

		for (Object[] row : data) {
			if (!isEmptyRow(row)) {
				// Save data. Assume OK
				productRepo.save(new Product(null, row[0].toString(), row[1].toString(), row[2].toString()));
				savedList.add(row);
			}
		}
		// Demo only: load new data from db
		savedList.add(new Object[] {"A", "B", "Red"});
		
		
		return savedList;
		
	}
	
	static boolean isEmptyRow(Object[] row) {
		for (Object colData : row) {
			if (colData != null) {
				return false;
			}
		}
		
		return true;
	}

}
