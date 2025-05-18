package umc.spring.study.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}