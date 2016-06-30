package com.beyond.mapper.common;

import com.beyond.filter.UserInfoFilter;

public class AbstractBusinessMapper {

	public String getPageSql(String sql) {
		StringBuffer sb = new StringBuffer(sql);
		
		return sb.toString();
	}

	/**
	 * sql通用过滤条件
	 * @param sql sql语句
	 * @param filter 过滤条件
	 * @return
	 */
	protected String appendCommonFilter(UserInfoFilter filter) {
		StringBuffer sb = new StringBuffer();
		/*if (filter.isGrouped()) {
			sb.append(" group by ");
			for (int i = 0; i < filter.getGroupingProperties().size(); i++) {
				sb.append(filter.getGroupingProperties().get(i).getProperty());
				if (i < filter.getGroupingProperties().size() - 1) {
					sb.append(",");
				}
			}
		}
		if (filter.isOrdered()) {
			sb.append(" order by ");
			for (int i = 0; i < filter.getOrderingProperties().size(); i++) {
				sb.append(filter.getOrderingProperties().get(i).getProperty());
				if (!filter.getOrderingProperties().get(i).isAsc()) {
					sb.append(" desc");
				}
				if (i < filter.getGroupingProperties().size() - 1) {
					sb.append(",");
				}
			}
		}*/
		if (filter.isPaged()) {
			sb.append(" limit " + filter.getStartRecordNumber()
				+ "," + filter.getPageSize());
		} else {
			sb.append(" limit " + filter.getLimit());
		}
		return sb.toString();
	}
}
