package com.ngf.sp_bkend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ngf.sp_bkend.model.Coin;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long>{
	
	List<CoinRepository> findByFamilyContaining(String family);

//	@Query (value = "SELECT * FROM Coin WHERE family like %?1% ORDER BY id", nativeQuery = true)
	@CrossOrigin(origins = "http://localhost:3000/coins/sort_by_name/")
	@Query ("SELECT c FROM Coin c WHERE c.family like %?1% ORDER BY c.id")
	List<Coin> findAllSortById(String family);
	
}
