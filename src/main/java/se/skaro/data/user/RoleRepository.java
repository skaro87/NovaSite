package se.skaro.data.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select a.role from Role a, User b where b.username=?1 and a.userid=b.userId")
	public List<String> findRoleByUserName(String username);
}
