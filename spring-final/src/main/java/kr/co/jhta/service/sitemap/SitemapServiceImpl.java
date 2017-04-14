package kr.co.jhta.service.sitemap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.sitemap.SitemapDao;
import kr.co.jhta.vo.SiteMap;

@Service
public class SitemapServiceImpl implements SitemapService{
	
	@Autowired
	SitemapDao sitemapDao;

	@Override
	public List<SiteMap> getAllSitemapService() {
		List<SiteMap> sitemapList = sitemapDao.getAllSitemap();
		return sitemapList;
	}

	@Override
	public SiteMap getSitemapByCodeService() {
		SiteMap siteMap = sitemapDao.getSitemapByCode();
		return siteMap;
	}

	@Override
	public List<SiteMap> getAllSitemapPreService() {
		List<SiteMap> sitemapList = sitemapDao.getAllSitemapPre();
		return sitemapList;
	}

	@Override
	public List<SiteMap> getAllSitemapSecService(SiteMap sitemap) {
		List<SiteMap> sitemapList = sitemapDao.getAllSitemapSec(sitemap);
		return sitemapList;
	}
		
}
