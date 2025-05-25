package umc.spring.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Mission;

import java.time.LocalDate;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findByStoreIdAndDeadlineAfter(Long storeId, LocalDate now, Pageable pageable);
}
