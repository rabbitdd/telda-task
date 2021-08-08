package main.mapper;

import main.data.Region;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author rabbit
 * @create 2021-08-05 20:38
 */
@Mapper
public interface DataMapper {

    @Select("select * from regions")
    List<Region> findAll();

    @Insert("insert into regions(name, shortname) values(#{name},#{shortname})")
    void insert(Region region);

    @Update("update regions set name=#{name}, shortname=#{shortname} where id=#{id}")
    void update(Region region);

    @Select("select * from regions where id = #{id}")
    Region getRegionById(int id);

    @Delete("delete from regions where id = #{id}")
    void deleteRegionById(int id);
}
