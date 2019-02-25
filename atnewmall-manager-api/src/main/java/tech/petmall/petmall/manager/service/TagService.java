package tech.petmall.petmall.manager.service;

import java.util.List;

import tech.petmall.petmall.bean.Tag;

public interface TagService {

	List<Tag> queryRootTags();

	List<Tag> queryChildTagsByPid(Integer id);

	List<Tag> queryAll();

}
