package com.beyond.framework.filter;

/**
 * 查询通用条件
 * @author zjm
 *
 */
public class SearchFilter {

	// 用于控制最多的返回记录数，避免造成数据性能问题
    private static final int MAX_RECORD = 2000;
    /**
     * 分页界限
     */
    private Integer limit; 
    /**
     * 是否分页
     */
    private boolean paged; 
    
    /**
     * 页码
     */
    private int pageNumber; 
    /**
     * 页数
     */
    private int pageSize;   
    /**
     * 分页属性
     *//*
    private PagingData pagingData;*/
    /**
     * 是否排序
     *//*
    private boolean ordered;
    *//**
     * 排序属性
     *//*
    private List<OrderingProperty> orderingProperties; 
    *//**
     * 是否分组
     *//*
    private boolean grouped;
    *//**
     * 分组属性
     *//*
    private List<GroupProperty> groupingProperties; */

	public boolean isPaged() {
        return paged;
    }
    
    public void setPaged(boolean paged) {
        this.paged = paged;
    }
    
    /*public PagingData getPagingData() {
        return pagingData;
    }
    
    public void setPagingData(PagingData pagingData) {
        this.pagingData = pagingData;
    }*/
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getLimit() {
        if (limit  == null) {
            return MAX_RECORD;
        }
        return limit;
    }

    public SearchFilter() {
        if (pageSize < 1) {
            pageSize = 1;
        }
        
        if (pageSize > MAX_RECORD) {
            pageSize = MAX_RECORD;
        }
        
    }
    
    public int getStartRecordNumber() {
        int startRecordNumber = (pageNumber - 1) * pageSize;
        return startRecordNumber;
    }
    
    public int getPageNumber() {
        return pageNumber;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public int getFromIndex() {
    	return  (pageNumber - 1) * pageSize;
    }
    
    public int getToIndex() {
    	return pageNumber * pageSize;
    }
    
    public int getToIndex(int maxIndex) {
    	int toIndex = pageNumber * pageSize;
    	toIndex = toIndex > maxIndex ? maxIndex : toIndex;
    	return toIndex;
    }

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
    
    /*public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

	public List<OrderingProperty> getOrderingProperties() {
		return orderingProperties;
	}

	public void setOrderingProperties(List<OrderingProperty> orderingProperties) {
		this.orderingProperties = orderingProperties;
	}

	public boolean isGrouped() {
		return grouped;
	}

	public void setGrouped(boolean grouped) {
		this.grouped = grouped;
	}

	public List<GroupProperty> getGroupingProperties() {
		return groupingProperties;
	}

	public void setGroupingProperties(List<GroupProperty> groupingProperties) {
		this.groupingProperties = groupingProperties;
	}*/
	 
}
