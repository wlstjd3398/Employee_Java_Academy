package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductInfoDao;
import exception.BadParameterException;
import vo.ProductInfo;

@WebServlet("/product/detail")
public class ProductDetailController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if(request.getParameter("productId") == null) {
				throw new BadParameterException();
			}
			
			int productId = Integer.parseInt(request.getParameter("productId"));
			
			ProductInfoDao dao = new ProductInfoDao();
			ProductInfo productInfo = dao.selectByIdx(productId);
			
			// selectByIdx에 나온 다음
			// 문제 발생상황 : 존재하지 않는 productId를 넣었을 경우
			// 이 문제를 적절히 해결해보세요
			
			if(productInfo == null) {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				return;
			}
			
			String data = "{\"name\":\"(1)\", \"category\":\"(2)\",\"stock\":(3),\"price\":(4),\"img\":\"(5)\"}";
			data = data.replace("(1)", productInfo.getName());
			data = data.replace("(2)", productInfo.getCategory());
			
			// 문자열화는 valueOf 사용 
			// String.valueOf(productInfo.getStock()) 이런식으로 사용함
			
			// + "" 해도 문자열화가 됨
			// 보통은 + "" 빈문자열을 넣어서 사용함
			
			data = data.replace("(3)", productInfo.getStock() + "");
			data = data.replace("(4)", productInfo.getPrice() + "");
			data = data.replace("(5)", productInfo.getImg());
			
			response.setContentType("application/json;charset=utf=8");
			
			PrintWriter out = response.getWriter();
			
			out.print(data);
			
			out.close();
			
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}


}