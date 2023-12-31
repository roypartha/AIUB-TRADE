package project.service;

import project.domain.Address;
import org.springframework.stereotype.Service;
import project.repository.AddressRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class AddressService {

    private Logger logger = Logger.getLogger(AddressService.class.getName());

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> list() {
        return addressRepository.list();
    }

    public Address get(Long id) {
        return addressRepository.get(id);
    }

    public boolean create(Address address) {
        return addressRepository.create(address);
    }

    public boolean update(Address address) {
        return addressRepository.update(address);
    }

    public boolean delete(Long id) {
        return addressRepository.delete(get(id));
    }
}
