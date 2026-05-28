package com.example.cacheredis.repo;

import com.example.cacheredis.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Cacherepo  extends JpaRepository<Weather,Long> {
    @Query("select w from Weather w where w.city=:city")
    Weather findWeatherByCity(@Param("city") String city);


@Modifying(clearAutomatically = true, flushAutomatically = true)

@Query("delete from Weather w where w.city=:city")
    int deleteWeatherByCity(@Param("city") String city);
}
