package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {

    Driver create(Driver model);

    Driver get(Long id);

    List<Driver> getAll();

    Driver update(Driver model);

    boolean delete(Long id);

}
