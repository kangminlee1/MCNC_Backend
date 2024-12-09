package mcnc.survwey.domain.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findByUser_UserId(String userId);
    List<Survey> findByUser_Email(String email);
    List<Survey> findByTitleContaining(String title);
}
