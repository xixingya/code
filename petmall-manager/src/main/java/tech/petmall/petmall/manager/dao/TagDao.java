package tech.petmall.petmall.manager.dao;

import java.util.List;

import tech.petmall.petmall.bean.Tag;

public interface TagDao {

	List<Tag> queryRootTags();

	List<Tag> queryChildTagsByPid(Integer id);

	List<Tag> queryAll();

}
