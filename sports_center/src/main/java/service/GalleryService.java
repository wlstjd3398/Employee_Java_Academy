package service;

import java.time.LocalDateTime;
import java.util.List;

import dao.GalleryInfoDao;
import vo.GalleryInfo;

public class GalleryService {

	// 새로운 갤러리 저장
		public boolean addGallery(GalleryInfo newGalleryInfo) {
			
			GalleryInfoDao dao = new GalleryInfoDao();
			
			boolean result = dao.insertGalleryInfo(newGalleryInfo);
			
			return result;
		}
		
		// 갤러리 목록 불러오기(페이지 번호에 맞는 pageNumber 불러오기)
		public String loadGalleryInfoListToJson(int pageNumber) {
			// 갤러리 목록을 불러온다.(페이지 번호에 맞는 페이지넘버를 불러옴)
			GalleryInfoDao dao = new GalleryInfoDao();
			List<GalleryInfo> galleryInfoList = dao.selectGalleryInfo(pageNumber);
			
			int amount = dao.getAmountOfGallery();
			
			// 불러온 갤러리 목록을 JSON으로 구성한다.
			String data = "{\"amount\": " + amount + ",";
			data += "\"GalleryList\":[";
			for(GalleryInfo galleryInfo : galleryInfoList) {
				
				int idx = galleryInfo.getIdx();
				String title = galleryInfo.getTitle();
				String content = galleryInfo.getContent();
				String img = galleryInfo.getImg();
				String writer = galleryInfo.getWriter();
				LocalDateTime insertDate = galleryInfo.getInsertDate();
				int hits = galleryInfo.getHits();
				
				data = data + "{\"idx\": " + idx + ",\"title\":\"" + title + "\",\"content\":\"" + content + ",\"img\":\"" + img + ",\"writer\":\"" + writer + ",\"insertDate\":\"" + insertDate + ",\"hits\":\"" + hits + "\"},";
			}
			data = data.substring(0, data.length()-1);
			data = data + "]}";
			
			return data;
		}
		

		// 상세 정보 불러오기
		public String loadGalleryInfoToJson(int idx) {
			// 갤러리의 상세 정보를 DB에서 불러옴
			GalleryInfoDao dao = new GalleryInfoDao();
			
			GalleryInfo GalleryInfo = dao.selectGalleryInfoByIdx(idx);
			
			// 불러온 상세 정보를 클라이언트에게 전달하기 위해 JSON으로 구성
			String data = null;
			
			if(GalleryInfo != null) {
				// 갤러리의 상세정보를 확인했다면 
				data = "{\"idx\": " + GalleryInfo.getIdx() + ",\"title\":\"" + GalleryInfo.getTitle() + "\",\"content\":\"" + GalleryInfo.getContent() + "\"}";
			}
			
				return data;
		}
		
		
		public boolean updateGalleryInfo(GalleryInfo newGalleryInfo) {
			
			GalleryInfoDao dao = new GalleryInfoDao();
			return dao.updateGalleryInfo(newGalleryInfo);
		}
	
}
