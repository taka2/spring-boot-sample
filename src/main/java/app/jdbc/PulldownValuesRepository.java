package app.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.PulldownValue;

public interface PulldownValuesRepository extends JpaRepository<PulldownValue, String> {
	public List<PulldownValue> findByKeyOrderBySortOrderAsc(String key);
}
