package com.atguigu.atnewmall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atnewmall.bean.Tag;
import com.atguigu.atnewmall.manager.dao.TagDao;
import com.atguigu.atnewmall.manager.service.TagService;

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
