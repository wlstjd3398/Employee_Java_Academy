package service;

import java.time.LocalDateTime;
import java.util.List;

import dao.NoticeInfoDao;
import vo.NoticeInfo;

public class NoticeService {

	// 새로운 공지사항 저장
	public boolean addNotice(NoticeInfo newNoticeInfo) {
		
		NoticeInfoDao dao = new NoticeInfoDao();
		
		boolean result = dao.insertNoticeInfo(newNoticeInfo);
		
		return result;
	}
	
	// 공지사항 목록 불러오기(페이지 번호에 맞는 pageNumber 불러오기)
	public String loadNoticeInfoListToJson(int pageNumber) {
		// 공지사항 목록을 불러온다.(페이지 번호에 맞는 페이지넘버를 불러옴)
		NoticeInfoDao dao = new NoticeInfoDao();
		List<NoticeInfo> noticeInfoList = dao.selectNoticeInfo(pageNumber);
		
		int amount = dao.getAmountOfNotice();
		
		// 불러온 공지사항 목록을 JSON으로 구성한다.
		String data = "{\"amount\": " + amount + ",";
		data += "\"noticeList\":[";
		for(NoticeInfo noticeInfo : noticeInfoList) {
			
			int idx = noticeInfo.getIdx();
			String title = noticeInfo.getTitle();
			String content = noticeInfo.getContent();
			String writer = noticeInfo.getWriter();
			LocalDateTime insertDate = noticeInfo.getInsertDate();
			int hits = noticeInfo.getHits();
			
			data = data + "{\"idx\": " + idx + ",\"title\":\"" + title + "\",\"content\":\"" + content + ",\"writer\":\"" + writer + ",\"insertDate\":\"" + insertDate + ",\"hits\":\"" + hits + "\"},";
		}
		data = data.substring(0, data.length()-1);
		data = data + "]}";
		
		return data;
	}
	

	// 상세 정보 불러오기
	public String loadNoticeInfoToJson(int idx) {
		// 공지사항의 상세 정보를 DB에서 불러옴
		NoticeInfoDao dao = new NoticeInfoDao();
		
		NoticeInfo noticeInfo = dao.selectNoticeInfoByIdx(idx);
		
		// 불러온 상세 정보를 클라이언트에게 전달하기 위해 JSON으로 구성
		String data = null;
		
		if(noticeInfo != null) {
			// 공지사항의 상세정보를 확인했다면 
			data = "{\"idx\": " + noticeInfo.getIdx() + ",\"title\":\"" + noticeInfo.getTitle() + "\",\"content\":\"" + noticeInfo.getContent() + "\"}";
		}
		
			return data;
	}
	
	
	public boolean updateNoticeInfo(NoticeInfo newNoticeInfo) {
		
		NoticeInfoDao dao = new NoticeInfoDao();
		return dao.updateNoticeInfo(newNoticeInfo);
	}
	
	
}
