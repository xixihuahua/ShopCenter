package com.shop.util;
/**
 * 分页查询工具类
 * @author junliu
 *
 */
public class AjaxPageUtil {
	/**
	 * 一页显示多少个
	 */
	private int pageRow = 2;
	/**
	 * 当前页数
	 */
	private int currentPage = 0;
	/**
	 * 当前起始行
	 */
	private int startRow;
	/**
	 * 结束行
	 */
	private int endRow;
	
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		if(pageRow < 0 ){
			this.pageRow = 10;
		}else{
			this.pageRow = pageRow;
		}
		//在设置当前页数的时候自动计算起始行和结束行
		this.startRow = (currentPage)*this.pageRow + 1;
		this.endRow = (currentPage+1) * this.pageRow;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage <= 0){
			this.currentPage = 0;
		}else{
			this.currentPage = currentPage;
		}
		//在设置当前页数的时候自动计算起始行和结束行
		this.startRow = (this.currentPage)*this.pageRow + 1;
		this.endRow = (this.currentPage+1) * this.pageRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	@Override
	public String toString() {
		return "AjaxPageUtil [pageRow=" + pageRow + ", currentPage="
				+ currentPage + ", startRow=" + startRow + ", endRow=" + endRow
				+ "]";
	}
	
	
}
