package com.sv.webscrapper.repository;

import com.sv.webscrapper.domain.Page;
import com.sv.webscrapper.domain.view.PageView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    @Query(nativeQuery = true, value = "SELECT wp.id, wp.name, count(l.id) as number_of_links FROM page wp left join link l on wp.id = l.page_id group by wp.id")
    List<PageView> nativeQueryPage();
}
