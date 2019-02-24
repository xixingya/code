package com.atguigu.atnewmall.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atnewmall.bean.AJAXResult;
import com.atguigu.atnewmall.bean.Tag;
import com.atguigu.atnewmall.manager.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;
	
	@ResponseBody
	@RequestMapping("/asyncLoadData")
	public Object asyncLoadData() {
		List<Tag> rootTags = new ArrayList<Tag>();
		List<Tag> allTags = tagService.queryAll();
		Map<Integer, Tag> tagMap = new HashMap<Integer, Tag>();
		for ( Tag tag : allTags ) {
			tagMap.put(tag.getId(), tag);
		}
		for ( Tag tag : allTags ) {
			// 子标签
			Tag child = tag;
			if ( child.getPid() == 0 ) {
				rootTags.add(tag);
			} else {
				// 父标签
				Tag parent = tagMap.get(child.getPid());
				// 组合父子标签的关系
				parent.getChildren().add(child);
			}
		}
		return rootTags;
	}
	
	@ResponseBody
	@RequestMapping("/loadData")
	public Object loadData() {
		AJAXResult result = new AJAXResult();
		
		try {
			
			// 准备数据
			// list ==> json ==> []
			// map  ==> json ==> {}
			List<Tag> list = new ArrayList<Tag>();
			/*
			// 父节点
			Tag tag = new Tag();
			tag.setOpen(true);
			tag.setName("父标签");
			
			// 子节点
			Tag childTag = new Tag();
			childTag.setName("子标签");
			
			// 组合父子节点的关系
			tag.getChildren().add(childTag);
			*/
			
			// 查询标签数据
			//List<Tag> tags = tagService.queryRootTags();
			/*
			Tag tag = new Tag();
			tag.setId(0);
			
			List<Tag> tags = tagService.queryChildTagsByPid(tag.getId());
			
			for ( Tag tag : tags ) {
				// 查询子节点
				List<Tag> children = tagService.queryChildTagsByPid(tag.getId());
				
				for ( Tag childTag : children ) {
					// 查询子节点的子节点
					List<Tag> childrenChildren = tagService.queryChildTagsByPid(childTag.getId());
					
					// 组合父子节点的关系
					childTag.setChildren(childrenChildren);
				}
				
				// 组合父子节点的关系
				tag.setChildren(children);
			}
			*/
			
			// 使用递归方式读取标签数据
			/*
			Tag tag = new Tag();
			tag.setId(0);
			queryChildTags(tag);
			result.setData(tag.getChildren());
			*/
			
			// 嵌套for循环查询标签数据
			/*
			List<Tag> rootTags = new ArrayList<Tag>();
			List<Tag> allTags = tagService.queryAll();
			
			for ( Tag tag : allTags ) {
				// 子标签
				Tag child = tag;
				if ( child.getPid() == 0 ) {
					rootTags.add(tag);
				} else {
					for ( Tag innerTag : allTags ) {
						if ( innerTag.getId().equals(child.getPid()) ) {
							// 父标签
							Tag parent = innerTag;
							
							// 组合父子标签的关系
							parent.getChildren().add(child);
							break;
						}
					}
				}
			}
			*/
			
			// map集合查询标签数据
			List<Tag> rootTags = new ArrayList<Tag>();
			List<Tag> allTags = tagService.queryAll();
			Map<Integer, Tag> tagMap = new HashMap<Integer, Tag>();
			for ( Tag tag : allTags ) {
				tagMap.put(tag.getId(), tag);
			}
			for ( Tag tag : allTags ) {
				// 子标签
				Tag child = tag;
				if ( child.getPid() == 0 ) {
					rootTags.add(tag);
				} else {
					// 父标签
					Tag parent = tagMap.get(child.getPid());
					// 组合父子标签的关系
					parent.getChildren().add(child);
				}
			}
			
			
			result.setData(rootTags);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 递归查询子标签
	 * 1) 调用自身
	 * 2) 调用自身时参数之间有规律
	 * 3) 含有跳出的逻辑
	 */
	private void queryChildTags( Tag parent ) {
		// 查询子标签
		List<Tag> children = tagService.queryChildTagsByPid(parent.getId());
		
		for ( Tag child : children ) {
			queryChildTags(child);
		}
		
		// 组合父子标签之间的关系
		parent.setChildren(children);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "tag/index";
	}
}
