package com.github.almirrps.cities.repositories;

import com.github.almirrps.cities.entities.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {

  String QUERY = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> "
      + "(SELECT lat_lon FROM cidade WHERE id=?2)) as distance";

  @Query(value = QUERY, nativeQuery = true)
  Double distanceByPoints(final Long cityId1, final Long cityId2);

  @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
  Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

  String QUERY_RADIUS_AREA = "SELECT * "
                           + " FROM cidade AS c "
                           + "WHERE earth_box(ll_to_earth(?1, ?2), ?3) @> ll_to_earth(c.lat_lon[0], c.lat_lon[1]) "
                           + "  AND earth_distance(ll_to_earth(?1, ?2), ll_to_earth(c.lat_lon[0], c.lat_lon[1])) < ?3";
  @Query(value = QUERY_RADIUS_AREA, nativeQuery = true)
  List<City> citiesByRadius(double x, double y, Double radius);
}
