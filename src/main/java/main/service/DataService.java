package main.service;

import main.data.Region;
import main.mapper.DataMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @author rabbit
 * @create 2021-08-07 19:37
 */
@Service
public class DataService {

    private final DataMapper dataMapper;

    public DataService(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    public List<Region> getAllRegions() {
        return dataMapper.findAll();
    }

    public void addRegion(Region region) {
        if (!checkRegion(region))
            throw new IllegalArgumentException("name and shortname can't be empty");
        dataMapper.insert(region);
    }

    public void editRegion(Region newRegion) {
        if (!checkRegion(newRegion))
            throw new IllegalArgumentException("name and shortname can't be empty");
        dataMapper.update(newRegion);
    }

    public Region getRegionById(int id) {
        return dataMapper.getRegionById(id);
    }

    public void deleteRegionById(int id) {
        dataMapper.deleteRegionById(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleExceptionWithBadRequest(Exception e) {
        return "Error occurred: " + e.getMessage();
    }

    private boolean checkRegion(Region region) {
        return region.getName() != null && region.getShortname() != null;
    }
}
