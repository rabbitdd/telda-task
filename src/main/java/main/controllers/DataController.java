package main.controllers;

import main.data.Region;
import main.service.DataService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rabbit
 * @create 2021-08-05 20:12
 */
@RestController
@RequestMapping("/data")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/allRegions")
    public List<Region> getAllRegions() {
        return dataService.getAllRegions();
    }

    @CachePut(value="regions", key="#region.getName()")
    @PostMapping("/region/add")
    public ResponseEntity<Object> addRegion(@RequestBody Region region) {
       dataService.addRegion(region);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/region/edit")
    public ResponseEntity<Object> editRegion(@RequestBody Region newRegion) {
        dataService.editRegion(newRegion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Cacheable(value = "regions", key="#id")
    @GetMapping("/region")
    public ResponseEntity<Region> getRegionById(@RequestParam int id) {
        return new ResponseEntity<>(dataService.getRegionById(id), HttpStatus.OK);
    }

    @CacheEvict(value = "regions", key = "#id")
    @DeleteMapping("/region/delete")
    public void deleteRegionById(@RequestParam int id) {
        dataService.deleteRegionById(id);
    }
}
