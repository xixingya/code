package tech.petmall.petmall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.petmall.petmall.bean.Tag;
import tech.petmall.petmall.manager.dao.TagDao;
import tech.petmall.petmall.manager.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;

	public List<Tag> queryRootTags() {
		return tagDao.queryRootTags();
	}

	public List<Tag> queryChildTagsByPid(Integer id) {
		return tagDao.queryChildTagsByPid(id);
	}

	public List<Tag> queryAll() {
		return tagDao.queryAll();
	}
}
