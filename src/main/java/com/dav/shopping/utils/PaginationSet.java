package com.dav.shopping.utils;

import java.util.List;

public class PaginationSet<T> {
	
	
	Integer page, totalPages, totalCount;
	List<T> items;
	Integer count;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	public Integer getCount() {
		return (!getItems().isEmpty()? getItems().size():0);
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
	
}
