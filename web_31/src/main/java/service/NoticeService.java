package service;

import java.util.List;

import dao.NoticeInfoDao;
import vo.NoticeInfo;

public class NoticeService {

	public boolean addNotice(NoticeInfo newNoticeInfo) {
		// 공지사항 테이블에 새로운 공지사항을 저장한다.
		
		NoticeInfoDao dao = new NoticeInfoDao();
		
		boolean result = dao.insertNoticeInfo(newNoticeInfo);
		
		return result;
	}
	
	
	public String loadNoticeInfoListToJson(int pageNumber) {
		// 공지사항 목록을 불러온다.(페이지 번호에 맞는 페이지넘버를 불러옴)
		NoticeInfoDao dao = new NoticeInfoDao();
		List<NoticeInfo> noticeInfoList = dao.selectNoticeInfo(pageNumber);
		
		int amount = dao.getAmountOfNotice();
		
		
		// 불러온 공지사항 목록을 JSON으로 구성한다.
		String data = "{\"amount\": " + amount + ",";
		data += "\"noticeList\":[";
		for(NoticeInfo noticeInfo : noticeInfoList) {
			int id = noticeInfo.getId();
			String title = noticeInfo.getTitle();
			String contents = noticeInfo.getContents();
			
//			System.out.println(contents); // replace 하기전 확인
			
			// 공지사항의 내용을 작성할 때 엔터를 치면 엔터가 \r\n 으로 변환돼서 저장됨
			// 이때 \ 때문에 자바스크립트가 전달 받은 공지사항 목록을 JSON으로 변환할 수 없게 됨
			
//			contents = contents.replace("\\", "\\\\"); 
			// 서버에서 이 방법으로 하는데, 잘안되어서 다른방법인 javascript로
			
			
			
//			System.out.println(contents); // replace 한 후 확인
			
			data = data + "{\"id\": " + id + ",\"title\":\"" + title + "\",\"contents\":\"" + contents + "\"},";
		}
		data = data.substring(0, data.length()-1);
		data = data + "]}";
		
		return data;
	}
	
	
//	public int getAmountOfNotice() {
//		
//		NoticeInfoDao dao = new NoticeInfoDao();
//		
//		int amount = dao.getAmountOfNotice();
//		
//		return amount;
//	}
//	
	
	public String loadNoticeInfoToJson(int id) {
		// 공지사항의 상세 정보를 DB에서 불러옴
		NoticeInfoDao dao = new NoticeInfoDao();
		
		NoticeInfo noticeInfo = dao.selectNoticeInfoById(id);
		
		// 불러온 상세 정보를 클라이언트에게 전달하기 위해 JSON으로 구성
		String data = null;
		
		if(noticeInfo != null) {
			// 공지사항의 상세정보를 확인했다면 
			data = "{\"id\": " + noticeInfo.getId() + ",\"title\":\"" + noticeInfo.getTitle() + "\",\"contents\":\"" + noticeInfo.getContents() + "\",\"filePath\":\"" + noticeInfo.getFilePath() + "\"}";
		}
		
			return data;
	}
	
	public boolean updateNoticeInfo(NoticeInfo newNoticeInfo) {
		
		NoticeInfoDao dao = new NoticeInfoDao();
		return dao.updateNoticeInfo(newNoticeInfo);
		
		
		
	}
	
	
}