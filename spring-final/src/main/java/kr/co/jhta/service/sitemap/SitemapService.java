package kr.co.jhta.service.sitemap;

import java.util.List;

import kr.co.jhta.vo.SiteMap;

public interface SitemapService{

	List<SiteMap> getAllSitemapService();
	SiteMap getSitemapByCodeService(String code);
	List<SiteMap> getAllSitemapPreService();
	List<SiteMap> getAllSitemapSecService(SiteMap sitemap);
}
