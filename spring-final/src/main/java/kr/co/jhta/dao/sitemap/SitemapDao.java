package kr.co.jhta.dao.sitemap;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.SiteMap;

@Transactional
public interface SitemapDao {
	
	List<SiteMap> getAllSitemap();
	SiteMap getSitemapByCode(String code);
	List<SiteMap> getAllSitemapPre();
	List<SiteMap> getAllSitemapSec(SiteMap sitemap);
}
