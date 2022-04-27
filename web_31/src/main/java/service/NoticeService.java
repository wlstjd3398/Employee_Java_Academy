package service;

import java.util.List;

import dao.NoticeInfoDao;
import vo.NoticeInfo;

public class NoticeService {

	public boolean addNotice(NoticeInfo newNoticeInfo) {
		
		// 공지사항 테이블에 새로운 공지사항을 저장한다
		 NoticeInfoDao dao = new NoticeInfoDao();
		 
		 boolean result = dao.inserNoticeInfo(newNoticeInfo);
		 
		 return result;
	}
	
	public String loadNoticeInfoToJson() {
		// 공지사항 목록을 불러옴
		// service가 크게 하는 일이 없다면 dao에서 할수있음
		NoticeInfoDao dao = new NoticeInfoDao();
		List<NoticeInfo> noticeInfoList = dao.selectNoticeInfo();
		
		// 불러온 공지사항 목록을 json으로 구성한다
		String data = "{\"noticeList\":[";
		for(NoticeInfo noticeInfo : noticeInfoList) {
			data = data + "{\"title\":\""+ noticeInfo.getTitle() + "\","
					+ "\"contents\":\"" + noticeInfo.getContents() +"\"},";
		}
		data = data.substring(0, data.length()-1);
		data= data + "]}";
		
		return data;
		
	}
	
}
